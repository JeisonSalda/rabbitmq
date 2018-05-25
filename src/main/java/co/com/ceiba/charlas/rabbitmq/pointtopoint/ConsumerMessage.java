package co.com.ceiba.charlas.rabbitmq.pointtopoint;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import com.rabbitmq.client.Channel;

public class ConsumerMessage {
	
	private ConfigurationBroker configuration;
	
	public ConsumerMessage( ) throws IOException, TimeoutException{
		configuration = ConfigurationBroker.getIntance();
	}
	
	public void recibirMensaje() throws IOException {
		Channel canal = configuration.getCanal();
		canal.basicQos(1);
		
		ProcesadorMensaje procesador = new ProcesadorMensaje(canal);
		canal.basicConsume(ConfigurationBroker.QUEUE, false, procesador);
	}

}
