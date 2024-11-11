package co.com.fpv.btg.web;

import co.com.fpv.btg.models.FundSubscribed;
import co.com.fpv.btg.models.Pocket;
import co.com.fpv.btg.usecases.pocket.IPocketUseCaseGateway;
import co.com.fpv.btg.web.dtos.FundSubscribeDTO;
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
@RequestMapping("/api/v1/vpf/pocket")
@RestController
public class PocketController {

    private final IPocketUseCaseGateway pocketUseCaseGateway;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public ResponseEntity<Pocket> open(@RequestBody Pocket pocket) {
        Pocket result = pocketUseCaseGateway.create(pocket);
        if (result != null) {
            return ResponseEntity.ok(result);
        }

        return ResponseEntity.status(HttpStatus.CONFLICT).build();
    }
}
