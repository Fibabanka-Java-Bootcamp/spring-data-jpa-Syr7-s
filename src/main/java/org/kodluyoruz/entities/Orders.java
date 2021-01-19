package org.kodluyoruz.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@Setter
public class Orders {

    @Id
    @GeneratedValue
    private int id;

    private LocalDate createdAt;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id",referencedColumnName = "id")
    private User user;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name ="order_book",
            joinColumns = @JoinColumn(name = "order_id"),
            inverseJoinColumns = @JoinColumn(name = "book_isbn"))
    private List<Book> registeredOrderBook;

    private double total;

    /*
    @Override
    public String toString() {
        return "Orders{" +
                "id=" + id +
                ", createdAt=" + createdAt +
                ", total=" + total +
                '}';
    }*/

    @Override
    public String toString() {
        return "Orders{" +
                "id=" + id +
                ", createdAt=" + createdAt +
                ", user=" + user +
                ", total=" + total +
                '}';
    }
}
