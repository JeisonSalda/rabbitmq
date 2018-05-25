package co.com.ceiba.charlas.rabbitmq.publishsubscribe;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class Publisher {
	
	private ConfigurationBroker configuration;
	
	public Publisher() throws IOException, TimeoutException{
		configuration = ConfigurationBroker.getIntance();
	}
	
	public void sendMessage( String message ) throws IOException{
		configuration.getCanal().basicPublish(ConfigurationBroker.EXCHANGE, "", null, message.getBytes());
	}

}
