package ONT.kuittausjarjestelma;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties("twilio")
public class TwilioConfiguration {
	private String accountSid = "ACd3ceef4874535e3c7a616a2632f692f4";
	private String authToken = "bb43ec7b85c0852fc0c96a1dadee1c21";
	private String trialNumber = "+19704007055";
	
	public TwilioConfiguration() {
		
	}

	public String getAccountSid() {
		return accountSid;
	}

	public void setAccountSid(String accountSid) {
		this.accountSid = accountSid;
	}

	public String getAuthToken() {
		return authToken;
	}

	public void setAuthToken(String authToken) {
		this.authToken = authToken;
	}

	public String getTrialNumber() {
		return trialNumber;
	}

	public void setTrialNumber(String trialNumber) {
		this.trialNumber = trialNumber;
	}



	
}
