package steve.dev.steve_bankaccountservice_ws.web;


import org.springframework.web.bind.annotation.*;
import steve.dev.steve_bankaccountservice_ws.entities.BankAccount;
import steve.dev.steve_bankaccountservice_ws.repositories.BankAccountRepository;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
public class AccountRestRepository {
    private BankAccountRepository bankAccountRepository;

    public AccountRestRepository(BankAccountRepository bankAccountRepository) {
        this.bankAccountRepository = bankAccountRepository;
    }

    @GetMapping("/bankAccounts")
    public List<BankAccount> bankAccounts(){
        return bankAccountRepository.findAll();
    }
    @GetMapping("/bankAccounts/{id}")
    public BankAccount bankAccount(@PathVariable String id){
        return bankAccountRepository.findById(id)
                .orElseThrow(()->new RuntimeException(String.format("Account %s not found",id)));
    }

    @PostMapping("/bankAccounts")
    public BankAccount save(@RequestBody BankAccount bankAccount){
        if (bankAccount.getId()==null) bankAccount.setId(UUID.randomUUID().toString());
        return bankAccountRepository.save(bankAccount);
    }

    @PutMapping("bankAccounts/{id}")
    public BankAccount update(@PathVariable String id,@RequestBody BankAccount bankAccount){
        BankAccount account=bankAccountRepository.findById(id).orElseThrow();
       if (bankAccount.getBalance()!=null) account.setBalance(bankAccount.getBalance());
       if (bankAccount.getCreatedAt()!=null) account.setCreatedAt(new Date());
       if(bankAccount.getType()!=null) account.setType(bankAccount.getType());
       if(bankAccount.getCurrency()!=null) account.setCurrency(bankAccount.getCurrency());

        return bankAccountRepository.save(account);
    }

    @DeleteMapping("/bankAccounts/{id}")
    public void deleteAccount(@PathVariable String id){
       bankAccountRepository.deleteById(id);

    }

}
