package com.project.demoproject.service;

import com.project.demoproject.controller.Account;
import com.project.demoproject.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.List;
import java.util.Optional;

@Service
public class AccountServiceImpl implements  AccountService {
    @Autowired
    private AccountRepository aRepository;

    @Override
    public List<Account> getAccounts() {
        return aRepository.findAll();
    }

    @Override
    public Account saveAccount(Account account) {
        return aRepository.save(account);
    }
    @Override
    public Account getSingleAccount(Long id) {
        Optional<Account>account= aRepository.findById(id);
        if(account.isPresent()){
            return  account.get();
        }
        throw  new RuntimeException("Account not found for this id"+id);
    }
    @Override
    public void deleteAccount(Long id){
        aRepository.deleteById(id);
    }
    @Override
    public Account updateAccount(Account account){
        return aRepository.save(account);
    }

}


