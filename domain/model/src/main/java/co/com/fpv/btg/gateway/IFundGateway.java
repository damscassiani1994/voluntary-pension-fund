package co.com.fpv.btg.gateway;

import co.com.fpv.btg.models.Fund;

import java.util.List;

public interface IFundGateway {

    Boolean create(List<Fund> funds);
    List<Fund> findAll();
    Fund findById(String id);

}
