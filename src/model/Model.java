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
				message.setup("It is draw!");
			}
			testForWinVertically();
			testForWinHorizontally();
			testForWinDiagonally();
				
		}
	}

	void testForWinVertically()
	{
		int whiteChain=0;
		int blackChain=0;
		boolean actualWhite=true;
		
		for(int i=0;i<15;i++)
		{
			for(int j=0;j<15;j++)
			{
				//kolumna potem wiersz
				if(!(main.Main.tablica[i][j].ifEmpty()))
				{
					if(main.Main.tablica[i][j].ifPlayerWhite())
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
					System.out.println("White win");
					message.setup("White wins!");
					break;
				}
				else if (blackChain>=5)
				{
					System.out.println("Black win");
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
				//kolumna potem wiersz
				if(!(main.Main.tablica[j][i].ifEmpty()))
				{
					if(main.Main.tablica[j][i].ifPlayerWhite())
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
					System.out.println("White win");
					message.setup("White wins!");
					break;
				}
				else if (blackChain>=5)
				{
					System.out.println("Black win");	
					message.setup("Black wins!");
					break;
				}
					
			}
		whiteChain=0;
		blackChain=0;
		}
	}
	
	void testForWinDiagonally()
	{
		int whiteChain=0;
		int blackChain=0;
		boolean actualWhite=true;
		
		//i - row
		
		for(int k=10;k>=0;k--)
		{
			//up to down ,left half
			int i=k;
			int j=0;
			
			while(i>=0 && i<=14 && j>=0 && j<=14)
			{
				
				if(!(main.Main.tablica[j][i].ifEmpty()))
				{
					if(main.Main.tablica[j][i].ifPlayerWhite())
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
				
				if(!(main.Main.tablica[j][i].ifEmpty()))
				{
					if(main.Main.tablica[j][i].ifPlayerWhite())
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
				
				if(!(main.Main.tablica[j][i].ifEmpty()))
				{
					if(main.Main.tablica[j][i].ifPlayerWhite())
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
				
				if(!(main.Main.tablica[j][i].ifEmpty()))
				{
					if(main.Main.tablica[j][i].ifPlayerWhite())
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
	
	
	boolean testForDraw()
	{
		if(movesNumber>=225)
			return true;
		else
			return false;
	}
	
	void restart()
	{
		
	}
}
