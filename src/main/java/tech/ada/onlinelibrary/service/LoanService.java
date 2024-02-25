package tech.ada.onlinelibrary.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.ada.onlinelibrary.domain.Loan;
import tech.ada.onlinelibrary.dto.LoanReturnDateRequest;
import tech.ada.onlinelibrary.repository.LoanRepository;

import java.util.Optional;

@Service
public class LoanService {

    private LoanRepository loanRepository;

    @Autowired
    public LoanService(LoanRepository loanRepository) {
        this.loanRepository = loanRepository;
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
