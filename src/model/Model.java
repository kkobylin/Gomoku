package model;

import javafx.application.Platform;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class Model 
{
	
	private static int movesNumber=0;
	Message message = new Message();
	boolean playerWhite;

	public Model(boolean whitePlayer) 
	{
		playerWhite=whitePlayer;

	}
	

	private void testForWinVertically()
	{
		int whiteChain=0;
		int blackChain=0;
		boolean actualWhite=true;
		
		for(int i=0;i<15;i++)
		{
			for(int j=0;j<15;j++)
			{
				//i - column j - row
				if(!(main.Main.tablica[i][j].getEmpty()))
				{
					if(main.Main.tablica[i][j].getPlayerWhite())
					{
						if(actualWhite)
						{
							whiteChain++;
						}
						else
						{
							blackChain=0;
							actualWhite=true;
							whiteChain++;
						}
					}
					else
					{
						if(actualWhite)
						{
							whiteChain=0;
							actualWhite=false;
							blackChain++;
						}
						else
						{
							blackChain++;
						}
					}
					
				}
				else
				{
					whiteChain=0;
					blackChain=0;
				}
				if(whiteChain>=5)
				{
					message.setup("White wins!");
					break;
				}
				else if (blackChain>=5)
				{
					message.setup("Black wins!");
					break;
				}
					
			}
		whiteChain=0;
		blackChain=0;
		}
			
	}
	
	void testForWinHorizontally()
	{
		int whiteChain=0;
		int blackChain=0;
		boolean actualWhite=true;
		
		for(int i=0;i<15;i++)
		{
			for(int j=0;j<15;j++)
			{
				if(!(main.Main.tablica[j][i].getEmpty()))
				{
					if(main.Main.tablica[j][i].getPlayerWhite())
					{
						if(actualWhite)
						{
							whiteChain++;
						}
						else
						{
							blackChain=0;
							actualWhite=true;
							whiteChain++;
						}
					}
					else
					{
						if(actualWhite)
						{
							whiteChain=0;
							actualWhite=false;
							blackChain++;
						}
						else
						{
							blackChain++;
						}
					}
					
				}
				else
				{
					whiteChain=0;
					blackChain=0;
				}
				if(whiteChain>=5)
				{
					message.setup("White wins!");
					break;
				}
				else if (blackChain>=5)
				{
					message.setup("Black wins!");
					break;
				}
					
			}
		whiteChain=0;
		blackChain=0;
		}
	}
	
	private void testForWinDiagonally()
	{
		int whiteChain=0;
		int blackChain=0;
		boolean actualWhite=true;
		
		//i - row, j - column
		
		for(int k=10;k>=0;k--)
		{
			//up to down ,left half
			int i=k;
			int j=0;
			
			while(i>=0 && i<=14 && j>=0 && j<=14)
			{
				
				if(!(main.Main.tablica[j][i].getEmpty()))
				{
					if(main.Main.tablica[j][i].getPlayerWhite())
					{
						if(actualWhite)
						{
							whiteChain++;
						}
						else
						{
							blackChain=0;
							actualWhite=true;
							whiteChain++;
						}
					}
					else
					{
						if(actualWhite)
						{
							whiteChain=0;
							actualWhite=false;
							blackChain++;
						}
						else
						{
							blackChain++;
						}
					}
					
				}
				else
				{
					whiteChain=0;
					blackChain=0;
				}
				if(whiteChain>=5)
				{
					message.setup("White wins!");
					break;
				}
				else if (blackChain>=5)
				{
					message.setup("Black wins!");
					break;
				}
			i++;
			j++;
			}
			whiteChain=0;
			blackChain=0;
			
			//down to up, left half
			i=k+4;
			j=0;
			
			while(i>=0 && i<=14 && j>=0 && j<=14)
			{
				
				if(!(main.Main.tablica[j][i].getEmpty()))
				{
					if(main.Main.tablica[j][i].getPlayerWhite())
					{
						if(actualWhite)
						{
							whiteChain++;
						}
						else
						{
							blackChain=0;
							actualWhite=true;
							whiteChain++;
						}
					}
					else
					{
						if(actualWhite)
						{
							whiteChain=0;
							actualWhite=false;
							blackChain++;
						}
						else
						{
							blackChain++;
						}
					}
					
				}
				else
				{
					whiteChain=0;
					blackChain=0;
				}
				if(whiteChain>=5)
				{
					message.setup("White wins!");
					break;
				}
				else if (blackChain>=5)
				{
					message.setup("Black wins!");
					break;
				}
			i--;
			j++;
			}
			whiteChain=0;
			blackChain=0;
			
			//down to up, right half without checking the longest down to up diagonal
			i=14;
			j=k;
			
			while(i>0 && i<=14 && j>0 && j<=14)
			{
				
				if(!(main.Main.tablica[j][i].getEmpty()))
				{
					if(main.Main.tablica[j][i].getPlayerWhite())
					{
						if(actualWhite)
						{
							whiteChain++;
						}
						else
						{
							blackChain=0;
							actualWhite=true;
							whiteChain++;
						}
					}
					else
					{
						if(actualWhite)
						{
							whiteChain=0;
							actualWhite=false;
							blackChain++;
						}
						else
						{
							blackChain++;
						}
					}
					
				}
				else
				{
					whiteChain=0;
					blackChain=0;
				}
				if(whiteChain>=5)
				{
					message.setup("White wins!");
					break;
				}
				else if (blackChain>=5)
				{
					message.setup("Black wins!");
					break;
				}
			i--;
			j++;
			}
			whiteChain=0;
			blackChain=0;
			
			//up to down ,right half without checking the longest up to down diagonal
			i=0;
			j=k;
			
			while(i>=0 && i<14 && j>0 && j<=14)
			{
				
				if(!(main.Main.tablica[j][i].getEmpty()))
				{
					if(main.Main.tablica[j][i].getPlayerWhite())
					{
						if(actualWhite)
						{
							whiteChain++;
						}
						else
						{
							blackChain=0;
							actualWhite=true;
							whiteChain++;
						}
					}
					else
					{
						if(actualWhite)
						{
							whiteChain=0;
							actualWhite=false;
							blackChain++;
						}
						else
						{
							blackChain++;
						}
					}
					
				}
				else
				{
					whiteChain=0;
					blackChain=0;
				}
				if(whiteChain>=5)
				{
					message.setup("White wins!");
					break;
				}
				else if (blackChain>=5)
				{	
					message.setup("Black wins!");
					break;
				}
			i++;
			j++;
			}
			whiteChain=0;
			blackChain=0;
			
		}
	}
	
	
	private void testForDraw()
	{
		if(movesNumber>=225)
			message.setup("It is draw!");
	}
	
	public void turn(FieldTile ft)
	{

		if (ft.getEmpty()) 
		{
			
			if (playerWhite) 	
				ft.setPlayerWhite();
			
			Circle circle = new Circle(27);
			if(playerWhite)
				circle.setFill(Color.rgb(252, 252, 252));
			else
				circle.setFill(Color.rgb(0, 0, 0));
			
			main.Main.gridPane.add(circle, ft.getCol(), ft.getRow());
			ft.notEmpty();
			movesNumber++;
			testForDraw();
			testForWinVertically();
			testForWinHorizontally();
			testForWinDiagonally();
				
		}
	}
	
	public void updateBoard(String str)
	{
		Platform.runLater(() -> {
			int scPos = str.indexOf(";");
			int col = Integer.parseInt(str.substring(0, scPos));
			int row = Integer.parseInt(str.substring(scPos + 1));

			Circle circle = new Circle(27);

			if (playerWhite)
				circle.setFill(Color.rgb(0, 0, 0));
			else
				circle.setFill(Color.rgb(252, 252, 252));

			if (!playerWhite)
				main.Main.tablica[col][row].setPlayerWhite();

			main.Main.gridPane.add(circle, col, row);
			main.Main.tablica[col][row].notEmpty();
			movesNumber++;
			testForDraw();
			testForWinVertically();
			testForWinHorizontally();
			testForWinDiagonally();
		});
		
		
	}
	
}
