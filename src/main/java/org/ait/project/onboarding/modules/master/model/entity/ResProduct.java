package org.ait.project.onboarding.modules.master.model.entity;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import java.time.ZonedDateTime;


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