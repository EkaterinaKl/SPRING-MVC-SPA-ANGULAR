package productsApp.exceptions;

import org.apache.log4j.Logger;

import productsApp.productApp;

/**
 * Class for Exception of CRUD operations.
 */
public class ProductException extends RuntimeException {

    private static final long serialVersionUID = 1L;


    public ProductException() {
        super();
    }

    public ProductException(String message, Throwable cause) {
        super(message, cause);
    }

    public ProductException(String message) {
        super(message);


    }

    public ProductException(Throwable cause) {
        super(cause);
    }

}
