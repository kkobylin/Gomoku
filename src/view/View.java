package view;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;

public class View {

	private Rectangle rec = new Rectangle(10,10,Color.RED);
	
	public void drawRec(int col, int row)
	{
		view.Main.gridPane.add(rec, col, row);
		rec.setTranslateX(22);
	}
	
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
	
	public void removeRec()
	{
		view.Main.gridPane.getChildren().remove(rec);
	}
	
}
