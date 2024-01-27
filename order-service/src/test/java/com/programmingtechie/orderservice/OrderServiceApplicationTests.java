package com.programmingtechie.orderservice;

import com.programmingtechie.orderservice.dto.OrderLineItemsDto;
import com.programmingtechie.orderservice.dto.OrderRequest;
import com.programmingtechie.orderservice.repository.OrderRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.testcontainers.containers.MySQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@Testcontainers
@AutoConfigureMockMvc
class OrderServiceApplicationTests {
	@Autowired
	private MockMvc mockMvc;
	@Autowired
	private ObjectMapper objectMapper;
	@Autowired
	private OrderRepository orderRepository;

	@Container
	final static MySQLContainer mysql = new MySQLContainer<>("mysql:latest");

	@DynamicPropertySource
	static void setProperties(DynamicPropertyRegistry dymDynamicPropertyRegistry) {
		dymDynamicPropertyRegistry.add("spring.datasource.url", mysql::getJdbcUrl);
		dymDynamicPropertyRegistry.add("spring.datasource.username", mysql::getUsername);
		dymDynamicPropertyRegistry.add("spring.datasource.password", mysql::getPassword);
	}

	@Test
	void shouldCreateOrder() throws Exception {
		OrderRequest orderRequest = getOrderRequest();

		String orderRequestString = objectMapper.writeValueAsString(orderRequest);

		mockMvc.perform(MockMvcRequestBuilders.post("/api/order")
				.contentType(MediaType.APPLICATION_JSON)
				.content(orderRequestString))
				.andExpect(status().isCreated());
		Assertions.assertEquals(1, orderRepository.findAll().size());
	}

	private OrderRequest getOrderRequest() {
		OrderRequest orderRequest = new OrderRequest();

		List<OrderLineItemsDto> orderLineItemsDtoList = new ArrayList<>();

		OrderLineItemsDto orderLineItemsDto = new OrderLineItemsDto();
		orderLineItemsDto.setSkuCode("iphone_13");
		orderLineItemsDto.setPrice(BigDecimal.valueOf(1200));
		orderLineItemsDto.setQuantity(1);

		orderLineItemsDtoList.add(orderLineItemsDto);

		orderRequest.setOrderLineItemsDtoList(orderLineItemsDtoList);
		return orderRequest;
	}

}
