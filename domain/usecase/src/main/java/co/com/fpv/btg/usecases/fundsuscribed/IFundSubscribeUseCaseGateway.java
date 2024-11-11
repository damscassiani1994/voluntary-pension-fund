package co.com.fpv.btg.usecases.fundsuscribed;

import co.com.fpv.btg.data.FundSubscribedResponse;
import co.com.fpv.btg.models.FundSubscribed;

import java.util.List;

public interface IFundSubscribeUseCaseGateway {

    FundSubscribedResponse open(FundSubscribed fundSubscribed);
    FundSubscribed cancel(String id);
    List<FundSubscribed> findAll(String clientId);
}
