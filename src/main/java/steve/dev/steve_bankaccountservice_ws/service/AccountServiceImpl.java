package steve.dev.steve_bankaccountservice_ws.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import steve.dev.steve_bankaccountservice_ws.dto.BankAccountRequestDTO;
import steve.dev.steve_bankaccountservice_ws.dto.BankAccountResponseDTO;
import steve.dev.steve_bankaccountservice_ws.entities.BankAccount;
import steve.dev.steve_bankaccountservice_ws.mappers.AccountMapper;
import steve.dev.steve_bankaccountservice_ws.repositories.BankAccountRepository;

import java.util.Date;
import java.util.UUID;

@Service @Transactional
public class AccountServiceImpl implements AccountService {
    @Autowired
    private BankAccountRepository bankAccountRepository;
    @Autowired
    private AccountMapper accountMapper;
    @Override
    public BankAccountResponseDTO addAccount(BankAccountRequestDTO bankAccountDTO) {
        //create also a mapper for transforming bankAccountRequestDTO to bankAccount
        BankAccount bankAccount= BankAccount.builder()
                .id(UUID.randomUUID().toString())
                .createdAt(new Date())
                .balance(bankAccountDTO.getBalance())
                .type(bankAccountDTO.getType())
                .currency(bankAccountDTO.getCurrency())
                .build();
        BankAccount savedBankAccount=bankAccountRepository.save(bankAccount);
        BankAccountResponseDTO bankAccountResponseDTO = accountMapper.fromBankAccount(savedBankAccount);
        /* // old version not using account mapper
        BankAccountResponseDTO bankAccountResponseDTO=BankAccountResponseDTO.builder()
                .id(savedBankAccount.getId())
                .type(savedBankAccount.getType())
                .createdAt(savedBankAccount.getCreatedAt())
                .currency(savedBankAccount.getCurrency())
                .balance(savedBankAccount.getBalance())
                .build();
                 return bankAccountResponseDTO;
                 */
        return bankAccountResponseDTO;


    }
    @Override
    public BankAccountResponseDTO updateAccount(String id, BankAccountRequestDTO bankAccountDTO) {
        //create also a mapper for transforming bankAccountRequestDTO to bankAccount
        BankAccount bankAccount= BankAccount.builder()
                .id(id)
                .createdAt(new Date())
                .balance(bankAccountDTO.getBalance())
                .type(bankAccountDTO.getType())
                .currency(bankAccountDTO.getCurrency())
                .build();
        BankAccount savedBankAccount=bankAccountRepository.save(bankAccount);
        BankAccountResponseDTO bankAccountResponseDTO = accountMapper.fromBankAccount(savedBankAccount);
        return bankAccountResponseDTO;


    }
}
