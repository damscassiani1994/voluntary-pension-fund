package co.com.fpv.btg.gateway;

import co.com.fpv.btg.models.Customer;

public interface ICustomerGateway {

    Customer create(Customer customer);

    Customer findById(String id);
}
