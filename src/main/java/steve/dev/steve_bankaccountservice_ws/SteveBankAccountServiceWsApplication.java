package steve.dev.steve_bankaccountservice_ws;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import steve.dev.steve_bankaccountservice_ws.entities.BankAccount;
import steve.dev.steve_bankaccountservice_ws.enums.AccountType;
import steve.dev.steve_bankaccountservice_ws.repositories.BankAccountRepository;

import java.util.Date;
import java.util.UUID;

@SpringBootApplication
public class SteveBankAccountServiceWsApplication {

    public static void main(String[] args) {
        SpringApplication.run(SteveBankAccountServiceWsApplication.class, args);

    }
    @Bean
    CommandLineRunner start(BankAccountRepository bankAccountRepository){
        return args -> {
            for (int i=0; i<10; i++){
                BankAccount bankAccount=BankAccount.builder()
                        .id(UUID.randomUUID().toString())
                        .type(Math.random()>0.5? AccountType.CURRENT_ACCOUNT:AccountType.SAVING_ACCOUNT)
                        .balance(1000+Math.random()*90000)
                        .createdAt(new Date())
                        .currency("MAD")
                        .build();
                bankAccountRepository.save(bankAccount);
            }
        };
    }

}
