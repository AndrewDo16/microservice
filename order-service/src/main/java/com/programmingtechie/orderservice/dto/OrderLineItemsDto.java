package com.programmingtechie.orderservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * Created by AndreyDo16 on 27.01.2024
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderLineItemsDto {
    public Long id;
    private String skuCode;
    private BigDecimal price;
    private Integer quantity;
}
