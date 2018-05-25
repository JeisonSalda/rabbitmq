package co.com.ceiba.charlas.rabbitmq.publishsubscribe;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class SimulatorPublisher {
	
	
	public static void main(String args[]) throws IOException, TimeoutException{
		for( int i = 0; i < 200; i++ ){
			try {
				Publisher publisher = new Publisher();
				publisher.sendMessage("BroadCast " + i);
				
			} catch (IOException | TimeoutException e) {
				System.err.println("Error " + e.getMessage());
			} 
		}
		ConfigurationBroker.getIntance().closeConnections();
		
	}

}
