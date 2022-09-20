package org.ait.project.onboarding.modules.master.controller;

import org.ait.project.onboarding.modules.master.dto.response.ResProductResponse;
import org.ait.project.onboarding.shared.template.ResponseCollection;
import org.ait.project.onboarding.shared.template.ResponseTemplate;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;


public interface MasterController {


    ResponseEntity<ResponseTemplate<ResponseCollection<ResProductResponse>>> getAllProduct();
    ResponseEntity<ResponseTemplate<ResponseCollection<ResProductResponse>>> getAllProductPaging(Pageable pageable);
}
