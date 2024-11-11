package co.com.fpv.btg.data;

import co.com.fpv.btg.models.FundSubscribed;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class FundSubscribedResponse {

    private String message;
    private FundSubscribed data;
}
