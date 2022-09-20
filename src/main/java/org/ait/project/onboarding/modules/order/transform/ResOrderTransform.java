package org.ait.project.onboarding.modules.order.transform;

import org.ait.project.onboarding.modules.order.dto.response.ResOrderResponse;
import org.ait.project.onboarding.modules.order.model.entity.ResOrder;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import java.util.List;


@Mapper(componentModel = "spring") // for Dependency Injection Spring
public interface ResOrderTransform {


  @Named("createResOrderResponse")
  @Mapping(target="merchantCode", source="resMerchant.merchantCode")
  @Mapping(target="customerCode", source="resCustomer.customerCode")
  ResOrderResponse createResOrderResponse(ResOrder resOrder);

  @IterableMapping(qualifiedByName = "createResOrderResponse")
  List<ResOrderResponse> createResOrderResponse(List<ResOrder> resOrderList);
}
