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
@Table(name = "res_customer")
@Getter
@Setter
public class ResCustomer {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", nullable = false)
  private Long id;

  @Column(name = "customer_code", nullable = false, unique = true)
  private String customerCode;

  @Column(name = "name", nullable = false, unique = true)
  private String name;

  @Column(name = "email", nullable = false, unique = true)
  private String email;

  @Column(name = "phone_number", nullable = false, unique = true)
  private String phoneNumber;

  @Column(name = "address", nullable = false, unique = true)
  private String address;

  @Column(name = "create_date")
  private ZonedDateTime createDate;

  @Column(name = "write_date")
  private ZonedDateTime writedDate;
}
