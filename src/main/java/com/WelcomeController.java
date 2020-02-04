package com;

import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class WelcomeController {
    
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index() {
        return "index";
    }
    
    @RequestMapping(value = "/Test", method = RequestMethod.GET)
    public String getTest(HttpSession session) {
        com.config.Token td = new com.config.Token();
        String token = td.getToken("ADMIN", "ADMIN", "ADM", "All");
        session.setAttribute("token","Bearer "+ token);
        return "Test";
    }
}
