package org.ait.project.onboarding.modules.master.model.repository;

import java.util.Optional;
import org.ait.project.onboarding.modules.master.model.entity.ResCustomer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ResCustomerRepository extends JpaRepository<ResCustomer, Long> {

  Optional<ResCustomer> findFirstByCustomerCode(String customerCode);
}