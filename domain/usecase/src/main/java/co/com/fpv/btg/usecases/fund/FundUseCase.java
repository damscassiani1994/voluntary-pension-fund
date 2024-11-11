package co.com.fpv.btg.usecases.fund;

import co.com.fpv.btg.gateway.IFundGateway;
import co.com.fpv.btg.models.Fund;
import lombok.RequiredArgsConstructor;

import java.util.LinkedList;
import java.util.List;

import static co.com.fpv.btg.utils.FundCategoryEnum.FIC;
import static co.com.fpv.btg.utils.FundCategoryEnum.FPV;

@RequiredArgsConstructor
public class FundUseCase implements  IFundUseCaseGateway{

    private final IFundGateway fundGateway;
    @Override
    public void createDefaultFund() {

        List<Fund> funds = new LinkedList<>();
        funds.add(Fund.builder().name("FPV_BTG_PACTUAL_RECAUDADORA")
                .minimumAmount(75000D).category(FPV.getCodigo())
                .isActive(Boolean.TRUE).build());
        funds.add(Fund.builder().name("FPV_BTG_PACTUAL_ECOPETROL")
                .minimumAmount(125000D).category(FPV.getCodigo())
                .isActive(Boolean.TRUE).build());
        funds.add(Fund.builder().name("DEUDAPRIVADA")
                .minimumAmount(50000D).category(FIC.getCodigo())
                .isActive(Boolean.TRUE).build());
        funds.add(Fund.builder().name("FDO-ACCIONES")
                .minimumAmount(250000D).category(FIC.getCodigo())
                .isActive(Boolean.TRUE).build());
        funds.add(Fund.builder().name("FPV_BTG_PACTUAL_DINAMICA")
                .minimumAmount(100000D).category(FPV.getCodigo())
                .isActive(Boolean.TRUE).build());
        boolean result = fundGateway.create(funds);
        System.out.println(("Se agregaron los registros: " + result));
    }

    @Override
    public Fund findById(String id) {
        return fundGateway.findById(id);
    }
}
