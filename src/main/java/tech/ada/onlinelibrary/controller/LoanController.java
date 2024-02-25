package tech.ada.onlinelibrary.controller;

import org.modelmapper.ModelMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tech.ada.onlinelibrary.domain.Loan;
import tech.ada.onlinelibrary.dto.LoanPostRequest;
import tech.ada.onlinelibrary.dto.LoanReturnDateRequest;
import tech.ada.onlinelibrary.repository.LoanRepository;
import tech.ada.onlinelibrary.service.LoanService;

import java.util.List;
import java.util.Optional;

@RestController
public class LoanController {

    private LoanService loanService;
    private LoanRepository loanRepository;
    private ModelMapper modelMapper;

    @Autowired
    public LoanController(LoanService loanService, LoanRepository loanRepository, ModelMapper modelMapper){
        this.loanService = loanService;
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
    public ResponseEntity<Loan> createLoan(@RequestBody CreateLoanRequest loanRequest){
        Loan loan = modelMapper.map(loanRequest, Loan.class);
        Loan newLoan = loanRepository.save(loan);
        return ResponseEntity.status(HttpStatus.CREATED).body(newLoan);
    }

    @PostMapping("/library/loans/return")
    public ResponseEntity<Loan> registerLoanReturn(@RequestBody LoanReturnDateRequest returnDateRequest) {
        Optional<Loan> loanOpt = loanService.registerLoanReturn(returnDateRequest);
        if (loanOpt.isPresent()) {
            return ResponseEntity.ok(loanOpt.get());
        } else {
            return ResponseEntity.notFound().build();
        }
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
