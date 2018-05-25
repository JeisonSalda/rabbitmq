package co.com.ceiba.charlas.rabbitmq.pointtopoint;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class GeneratorConsumer {
	
public static void main( String args[] ){
		
		try {
			ConsumerMessage consumer = new ConsumerMessage();
			consumer.recibirMensaje();
			
		} catch (IOException | TimeoutException e) {
			System.out.println("Error: " + e.getMessage());
		}
		
		
	}

}
