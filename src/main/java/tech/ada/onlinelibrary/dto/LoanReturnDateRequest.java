package tech.ada.onlinelibrary.dto;

import java.time.LocalDate;

public class LoanReturnDateRequest {

    private Long loanId;

    public Long getLoanId() {
        return loanId;
    }

    public void setLoanId(Long loanId) {
        this.loanId = loanId;
    }

}
