package com.project.DASBackend.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Service_Price_List")
public class ServicePriceList {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Service_price_Id")
    private Integer servicePriceId;

    @Column(name = "Size_from", nullable = false)
    private Float sizeFrom;

    @Column(name = "Size_to", nullable = false)
    private Float sizeTo;

    @Column(name = "Init_price", nullable = false)
    private Integer initPrice;

    @Column(name = "Price_unit", nullable = false)
    private Integer priceUnit;

    @ManyToOne
    @JoinColumn(name = "Service_Id", nullable = false)
    private Services service;
}
