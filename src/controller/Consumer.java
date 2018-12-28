package controller;

import javax.jms.ConnectionFactory;
import javax.jms.JMSConsumer;
import javax.jms.JMSContext;
import javax.jms.JMSException;
import javax.jms.Queue;
import javax.jms.TextMessage;

public class Consumer {
	private JMSContext jmsContext;
	private JMSConsumer jmsConsumer;
	private Queue queue;
	
	public JMSConsumer getJMSConsumer()
	{
		return jmsConsumer;
	}
	
	

	public Consumer(String url, String queueName) throws JMSException {
		ConnectionFactory connectionFactory = new com.sun.messaging.ConnectionFactory();
		jmsContext = connectionFactory.createContext();
// 7676 numer portu, na kt�rym JMS Service nas�uchuje po��cze�
// [hostName][:portNumber][/serviceName] np. "localhost:7676/jms"
		((com.sun.messaging.ConnectionFactory) connectionFactory)
				.setProperty(com.sun.messaging.ConnectionConfiguration.imqAddressList, url);
		queue = new com.sun.messaging.Queue(queueName); // "ATJQueue"
		jmsConsumer = jmsContext.createConsumer(queue);
	}

	public String receiveQueueMessage() throws JMSException {
		javax.jms.Message msg = jmsConsumer.receive(10); // 10 ms
		if (msg instanceof TextMessage)
			return ((TextMessage) msg).getText();
		return null;
	}

	public void finalize() {
		if (jmsConsumer != null)
			jmsConsumer.close();
		if (jmsContext != null)
			jmsContext.close();
	}
}
