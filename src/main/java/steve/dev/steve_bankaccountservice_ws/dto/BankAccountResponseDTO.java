package steve.dev.steve_bankaccountservice_ws.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import steve.dev.steve_bankaccountservice_ws.enums.AccountType;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.util.Date;

@Data @AllArgsConstructor @NoArgsConstructor @Builder
public class BankAccountResponseDTO {
    private String id;
    private Date createdAt;
    private Double balance;
    private String currency;
    private AccountType type;
}
