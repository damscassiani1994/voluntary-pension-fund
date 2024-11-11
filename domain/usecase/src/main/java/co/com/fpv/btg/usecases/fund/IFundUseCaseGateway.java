package co.com.fpv.btg.usecases.fund;

import co.com.fpv.btg.models.Fund;

public interface IFundUseCaseGateway {
    void createDefaultFund();
    Fund findById(String id);
}
