package ro.sda.javaro35.finalProject.dto;

import lombok.Getter;
import lombok.Setter;
import ro.sda.javaro35.finalProject.entities.Address;
import ro.sda.javaro35.finalProject.entities.cartNoders.Orders;

import java.util.List;

@Getter
@Setter
public class UserDto {

    private Long id;
    private String name;
    private String email;
    private List<Orders> orderList;
    private String password;
    private List<Address> addressList;
    private String thumbnail;
    private String roles;

}
