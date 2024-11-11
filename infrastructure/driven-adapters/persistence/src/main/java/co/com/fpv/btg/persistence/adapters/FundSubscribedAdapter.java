package co.com.fpv.btg.persistence.adapters;

import co.com.fpv.btg.gateway.IFundSubscribedGateway;
import co.com.fpv.btg.models.FundSubscribed;
import co.com.fpv.btg.persistence.documents.FundSubscribedDocument;
import co.com.fpv.btg.persistence.repositories.IFundSubscribedRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class FundSubscribedAdapter implements IFundSubscribedGateway {

    private final IFundSubscribedRepository fundSubscribedRepository;
    private final ModelMapper mapper;
    @Override
    public FundSubscribed open(FundSubscribed fundSubscribed) {
        FundSubscribedDocument result =  fundSubscribedRepository
                .save(mapper.map(fundSubscribed, FundSubscribedDocument.class));

        return mapper.map(result, FundSubscribed.class);
    }

    @Override
    public FundSubscribed cancel(String id) {
        Optional<FundSubscribedDocument> fundSubscribedOpt = fundSubscribedRepository.findById(id);
        if (fundSubscribedOpt.isPresent()) {
            FundSubscribedDocument fundSubscribed = fundSubscribedOpt.get();
            fundSubscribed.setIsActive(Boolean.FALSE);
            fundSubscribed.setLinkingValue(-fundSubscribed.getLinkingValue());
            return mapper.map(fundSubscribedRepository.save(fundSubscribed), FundSubscribed.class);
        }
        return null;
    }

    @Override
    public List<FundSubscribed> findAll(String clientId) {
        List<FundSubscribedDocument> fundSubscribedDocuments = fundSubscribedRepository.findAllByCustomerId(clientId);
        List<FundSubscribed> fundSubscribes = new LinkedList<>();
        fundSubscribedDocuments.forEach(fundSubscribedDocument -> {
            fundSubscribes.add(mapper.map(fundSubscribedDocument, FundSubscribed.class));
        });

        return  fundSubscribes;
    }
}
