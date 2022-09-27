package org.ait.project.onboarding.modules.order.transform;

import java.util.List;
import org.ait.project.onboarding.modules.master.model.entity.ResCustomer;
import org.ait.project.onboarding.modules.master.model.entity.ResMerchant;
import org.ait.project.onboarding.modules.order.dto.request.ResOrderRequest;
import org.ait.project.onboarding.modules.order.dto.response.ResOrderResponse;
import org.ait.project.onboarding.modules.order.model.entity.ResOrder;
import org.ait.project.onboarding.modules.order.model.entity.ResOrderLine;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;


@Mapper(componentModel = "spring") // for Dependency Injection Spring
public interface OrderTransform {


  @Named("createDraftOrder")
  @Mapping(ignore = true, target = "id")
  @Mapping(ignore = true, target = "createDate")
  @Mapping(ignore = true, target = "writedDate")
  @Mapping(target = "resCustomer", source = "resCustomer")
  @Mapping(target = "resMerchant", source = "resMerchant")
  @Mapping(target = "noReff", source = "noReff")
  @Mapping(target = "status", source = "status")
  @Mapping(target = "total", source = "resOrderRequest.total")
  @Mapping(target = "customerPhone", source = "resOrderRequest.customerPhone")
  @Mapping(target = "customerEmail", source = "resOrderRequest.customerEmail")
  @Mapping(target = "customerAddress", source = "resOrderRequest.customerEmail")
  @Mapping(target = "orderLine", source = "resOrderLine")
  ResOrder createDraftOrder(ResOrder resOrder, List<ResOrderLine> resOrderLine, ResCustomer resCustomer,
      ResMerchant resMerchant, ResOrderRequest resOrderRequest, String noReff, String status);

  @Named("createOrderResponse")
  @Mapping(target = "merchantCode", source = "resMerchant.merchantCode")
  @Mapping(target = "customerCode", source = "resCustomer.customerCode")
  ResOrderResponse createOrderResponse(ResOrder resOrder);

  @IterableMapping(qualifiedByName = "createOrderResponse")
  List<ResOrderResponse> createOrderResponseList(List<ResOrder> resOrderList);
}
