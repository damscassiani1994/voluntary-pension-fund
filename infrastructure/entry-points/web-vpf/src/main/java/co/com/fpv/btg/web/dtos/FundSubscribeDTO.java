package co.com.fpv.btg.web.dtos;

import co.com.fpv.btg.models.Customer;
import co.com.fpv.btg.models.Fund;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FundSubscribeDTO {

    private String fund;
    private String customer;
    private Double linkingValue;
}
