package model;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;

public class Message
{
	private Alert alert = new Alert(AlertType.NONE);
	public Message()
	{
		alert.setTitle("End of Game");
		alert.getDialogPane().getButtonTypes().add(ButtonType.OK);
	}
	
	public void setup(String messageContent)
	{
		alert.setContentText(messageContent);
		alert.showAndWait();
	}
}
