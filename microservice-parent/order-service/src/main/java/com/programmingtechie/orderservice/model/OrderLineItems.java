package com.programmingtechie.orderservice.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by AndreyDo16 on 27.01.2024
 */

@Entity
@Table(name = "t_order_line_items")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderLineItems {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;
    private String skuCode;
    private BigDecimal price;
    private Integer quantity;
}
