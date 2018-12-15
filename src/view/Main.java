package view;


import controller.Controller;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import model.FieldTile;
import model.Message;


public class Main extends Application 
{
	public static GridPane gridPane = new GridPane();
	public static FieldTile[][] tablica= new FieldTile[15][15];
	public static Controller controller;
	Message mes = new Message();
	Boolean playerWhite;
	
	@Override
	public void start(Stage primaryStage) 
	{
		//true - player White
		//false - player Black
		playerWhite=true;
		controller = new Controller(playerWhite);
		try {	
			
			gridPane.setPrefSize(810,810);
			gridPane.setGridLinesVisible(true);
			gridPane.setStyle("-fx-background-color:  #FFFF99;");
			Scene scene = new Scene(gridPane, 810, 810);
			for (int i = 0; i < 15; i++)
				for (int j = 0; j < 15; j++) 
				{
					FieldTile ft = new FieldTile(i,j);
					tablica[i][j]=ft;
					gridPane.add(ft, i, j);
				}    
			
			
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
}


