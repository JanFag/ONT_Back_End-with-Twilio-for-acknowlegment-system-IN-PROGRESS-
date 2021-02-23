package ONT.kuittausjarjestelma;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import com.twilio.Twilio;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

@Configuration
public class TwilioInitializer {
	private final static Logger LOGGER = LoggerFactory.getLogger(TwilioInitializer.class);
	
	
	private final TwilioConfiguration twilioConfiguration;
	
	@Autowired
	public TwilioInitializer(TwilioConfiguration twilioConfiguration) {
		this.twilioConfiguration = twilioConfiguration;
		LOGGER.info("LOOK HERE! "+twilioConfiguration.getAccountSid());
		Twilio.init(
				twilioConfiguration.getAccountSid(),
				twilioConfiguration.getAuthToken()
		);
		LOGGER.info("Twilio initialized... with account sid {}", twilioConfiguration.getAccountSid());
		
		
	}
}
