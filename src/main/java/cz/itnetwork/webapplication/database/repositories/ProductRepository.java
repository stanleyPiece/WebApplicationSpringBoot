package cz.itnetwork.webapplication.database.repositories;

import cz.itnetwork.webapplication.database.entities.ProductEntity;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<ProductEntity, Long> {
}
