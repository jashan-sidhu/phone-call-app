package com.jashan.phonecallapp;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Call;
import com.twilio.type.PhoneNumber;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.net.URI;

@SpringBootApplication
public class PhoneCallAppApplication implements ApplicationRunner {


	/*we are using ApplicationRunner beacuse it automatically executes the run method.
	and we have defined the Call creator in that so that whenever the application runs it calls the number.
	 */

	private final static String SID_ACCOUNT = "AC4f2eb90a04f95849247960574442b694"; 	//TWILIO parameters
	private final static String AUTH_ID = "450d5e4d2170d239fe3546e445c72702"; 	//TWILIO parameters
	private final static String FROM_NUMBER = "+14068124805"; 	//TWILIO parameters
	private final static String TO_NUMBER = "+919729208066"; 	//TWILIO parameters

/*	using static block because at the class loading phase this function will get executed.
	and it will initialize the twilio in our application.*/
	static {
		Twilio.init(SID_ACCOUNT, AUTH_ID);
	}

	public static void main(String[] args) {
		SpringApplication.run(PhoneCallAppApplication.class, args);
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		Call.creator(new PhoneNumber(TO_NUMBER), new PhoneNumber(FROM_NUMBER),
						new URI("http://demo.twilio.com/docs/voice.xml"))
				.create();
	}
}
