package com.programmingtechie.orderservice.dto;

import com.programmingtechie.orderservice.model.OrderLineItems;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.util.List;

/**
 * Created by AndreyDo16 on 27.01.2024
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderRequest {
    private List<OrderLineItemsDto> orderLineItemsDtoList;
}
