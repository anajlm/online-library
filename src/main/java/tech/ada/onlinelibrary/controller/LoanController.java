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

import java.util.List;

@RestController
public class LoanController {

    private LoanRepository loanRepository;
    private ModelMapper modelMapper;

    @Autowired
    public LoanController(LoanRepository loanRepository, ModelMapper modelMapper){
        this.loanRepository = loanRepository;
        this.modelMapper = modelMapper;
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

    @PostMapping("/library/loans")
    public ResponseEntity<Loan> createLoan(@RequestBody LoanPostRequest loanRequest){
        Loan loan = modelMapper.map(loanRequest, Loan.class);
        Loan newLoan = loanRepository.save(loan);
        return ResponseEntity.status(HttpStatus.CREATED).body(newLoan);
    }


}
