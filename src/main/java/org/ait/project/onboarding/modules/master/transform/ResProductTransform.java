package org.ait.project.onboarding.modules.master.transform;

import java.util.List;
import org.ait.project.onboarding.modules.master.dto.response.ResProductResponse;
import org.ait.project.onboarding.modules.master.model.entity.ResProduct;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;


@Mapper(componentModel = "spring") // for Dependency Injection Spring
public interface ResProductTransform {


  @Named("createProductResponse")
  @Mapping(target = "merchantName", source = "resMerchant.name")
  @Mapping(target = "merchantCode", source = "resMerchant.merchantCode")
  ResProductResponse createProductResponse(ResProduct resProduct);

  @IterableMapping(qualifiedByName = "createProductResponse")
  List<ResProductResponse> createProductResponseList(List<ResProduct> resProductList);
}
