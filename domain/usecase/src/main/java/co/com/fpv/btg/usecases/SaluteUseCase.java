package co.com.fpv.btg.usecases;

import co.com.fpv.btg.models.TestBTG;

public class SaluteUseCase implements ISaluteUseCaseGateway{
    @Override
    public String getSalute() {
        TestBTG testBTG = new TestBTG();
        testBTG.setSalute("Hola mundo btg");
        return testBTG.getSalute();
    }
}
