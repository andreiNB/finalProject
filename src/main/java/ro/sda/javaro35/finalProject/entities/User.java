package ro.sda.javaro35.finalProject.entities;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import ro.sda.javaro35.finalProject.entities.cartNoders.Orders;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

import static lombok.AccessLevel.PRIVATE;

@FieldDefaults(level = PRIVATE)
@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public final class User {
    @Id
    Long Id;
    @GeneratedValue(strategy = GenerationType.AUTO)
    String name;
    @OneToMany(mappedBy = "user")
    List<Orders> orderList = new ArrayList<>();
    @Column(nullable = false, unique = true)
    String email;
    @Column(nullable = false)
    String password;
    @OneToMany(mappedBy = "user", cascade = CascadeType.REMOVE)
    private List<Address> addressList = new ArrayList<>();
    String roles;
    String thumbnail;


}