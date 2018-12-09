package controller;

import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import model.FieldTile;

public class Controller {
	
	private model.Model model = new model.Model();
	
	public Controller() 
	{
	}
    
    
    @FXML
    public void Click(MouseEvent event) 
    {	
    		model.turn((FieldTile)event.getSource());
    }

}
