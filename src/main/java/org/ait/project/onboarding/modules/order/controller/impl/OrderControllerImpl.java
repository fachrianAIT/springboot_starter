package org.ait.project.onboarding.modules.order.controller.impl;

import org.ait.project.onboarding.modules.master.dto.response.ResProductResponse;
import org.ait.project.onboarding.modules.order.controller.OrderController;
import org.ait.project.onboarding.modules.order.dto.request.ResOrderPaymentRequest;
import org.ait.project.onboarding.modules.order.dto.request.ResOrderRequest;
import org.ait.project.onboarding.modules.order.dto.response.ResOrderResponse;
import org.ait.project.onboarding.modules.order.model.entity.ResOrder;
import org.ait.project.onboarding.modules.order.service.delegate.impl.OrderDelegateImpl;
import org.ait.project.onboarding.modules.order.service.internal.impl.OrderInternalImpl;
import org.ait.project.onboarding.modules.order.transform.ResOrderTransform;
import org.ait.project.onboarding.shared.enums.ResponseEnum;
import org.ait.project.onboarding.shared.template.ResponseDetail;
import org.ait.project.onboarding.shared.template.ResponseTemplate;
import org.ait.project.onboarding.shared.utils.ResponseHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/trx/v1")
public class OrderControllerImpl implements OrderController {

    @Autowired
    OrderInternalImpl orderInternal;
    @Autowired
    ResponseHelper responseHelper;
    @Autowired
    ResOrderTransform resOrderTransform;

    @Override
    @GetMapping("order/{noReff}")
    public ResponseEntity<ResponseTemplate<ResponseDetail<ResOrderResponse>>> getOrderByNoReff(@PathVariable String noReff){
        return orderInternal.getOrderByNoReff(noReff);
    }

    @Override
    @PostMapping("draft-order")
    public ResponseEntity<ResponseTemplate<ResponseDetail<ResOrderResponse>>> postDraftOrder(ResOrderRequest resOrderRequest) {
        return orderInternal.postDraftOrder(resOrderRequest);
    }

    @Override
    @PostMapping("paid-order")
    public ResponseEntity<ResponseTemplate<ResponseDetail<ResOrderResponse>>> postPaidOrder(ResOrderPaymentRequest resOrderPaymentRequest) {
        return orderInternal.postPaidtOrder(resOrderPaymentRequest);
    }


}
