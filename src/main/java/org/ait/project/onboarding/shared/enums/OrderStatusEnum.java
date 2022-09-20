package org.ait.project.onboarding.shared.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum OrderStatusEnum {
    DRAFT("draft", "Unpaid Order"),
    PAID("paid", "Order has been paid"),
    ;

    private String responseCode;
    private String responseMessage;
}
