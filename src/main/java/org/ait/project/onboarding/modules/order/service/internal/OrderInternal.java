package org.ait.project.onboarding.modules.order.service.internal;

import org.ait.project.onboarding.modules.order.dto.request.ResOrderPaymentRequest;
import org.ait.project.onboarding.modules.order.dto.request.ResOrderRequest;
import org.ait.project.onboarding.modules.order.dto.response.ResOrderResponse;
import org.ait.project.onboarding.shared.template.ResponseDetail;
import org.ait.project.onboarding.shared.template.ResponseTemplate;
import org.springframework.http.ResponseEntity;


public interface OrderInternal {

  ResponseEntity<ResponseTemplate<ResponseDetail<ResOrderResponse>>> getOrderByNoReff(
      String noReff);

  ResponseEntity<ResponseTemplate<ResponseDetail<ResOrderResponse>>> postDraftOrder(
      ResOrderRequest resOrderRequest);

  ResponseEntity<ResponseTemplate<ResponseDetail<ResOrderResponse>>> postPaidOrder(
      ResOrderPaymentRequest resOrderPaymentRequest);
}

