package com.programmingtechie.notifictionservice.event;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by AndreyDo16 on 29.01.2024
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderPlacedEvent {

    private String orderNumber;

}