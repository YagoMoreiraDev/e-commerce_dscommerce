package com.cloud.yagodev.ecommerce_dscommerce.domain.entities;

import com.cloud.yagodev.ecommerce_dscommerce.domain.enums.OrderStatus;
import jakarta.persistence.*;

import java.time.Instant;

@Entity
@Table(name = "tb_order")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private Instant moment;
    private OrderStatus status;

    @ManyToOne
    @JoinColumn(name = "col_client_id")
    private User client;

    public Order() {
    }

    public Order(String id, Instant moment, OrderStatus status, User client) {
        this.id = id;
        this.moment = moment;
        this.status = status;
        this.client = client;
    }

    public String getId() {
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

    @Override
    public String toString() {
        return "Order{" +
                "id='" + id + '\'' +
                ", moment=" + moment +
                ", status=" + status +
                ", client=" + client +
                '}';
    }
}
