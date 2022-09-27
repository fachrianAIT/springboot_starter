package org.ait.project.onboarding.modules.order.service.internal.impl;

import org.ait.project.onboarding.modules.order.dto.request.ResOrderPaymentRequest;
import org.ait.project.onboarding.modules.order.dto.request.ResOrderRequest;
import org.ait.project.onboarding.modules.order.dto.response.ResOrderResponse;
import org.ait.project.onboarding.modules.order.model.entity.ResOrder;
import org.ait.project.onboarding.modules.order.service.delegate.impl.OrderDelegateImpl;
import org.ait.project.onboarding.modules.order.service.internal.OrderInternal;
import org.ait.project.onboarding.modules.order.transform.OrderTransform;
import org.ait.project.onboarding.shared.enums.ResponseEnum;
import org.ait.project.onboarding.shared.template.ResponseDetail;
import org.ait.project.onboarding.shared.template.ResponseTemplate;
import org.ait.project.onboarding.shared.utils.ResponseHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


@Service
public class OrderInternalImpl implements OrderInternal {

  @Autowired
  OrderDelegateImpl orderDelegate;
  @Autowired
  ResponseHelper responseHelper;
  @Autowired
  OrderTransform resOrderTransform;

  @Override
  public ResponseEntity<ResponseTemplate<ResponseDetail<ResOrderResponse>>>
      getOrderByNoReff(String noReff) {
    ResOrder resOrder = orderDelegate.getOrderByNoreff(noReff);
    return responseHelper.createResponseDetail(ResponseEnum.SUCCESS,
        resOrderTransform.createOrderResponse(resOrder));
  }

  @Override
  public ResponseEntity<ResponseTemplate<ResponseDetail<ResOrderResponse>>>
      postDraftOrder(ResOrderRequest resOrderRequest) {
    ResOrder resOrder = orderDelegate.postDraftOrder(resOrderRequest);
    return responseHelper.createResponseDetail(ResponseEnum.SUCCESS,
        resOrderTransform.createOrderResponse(resOrder));
  }

  @Override
  public ResponseEntity<ResponseTemplate<ResponseDetail<ResOrderResponse>>>
      postPaidOrder(ResOrderPaymentRequest resOrderPaymentRequest) {
    if (resOrderPaymentRequest.getChannelPayment().equalsIgnoreCase("bank")) {
      ResOrder resOrder = orderDelegate.postPaidOrder(resOrderPaymentRequest.getChannelPayment(),
          resOrderPaymentRequest.getNoReff());

      return responseHelper.createResponseDetail(ResponseEnum.SUCCESS,
          resOrderTransform.createOrderResponse(resOrder));
    } else {
      ResOrder resOrder = orderDelegate.getOrderByNoreff(resOrderPaymentRequest.getNoReff());
      return responseHelper.createResponseDetail(ResponseEnum.PAYMENT_CHANNEL_BANK_ONLY,
          resOrderTransform.createOrderResponse(resOrder));
    }
  }
}
