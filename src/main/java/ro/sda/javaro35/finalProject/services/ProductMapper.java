package ro.sda.javaro35.finalProject.services;

import ro.sda.javaro35.finalProject.dto.ProductDto;
import ro.sda.javaro35.finalProject.entities.Product;
import ro.sda.javaro35.finalProject.repository.ProductRepository;

public class ProductMapper implements Mapper<Product,ProductDto>{

    private final ProductRepository productRepository;

    public ProductMapper(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public ProductDto convertToDto(Product entity) {
        ProductDto productDto = new ProductDto();
        productDto.setId(entity.getId());
        productDto.setProductCategory(entity.getProductCategory());
        return productDto;
    }

    @Override
    public Product convertToEntity(ProductDto dto) {

        Product product;
        if(dto.getId() != null){
            product = productRepository.findById(dto.getId()).orElse(new Product());

        }else{
            product = new Product();
        }
        product.setId(dto.getId());
        product.setProductCategory(dto.getProductCategory());
        return product;
    }

}
