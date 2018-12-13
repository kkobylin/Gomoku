package view;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class View {

	public void drawWhite(int col, int row)
	{
		Circle circle = new Circle(27);
		circle.setFill(Color.rgb(252, 252, 252));
		view.Main.gridPane.add(circle, col, row);
	}
	
	public void drawBlack(int col, int row)
	{
		Circle circle = new Circle(27);
		circle.setFill(Color.rgb(0, 0, 0));
		view.Main.gridPane.add(circle, col, row);
	}
	
	
}
