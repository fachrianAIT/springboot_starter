package org.ait.project.onboarding.modules.master.controller;

import org.ait.project.onboarding.modules.master.dto.response.ResProductResponse;
import org.ait.project.onboarding.modules.master.service.internal.MasterInternal;
import org.ait.project.onboarding.shared.template.ResponseCollection;
import org.ait.project.onboarding.shared.template.ResponseTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/master/v1")
public class MasterController implements MasterInternal{

  @Autowired
  MasterInternal masterInternal;

  @Override
  @GetMapping("/product")
  public ResponseEntity<ResponseTemplate<ResponseCollection<ResProductResponse>>> getAllProduct() {
    return masterInternal.getAllProduct();
  }

  @Override
  @GetMapping("/product-paging")
  public ResponseEntity<ResponseTemplate<ResponseCollection<ResProductResponse>>>
      getAllProductPaging(Pageable pageable) {
    return masterInternal.getAllProductPaging(pageable);
  }
}
