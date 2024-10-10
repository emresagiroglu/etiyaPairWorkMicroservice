package org.example.orderservice.service;

import lombok.RequiredArgsConstructor;
import org.example.orderservice.client.ProductServiceClient;
import org.example.orderservice.dto.CreateOrderRequest;
import org.example.orderservice.dto.ProductForOrderDto;
import org.example.orderservice.entity.Order;
import org.example.orderservice.entity.Product;
import org.example.orderservice.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService{
    private final OrderRepository orderRepository;
    private final ProductServiceClient productServiceClient;

    @Override
    public void add(CreateOrderRequest createOrderRequest) {
        List<Product> response = productServiceClient.findAllByIds(
                createOrderRequest.getProducts().stream().map(ProductForOrderDto::getProductId).toList()
        );

        //TODO: Refactor as business rules.
        // OrderBusinessRules.AllProductsShouldExist()
        if(response.size() != createOrderRequest.getProducts().size()) //
        {
            // Ürün sayısı uyuşmuyor..
        }
        // 293 -> 5 adet istenmiş stok yeterli mi?
        Order order = new Order();
        order.setOrderDate(LocalDate.now());
        order.setCustomerId(createOrderRequest.getCustomerId());
        order.setProducts(response);
        orderRepository.save(order);
    }

    @Override
    public List<Order> getAll() {
        return orderRepository.findAll();
    }
}
