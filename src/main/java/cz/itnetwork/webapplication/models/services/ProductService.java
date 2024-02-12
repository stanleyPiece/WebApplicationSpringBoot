package cz.itnetwork.webapplication.models.services;

import cz.itnetwork.webapplication.models.dto.ProductDTO;

import java.util.List;

public interface ProductService {
    void createProduct(ProductDTO productDTO);

    List<ProductDTO> getAllProducts();

    ProductDTO getProductById(long productId);

    void editProduct(ProductDTO productDTO);

    void remove(long productId);
}
