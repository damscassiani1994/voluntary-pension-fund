package co.com.fpv.btg.models;


import co.com.fpv.btg.utils.GenericModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FundSubscribed extends GenericModel {

    private String id;
    private Fund fund;
    private Customer customer;
    private Double linkingValue;

    @Builder
    public FundSubscribed(Boolean isActive, String id, Fund fund, Customer customer, Double linkingValue) {
        super(isActive);
        this.id = id;
        this.fund = fund;
        this.customer = customer;
        this.linkingValue = linkingValue;
    }
}
