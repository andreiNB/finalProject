package ro.sda.javaro35.finalProject.controller;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import ro.sda.javaro35.finalProject.dto.ProductDto;
import ro.sda.javaro35.finalProject.entities.Product;
import ro.sda.javaro35.finalProject.services.ProductService;

import javax.validation.Valid;
import java.util.List;

@Controller
@AllArgsConstructor
public class ProductController {

    private ProductService productService;


    @GetMapping("/products")
    public String showProducts(Model model) {
        List<ProductDto> products = productService.getAllProducts();
        model.addAttribute("products", products);
        return "products";
    }

    @GetMapping("/products/create")
    public String showForm(Model model) {
        model.addAttribute("productForm", new ProductDto());
        return "product_create";
    }

    @PostMapping("products/create")
    public String createProduct(@ModelAttribute("productForm") @Valid ProductDto form, Errors errors, Model model) {
        if (errors.hasErrors()) {
            return "product_create";
        }
        productService.createProduct(form);
        return "redirect:/products";
    }

    @GetMapping("/products/edit/{productId}")
    public String showEditForm(@PathVariable("productId") long id, Model model) {
        ProductDto productForm = productService.findById(id);
        model.addAttribute("productForm", productForm);
        return "product_create";
    }

    @GetMapping("products/delete/{productId")
    public String deleteProduct(@PathVariable("productId") long id, Model model) {
        productService.deleteById(id);
        return "redirect:/products";
    }
}
