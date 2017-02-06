package productsApp.controllers;

import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import productsApp.productApp;
import productsApp.exceptions.ProductException;
import productsApp.exceptions.RestException;

/**
 * Excepts the CRUD-exceptions
 *
 * @author Ekaterina
 */
@ControllerAdvice
public class GlobalRestExeptionHandlerControllerAdvice {

    public RestException error = new RestException();
    ;

    static Logger log = Logger.getLogger(productApp.class.getName());

    /**
     * This method provide error returning for SPA in JSON.
     *
     * @param e the exception of CRUD actions
     * @return error as RestException
     * @see {@link RestException}
     */
    @ExceptionHandler(ProductException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)

    public
    @ResponseBody
    RestException HandleProductException(ProductException e) {

        String msg = e.getMessage();
        error.setMessage(msg);
        error.setCode(404);

        log.error(msg);

        return error;

    }

}
