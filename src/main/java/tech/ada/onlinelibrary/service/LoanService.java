package tech.ada.onlinelibrary.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.ada.onlinelibrary.domain.Loan;
import tech.ada.onlinelibrary.dto.LoanReturnDateRequest;
import tech.ada.onlinelibrary.repository.LoanRepository;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class LoanService {
    private LoanRepository loanRepository;

    @Autowired
    public LoanService(LoanRepository loanRepository){
        this.loanRepository = loanRepository;
    }

    public Boolean checkLoanAuthorization(Long userId){
        List<Loan> loans = loanRepository.findByUserId(userId);

        for(int i=0; i < loans.size(); i++ ) {
            Loan loan = loans.get(i);
            LocalDate scheduledReturnDate = loan.getScheduledReturnDate();
            LocalDate realReturnDate = loan.getRealReturnDate();
            LocalDate penaltyDate = realReturnDate.plusDays(15);
            LocalDate actualDate = LocalDate.now();

            if(realReturnDate != null){
                if (realReturnDate.isAfter(scheduledReturnDate)&&(penaltyDate.isBefore(actualDate))) return false;
            } else {
                return false;
            }

        }
        return true;
    }

    public void createLoan(Loan loan) {
        loanRepository.save(loan);
    }

    public Optional<Loan> registerLoanReturn(LoanReturnDateRequest returnDateRequest) {
        Optional<Loan> loanOpt = loanRepository.findById(returnDateRequest.getLoanId());

        if (loanOpt.isPresent()) {
            Loan loan = loanOpt.get();
            loan.setRealReturnDate(returnDateRequest.getRealReturnDate());
            loanRepository.save(loan);
        }

        return loanOpt;
    }
  
}
