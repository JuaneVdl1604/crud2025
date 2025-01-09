package com.coursedemo.simplecrud.mappers;

import com.coursedemo.simplecrud.model.product.Product;
import com.coursedemo.simplecrud.model.rdmProduct.RdmProduct;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;


@Mapper(componentModel = "spring")
public interface ProductMappers {
    ProductMappers INSTANCE = Mappers.getMapper(ProductMappers.class);

    @Mapping(source = "title",target = "name")
    Product rdmProductToProduct(RdmProduct product);
}
