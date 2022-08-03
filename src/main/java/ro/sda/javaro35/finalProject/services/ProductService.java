package ro.sda.javaro35.finalProject.services;

import org.springframework.stereotype.Service;
import ro.sda.javaro35.finalProject.dto.ProductDto;
import ro.sda.javaro35.finalProject.entities.Product;
import ro.sda.javaro35.finalProject.exceptions.EntityNotFoundError;
import ro.sda.javaro35.finalProject.repository.ProductRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {

    private ProductRepository productRepository;

    private ProductMapper productMapper;

    public ProductService(ProductRepository productRepository, ProductMapper productMapper) {
        this.productRepository = productRepository;
        this.productMapper = productMapper;
    }

    public List<ProductDto> getAllProducts() {

        return productRepository.findAll().stream().map(product -> productMapper.convertToDto(product)).collect(Collectors.toList());
    }

    public ProductDto createProduct(ProductDto form) {
        Product product = productMapper.convertToEntity(form);
        product = productRepository.save(product);
        return productMapper.convertToDto(product);
    }

    public ProductDto findById(long id) {
        Product productEntity = productRepository.findById(id).orElseThrow(() -> new EntityNotFoundError(String.format("Product with %s does not exist", id)));
        return productMapper.convertToDto(productEntity);
    }

    public void deleteById(long id) {
        productRepository.findById(id).orElseThrow(() -> new EntityNotFoundError(String.format("Product with %s does not exist", id)));
    }
}
