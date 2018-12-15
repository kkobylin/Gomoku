package controller;

import javax.jms.JMSException;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import model.FieldTile;
import model.Message;
import model.Model;
import view.View;

public class Controller {
	
	public static Model model;
	Producer producer;
	Consumer consumer;
	Message alert = new Message();
	static boolean myTurn;
	FieldTile lastFt=null;
	View viewObj= new View();
	

	public Controller(boolean whitePlayer) 
	{
		myTurn=false;
		try {
			if (whitePlayer)
				producer = new Producer("localhost:4848/jms", "producer");
			else
				producer = new Producer("localhost:4848/jms", "consumer");
		} catch (JMSException e) {
			alert.setup("Problem while trying to connect to server.");
		}
		
		
		try {
			if (whitePlayer)
				consumer = new Consumer("localhost:4848/jms", "consumer");
			else
				consumer = new Consumer("localhost:4848/jms", "producer");
		} catch (JMSException e) {
			alert.setup("Problem while trying to connect to server.");
		}
		
		consumer.getJMSConsumer().setMessageListener(new AsynchConsumer());
	
		if (whitePlayer) {
			myTurn = true;
		}
	
		model = new Model(whitePlayer);
	}
	
	public void setMyTurn()
	{
		myTurn=true;
		Platform.runLater(() ->
		{
		viewObj.drawRec(lastFt.getCol(), lastFt.getRow());
		});
	}
    
    
    @FXML
    public void Click(MouseEvent event) 
    {	
    	
    		if(myTurn)
    		{
    			if(lastFt!=null)
    			{
    				viewObj.removeRec();
    			}
    			myTurn=false;
    			
    			String text = String.valueOf(((FieldTile)event.getSource()).getCol());
    			text+=";";
    			text+=String.valueOf(((FieldTile)event.getSource()).getRow());
    			producer.sendQueueMessage(text);
    			lastFt=view.Main.tablica[((FieldTile)event.getSource()).getCol()][((FieldTile)event.getSource()).getRow()];  			
    			model.turn((FieldTile)event.getSource());
    		}
    	
    		
    }
    
    public void endOfGame()
    {
    	producer.finalize();
    	consumer.finalize();
    }

}
