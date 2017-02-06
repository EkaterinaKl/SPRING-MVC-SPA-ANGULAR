package productsApp.services;

import java.util.Collection;
import java.util.List;

import org.springframework.cache.annotation.Cacheable;

import productsApp.entities.Product;

public interface ProductService {


    // for Queries example only
    public Collection<Product> findByPriceRange(long price1, long price2);

    public Collection<Product> findAll();

    public Product insertProduct(Product product);

    public void updateProduct(Product product);

    public void save(Product product);

    //@Cacheable ("products")
    public Product findById(long id);


    public void delete(long id);


}
