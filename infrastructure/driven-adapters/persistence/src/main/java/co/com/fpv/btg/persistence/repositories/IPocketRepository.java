package co.com.fpv.btg.persistence.repositories;

import co.com.fpv.btg.persistence.documents.PocketDocument;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface IPocketRepository extends MongoRepository<PocketDocument, String> {

    PocketDocument findByCustomerId(String customerId);
}
