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
			try {
				Controller.model.updateBoard(((TextMessage) message).getText());
				main.Main.controller.setMyTurn();

			} catch (JMSException e) {
				e.printStackTrace();
			}
	}
}
