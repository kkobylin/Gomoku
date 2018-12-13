package model;
import javafx.scene.canvas.Canvas;

public class FieldTile extends Canvas
{
	private int row, col;
	boolean empty;
	private boolean playerWhite;
	
	public FieldTile(int c, int r)
	{
		super();
		this.setHeight(54);
		this.setWidth(54);
		this.setOnMouseClicked(event -> main.Main.controller.Click(event));
		this.setVisible(true);
		row=r;
		col=c;
		empty=true;
		playerWhite=false;
	}
	
	public int getRow()
	{
		return row;
	}
	
	public int getCol()
	{
		return col;
	}
	
	public boolean getEmpty()
	{
		return empty;
	}
	
	public void notEmpty()
	{
		empty=false;
	}
	
	public void setPlayerWhite()
	{
		playerWhite=true;
	}
	
	public boolean getPlayerWhite()
	{
		return playerWhite;
	}
	
}
