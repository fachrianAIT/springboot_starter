package org.ait.project.onboarding.modules.order.controller;

import org.ait.project.onboarding.modules.order.dto.request.ResOrderPaymentRequest;
import org.ait.project.onboarding.modules.order.dto.request.ResOrderRequest;
import org.ait.project.onboarding.modules.order.dto.response.ResOrderResponse;
import org.ait.project.onboarding.shared.template.ResponseDetail;
import org.ait.project.onboarding.shared.template.ResponseTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;


public interface OrderController {


  ResponseEntity<ResponseTemplate<ResponseDetail<ResOrderResponse>>> getOrderByNoReff(
      String noReff);

  ResponseEntity<ResponseTemplate<ResponseDetail<ResOrderResponse>>> postDraftOrder(
      @RequestBody ResOrderRequest resOrderRequest);

  ResponseEntity<ResponseTemplate<ResponseDetail<ResOrderResponse>>> postPaidOrder(
      @RequestBody ResOrderPaymentRequest resOrderPaymentRequest);
}
