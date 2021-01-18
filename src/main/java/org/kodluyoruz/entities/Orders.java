package org.kodluyoruz.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
public class Orders {

    @Id
    @GeneratedValue
    private int id;

    private LocalDate createdAt;

    private double total;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "Orders{" +
                "id=" + id +
                ", createdAt=" + createdAt +
                ", total=" + total +
                '}';
    }
}
