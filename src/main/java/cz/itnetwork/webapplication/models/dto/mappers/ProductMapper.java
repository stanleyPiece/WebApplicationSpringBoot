package cz.itnetwork.webapplication.models.dto.mappers;

import cz.itnetwork.webapplication.database.entities.ProductEntity;
import cz.itnetwork.webapplication.models.dto.ProductDTO;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    ProductEntity toEntity(ProductDTO sourceProduct);

    ProductDTO toDTO(ProductEntity sourceEntity);

    void updateProductDTO(ProductDTO source, @MappingTarget ProductDTO target);

    void updateProductEntity(ProductDTO source, @MappingTarget ProductEntity target);
}
