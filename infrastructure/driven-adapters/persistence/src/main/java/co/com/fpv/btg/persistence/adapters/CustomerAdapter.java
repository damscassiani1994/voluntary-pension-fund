package co.com.fpv.btg.persistence.adapters;

import co.com.fpv.btg.gateway.ICustomerGateway;
import co.com.fpv.btg.models.Customer;
import co.com.fpv.btg.persistence.documents.CustomerDocument;
import co.com.fpv.btg.persistence.repositories.ICustomerRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CustomerAdapter implements ICustomerGateway {
    private final ICustomerRepository customerRepository;

    private final ModelMapper mapper;
    @Override
    public Customer create(Customer customer) {
        CustomerDocument customerDocumentFound = customerRepository
                .findByIdentificationNumberAndIdentificationType(customer.getIdentificationNumber(),
                        customer.getIdentificationType());
        if (customerDocumentFound == null) {
            CustomerDocument customerDocument = customerRepository.save(mapper.map(customer, CustomerDocument.class));
            return mapper.map(customerDocument, Customer.class);
        }
        return null;
    }

    @Override
    public Customer findById(String id) {
        return customerRepository.findById(id).map(fund -> mapper.map(fund, Customer.class)).orElse(null);
    }
}
