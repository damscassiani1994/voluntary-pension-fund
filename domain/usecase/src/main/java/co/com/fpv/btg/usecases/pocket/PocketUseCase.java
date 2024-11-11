package co.com.fpv.btg.usecases.pocket;

import co.com.fpv.btg.gateway.IPocketGateway;
import co.com.fpv.btg.models.Pocket;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class PocketUseCase implements IPocketUseCaseGateway{
    private final IPocketGateway pocketGateway;
    @Override
    public Pocket create(Pocket pocket) {
        return pocketGateway.create(pocket);
    }

    @Override
    public Pocket findByCustomerId(String customerId) {
        return pocketGateway.findByCustomerId(customerId);
    }
}
