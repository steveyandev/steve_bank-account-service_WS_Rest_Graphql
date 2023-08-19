package steve.dev.steve_bankaccountservice_ws.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import steve.dev.steve_bankaccountservice_ws.entities.BankAccount;

public interface BankAccountRepository extends JpaRepository<BankAccount,Long> {
}
