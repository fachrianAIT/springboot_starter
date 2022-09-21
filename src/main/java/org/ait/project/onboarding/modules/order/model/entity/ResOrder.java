package org.ait.project.onboarding.modules.order.model.entity;


import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.ait.project.onboarding.modules.master.model.entity.ResCustomer;
import org.ait.project.onboarding.modules.master.model.entity.ResMerchant;



@Entity
@Table(name = "res_order")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ResOrder {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", nullable = false)
  private Long id;

  @OneToMany(fetch = FetchType.LAZY, mappedBy = "orderId", orphanRemoval = true,
      cascade = CascadeType.ALL)
  private List<ResOrderLine> orderLine = new ArrayList<>();

  @Column(name = "no_reff", nullable = false, unique = true)
  private String noReff;

  @ManyToOne(fetch = FetchType.LAZY, optional = false)
  @JoinColumn(name = "res_customer_id", nullable = false)
  private ResCustomer resCustomer;

  @ManyToOne(fetch = FetchType.LAZY, optional = false)
  @JoinColumn(name = "res_merchant_id", nullable = false)
  private ResMerchant resMerchant;

  @Column(name = "total", nullable = false)
  private int total;

  @Column(name = "status", nullable = false)
  private String status;

  @Column(name = "customer_email", nullable = false)
  private String customerEmail;

  @Column(name = "customer_phone", nullable = false)
  private String customerPhone;

  @Column(name = "customer_address", nullable = false)
  private String customerAddress;

  @Column(name = "payment_channel")
  private String paymentChannel;

  @Column(name = "create_date")
  private ZonedDateTime createDate;

  @Column(name = "write_date")
  private ZonedDateTime writedDate;

}