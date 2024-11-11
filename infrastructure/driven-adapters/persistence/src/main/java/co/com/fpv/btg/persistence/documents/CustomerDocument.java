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
@Document("customers")
public class CustomerDocument extends GenericDocument {

    @Id
    private String id;
    private String identificationType;
    private String identificationNumber;
    private String name;
    private String email;
    private String cellPhoneCode;
    private String cellPhoneNumber;
}
