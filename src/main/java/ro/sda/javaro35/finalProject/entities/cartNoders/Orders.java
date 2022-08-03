package ro.sda.javaro35.finalProject.entities.cartNoders;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import ro.sda.javaro35.finalProject.entities.Address;
import ro.sda.javaro35.finalProject.entities.User;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static lombok.AccessLevel.PRIVATE;

@Entity
@Getter
@Setter
@NoArgsConstructor
@FieldDefaults(level = PRIVATE)
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer id;
    double totalPrice;
    @ManyToOne()
    @JoinTable(name = "order_addresses",
            joinColumns = @JoinColumn(name = "order_id"),
            inverseJoinColumns = @JoinColumn(name = "address_id"))
    Address address;
    Date orderDate;
    @OneToMany(mappedBy = "orders")
    List<OrderLine> entries = new ArrayList<OrderLine>();
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinTable(name = "user_orders",
            joinColumns = @JoinColumn(name = "order_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id"))
    User user;
    @Enumerated(EnumType.STRING)
    OrderStatus orderStatus;
}