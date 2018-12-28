package model;

import javafx.application.Platform;
import view.Controller;

public class Model 
{
	
	private static int movesNumber=0;
	private Message message = new Message();
	private boolean playerWhite;

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
				if(!(view.Controller.tablica[i][j].getEmpty()))
				{
					if(view.Controller.tablica[i][j].getPlayerWhite())
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
					view.Main.controller.endOfGame();
					break;
				}
				else if (blackChain>=5)
				{
					message.setup("Black wins!");
					view.Main.controller.endOfGame();
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
				if(!(view.Controller.tablica[j][i].getEmpty()))
				{
					if(view.Controller.tablica[j][i].getPlayerWhite())
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
					view.Main.controller.endOfGame();
					break;
				}
				else if (blackChain>=5)
				{
					message.setup("Black wins!");
					view.Main.controller.endOfGame();
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
				
				if(!(view.Controller.tablica[j][i].getEmpty()))
				{
					if(view.Controller.tablica[j][i].getPlayerWhite())
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
					view.Main.controller.endOfGame();
					break;
				}
				else if (blackChain>=5)
				{
					message.setup("Black wins!");
					view.Main.controller.endOfGame();
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
				
				if(!(view.Controller.tablica[j][i].getEmpty()))
				{
					if(view.Controller.tablica[j][i].getPlayerWhite())
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
					view.Main.controller.endOfGame();
					break;
				}
				else if (blackChain>=5)
				{
					message.setup("Black wins!");
					view.Main.controller.endOfGame();
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
				
				if(!(view.Controller.tablica[j][i].getEmpty()))
				{
					if(view.Controller.tablica[j][i].getPlayerWhite())
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
					view.Main.controller.endOfGame();
					break;
				}
				else if (blackChain>=5)
				{
					message.setup("Black wins!");
					view.Main.controller.endOfGame();
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
				
				if(!(view.Controller.tablica[j][i].getEmpty()))
				{
					if(view.Controller.tablica[j][i].getPlayerWhite())
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
					view.Main.controller.endOfGame();
					break;
				}
				else if (blackChain>=5)
				{	
					message.setup("Black wins!");
					view.Main.controller.endOfGame();
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
		{
			message.setup("It is draw!");
			view.Main.controller.endOfGame();
		}
	}
	
	
	public void turn(FieldTile ft)
	{

		if (ft.getEmpty()) 
		{
			
			if (playerWhite) 	
				ft.setPlayerWhite();
			
			if(playerWhite)
				view.Main.controller.drawWhite(ft.getCol(), ft.getRow());
			else
				view.Main.controller.drawBlack(ft.getCol(), ft.getRow());

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

			if(!playerWhite)
				view.Main.controller.drawWhite(col, row);
			else
				view.Main.controller.drawBlack(col, row);

			if (!playerWhite)
				Controller.tablica[col][row].setPlayerWhite();

			Controller.tablica[col][row].notEmpty();
			movesNumber++;
			testForDraw();
			testForWinVertically();
			testForWinHorizontally();
			testForWinDiagonally();
		});
		
		
	}
	
}
