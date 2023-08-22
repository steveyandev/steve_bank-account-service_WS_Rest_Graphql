package steve.dev.steve_bankaccountservice_ws.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import steve.dev.steve_bankaccountservice_ws.entities.BankAccount;

@RepositoryRestResource
public interface BankAccountRepository extends JpaRepository<BankAccount,String> {
}
