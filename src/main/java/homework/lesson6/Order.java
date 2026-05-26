package homework.lesson6;

import java.io.Serializable;
import java.time.LocalDateTime;

public class Order implements Serializable {

    public OrderStatus status;
    public int orderNumber;
    public LocalDateTime creationDate;
    public LocalDateTime updateDate;

    public Order(int orderNumber, OrderStatus status, LocalDateTime creationDate) {
        this.orderNumber = orderNumber;
        this.status = status;
        this.creationDate = creationDate;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public int getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(int orderNumber) {
        this.orderNumber = orderNumber;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }

    public LocalDateTime getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(LocalDateTime updateDate) {
        this.updateDate = updateDate;
    }

    @Override
    public String toString() {
        return "Order{" +
                "status = " + status +
                ", orderNumber = " + orderNumber +
                ", creationDate = " + creationDate +
                ", updateDate = " + updateDate +
                '}';
    }
}
