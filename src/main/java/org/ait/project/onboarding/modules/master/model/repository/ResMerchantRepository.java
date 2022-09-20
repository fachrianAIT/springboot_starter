package org.ait.project.onboarding.modules.master.model.repository;

import org.ait.project.onboarding.modules.master.model.entity.ResMerchant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResMerchantRepository extends JpaRepository<ResMerchant, Long> {

    ResMerchant findFirstByMerchantCode(String merchantCode);
}