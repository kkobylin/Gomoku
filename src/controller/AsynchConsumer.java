package controller;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;
import controller.Controller;

public class AsynchConsumer implements MessageListener {
	@Override
	public void onMessage(Message message) {
		if (message instanceof TextMessage)
			try 
			{
				Controller.myTurn=true;

			} 
			//catch (JMSException e) 
		catch(Exception e)
		{
				e.printStackTrace();
			}
	}
}
