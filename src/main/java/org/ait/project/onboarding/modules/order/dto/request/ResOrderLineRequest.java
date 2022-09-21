package org.ait.project.onboarding.modules.order.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;


@Data
@Builder
@ToString
public class ResOrderLineRequest {

  @JsonProperty("product_code")
  private String productCode;

  @JsonProperty("product_name")
  private String productName;

  @JsonProperty("product_qty")
  private int productQty;

  @JsonProperty("sub_total")
  private int subTotal;
}
