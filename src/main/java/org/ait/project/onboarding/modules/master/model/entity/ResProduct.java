package org.ait.project.onboarding.modules.master.model.entity;

import java.time.ZonedDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;


@Entity
@Table(name = "res_product")
@Getter
@Setter
public class ResProduct {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", nullable = false)
  private Long id;

  @Column(name = "product_code", nullable = false, unique = true)
  private String productCode;

  @Column(name = "product_name", nullable = false, unique = true)
  private String productName;

  @Column(name = "product_qty", nullable = false)
  private int productQty;

  @ManyToOne(fetch = FetchType.LAZY, optional = false)
  @JoinColumn(name = "res_merchant_id", nullable = false)
  private ResMerchant resMerchant;

  @Column(name = "create_date")
  private ZonedDateTime createDate;

  @Column(name = "write_date")
  private ZonedDateTime writedDate;
}