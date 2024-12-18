package com.ivan.springboot.di.app.springboot_di.services;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.ivan.springboot.di.app.springboot_di.models.Product;
import com.ivan.springboot.di.app.springboot_di.repositories.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {

    @Value("${config.price.tax}")
    private Double tax;
    
    // @Autowired
    // @Qualifier("productList")
    private ProductRepository repository;
    
    public ProductServiceImpl(/*@Qualifier("productList")*/ @Qualifier("productJson") ProductRepository repository) {
        this.repository = repository;
    }

    //in this method we multiply by 1.25 to simulate a price plus taxes
    @Override
    public List<Product> findAll(){
        return repository.findAll().stream().map(p ->{
            Double priceTax= p.getPrice() * tax;
            //Product newProduct = new Product(p.getId(), p.getName(), priceTax.longValue());

            Product newProduct = (Product)p.clone();
            newProduct.setPrice(priceTax.longValue());
            return newProduct;

            // p.setPrice(priceTax.longValue());
            // return p;
        }).collect(Collectors.toList());
    }

    @Override
    public Product findById(Long id){
        return repository.findById(id);
    }

}
