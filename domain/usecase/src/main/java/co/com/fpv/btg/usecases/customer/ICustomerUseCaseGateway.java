package co.com.fpv.btg.usecases.customer;

import co.com.fpv.btg.models.Customer;

public interface ICustomerUseCaseGateway {
    Customer create(Customer customer);
    Customer findById(String id);
}
