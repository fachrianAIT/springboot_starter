package org.ait.project.onboarding.modules.master.service.delegate.impl;

import java.util.List;
import org.ait.project.onboarding.modules.master.model.entity.ResProduct;
import org.ait.project.onboarding.modules.master.model.repository.ResProductRepository;
import org.ait.project.onboarding.modules.master.service.delegate.MasterDelegate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


@Service
public class MasterDelegateImpl implements MasterDelegate {

  @Autowired
  ResProductRepository resProductRepository;

  @Override
  public List<ResProduct> getAllProduct() {
    List<ResProduct> resProductList = resProductRepository.findByProductQtyGreaterThan(0);
    return resProductList;
  }

  @Override
  public Page<ResProduct> getAllProductPaging(Pageable pageable) {
    Page<ResProduct> resProductList = resProductRepository.findByProductQtyGreaterThan(0, pageable);
    return resProductList;
  }
}
