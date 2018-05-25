package co.com.ceiba.charlas.rabbitmq.publishsubscribe;
import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class SimulatorSubscriber {
	
	public static void main(String args[]) throws IOException, TimeoutException{
		
		try {
			Subscriber subscriber = new Subscriber();
			subscriber.receive();
			
		} catch (IOException | TimeoutException e) {
			System.err.println("Error " + e.getMessage());
		}		
	}

}
