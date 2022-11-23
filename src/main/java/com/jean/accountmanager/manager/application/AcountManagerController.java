package com.jean.accountmanager.manager.application;

import com.jean.accountmanager.manager.application.mapper.AccountMapper;
import com.jean.accountmanager.manager.application.mapper.TransactionMapper;
import com.jean.accountmanager.manager.application.request.AccountRequest;
import com.jean.accountmanager.manager.application.request.TransactionRequest;
import com.jean.accountmanager.manager.application.response.AccountResponse;
import com.jean.accountmanager.manager.application.response.TransactionResponse;
import com.jean.accountmanager.manager.domain.port.service.AccountService;
import com.jean.accountmanager.manager.domain.port.service.TransactionService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/v1/account-manager")
@Slf4j
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class AcountManagerController {

    private AccountMapper accountMapper;
    private TransactionMapper transactionMapper;
    private AccountService accountService;

    private TransactionService transactionService;
    @PostMapping
    public ResponseEntity<AccountResponse> createAccount(@RequestBody AccountRequest request) {
        AccountResponse response = accountMapper.toResponse(accountService.createAccount(accountMapper.toDomain(request)));
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("/{accountId}")
    public ResponseEntity<AccountResponse> getAccount(@PathVariable("accountId") Integer accountId) {
        AccountResponse response = accountMapper.toResponse(accountService.getAccount(accountId));
        return ResponseEntity.ok(response);
    }

    @PostMapping("/transactions")
    public ResponseEntity<TransactionResponse> createTransaction(@RequestBody TransactionRequest request) {
        TransactionResponse response = transactionMapper.toResponse(transactionService.createTransaction(transactionMapper.toDomain(request)));
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}
