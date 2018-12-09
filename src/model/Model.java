package model;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class Model 
{
	
	private static boolean playerWhiteTurn=true;
	private static int movesNumber=0;
	private Circle circle = new Circle(27);
	Message message = new Message();
	
	public Model() 
	{
		
	}
	
	public void turn(FieldTile ft)
	{
		if (ft.ifEmpty()) 
		{
			if (playerWhiteTurn) {
				circle.setFill(Color.rgb(252, 252, 252));
				ft.setPlayerWhite();
				playerWhiteTurn = false;
			} else {
				circle.setFill(Color.rgb(0, 0, 0));
				playerWhiteTurn = true;
			}

			main.Main.gridPane.add(circle, ft.getCol(), ft.getRow());
			ft.notEmpty();
			movesNumber++;
			if(testForDraw())
			{
				//message.setup("It is draw!");
			}
				
		}
	}

	boolean testForDraw()
	{
		if(movesNumber>=10)
			return true;
		else
			return false;
	}
	
	void restart()
	{
		
	}
}
