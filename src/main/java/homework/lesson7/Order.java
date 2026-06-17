package homework.lesson7;

import java.io.Serializable;
import java.time.LocalDateTime;

public class Order implements Serializable {

    private OrderStatus status;
    private final int orderNumber;
    private final LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public Order(int orderNumber) {
        this.orderNumber = orderNumber;
        this.status = OrderStatus.NEW;
        this.createdAt = LocalDateTime.now();
    }

    public Order(int orderNumber, OrderStatus status, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.orderNumber = orderNumber;
        this.status = status;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
        this.updatedAt = LocalDateTime.now();
    }

    public int getOrderNumber() {
        return orderNumber;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    @Override
    public String toString() {
        return "Order{" +
                "status = " + status +
                ", orderNumber = " + orderNumber +
                ", creationDate = " + createdAt +
                ", updateDate = " + updatedAt +
                '}';
    }
}

