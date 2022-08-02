package ro.sda.javaro35.finalProject.entities;


import lombok.Data;
import lombok.experimental.FieldDefaults;
import ro.sda.javaro35.finalProject.enums.ProductCategory;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import static lombok.AccessLevel.PRIVATE;

@FieldDefaults(level = PRIVATE)
@Entity
@Data
public class Product {
    @Id
    @GeneratedValue
    Long id;
    ProductCategory productCategory;
}
