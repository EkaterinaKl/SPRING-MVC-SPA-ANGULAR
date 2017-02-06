package productsApp.services;

import java.util.Collection;

import javax.transaction.Transactional;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import productsApp.productApp;
import productsApp.entities.Product;
import productsApp.repositories.ProductRepository;

@Service
@Transactional
public class ProductsServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    static Logger log = Logger.getLogger(productApp.class.getName());


    @Override
    public Collection<Product> findAll() {

        return productRepository.findAll();
    }

    @Override
    public void updateProduct(Product NewProduct) {

        Product OldProduct = this.findById(NewProduct.getId());

        /**
         * чтобы избежать повторной отправки изображения при обновлении
         *
         */
        if (NewProduct.getImg() == null) {
            if (OldProduct.getImg() == null) {
                NewProduct.setImg("noimg.jpg");
            } else {
                NewProduct.setImg(OldProduct.getImg());
            }
        }

        productRepository.saveAndFlush(NewProduct);

    }

    @Override
    public void save(Product product) {

        productRepository.saveAndFlush(product);

    }


    @Override
    public Product findById(long id) {
        return productRepository.findById(id);
    }

    @Override
    public void delete(long id) {

        productRepository.delete(id);
    }

    @Override
    public Collection<Product> findByPriceRange(long price1, long price2) {

        return productRepository.findByPriceRange(price1, price2);
    }

    @Override
    public Product insertProduct(Product product) {
        if (product.getImg() == null) {
            product.setImg("noimg.jpg");
        }
        this.save(product);
        return product;
    }

}
