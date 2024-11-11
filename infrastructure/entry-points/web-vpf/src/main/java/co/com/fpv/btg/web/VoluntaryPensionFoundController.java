package co.com.fpv.btg.web;

import co.com.fpv.btg.usecases.ISaluteUseCaseGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RequiredArgsConstructor
@RequestMapping("/api/v1/vpf")
@RestController
public class VoluntaryPensionFoundController {

    private final ISaluteUseCaseGateway saluteUseCaseGateway;

    @ResponseStatus(HttpStatus.CREATED)
    @GetMapping
    public ResponseEntity<String> find() {
        return ResponseEntity.ok(saluteUseCaseGateway.getSalute());
    }
}
