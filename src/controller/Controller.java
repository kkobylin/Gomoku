package controller;

import javax.jms.JMSException;

import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import model.FieldTile;
import model.Message;
import model.Model;

public class Controller {
	
	//private model.Model model = new model.Model();
	private Model model;
	Producer producer;
	Consumer consumer;
	Message alert = new Message();
	static boolean myTurn;
	

	public Controller(boolean whitePlayer) 
	{
		myTurn=false;
		try {
			producer = new Producer("localhost:4848/jms", "producer");
		} catch (JMSException e) {
			alert.setup("Problem while trying to connect to server.");
		}
		
		
		try {
			consumer = new Consumer("localhost:4848/jms", "consumer");
		} catch (JMSException e) {
			alert.setup("Problem while trying to connect to server.");
			System.out.print("exception");
		}
		
		consumer.getJMSConsumer().setMessageListener(new AsynchConsumer());
	
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
    	
    		if(myTurn)
    		{
    			model.turn((FieldTile)event.getSource());
    			myTurn=false;
    			producer.sendQueueMessage("Your turn");
    		}
    	
    		
    }

}
