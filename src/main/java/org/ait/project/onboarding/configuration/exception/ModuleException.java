package org.ait.project.onboarding.configuration.exception;

import lombok.Getter;
import org.ait.project.onboarding.shared.enums.ResponseEnum;

@Getter
public class ModuleException extends RuntimeException {

  private final ResponseEnum responseEnum;

  public ModuleException(ResponseEnum responseEnum) {
    super(responseEnum.getResponseCode());
    this.responseEnum = responseEnum;
  }
}
