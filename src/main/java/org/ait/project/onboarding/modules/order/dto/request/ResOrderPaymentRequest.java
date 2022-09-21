package org.ait.project.onboarding.modules.order.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;


@Data
@Builder
@ToString
public class ResOrderPaymentRequest {

  @JsonProperty("no_reff")
  private String noReff;

  @JsonProperty("channel_payment")
  private String channelPayment;
}
