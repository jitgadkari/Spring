package com.project.demoproject.controller;

//import org.springframework.stereotype.Controller;
import com.project.demoproject.service.AccountService;
import lombok.Value;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
//import org.springframework.web.bind.annotation.ResponseBody;


//@Controller
@RestController
@RequestMapping("/api")
public class AccountController {

//    @RequestMapping(value = "/accounts",method = RequestMethod.GET)

    @Autowired
    private AccountService aService;
    @GetMapping("/accounts")
    public List<Account> getAccounts(){
        return  aService.getAccounts();
    }

    @GetMapping("/accounts/{id}")
    public  Account getAccount(@PathVariable("id")Long id){
        return aService.getSingleAccount(id);
    }

    @PostMapping("/accounts")
    public  Account saveAccount(@RequestBody Account account){
        return aService.saveAccount(account) ;
    }
    @PutMapping("/accounts/{id}")
    public  Account updateAccount(@PathVariable Long id, @RequestBody Account account){
        account.setId(id);
        return aService.updateAccount(account);
    }
    @DeleteMapping("/accounts")
    public void deleteAccount(@RequestParam("id")Long id){
        aService.deleteAccount(id);
    }



}
