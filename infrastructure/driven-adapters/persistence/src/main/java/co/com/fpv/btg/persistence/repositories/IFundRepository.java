package co.com.fpv.btg.persistence.repositories;

import co.com.fpv.btg.persistence.documents.FundDocument;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface IFundRepository extends MongoRepository<FundDocument, String> {
    FundDocument findByName(String name);
}
