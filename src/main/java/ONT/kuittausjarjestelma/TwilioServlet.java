package ONT.kuittausjarjestelma;
import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.twilio.twiml.messaging.Body;
import com.twilio.twiml.messaging.Message;
import com.twilio.twiml.MessagingResponse;
import com.twilio.twiml.TwiMLException;

@org.springframework.stereotype.Service
public class TwilioServlet extends HttpServlet {
	private final static Logger LOGGER = LoggerFactory.getLogger(TwilioServlet.class);
  public void service(HttpServletRequest request, HttpServletResponse response) throws IOException {
    String body = request.getParameter("Body");
    LOGGER.info("BODY IS HERE!" + body);
    String message = "Message";
    if (body.equals("hello")) {
      // Say hi
      message = "Hi there!";
    } else if (body.equals("bye")) {
      // Say goodbye
      message = "Goodbye!";
    }

    // Create a TwiML response and add our friendly message.
    Body messageBody = new Body.Builder(message).build();
    Message sms = new Message.Builder().body(messageBody).build();
    MessagingResponse twiml = new MessagingResponse.Builder().message(sms).build();

    response.setContentType("application/xml");

    try {
      response.getWriter().print(twiml.toXml());
    } catch (TwiMLException e) {
      e.printStackTrace();
    }
  }
}