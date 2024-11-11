package co.com.fpv.btg.models;

import co.com.fpv.btg.utils.GenericModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Customer extends GenericModel {

    private String id;
    private String identificationType;
    private String identificationNumber;
    private String name;
    private String email;
    private String cellPhoneCode;
    private String cellPhoneNumber;

    @Builder
    public Customer(Boolean isActive, String id, String identificationType, String identificationNumber, String name,
                    String email, String cellPhoneCode, String cellPhoneNumber) {
        super(isActive);
        this.id = id;
        this.identificationType = identificationType;
        this.identificationNumber = identificationNumber;
        this.name = name;
        this.email = email;
        this.cellPhoneCode = cellPhoneCode;
        this.cellPhoneNumber = cellPhoneNumber;
    }
}
