package co.com.fpv.btg.web;


import co.com.fpv.btg.models.Customer;
import co.com.fpv.btg.usecases.customer.ICustomerUseCaseGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RequestMapping("/api/v1/vpf/customer")
@RestController
public class CustomerController {

    private final ICustomerUseCaseGateway customerUseCaseGateway;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public ResponseEntity<Customer> create(@RequestBody Customer customer) {
        Customer result = customerUseCaseGateway.create(customer);
        if (result != null) {
            return ResponseEntity.ok(result);
        }
        return ResponseEntity.status(HttpStatus.CONFLICT).build();
    }
}