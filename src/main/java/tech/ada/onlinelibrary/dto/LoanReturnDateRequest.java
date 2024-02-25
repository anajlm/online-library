package tech.ada.onlinelibrary.dto;

import java.time.LocalDate;

public class LoanReturnDateRequest {

    private Long loanId;
    private LocalDate realReturnDate;

    public Long getLoanId() {
        return loanId;
    }

    public void setLoanId(Long loanId) {
        this.loanId = loanId;
    }

    public LocalDate getRealReturnDate() {
        return realReturnDate;
    }

    public void setRealReturnDate(LocalDate realReturnDate) {
        this.realReturnDate = realReturnDate;
    }
}
