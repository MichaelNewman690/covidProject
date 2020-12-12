package User.accessingdatamysql;

import java.util.Map;
import java.util.UUID;
import javax.servlet.http.HttpServletRequest;

import com.example.accessingdatamysql.UserRepository;

import org.apache.logging.log4j.message.SimpleMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class RegisterController {

	@Controller
	@RequestMapping(path="/demo") 
	public class MainController {
  	@Autowired 
    private UserRepository userRepository;
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public ModelAndView processRegistrationForm(ModelAndView modelAndView, @Valid User user, BindingResult bindingResult, HttpServletRequest request) {
				
		System.out.println(userExists);	
		if (userExists != null) {
			modelAndView.addObject("alreadyRegisteredMessage", "Oops!  There is already a user registered with the email provided.");
			modelAndView.setViewName("register");
			bindingResult.reject("email");
		}
			
		if (bindingResult.hasErrors()) { 
			modelAndView.setViewName("register");		
		} else { 
		    user.setEnabled(false);
		      		        
		    Object userService;
			((Object) userService).saveUser(user);
				
			String appUrl = request.getScheme() + "://" + request.getServerName();
			
			SimpleMailMessage registrationEmail = new SimpleMessage();
			registrationEmail.setTo(user.getEmail());
			registrationEmail.setSubject("Registration Confirmation");
			registrationEmail.setText("To confirm your e-mail address, please click the link below:\n"
					+ appUrl + "/confirm?token=" + user.getConfirmationToken());
			registrationEmail.setFrom("noreply@domain.com");
			
			modelAndView.addObject("confirmationMessage", "A confirmation e-mail has been sent to " + user.getEmail());
			modelAndView.setViewName("register");
		}
			
		return modelAndView;
	}
	
	
	
}
