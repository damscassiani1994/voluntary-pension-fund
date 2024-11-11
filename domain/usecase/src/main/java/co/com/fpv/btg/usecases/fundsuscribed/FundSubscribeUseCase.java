package co.com.fpv.btg.usecases.fundsuscribed;

import co.com.fpv.btg.data.FundSubscribedResponse;
import co.com.fpv.btg.gateway.ICustomerGateway;
import co.com.fpv.btg.gateway.IFundGateway;
import co.com.fpv.btg.gateway.IFundSubscribedGateway;
import co.com.fpv.btg.gateway.IPocketGateway;
import co.com.fpv.btg.models.FundSubscribed;
import co.com.fpv.btg.models.Pocket;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class FundSubscribeUseCase implements IFundSubscribeUseCaseGateway{

    private final IFundSubscribedGateway fundSubscribedGateway;
    private final IPocketGateway pocketGateway;

    @Override
    public FundSubscribedResponse open(FundSubscribed fundSubscribed) {
        Pocket pocket = pocketGateway.findByCustomerId(fundSubscribed.getCustomer().getId());
        if (pocket != null) {
            if (validateValue(pocket.getValue(), fundSubscribed.getLinkingValue())) {
                fundSubscribed.setIsActive(Boolean.TRUE);
                FundSubscribed fundCreated = fundSubscribedGateway.open(fundSubscribed);
                if (fundCreated != null) {
                    pocket.setValue(pocket.getValue() - fundSubscribed.getLinkingValue());
                    pocketGateway.update(pocket);
                }
                return FundSubscribedResponse
                        .builder()
                        .data(fundSubscribed)
                        .message("Se vinculo al fondo de forma exitosa")
                        .build();
            } else {
                return FundSubscribedResponse
                        .builder()
                        .data(null)
                        .message(String
                                .format("“No tiene saldo disponible para vincularse al fondo %s",
                                        fundSubscribed.getFund().getName()))
                        .build();
            }

        }
        return FundSubscribedResponse
                .builder()
                .data(null)
                .message("Hubo problemas al consultar su bolsillo")
                .build();
    }

    @Override
    public FundSubscribed cancel(String id) {
        FundSubscribed fundSubscribed = fundSubscribedGateway.cancel(id);
        if (fundSubscribed != null) {
            Pocket pocket = pocketGateway.findByCustomerId(fundSubscribed.getCustomer().getId());
            if (pocket != null) {
                pocket.setValue(pocket.getValue() + Math.abs(fundSubscribed.getLinkingValue()));
                pocketGateway.update(pocket);
            }
        }

        return  fundSubscribed;
    }

    @Override
    public List<FundSubscribed> findAll(String clientId) {
        return fundSubscribedGateway.findAll(clientId);
    }

    private Boolean validateValue(Double pocketValue, Double linkingValue) {
        if (pocketValue >= linkingValue) {
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }
}
