package cz.itnetwork.webapplication.database.entities;

import jakarta.persistence.*;
import org.hibernate.validator.constraints.Range;

@Table(name = "produkty")
@Entity
public class ProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long productId;

    @Column(name = "Název Produktu", nullable = false)
    private String productName;

    @Column(name = "Popis Produktu", nullable = false)
    private String productDescription;

    @Column(name = "Cena Produktu", nullable = false)
    @Range(min = 0)
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

    public int getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(int productPrice) {
        this.productPrice = productPrice;
    }
}
