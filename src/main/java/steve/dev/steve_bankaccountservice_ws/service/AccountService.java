package steve.dev.steve_bankaccountservice_ws.service;

import steve.dev.steve_bankaccountservice_ws.dto.BankAccountRequestDTO;
import steve.dev.steve_bankaccountservice_ws.dto.BankAccountResponseDTO;
import steve.dev.steve_bankaccountservice_ws.entities.BankAccount;

public interface AccountService {
    public BankAccountResponseDTO addAccount(BankAccountRequestDTO bankAccountDTO)
}
