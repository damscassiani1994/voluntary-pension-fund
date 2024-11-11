package co.com.fpv.btg.gateway;

import co.com.fpv.btg.models.FundSubscribed;

import java.util.List;

public interface IFundSubscribedGateway {

    FundSubscribed open(FundSubscribed fundSubscribed);
    FundSubscribed cancel(String id);
    List<FundSubscribed> findAll(String clientId);
}
