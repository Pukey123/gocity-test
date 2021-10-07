package goinventory.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Alex created 06/10/2021
 **/
@Controller
public class HomeController {

    @RequestMapping(value="/")
    public String index() {
        return "index";
    }
}
