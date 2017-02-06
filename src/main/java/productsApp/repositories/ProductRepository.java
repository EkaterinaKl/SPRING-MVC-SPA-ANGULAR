package productsApp.repositories;

import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import productsApp.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
    Product findById(Long id);

    //только для примера выполнения запросов
    //возможно через сервис или без autowire


    @Query(value = "select name,price from Product p where p.price>?1 and p.price<?2")
    Collection<Product> findByPriceRange(long price1, long price2);

}
