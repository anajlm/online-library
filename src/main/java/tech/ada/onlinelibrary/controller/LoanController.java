package tech.ada.onlinelibrary.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tech.ada.onlinelibrary.domain.Book;
import tech.ada.onlinelibrary.domain.Loan;
import tech.ada.onlinelibrary.dto.BookPostRequest;
import tech.ada.onlinelibrary.dto.LoanPostRequest;
import tech.ada.onlinelibrary.repository.LoanRepository;
import tech.ada.onlinelibrary.service.LoanService;

import java.util.List;
import java.util.Optional;

@RestController
public class LoanController {

    private LoanRepository loanRepository;
    private ModelMapper modelMapper;

    private LoanService loanService;

    @Autowired
    public LoanController(LoanRepository loanRepository, ModelMapper modelMapper){
        this.loanRepository = loanRepository;
        this.modelMapper = modelMapper;
    }


    @PostMapping("/library/loans")
    public ResponseEntity<List<Loan>> newLoan(@RequestBody Loan loan) {
        Long userId = loan.getId();

        boolean isAuthorized = loanService.checkLoanAuthorization(userId);

        if (isAuthorized) {
            loanService.createLoan(loan);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
        }
    }

    @GetMapping("/library/loans")
    public ResponseEntity<List<Loan>> getAllLoans(){
        List<Loan> loans = loanRepository.findAll();
        return ResponseEntity.ok(loans);
    }

    @GetMapping(value = "/library/loans", params = {"userId"})
    public ResponseEntity<List<Loan>> getLoansByUserId(@RequestParam Long userId){
        List<Loan> loans = loanRepository.findByUserId(userId);
        return ResponseEntity.ok(loans);
    }


    @GetMapping(value = "/library/loans", params = {"title"})
    public ResponseEntity<List<Loan>> getLoansByTitle(@RequestParam String title) {
        List<Loan> loans1 = loanRepository.findByTitle(title);
        return ResponseEntity.ok(loans1);
    }

    @GetMapping(value = "/library/loans", params = {"author"})
    public ResponseEntity<List<Loan>> getLoansByAuthor(@RequestParam String author) {
        List<Loan> loans2 = loanRepository.findByAuthor(author);
        return ResponseEntity.ok(loans2);
    }

    @GetMapping(value = "/library/loans", params = {"genre"})
    public ResponseEntity<List<Loan>> getLoansByGenre(@RequestParam String genre) {
        List<Loan> loans3 = loanRepository.findByGenre(genre);
        return ResponseEntity.ok(loans3);
    }

    @PostMapping("/library/loans")
    public ResponseEntity<Loan> createLoan(@RequestBody LoanPostRequest loanRequest){
        Loan loan = modelMapper.map(loanRequest, Loan.class);
        Loan newLoan = loanRepository.save(loan);
        return ResponseEntity.status(HttpStatus.CREATED).body(newLoan);
    }

    @DeleteMapping(value = "/library/loans/{id}")
    public ResponseEntity<Loan> deleteLoan(@PathVariable Long id){
        Optional<Loan> optionalLoan = loanRepository.findById(id);
        if (optionalLoan.isPresent()){
            loanRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        } else  {
            return ResponseEntity.notFound().build();

        }
    }


}
