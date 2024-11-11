package co.com.fpv.btg.utils;

import lombok.Getter;

@Getter
public enum FundCategoryEnum {
    FPV(1), FIC(2);

    private int codigo;
    private  FundCategoryEnum(int codigo) {
        this.codigo = codigo;
    }


}
