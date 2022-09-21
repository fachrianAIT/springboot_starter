package org.ait.project.onboarding.modules.order.service.delegate;

import org.ait.project.onboarding.modules.order.dto.request.ResOrderRequest;
import org.ait.project.onboarding.modules.order.model.entity.ResOrder;


public interface OrderDelegate {

  // res_product
  ResOrder getOrderByNoreff(String noReff);

  ResOrder postDraftOrder(ResOrderRequest resOrderRequest);

  ResOrder postPaidOrder(String noReff, String channelPayment);
}
