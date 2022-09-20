package org.ait.project.onboarding.modules.master.model.entity;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import java.time.ZonedDateTime;


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
