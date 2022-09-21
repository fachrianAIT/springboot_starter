package org.ait.project.onboarding.modules.master.model.entity;


import java.time.ZonedDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;


@Entity
@Table(name = "res_merchant")
@Getter
@Setter
public class ResMerchant {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", nullable = false)
  private Long id;

  @Column(name = "merchant_code", nullable = false, unique = true)
  private String merchantCode;

  @Column(name = "name", nullable = false, unique = true)
  private String name;

  @Column(name = "create_date")
  private ZonedDateTime createDate;

  @Column(name = "write_date")
  private ZonedDateTime writedDate;

}