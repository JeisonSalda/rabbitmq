package co.com.ceiba.charlas.rabbitmq.pointtopoint;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class Productor {
	
	private ConfigurationBroker configuration;
	
	public Productor( ) throws IOException, TimeoutException{
		configuration = ConfigurationBroker.getIntance();
	}
	
	public void sendMessage( String message) throws IOException{
		configuration.getCanal().basicPublish("", ConfigurationBroker.QUEUE, null, message.getBytes());
	}

}
