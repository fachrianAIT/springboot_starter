package org.ait.project.onboarding.modules.order.model.entity;

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
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Table(name = "res_order_line")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ResOrderLine {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", nullable = false)
  private Long id;

  @ManyToOne(fetch = FetchType.LAZY, optional = false)
  @JoinColumn(name = "order_id", nullable = false)
  private ResOrder orderId;

  @Column(name = "product_code", nullable = false)
  private String productCode;

  @Column(name = "product_name", nullable = false)
  private String productName;

  @Column(name = "product_qty", nullable = false)
  private int productQty;

  @Column(name = "sub_total", nullable = false)
  private int subTotal;

  @Column(name = "create_date")
  private ZonedDateTime createDate;

  @Column(name = "write_date")
  private ZonedDateTime writedDate;


}
