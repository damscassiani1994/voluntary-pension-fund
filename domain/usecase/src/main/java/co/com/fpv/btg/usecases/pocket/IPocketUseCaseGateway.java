package co.com.fpv.btg.usecases.pocket;

import co.com.fpv.btg.models.Pocket;

public interface IPocketUseCaseGateway {
    Pocket create(Pocket pocket);
    Pocket findByCustomerId(String customerId);
}
