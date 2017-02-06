package productsApp.controllers;

import java.util.Collection;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import productsApp.productApp;
import productsApp.entities.Product;
import productsApp.exceptions.ProductException;
import productsApp.services.ProductService;
import productsApp.util.Message;

import org.apache.log4j.Logger;


/**
 * Controller which handle HTTP Request from SPA.
 *
 * @author Ekaterina
 */

@RestController
@RequestMapping(value = ProductController.PATH)
public class ProductController {

    @Autowired
    private ProductService productService;

    static final String PATH = "/product";

    static Logger log = Logger.getLogger(productApp.class.getName());





    /**
     * Handle request: GET /product
     *
     * @return list of items
     */

    @RequestMapping(value = "", method = RequestMethod.GET) //
    public Collection<Product> list() {

        try {

        Collection<Product> ListProducts = productService.findAll();

        //Collection <Product> ListProducts=productRepository.findAll();
        log.info(Message.SUCCESS_READING);
        return ListProducts;

        	}
        	catch (Exception E)  {

        		throw new ProductException(Message.ERROR_READING);
        	}

    }

    /**
     * Handle request: GET /product/{id}
     *
     * @param id the id of item to find
     * @return one item by Id
     */


    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Product findById(@PathVariable String id) {

        Long idProduct = Long.parseLong(id);
        Product product = productService.findById(idProduct);
        if (product == null) {
            throw new ProductException(Message.ERROR_READING);
        }
        log.info(Message.SUCCESS_READING);
        return product;

    }

    @RequestMapping(value = "/search/price/{price1}/{price2}")
    public Collection<Product> getProductByPriceRange(@PathVariable int price1, @PathVariable int price2) {
        Collection<Product> ListProducts = productService.findByPriceRange(price1, price2);
        return ListProducts;
    }




    /**
     * Handle request: POST /product}
     *
     * @param product the product to insert
     * @return product
     */

    @RequestMapping(value = "", method = RequestMethod.POST)
    public Product insert(@RequestBody Product product) {


        try {
            product = productService.insertProduct(product);
            log.info(Message.SUCCESS_INSERTING);
        } catch (Exception E) {
            throw new ProductException(Message.ERROR_INSERTING);
        }
        return product;
    }

    /**
     * Handle request: PUT /product/
     *
     * @param product the product to update
     * @return no return the product because it saved on the client in "item"
     */

    @RequestMapping(value = "", method = RequestMethod.PUT)
    public void update(@RequestBody Product NewProduct) {


        try {
            productService.updateProduct(NewProduct);
            log.info(Message.SUCCESS_UPDATING);
        } catch (Exception E) {

            throw new ProductException(Message.ERROR_UPDATING);
        }

    }

    /**
     * Handle request: DELETE /product/{id}
     *
     * @param id the id of product to delete
     * @return no return the product because it saved on the client in "item"
     */

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable Long id) {

        try {
            productService.delete(id);
            log.info(Message.SUCCESS_DELETING);
        } catch (Exception E) {

            throw new ProductException(Message.ERROR_DELETING);
        }

    }

}
