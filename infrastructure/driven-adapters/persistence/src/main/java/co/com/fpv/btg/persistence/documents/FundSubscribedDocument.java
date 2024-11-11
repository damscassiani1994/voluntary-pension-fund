package co.com.fpv.btg.persistence.documents;


import co.com.fpv.btg.models.Customer;
import co.com.fpv.btg.models.Fund;
import co.com.fpv.btg.utils.GenericModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
@Document("fund_subscribed")
public class FundSubscribedDocument extends GenericModel {

    @Id
    private String id;
    private Fund fund;
    private Customer customer;
    private Double linkingValue;
}
