package org.ait.project.onboarding.modules.master.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;


@Data
@Builder
@ToString
public class ResProductResponse {

  @JsonProperty("id")
  private int id;

  @JsonProperty("product_code")
  private String productCode;

  @JsonProperty("product_name")
  private String productName;

  @JsonProperty("product_qty")
  private String productQty;

  @JsonProperty("merchant_name")
  private String merchantName;

  @JsonProperty("merchant_code")
  private String merchantCode;

}
