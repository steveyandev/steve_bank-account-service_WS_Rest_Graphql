package steve.dev.steve_bankaccountservice_ws.web;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import steve.dev.steve_bankaccountservice_ws.dto.BankAccountRequestDTO;
import steve.dev.steve_bankaccountservice_ws.dto.BankAccountResponseDTO;
import steve.dev.steve_bankaccountservice_ws.entities.BankAccount;
import steve.dev.steve_bankaccountservice_ws.repositories.BankAccountRepository;
import steve.dev.steve_bankaccountservice_ws.service.AccountService;

import java.util.List;

@Controller
public class BankAccountGraphQLController {
    @Autowired
    private BankAccountRepository bankAccountRepository;
    @Autowired
    private AccountService accountService;
    @QueryMapping
    public List<BankAccount> accountsList(){
        return bankAccountRepository.findAll();
    }
    @QueryMapping
    public BankAccount bankAccountById(@Argument String id){
        return bankAccountRepository.findById(id)
                .orElseThrow(()->new RuntimeException(String.format("Account %s not found",id)));
    }
    @MutationMapping
    public BankAccountResponseDTO addAccount(@Argument BankAccountRequestDTO bankAccount){
       return accountService.addAccount(bankAccount);
    }
}
/*@Data @NoArgsConstructor @AllArgsConstructor
class BankAccountDTO{
    private String type;
    private  Double balance;
    private String currency;
}*/
/*
record BankAccountDTO(Double balance, String type,String currency ){

}
*/

