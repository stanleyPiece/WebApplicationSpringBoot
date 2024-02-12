package cz.itnetwork.webapplication.controllers;

import cz.itnetwork.webapplication.models.dto.ProductDTO;
import cz.itnetwork.webapplication.models.dto.TitleDTO;
import cz.itnetwork.webapplication.models.dto.mappers.ProductMapper;
import cz.itnetwork.webapplication.models.services.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private ProductMapper productMapper;

    @GetMapping
    public String renderProductIndex(@ModelAttribute TitleDTO title,
                                     Model model) {
        title.setTitle("Produkty");
        List<ProductDTO> products = productService.getAllProducts();
        model.addAttribute("products", products);
        return "pages/products/productIndex";
    }

    @Secured("ROLE_ADMIN")
    @GetMapping("createProduct")
    public String renderCreateProduct(@ModelAttribute TitleDTO title,
                                      @ModelAttribute ProductDTO product) {
        title.setTitle("Nový produkt:");
        return "pages/products/createProduct";
    }

    @Secured("ROLE_ADMIN")
    @PostMapping("createProduct")
    public String createProduct(@ModelAttribute TitleDTO title,
        @Valid @ModelAttribute ProductDTO product,
        BindingResult result) {

        title.setTitle("Nový produkt:");

        if (result.hasErrors()) {
            return renderCreateProduct(title, product);
        }

        productService.createProduct(product);
        return "redirect:/products";
    }

    @GetMapping("productDetail/{productId}")
    public String renderProductDetail(@ModelAttribute TitleDTO title,
                                      @PathVariable long productId,
                                      Model model
    ) {
        title.setTitle("Detail");

        ProductDTO fetchedProduct = productService.getProductById(productId);
        model.addAttribute("product", fetchedProduct);

        return "pages/products/productDetail";
    }

    @Secured("ROLE_ADMIN")
    @GetMapping("editProduct/{productId}")
    public String renderEditForm(@ModelAttribute TitleDTO title,
            @PathVariable Long productId,
            ProductDTO product
    ) {
        title.setTitle("Upravit");

        ProductDTO fetchedProduct = productService.getProductById(productId);
        productMapper.updateProductDTO(fetchedProduct, product);

        return "pages/products/editProduct";
    }

    @Secured("ROLE_ADMIN")
    @PostMapping("editProduct/{productId}")
    public String editArticle(@ModelAttribute TitleDTO title,
            @PathVariable long productId,
            @Valid ProductDTO product,
            BindingResult result
    ) {
        title.setTitle("Upravit");

        if (result.hasErrors())
            return renderEditForm(title, productId, product);

        product.setProductId(productId);
        productService.editProduct(product);

        return "redirect:/products";
    }

    @Secured("ROLE_ADMIN")
    @GetMapping("deleteProduct/{productId}")
    public String deleteProduct(@PathVariable long productId,
                                RedirectAttributes redirectAttributes) {
        productService.remove(productId);
        redirectAttributes.addFlashAttribute("success", "Produkt smazán.");

        return "redirect:/products";
    }
}
