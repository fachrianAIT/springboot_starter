package org.ait.project.onboarding.shared.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum ResponseEnum {
  SUCCESS("TEST-0000", "success", HttpStatus.OK),
  NOT_FOUND("TEST-0001", "data.not.found", HttpStatus.NOT_FOUND),
  PAYMENT_CHANNEL_BANK_ONLY("TEST-0002", "payment.channel.bank.only", HttpStatus.OK),
  INVALID_PARAM("TEST-0009", "invalid.param", HttpStatus.BAD_REQUEST),
  INTERNAL_SERVER_ERROR("TEST-9999", "internal.server.error", HttpStatus.INTERNAL_SERVER_ERROR),
  ;

  private String responseCode;
  private String responseMessage;
  private HttpStatus httpStatus;

}
