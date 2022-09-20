package org.ait.project.onboarding.modules.order.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import java.util.List;


@Data
@Builder
@ToString
public class ResOrderRequest {

    @JsonProperty("customer_code")
    private String customerCode;

    @JsonProperty("merchant_code")
    private String merchantCode;

    @JsonProperty("total")
    private int total;

    @JsonProperty("customer_phone")
    private String customerPhone;

    @JsonProperty("customer_email")
    private String customerEmail;

    @JsonProperty("customer_address")
    private String customerAddress;

    @JsonProperty("order_line")
    private List<ResOrderLineRequest> orderLine;

}
