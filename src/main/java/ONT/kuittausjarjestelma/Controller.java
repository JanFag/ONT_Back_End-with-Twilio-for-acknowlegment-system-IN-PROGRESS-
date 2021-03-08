package ONT.kuittausjarjestelma;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.twilio.twiml.MessagingResponse;

import java.io.IOException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import ONT.kuittausjarjestelma.TwilioServlet;

@RestController
public class Controller {

	private final static Logger LOGGER = LoggerFactory.getLogger(Controller.class);
	@Autowired
	private Service service;
	
	@Autowired
	private TwilioServlet twilioServlet;
	
	@Autowired
	private HttpServletRequest request;
	
	@Autowired
	private HttpServletResponse response;
	
	
	
	@RequestMapping(value = "api/v1/sms", method = RequestMethod.POST)
	public void sendSms(@Valid @RequestBody SmsRequest smsRequest) {
		service.sendSms(smsRequest);
	}
	
	// ...
	@RequestMapping(value = "/replyMessage", method = RequestMethod.POST)
	public void replyMessage(HttpServletRequest request, HttpServletResponse response) throws IOException {
		LOGGER.info("THIS IS THE REQUEST. request:" + request + ". response: "+ response.getCharacterEncoding());
		twilioServlet.service(request, response);
	  
	}

}
