package ro.sda.javaro35.finalProject.dto;

import lombok.Data;
import ro.sda.javaro35.finalProject.enums.ProductCategory;

@Data
public class ProductDto {

    Long id;
    ProductCategory productCategory;
}
