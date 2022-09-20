package org.ait.project.onboarding.modules.master.service.internal.impl;

import org.ait.project.onboarding.modules.master.dto.response.ResProductResponse;
import org.ait.project.onboarding.modules.master.model.entity.ResProduct;
import org.ait.project.onboarding.modules.master.service.delegate.impl.MasterDelegateImpl;
import org.ait.project.onboarding.modules.master.service.internal.MasterInternal;
import org.ait.project.onboarding.modules.master.transform.ResProductTransform;
import org.ait.project.onboarding.shared.enums.ResponseEnum;
import org.ait.project.onboarding.shared.template.ResponseCollection;
import org.ait.project.onboarding.shared.template.ResponseTemplate;
import org.ait.project.onboarding.shared.utils.ResponseHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class MasterInternalImpl implements MasterInternal {

    @Autowired
    MasterDelegateImpl serviceDelegate;
    @Autowired
    ResponseHelper responseHelper;

    @Autowired
    ResProductTransform resProductTransform;

    @Override
    public ResponseEntity<ResponseTemplate<ResponseCollection<ResProductResponse>>> getAllProduct() {
        List<ResProduct> resProductList = serviceDelegate.getAllProduct();
        return responseHelper.createResponseCollection(ResponseEnum.SUCCESS, null,
                resProductTransform.createProductResponseList(resProductList));
    }

    @Override
    public ResponseEntity<ResponseTemplate<ResponseCollection<ResProductResponse>>> getAllProductPaging(Pageable pageable) {
        Page<ResProduct> resProductList = serviceDelegate.getAllProductPaging(pageable);
        return responseHelper.createResponseCollection(ResponseEnum.SUCCESS, resProductList,
                resProductTransform.createProductResponseList(resProductList.getContent()));
    }
}
