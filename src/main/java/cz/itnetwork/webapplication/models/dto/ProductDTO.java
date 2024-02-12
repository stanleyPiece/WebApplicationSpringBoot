package cz.itnetwork.webapplication.models.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class ProductDTO {

    private long productId;

    @NotBlank(message = "Vyplňte název produktu")
    @Size(min = 5, max = 20, message = "Název produktu musí být v rozsahu 5 až 20 znaků")
    private String productName;

    @NotBlank(message = "Vyplňte popis produktu")
    private String productDescription;

    @NotNull(message = "Vyplňte cenu produktu")
    private Integer productPrice;

    public long getProductId() {
        return productId;
    }

    public void setProductId(long productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public Integer getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(Integer productPrice) {
        this.productPrice = productPrice;
    }
}