package co.com.fpv.btg.web;

import co.com.fpv.btg.data.FundSubscribedResponse;
import co.com.fpv.btg.models.Customer;
import co.com.fpv.btg.models.Fund;
import co.com.fpv.btg.models.FundSubscribed;
import co.com.fpv.btg.usecases.customer.ICustomerUseCaseGateway;
import co.com.fpv.btg.usecases.fund.IFundUseCaseGateway;
import co.com.fpv.btg.usecases.fundsuscribed.IFundSubscribeUseCaseGateway;
import co.com.fpv.btg.web.dtos.FundSubscribeDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static io.micrometer.common.util.StringUtils.isEmpty;

@RequiredArgsConstructor
@RequestMapping("/api/v1/vpf/fund-subscribe")
@RestController
public class FundSubscribeController {

    private final IFundSubscribeUseCaseGateway fundSubscribeUseCaseGateway;
    private final IFundUseCaseGateway fundUseCaseGateway;
    private final ICustomerUseCaseGateway customerUseCaseGateway;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public ResponseEntity<FundSubscribedResponse> open(@RequestBody FundSubscribeDTO fundSubscribeDTO) {
        if (!isEmpty(fundSubscribeDTO.getFund()) && !isEmpty(fundSubscribeDTO.getCustomer())) {
            FundSubscribed fundSubscribedAdd = getFundSubscribed(fundSubscribeDTO);
            if (fundSubscribedAdd != null) {
                FundSubscribedResponse result = fundSubscribeUseCaseGateway.open(fundSubscribedAdd);
                if (result != null) {
                    return ResponseEntity.ok(result);
                }
            }

        }

        return ResponseEntity.status(HttpStatus.CONFLICT).build();
    }


    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/cancel")
    public ResponseEntity<FundSubscribed> cancel(@RequestParam(name = "id") String id) {
        FundSubscribed result = fundSubscribeUseCaseGateway.cancel(id);
        if (result != null) {
            return ResponseEntity.ok(result);
        }
        return ResponseEntity.status(HttpStatus.CONFLICT).build();
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/all")
    public ResponseEntity<List<FundSubscribed>> findAll(@RequestParam(name = "clientId") String id) {
        List<FundSubscribed> result = fundSubscribeUseCaseGateway.findAll(id);
        return ResponseEntity.ok(result);
    }

    private FundSubscribed getFundSubscribed(FundSubscribeDTO fundSubscribeDTO) {
        Customer customer = customerUseCaseGateway.findById(fundSubscribeDTO.getCustomer());
        Fund fund = fundUseCaseGateway.findById(fundSubscribeDTO.getFund());


        if (fund != null && customer != null) {
            FundSubscribed fundSubscribed = new FundSubscribed();
            fundSubscribed.setFund(fund);
            fundSubscribed.setCustomer(customer);
            fundSubscribed.setLinkingValue(fundSubscribeDTO.getLinkingValue());
            return fundSubscribed;
        }
        return null;
    }
}
