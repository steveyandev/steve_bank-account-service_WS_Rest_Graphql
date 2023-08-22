package steve.dev.steve_bankaccountservice_ws.entities;

import org.springframework.data.rest.core.config.Projection;
import steve.dev.steve_bankaccountservice_ws.enums.AccountType;

@Projection(types = BankAccount.class, name = "p1")
public interface AccountProjection {
    public String getId();
    public AccountType getType();
    public Double getBalance();
}
