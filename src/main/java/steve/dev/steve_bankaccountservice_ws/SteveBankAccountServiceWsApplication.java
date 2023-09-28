package steve.dev.steve_bankaccountservice_ws;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import steve.dev.steve_bankaccountservice_ws.entities.BankAccount;
import steve.dev.steve_bankaccountservice_ws.entities.Customer;
import steve.dev.steve_bankaccountservice_ws.enums.AccountType;
import steve.dev.steve_bankaccountservice_ws.repositories.BankAccountRepository;
import steve.dev.steve_bankaccountservice_ws.repositories.CustomerRepository;

import java.util.Date;
import java.util.UUID;
import java.util.stream.Stream;

@SpringBootApplication
public class SteveBankAccountServiceWsApplication {

    public static void main(String[] args) {
        SpringApplication.run(SteveBankAccountServiceWsApplication.class, args);

    }
    @Bean
    CommandLineRunner start(BankAccountRepository bankAccountRepository, CustomerRepository customerRepository){
        return args -> {
            Stream.of("Steve","Herman","Azer").forEach(c->{
                Customer customer=Customer.builder()
                                .name(c)
                                .build();

                customerRepository.save(customer);
            });

    customerRepository.findAll().forEach(
            customer -> {
                for (int i=0; i<10; i++){
                    BankAccount bankAccount=BankAccount.builder()
                            .id(UUID.randomUUID().toString())
                            .type(Math.random()>0.5? AccountType.CURRENT_ACCOUNT:AccountType.SAVING_ACCOUNT)
                            .balance(1000+Math.random()*90000)
                            .createdAt(new Date())
                            .currency("MAD")
                            .customer(customer)
                            .build();
                    bankAccountRepository.save(bankAccount);
                }
            }
    );

        };
    }

}
