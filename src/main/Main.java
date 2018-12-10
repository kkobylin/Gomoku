package main;


import controller.Controller;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import model.FieldTile;
import java.net.ConnectException;
import javax.jms.JMSException;


public class Main extends Application 
{
	public static GridPane gridPane = new GridPane();
	public static FieldTile[][] tablica= new FieldTile[15][15];
	Controller controler;
	
	@Override
	public void start(Stage primaryStage) 
	{
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
		} catch (Exception e) 
		{
			e.printStackTrace();
		}
		
		
		controler = new Controller(true);
		
	}

	public static void main(String[] args) 
	{ launch(args); }
}


