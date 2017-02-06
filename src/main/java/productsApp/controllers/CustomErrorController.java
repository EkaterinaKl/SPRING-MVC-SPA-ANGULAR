package productsApp.controllers;

import org.apache.log4j.Logger;
import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import productsApp.productApp;

/**
 * Defines the error-page.
 * It uses redirect to correct display error-page in SPA
 *
 * @author Ekaterina
 */

@Controller
public class CustomErrorController implements ErrorController {
    private static final String ERR_MSG = "Ошибка: запрос несуществующего ресурса";
    private static final String PATH = "/error";

    static Logger log = Logger.getLogger(productApp.class.getName());

    @RequestMapping(value = PATH)
    //
    public String  errorHandle() {
        log.warn(ERR_MSG);
        return "redirect:/errForNg";

    }

    @Override
    public String getErrorPath() {

        return PATH;
    }

}
