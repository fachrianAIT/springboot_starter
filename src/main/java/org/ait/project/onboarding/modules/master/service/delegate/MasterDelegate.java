package org.ait.project.onboarding.modules.master.service.delegate;

import java.util.List;
import org.ait.project.onboarding.modules.master.model.entity.ResProduct;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface MasterDelegate {

  // res_product
  List<ResProduct> getAllProduct();

  Page<ResProduct> getAllProductPaging(Pageable pageable);
}
