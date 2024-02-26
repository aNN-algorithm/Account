package com.example.Account_ann.controller;

import com.example.Account_ann.domain.Account;
import com.example.Account_ann.dto.AccountDto;
import com.example.Account_ann.dto.AccountInfo;
import com.example.Account_ann.dto.DeleteAccount;
import com.example.Account_ann.service.AccountService;
import com.example.Account_ann.service.RedisTestService;
import com.example.Account_ann.dto.CreateAccount;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class AccountController {
    private final AccountService accountService;
    private final RedisTestService redisTestService;

    @PostMapping("/account")
    public CreateAccount.Response createAccount(
            @RequestBody @Valid CreateAccount.Request reqeust
    ) {
        return CreateAccount.Response.from(
                accountService.createAccount(
                reqeust.getUserId(),
                reqeust.getInitialBalance())
        );
    }

    @DeleteMapping("/account")
    public DeleteAccount.Response deleteAccount(
            @RequestBody @Valid DeleteAccount.Request reqeust
    ) {
        return DeleteAccount.Response.from(
                accountService.deleteAccount(
                reqeust.getUserId(),
                reqeust.getAccountNumber())
        );
    }

    @GetMapping("/account")
    public List<AccountInfo> getAccountsByUserUd (
            @RequestParam("user_id") Long userId
    ) {
        return accountService.getAccountsByUserId(userId)
                .stream().map(accountDto -> AccountInfo.builder()
                        .accountNumber(accountDto.getAccountNumber())
                        .balance(accountDto.getBalance())
                        .build())
                .collect(Collectors.toList());
    }

    @GetMapping("/get-lock")
    public String getLock() {
        return redisTestService.getLock();
    }


    @GetMapping("/account/{id}")
    public Account getAccount(
            @PathVariable Long id) {

        return accountService.getAccount(id);
    }
}
