package co.com.fpv.btg.persistence.adapters;

import co.com.fpv.btg.gateway.IPocketGateway;
import co.com.fpv.btg.models.Customer;
import co.com.fpv.btg.models.Pocket;
import co.com.fpv.btg.persistence.documents.CustomerDocument;
import co.com.fpv.btg.persistence.documents.PocketDocument;
import co.com.fpv.btg.persistence.repositories.IPocketRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PocketAdapter implements IPocketGateway {
    private final IPocketRepository pocketRepository;
    private final ModelMapper mapper;

    @Override
    public Pocket create(Pocket pocket) {
        PocketDocument pocketDocumentFound = pocketRepository.findByCustomerId(pocket.getCustomerId());
        if (pocketDocumentFound == null) {
            PocketDocument pocketDocument = pocketRepository
                    .save(mapper.map(pocket, PocketDocument.class));
            return mapper.map(pocketDocument, Pocket.class);
        }

        return null;
    }

    @Override
    public Pocket findByCustomerId(String customerId) {
        PocketDocument pocketDocument = pocketRepository.findByCustomerId(customerId);
        if (pocketDocument != null) {
            return  mapper.map(pocketDocument, Pocket.class);
        }
        return null;
    }

    @Override
    public Pocket update(Pocket pocket) {
        PocketDocument pocketDocument = pocketRepository
                .save(mapper.map(pocket, PocketDocument.class));
        return mapper.map(pocketDocument, Pocket.class);
    }
}
