package co.com.fpv.btg.persistence.adapters;

import co.com.fpv.btg.gateway.IFundGateway;
import co.com.fpv.btg.models.Fund;
import co.com.fpv.btg.persistence.documents.FundDocument;
import co.com.fpv.btg.persistence.repositories.IFundRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class FundAdapter implements IFundGateway {

    private  final IFundRepository fundRepository;
    private final ModelMapper mapper;

    @Override
    public Boolean create(List<Fund> funds) {
        List<FundDocument> fundDocuments = new LinkedList<>();
        mapper.map(funds, fundDocuments);
        funds.forEach(fund -> {
            FundDocument fundDocument = fundRepository.findByName(fund.getName());
            if (fundDocument == null) {
                fundDocuments.add(mapper.map(fund, FundDocument.class));
            }

        });
        if (!fundDocuments.isEmpty()) {
            fundRepository.saveAll(fundDocuments);
            fundDocuments.stream().map(FundDocument::toString).forEach(System.out::println);
            return true;
        }
        return false;
    }

    @Override
    public List<Fund> findAll() {
        List<FundDocument> fundDocuments = fundRepository.findAll();
        List<Fund> funds = new LinkedList<>();
        mapper.map(fundDocuments, funds);
        return funds;
    }

    @Override
    public Fund findById(String id) {
        Optional<FundDocument> fundDocument = fundRepository.findById(id);
        return fundDocument.map(document -> mapper.map(document, Fund.class)).orElse(null);
    }
}
