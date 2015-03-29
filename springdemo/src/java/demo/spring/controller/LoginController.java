
package demo.spring.controller;

import demo.spring.common.LogWriter;
import java.util.Locale;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
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
    private static final Log logger = LogFactory.getLog(LoginController.class);
    
    @Autowired
    ReloadableResourceBundleMessageSource messageSource;
    @RequestMapping(value="/LoginPage", method = RequestMethod.GET)
    public ModelAndView loginPage(@RequestParam(value = "error", required = false) String error,
		@RequestParam(value = "logout", required = false) String logout, 
                @RequestParam(value = "sessionexpired", required = false) String sessionexpired,
                Locale locale){
        logger.debug("INIT: Login ");
        ModelAndView modelAndView = new ModelAndView();
        	if (error != null) {
			//modelAndView.addObject("error", "Invalid username and password!");
                        logger.error("Error Logon: Login ", new Exception(error));
                        modelAndView.addObject("error", messageSource.getMessage("login.invalid.credentials", null,locale ));
		}
 
		if (logout != null) {
			//modelAndView.addObject("msg", "You've been logged out successfully.");
                    logger.error("Error Logon: Login ", new Exception(error));
                    modelAndView.addObject("msg", messageSource.getMessage("logout.message", null,locale ));
		}
                if (sessionexpired != null) {
			//modelAndView.addObject("msg", "You've been logged out successfully.");
                    logger.error("Error Logon: Login ", new Exception(error));
                    modelAndView.addObject("msg", messageSource.getMessage("session.expired", null,locale ));
		}
        modelAndView.setViewName("login");
         logger.debug("Exit: Login ");
        return modelAndView;
    
    }
    
    @RequestMapping(value="/workspace/welcome.action", method = RequestMethod.GET)
    public ModelAndView welcomePage(){
         logger.debug("Exit: welcome ");
        ModelAndView modelAndView = new ModelAndView();
        ModelAndView model = new ModelAndView();
	
        modelAndView.setViewName("index");
         logger.debug("Exit: welcome ");
        return modelAndView;
    
    }
}
