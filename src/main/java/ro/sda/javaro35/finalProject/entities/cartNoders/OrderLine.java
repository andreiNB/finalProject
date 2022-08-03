package ro.sda.javaro35.finalProject.entities.cartNoders;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import ro.sda.javaro35.finalProject.entities.Product;

import javax.persistence.*;

import static lombok.AccessLevel.PRIVATE;

@Entity
@NoArgsConstructor
@Getter
@Setter
@FieldDefaults(level = PRIVATE)
public class OrderLine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int quantity;

    @ManyToOne
    Product product;

    @ManyToOne
    @JoinTable(name = "order_orderlines",
            joinColumns = @JoinColumn(name = "orderline_id"),
            inverseJoinColumns = @JoinColumn(name = "orders_id"))
    Orders orders;

    double price;

    public OrderLine(int quantity, Product product, Orders orders, double price) {
        this.quantity = quantity;
        this.product = product;
        this.orders = orders;
        this.price = price;
    }
}