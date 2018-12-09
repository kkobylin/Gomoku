package main;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import model.FieldTile;


public class Main extends Application 
{
	public static GridPane gridPane = new GridPane();
	
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
					gridPane.add(ft, i, j);
				}    
			
			
		        
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (Exception e) 
		{
			e.printStackTrace();
		}
	}

	public static void main(String[] args) 
	{ launch(args); }
}


