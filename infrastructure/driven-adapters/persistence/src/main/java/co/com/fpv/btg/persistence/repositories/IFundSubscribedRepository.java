package co.com.fpv.btg.persistence.repositories;

import co.com.fpv.btg.persistence.documents.FundSubscribedDocument;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface IFundSubscribedRepository extends MongoRepository<FundSubscribedDocument, String> {
    List<FundSubscribedDocument> findAllByCustomerId(String customerId);
}
