package com.jean.accountmanager.manager.application;

import com.jean.accountmanager.manager.application.mapper.AccountMapper;
import com.jean.accountmanager.manager.application.request.AccountRequest;
import com.jean.accountmanager.manager.application.response.AccountResponse;
import com.jean.accountmanager.manager.domain.port.service.AccountService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/v1/account-manager")
@Slf4j
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class AcountManagerController {

    private AccountMapper accountMapper;
    private AccountService accountService;
    @PostMapping
    public ResponseEntity<AccountResponse> createAccount(@RequestBody AccountRequest request) {
        AccountResponse response = accountMapper.toResponse(accountService.createAccount(accountMapper.toDomain(request)));
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}
