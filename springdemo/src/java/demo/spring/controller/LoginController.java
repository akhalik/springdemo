
package demo.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
/**
 *
 * @author akhalik
 */
@Controller
public class LoginController {
    
    @RequestMapping(value="/LoginPage", method = RequestMethod.GET)
    public ModelAndView loginPage(){
        System.out.println("secured");
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("login");
        return modelAndView;
    
    }
    
    @RequestMapping(value="/workspace/welcome.action", method = RequestMethod.GET)
    public ModelAndView welcomePage(){
        System.out.println("secured");
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("index");
        return modelAndView;
    
    }
}
