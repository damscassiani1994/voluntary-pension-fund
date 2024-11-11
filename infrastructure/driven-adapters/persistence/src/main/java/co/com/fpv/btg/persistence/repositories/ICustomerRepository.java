package co.com.fpv.btg.persistence.repositories;

import co.com.fpv.btg.persistence.documents.CustomerDocument;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ICustomerRepository extends MongoRepository<CustomerDocument, String> {

    CustomerDocument findByIdentificationNumberAndIdentificationType(
            String identificationNumber, String identificationType);
}
