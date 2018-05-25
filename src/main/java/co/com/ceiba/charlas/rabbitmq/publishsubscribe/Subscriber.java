package co.com.ceiba.charlas.rabbitmq.publishsubscribe;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import com.rabbitmq.client.Channel;

public class Subscriber {
	
private ConfigurationBroker configuration;
	
	public Subscriber() throws IOException, TimeoutException{
		configuration = ConfigurationBroker.getIntance();
	}
	
	public void receive() throws IOException{
		Channel channel = configuration.getCanal();
		String queueName = channel.queueDeclare().getQueue();
		channel.queueBind(queueName, ConfigurationBroker.EXCHANGE, "");
		
		ProcesadorMensaje procesador = new ProcesadorMensaje(channel);
		channel.basicConsume(queueName, false, procesador);
		
	}

}
