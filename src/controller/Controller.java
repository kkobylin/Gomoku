package controller;

import javax.jms.JMSException;

import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import model.FieldTile;
import model.Message;
import model.Model;

public class Controller {
	
	private Model model;
	Producer producer;
	Consumer consumer;
	Message alert = new Message();
	static boolean myTurn=false;
	

	
	public Controller()
	{
		
	}
	
	public Controller(boolean whitePlayer) 
	{
		try {
			producer = new Producer("localhost:4848/jms", "producer");
		} catch (JMSException e) {
			alert.setup("Problem while trying to connect to server.");
		}
		
		//wyslac odpowiednia nazwe gracza
		//producer.sendQueueMessage("Player1");
		
		try {
			consumer = new Consumer("localhost:4848/jms", "consumer");
		} catch (JMSException e) {
			alert.setup("Problem while trying to connect to server.");
		}
		
		consumer.getJMSConsumer().setMessageListener(new AsynchConsumer());
		
		//Wyslanie pierwszej wiadomosci dorobic
		if(whitePlayer)
			{
			myTurn=true;
			}
	
		model = new Model(whitePlayer);
		System.out.println("cos");
	}
    
    
    @FXML
    public void Click(MouseEvent event) 
    {	
    	//model.turn((FieldTile)event.getSource());
    	
    		if(myTurn)
    		{
    			//model.turn((FieldTile)event.getSource());
    			myTurn=false;
    			producer.sendQueueMessage("Your turn");
    		}
    	
    		
    }

}
