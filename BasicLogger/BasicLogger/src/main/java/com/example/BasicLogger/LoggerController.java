import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.ui.ModelMap;

@RestController
public class LoggerController{
   private static final Logger LOGGER = Logger.getLogger(LoggerController.class);
   @GetMapping("/Hello")
   public String printHello(ModelMap model) {
      LOGGER.info("printHello started.");

      //logs debug message
      if(LOGGER.isDebugEnabled()){
         LOGGER.debug("Inside:  printHello");
      }
      //logs exception
      LOGGER.error("Logging a sample exception", new Exception("Testing"));

      model.addAttribute("message", "Hello Spring Framework!");
      LOGGER.info("printHello ended.");
      return "hello";
   }
}
