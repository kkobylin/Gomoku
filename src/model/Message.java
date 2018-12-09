package model;

import java.util.Optional;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;

public class Message
{
	private Alert alert = new Alert(AlertType.NONE);
	Optional<ButtonType> result = alert.showAndWait();
	private model.Model model = new model.Model();
	private String message = new String();
	public Message()
	{
		alert.setTitle("End of Game");
		alert.getDialogPane().getButtonTypes().add(ButtonType.YES);
		alert.getDialogPane().getButtonTypes().add(ButtonType.NO);
		alert.getDialogPane().getButtonTypes().add(ButtonType.CLOSE);
	}
	
	public void setup(String messageContent)
	{
		message+=messageContent;
		message+=System.lineSeparator();
		message+="Do you want to play again?";
		alert.setContentText(message);
		alert.showAndWait();
		
		if (result.isPresent() ) {
		if (result.get() == ButtonType.YES) { model.restart(); }
		else if (result.get() == ButtonType.NO) { alert.close();}
		}

	}
}
