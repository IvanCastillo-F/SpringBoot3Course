package com.ivan.springboot.di.app.springboot_di.repositories;

import java.util.Arrays;
import java.util.List;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;
// import org.springframework.web.context.annotation.RequestScope;
//import org.springframework.web.context.annotation.SessionScope;

import com.ivan.springboot.di.app.springboot_di.models.Product;


// @RequestScope
/*
 * The RequestScope annotation works to instead of saving the data in the class as singleton
 * the data only exist per Request avoiding mutability
 */
//@SessionScope
/*
 * The SessionScope annotation works to instead of saving the data in the class as singleton
 * the data exist only in the web browser window you are so if you modify data and this is no saved,
 * in a DB the unsaved changes will be destroyed when you close the web navigator window.
 */
@Primary
@Repository("productList")
public class ProductRepositoryImpl  implements ProductRepository{

    private List<Product> data;

    public ProductRepositoryImpl() {
        this.data = Arrays.asList(
            new Product(1L, "Memoria corsair 31",300L),
            new Product(2L, "CPU Intel Core i9",850L),
            new Product(3L, "Teclado Razer Mini 60%",180L),
            new Product(4L, "MotherBoard Gigabyte",490L)
        );
    }

    @Override
    public List<Product> findAll(){
        return data;
    }
    
    @Override
    public Product findById(Long id){
        return data.stream().filter(p -> p.getId().equals(id)).findFirst().orElse(null);
    }

}
