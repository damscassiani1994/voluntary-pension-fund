package co.com.fpv.btg.gateway;


import co.com.fpv.btg.models.Pocket;

public interface IPocketGateway {

    Pocket create(Pocket pocket);
    Pocket findByCustomerId(String customerId);
    Pocket update(Pocket pocket);
}
