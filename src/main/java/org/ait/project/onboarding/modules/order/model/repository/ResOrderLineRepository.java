package org.ait.project.onboarding.modules.order.model.repository;

import org.ait.project.onboarding.modules.order.model.entity.ResOrderLine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ResOrderLineRepository extends JpaRepository<ResOrderLine, Long> {
}