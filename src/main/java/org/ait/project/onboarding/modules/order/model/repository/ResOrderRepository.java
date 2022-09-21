package org.ait.project.onboarding.modules.order.model.repository;

import org.ait.project.onboarding.modules.order.model.entity.ResOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Repository
public interface ResOrderRepository extends JpaRepository<ResOrder, Long> {


  ResOrder findByNoReff(String noReff);

  @Transactional
  @Modifying
  @Query("update ResOrder r set r.status = ?1, r.paymentChannel = ?2 where r.noReff = ?3")
  int updateStatusAndChannelPaymentByNoReff(String status, String paymentChannel, String noReff);

}
