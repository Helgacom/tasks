package enums;

import java.util.Objects;

public class Order {
    /*класс заказ-наряд*/
    private int id;
    private String model;
    private Status status;

    public Order(int number, String car, Status status) {
        this.id = number;
        this.model = car;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return id == order.id && Objects.equals(model, order.model) && status == order.status;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, model, status);
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", model='" + model + '\'' +
                ", status=" + status +
                '}';
    }
}
