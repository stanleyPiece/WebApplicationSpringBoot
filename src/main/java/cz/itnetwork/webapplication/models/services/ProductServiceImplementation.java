package cz.itnetwork.webapplication.models.services;

import cz.itnetwork.webapplication.database.entities.ProductEntity;
import cz.itnetwork.webapplication.database.repositories.ProductRepository;
import cz.itnetwork.webapplication.models.dto.ProductDTO;
import cz.itnetwork.webapplication.models.dto.mappers.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.StreamSupport;

@Service
public class ProductServiceImplementation implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductMapper productMapper;

    @Override
    public void createProduct(ProductDTO product) {
        /* můžeme zkrátit kód
        ProductEntity newProductEntity = new ProductEntity();
        productMapper.toEntity(product);
        */
        ProductEntity newProductEntity = productMapper.toEntity(product);

        productRepository.save(newProductEntity);
    }

    @Override
    public List<ProductDTO> getAllProducts() {
        return StreamSupport.stream(productRepository.findAll().spliterator(), false)
                .map(i -> productMapper.toDTO(i))
                .toList();
    }

    @Override
    public ProductDTO getProductById(long productId) {
        ProductEntity fetchedProduct = getProductOrThrow(productId);

        return productMapper.toDTO(fetchedProduct);
    }

    @Override
    public void editProduct(ProductDTO product) {
        ProductEntity fetchedProduct = getProductOrThrow(product.getProductId());

        productMapper.updateProductEntity(product, fetchedProduct);
        productRepository.save(fetchedProduct);
    }

    private ProductEntity getProductOrThrow(long productId) {
        return productRepository
                .findById(productId)
                .orElseThrow();
    }

    @Override
    public void remove(long productId) {
        ProductEntity fetchedProduct = getProductOrThrow(productId);
        productRepository.delete(fetchedProduct);
    }
}
