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
public class Fund extends GenericModel {

    private String id;
    private String name;
    private Double minimumAmount;
    private Integer category;

    @Builder
    public Fund(Boolean isActive, String id, String name, Double minimumAmount, Integer category) {
        super(isActive);
        this.id = id;
        this.name = name;
        this.minimumAmount = minimumAmount;
        this.category = category;
    }
}
