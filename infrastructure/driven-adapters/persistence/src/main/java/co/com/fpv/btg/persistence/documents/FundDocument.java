package co.com.fpv.btg.persistence.documents;

import co.com.fpv.btg.persistence.util.GenericDocument;
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
@Document("funds")
public class FundDocument extends GenericDocument {

    @Id
    private String id;
    private String name;
    private Double minimumAmount;
    private Integer category;


    public String toString() {
        return String.format(
                "Fund[id=%s, name='%s', minimumAmount='%s', " +
                        "category='%s']",
                id, name, minimumAmount, category);
    }
}
