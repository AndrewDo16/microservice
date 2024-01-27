package com.programmingtechie.orderservice.repository;

import com.programmingtechie.orderservice.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by AndreyDo16 on 27.01.2024
 */

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

}
