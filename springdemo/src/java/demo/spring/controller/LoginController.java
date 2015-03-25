
package demo.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
/**
 *
 * @author akhalik
 */
@Controller
public class LoginController {
    
    @RequestMapping(value="/LoginPage", method = RequestMethod.GET)
    public ModelAndView loginPage(@RequestParam(value = "error", required = false) String error,
		@RequestParam(value = "logout", required = false) String logout){
        System.out.println("secured");
        ModelAndView modelAndView = new ModelAndView();
        	if (error != null) {
			modelAndView.addObject("error", "Invalid username and password!");
		}
 
		if (logout != null) {
			modelAndView.addObject("msg", "You've been logged out successfully.");
		}
        modelAndView.setViewName("login");
        return modelAndView;
    
    }
    
    @RequestMapping(value="/workspace/welcome.action", method = RequestMethod.GET)
    public ModelAndView welcomePage(){
        System.out.println("secured");
        ModelAndView modelAndView = new ModelAndView();
        ModelAndView model = new ModelAndView();
	
        modelAndView.setViewName("index");
        return modelAndView;
    
    }
}
