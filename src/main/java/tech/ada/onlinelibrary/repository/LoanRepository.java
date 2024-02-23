package tech.ada.onlinelibrary.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.ada.onlinelibrary.domain.Loan;
import tech.ada.onlinelibrary.domain.User;

import java.util.List;

public interface LoanRepository extends JpaRepository<Loan, Long> {
    List<Loan> findByUserId(Long userId);
}
