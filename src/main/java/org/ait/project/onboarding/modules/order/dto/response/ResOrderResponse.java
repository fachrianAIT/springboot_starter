package org.ait.project.onboarding.modules.order.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;
import java.util.List;


@Data
@Builder
@ToString
public class ResOrderResponse {

    @JsonProperty("id")
    private int id;

    @JsonProperty("no_reff")
    private String noReff;

    @JsonProperty("customer_code")
    private String customerCode;

    @JsonProperty("merchant_code")
    private String merchantCode;

    @JsonProperty("total")
    private String total;

    @JsonProperty("status")
    private String status;

    @JsonProperty("order_line")
    private List<ResOrderLineResponse> orderLine;

}
