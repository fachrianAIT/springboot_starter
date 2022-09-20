package org.ait.project.onboarding.modules.order.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;


@Data
@Builder
@ToString
public class ResOrderLineResponse {

    @JsonProperty("id")
    private int id;

    @JsonProperty("product_code")
    private String productCode;

    @JsonProperty("product_name")
    private String productName;

    @JsonProperty("product_qty")
    private String productQty;

    @JsonProperty("sub_total")
    private String subTotal;

}
