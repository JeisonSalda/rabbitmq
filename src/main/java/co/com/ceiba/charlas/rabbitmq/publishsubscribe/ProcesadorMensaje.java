package co.com.ceiba.charlas.rabbitmq.publishsubscribe;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.DefaultConsumer;
import com.rabbitmq.client.Envelope;
import com.rabbitmq.client.AMQP.BasicProperties;

public class ProcesadorMensaje extends DefaultConsumer {

	private Channel canal;
	
	public ProcesadorMensaje(Channel channel) {
		super(channel);
		this.canal = channel;
	}

	@Override
	public void handleDelivery(String consumerTag, Envelope envelop, BasicProperties basicProp, byte[] body) throws IOException{
		String mensaje = "";
		try {
			mensaje = new String(body, "UTF-8");
			System.out.println("[x] Mensaje recibido '" + mensaje + "'");
			Thread.sleep(1000);
		} catch (UnsupportedEncodingException| InterruptedException e) {
			
			e.printStackTrace();
		}finally{
			System.out.println("[x] Done ");
			canal.basicAck(envelop.getDeliveryTag(), false);
		}
		
	}
	
	

}
