package co.com.ceiba.charlas.rabbitmq.pointtopoint;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class GeneratorProductor {
	
	public static void main( String args[] ) throws IOException, TimeoutException{
		
		for( int i = 0; i < 200; i++ ){
			try {
				Productor productor = new Productor();
				productor.sendMessage("Hola prueba con rabbitmq: " + i);
				
			} catch (IOException | TimeoutException e) {
				System.out.println("Error: " + e.getMessage());
			}
		}
		
		ConfigurationBroker.getIntance().closeConnections();
		
	}

}
