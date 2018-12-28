package view;


import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import model.Message;


public class Main extends Application 
{
	//true - player White
	//false - player Black
	static private Boolean playerWhite=true;
	private Message mes = new Message();
	public static Controller controller;
	
	
	@Override
	public void start(Stage primaryStage) 
	{
		
		try {	
			
			ViewLoader<AnchorPane, Controller> viewLoader = new ViewLoader<AnchorPane, Controller>("Main.fxml");
			AnchorPane anchorPane = viewLoader.getLayout();
			controller = viewLoader.getController();
			Scene scene = new Scene(anchorPane, 810, 810);
			
			
			primaryStage.setScene(scene);
			primaryStage.show();
			String text ="";
			
			if(playerWhite)
			{
				text+="You are Player White";
				text+=System.lineSeparator();
				text+="Your move!";
				mes.startGame(text);
			}
			else
			{
				text+="You are Player Black";
				text+=System.lineSeparator();
				text+="Wait for Player White move!";
				mes.startGame(text);
			}
				
		} catch (Exception e) 
		{
			e.printStackTrace();
		}
		
		
		
		
	}

	public static void main(String[] args) 
	{ launch(args); }
	
	static public boolean getPlayer()
	{
		return playerWhite;
	}
}


