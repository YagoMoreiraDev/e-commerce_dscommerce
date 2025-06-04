package com.cloud.yagodev.ecommerce_dscommerce.domain.entities;

import com.cloud.yagodev.ecommerce_dscommerce.domain.enums.OrderStatus;
import jakarta.persistence.*;

import java.time.Instant;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "tb_order")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
    private Instant moment;

    @Enumerated(EnumType.STRING)
    private OrderStatus status;

    @ManyToOne
    @JoinColumn(name = "col_client_id")
    private User client;

    @OneToOne(mappedBy = "order", cascade = CascadeType.ALL)
    private Payment payment;

    @OneToMany(mappedBy = "id.order")
    private Set<OrderItem> orderItems = new HashSet<>();

    public Order() {
    }

    public Order(Long id, Instant moment, OrderStatus status, User client, Payment payment) {
        this.id = id;
        this.moment = moment;
        this.status = status;
        this.client = client;
        this.payment = payment;
    }

    public Long getId() {
        return id;
    }

    public Instant getMoment() {
        return moment;
    }

    public void setMoment(Instant moment) {
        this.moment = moment;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public User getClient() {
        return client;
    }

    public void setClient(User client) {
        this.client = client;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    public Set<OrderItem> getOrderItems() {
        return orderItems;
    }

    //Aqui eu to pegando lá do meu Order o Product correspondente, estou dando um get nos pedidos onde o determinado produto participou.
    public List<Product> getProducts() {
        return orderItems.stream().map(x -> x.getProduct()).toList();
    }

    @Override
    public String toString() {
        return "Order{" +
                "id='" + id + '\'' +
                ", moment=" + moment +
                ", status=" + status +
                ", client=" + client +
                ", payment=" + payment +
                '}';
    }
}
