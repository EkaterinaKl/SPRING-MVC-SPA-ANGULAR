package productsApp.controllers;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import productsApp.productApp;

/**
 * @author Ekaterina
 *         It is redirect for update queries. It is need to correct
 *         dispaly routes of ng-view in Angular
 */
@Controller

public class MainController {

    static Logger log = Logger.getLogger(productApp.class.getName());

    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public String redirectAdmin() {
        return "forward:/";
    }

    @RequestMapping(value = "/errForNg")
    public String redirectErrorToClient() {
        return "forward:/";
    }

    @RequestMapping(value = "/view", method = RequestMethod.GET)
    public String redirectView() {
        return "forward:/";
    }

    @RequestMapping(value = "/about", method = RequestMethod.GET)
    public String redirectAbout() {
        return "forward:/";
    }

    //*****************************************
    //Notes: cases are enabled without SPA
    //********************************
    //	@RequestMapping(value="/view" , method=RequestMethod.GET)
    //	public ModelAndView  redirectView(Locale locale, Model model) {
    //		 return new ModelAndView("view");
    //	}
    //	public String redirectView() {
    //		 return "view";
    //	}
}
