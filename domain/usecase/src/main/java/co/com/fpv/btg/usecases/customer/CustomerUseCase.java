package co.com.fpv.btg.usecases.customer;

import co.com.fpv.btg.gateway.ICustomerGateway;
import co.com.fpv.btg.models.Customer;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CustomerUseCase implements ICustomerUseCaseGateway {

    private final ICustomerGateway customerGateway;

    @Override
    public Customer create(Customer customer) {
        customer.setIsActive(Boolean.TRUE);
        return customerGateway.create(customer);
    }

    @Override
    public Customer findById(String id) {
        return customerGateway.findById(id);
    }
}
