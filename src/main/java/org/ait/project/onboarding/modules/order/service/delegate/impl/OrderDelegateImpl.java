package org.ait.project.onboarding.modules.order.service.delegate.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.ait.project.onboarding.modules.master.model.entity.ResCustomer;
import org.ait.project.onboarding.modules.master.model.entity.ResMerchant;
import org.ait.project.onboarding.modules.master.model.repository.ResCustomerRepository;
import org.ait.project.onboarding.modules.master.model.repository.ResMerchantRepository;
import org.ait.project.onboarding.modules.master.model.repository.ResProductRepository;
import org.ait.project.onboarding.modules.order.dto.request.ResOrderLineRequest;
import org.ait.project.onboarding.modules.order.dto.request.ResOrderRequest;
import org.ait.project.onboarding.modules.order.model.entity.ResOrder;
import org.ait.project.onboarding.modules.order.model.entity.ResOrderLine;
import org.ait.project.onboarding.modules.order.model.repository.ResOrderRepository;
import org.ait.project.onboarding.modules.order.service.delegate.OrderDelegate;
import org.ait.project.onboarding.modules.order.transform.OrderTransform;
import org.ait.project.onboarding.shared.enums.OrderStatusEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class OrderDelegateImpl implements OrderDelegate {

  @Autowired
  ResOrderRepository resOrderRepository;
  @Autowired
  ResCustomerRepository resCustomerRepository;
  @Autowired
  ResMerchantRepository resMerchantRepository;
  @Autowired
  ResProductRepository resProductRepository;

  @Autowired
  OrderTransform orderTransform;

  @Override
  public ResOrder getOrderByNoreff(String noReff) {
    return resOrderRepository.findByNoReff(noReff);
  }

  @Override
  public ResOrder postDraftOrder(ResOrderRequest resOrderRequest) {

    ResCustomer resCustomer = resCustomerRepository.findFirstByCustomerCode(
        resOrderRequest.getCustomerCode()).orElseThrow(() -> new RuntimeException("No Customer Data"));
    ResMerchant resMerchant = resMerchantRepository.findFirstByMerchantCode(
        resOrderRequest.getMerchantCode()).orElseThrow(() -> new RuntimeException("No Merchant Data"));;

    List<ResOrderLineRequest> resOrderLineRequestList = resOrderRequest.getOrderLine();

    ResOrder resOrder = new ResOrder();
    List<ResOrderLine> resOrderLines = new ArrayList<ResOrderLine>();

    for (int i = 0; i < resOrderLineRequestList.size(); i += 1) {

      ResOrderLine itemLine = new ResOrderLine();
      itemLine.setProductCode(resOrderLineRequestList.get(i).getProductCode());
      itemLine.setProductName(resOrderLineRequestList.get(i).getProductName());
      itemLine.setProductQty(resOrderLineRequestList.get(i).getProductQty());
      itemLine.setSubTotal(resOrderLineRequestList.get(i).getSubTotal());
      itemLine.setOrderId(resOrder);
      resOrderLines.add(itemLine);

      resProductRepository.updateProductQtyByProductCode(
          resOrderLineRequestList.get(i).getProductQty(),
          resOrderLineRequestList.get(i).getProductCode());
    }

    UUID uuid = UUID.randomUUID();

    resOrder.setResCustomer(resCustomer);
    resOrder.setResMerchant(resMerchant);
    resOrder.setNoReff(uuid.toString());
    resOrder.setStatus(OrderStatusEnum.DRAFT.getResponseCode());
    resOrder.setTotal(resOrderRequest.getTotal());
    resOrder.setCustomerPhone(resOrderRequest.getCustomerPhone());
    resOrder.setCustomerEmail(resOrderRequest.getCustomerEmail());
    resOrder.setCustomerAddress(resOrderRequest.getCustomerAddress());
    resOrder.setOrderLine(resOrderLines);

    resOrderRepository.save(resOrder);
    return resOrder;
  }

  @Override
  public ResOrder postPaidOrder(String channelPayment, String noReff) {
    resOrderRepository.updateStatusAndChannelPaymentByNoReff(OrderStatusEnum.PAID.getResponseCode(),
        channelPayment, noReff);
    return resOrderRepository.findByNoReff(noReff);
  }
}
