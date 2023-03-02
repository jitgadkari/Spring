package com.project.demoproject.service;

import com.project.demoproject.controller.Account;

import java.util.List;

public interface AccountService {

    List<Account> getAccounts();
    Account saveAccount(Account account);
    Account getSingleAccount(Long id);

    void deleteAccount(Long id);

    Account updateAccount(Account account);

}
