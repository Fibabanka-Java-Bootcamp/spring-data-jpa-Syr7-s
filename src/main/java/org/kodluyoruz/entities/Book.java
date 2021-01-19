package org.kodluyoruz.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;
@Entity
@Getter
@Setter
public class Book {

    @Id
    private String isbn;

    private String name;

    private String description;

    //@Temporal(TemporalType.DATE)
    private LocalDate publishedDate;

    //@Temporal(TemporalType.DATE)
    private LocalDate addedDate;

    private double price;

    private String currency;

    private String imageUrl;



    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "category_id", referencedColumnName = "id")
    private Category category;

    @ManyToMany(mappedBy = "registeredOrderBook",cascade = CascadeType.ALL)
    private List<Orders> orders;

    @ManyToMany(mappedBy = "registeredAuthorBook",fetch = FetchType.EAGER)
    private List<Author> authors;

    /*   @Override
    public String toString() {
        return "Book{" +
                "isbn='" + isbn + '\'' +
                ", name='" + name + '\'' +
                '}';
    }*/
/*
    @Override
    public String toString() {
        return "Book{" +
                "isbn='" + isbn + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", publishedDate=" + publishedDate +
                ", addedDate=" + addedDate +
                ", price=" + price +
                ", currency='" + currency + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                //", category=" + category +
                '}';
    }*/

    @Override
    public String toString() {
        return "Book{" +
                "isbn='" + isbn + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", publishedDate=" + publishedDate +
                ", addedDate=" + addedDate +
                ", price=" + price +
                ", currency='" + currency + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", category=" + category +
               // ", orders=" + orders +
               // ", authors=" + authors +
                '}';
    }
}
