package org.ait.project.onboarding.modules.master.model.repository;

import org.ait.project.onboarding.modules.master.model.entity.ResProduct;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;

@Repository
public interface ResProductRepository extends JpaRepository<ResProduct, Long> {

    ArrayList<ResProduct> findByProductQtyGreaterThan(int productQty);
    Page<ResProduct> findByProductQtyGreaterThan(int productQty, Pageable pageable);

    @Transactional
    @Modifying
    @Query("update ResProduct r set r.productQty = r.productQty - ?1 where r.productCode = ?2")
    int updateProductQtyByProductCode(int productQty, String productCode);


}