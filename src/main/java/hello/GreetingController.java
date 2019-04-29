package hello;

import org.jboss.logging.Message;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.util.HtmlUtils;

@Controller
public class GreetingController {

    Logger logger = LoggerFactory.getLogger(getClass());

    @MessageMapping("/hello")
    @SendTo({"/topic/greetings"})
    public Greeting greeting(HelloMessage message) throws Exception {
        return new Greeting("Hello, " + HtmlUtils.htmlEscape(message.getName()) + "!");
    }

    @RequestMapping("/hi")
    public Greeting sendUser(String username){
        logger.info("hi my wife");
        return new Greeting("Hello, " + username + "!");
    }

}
