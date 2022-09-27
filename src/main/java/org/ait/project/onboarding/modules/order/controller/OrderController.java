package org.ait.project.onboarding.modules.order.controller;

import org.ait.project.onboarding.modules.order.dto.request.ResOrderPaymentRequest;
import org.ait.project.onboarding.modules.order.dto.request.ResOrderRequest;
import org.ait.project.onboarding.modules.order.dto.response.ResOrderResponse;
import org.ait.project.onboarding.modules.order.service.internal.OrderInternal;
import org.ait.project.onboarding.modules.order.service.internal.impl.OrderInternalImpl;
import org.ait.project.onboarding.shared.template.ResponseDetail;
import org.ait.project.onboarding.shared.template.ResponseTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/trx/v1")
public class OrderController implements OrderInternal {

  @Autowired
  OrderInternalImpl orderInternal;

  @Override
  @GetMapping("order/{noReff}")
  public ResponseEntity<ResponseTemplate<ResponseDetail<ResOrderResponse>>> getOrderByNoReff(
      @PathVariable String noReff) {
    return orderInternal.getOrderByNoReff(noReff);
  }

  @Override
  @PostMapping("draft-order")
  public ResponseEntity<ResponseTemplate<ResponseDetail<ResOrderResponse>>> postDraftOrder(
      @RequestBody  ResOrderRequest resOrderRequest) {
    return orderInternal.postDraftOrder(resOrderRequest);
  }

  @Override
  @PostMapping("paid-order")
  public ResponseEntity<ResponseTemplate<ResponseDetail<ResOrderResponse>>> postPaidOrder(
      @RequestBody  ResOrderPaymentRequest resOrderPaymentRequest) {
    return orderInternal.postPaidOrder(resOrderPaymentRequest);
  }
}
