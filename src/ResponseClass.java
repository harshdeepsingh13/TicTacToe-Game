

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class ResponseClass implements ActionListener
{
	GuiClass GuiClassObject;
	int flag=0;
	int turn=0;
	int x,y;
	ResponseClass(GuiClass object)
	{
		this.GuiClassObject=object;
	}
	//0-Continue;1-player(O) one won;2-player(X) 2 won;3-draw
	public int gameStatus()
	{
		///*
		for(int i=0;i<GuiClassObject.tacBack.length;i++)
		{
			for(int j=0;j<GuiClassObject.tacBack[i].length;j++)
				System.out.print(GuiClassObject.tacBack[i][j] + "\t");
			System.out.println();
		}
		System.out.println();
		//*/
		int gameState=-1;
		char symbol='t';
		for(int i=0;i<GuiClassObject.tacBack.length;i++)
		{
			for(int j=0;j<GuiClassObject.tacBack[i].length;j++)
			{
				if(GuiClassObject.tacBack[i][j]=='n')
				{
					gameState=0;
					break;
				}
			}
		}
		if(gameState==0)
		{
		//for rows and columns
			// for(int i=0;i<GuiClassObject.tacBack.length-1;i++)
			// {
			// 	for(int j=0;j<GuiClassObject.tacBack[i].length-1;j++)
			// 	{
			// 		if(GuiClassObject.tacBack[i][j]==GuiClassObject.tacBack[i][j+1])// && GuiClassObject.tacBack[i][j]!='n')
			// 		{
			// 			//rows
			// 			if((j+1)==GuiClassObject.tacBack[i].length-1)
			// 			{
			// 				symbol=GuiClassObject.tacBack[i][j];
			// 				for(int k=0;k<GuiClassObject.tacBack[i].length;k++)
			// 				{
			// 					GuiClassObject.tacButtons[i][k].setBackground(Color.RED);
			// 					// GuiCct.tacButtons[i][k].setOpaque(true);
			// 					GuiClassObject.tacButtons[i][k].setBorder(null);
			// 				}
			// 				break;
			// 			}
			// 			else continue;
			// 		}
			// 		else if(GuiClassObject.tacBack[i][j]==GuiClassObject.tacBack[i+1][j]) //&& GuiClassObject.tacBack[i][j]!='n')
			// 		{
			// 			//columns
			// 			if((i+1)==GuiClassObject.tacBack.length-1)
			// 			{
			// 				symbol=GuiClassObject.tacBack[i][j];
			// 				for(int k=0;k<GuiClassObject.tacBack[i].length;k++)
			// 				{
			// 					GuiClassObject.tacButtons[k][j].setBackground(Color.RED);
			// 					// GsObject.tacButtons[k][j].setOpaque(true);
			// 					GuiClassObject.tacButtons[k][j].setBorder(null);
			// 				}
			// 				break;
			// 			}
			// 			else continue;
			// 		}
			// 		else if(i==j)
			// 		{
			// 			//main diagonal
			// 			if(GuiClassObject.tacBack[i][j]==GuiClassObject.tacBack[i+1][j+1])// && GuiClassObject.tacBack[i][j]!='n')
			// 			{
			// 				if((i+1)==GuiClassObject.tacBack.length-1)
			// 				{
			// 					symbol=GuiClassObject.tacBack[i][j];
			// 					for(int k=0,m=0;k<GuiClassObject.tacBack.length;k++,m++)
			// 					{
			// 						GuiClassObject.tacButtons[k][m].setBackground(Color.RED);
			// 						// GuiClject.tacButtons[k][m].setOpaque(true);
			// 						GuiClassObject.tacButtons[k][m].setBorder(null);
			// 					}
			// 					break;
			// 				}
			// 				else continue;
			// 			}
			// 		}
			// 	}
			// }

			//Rows

			for(int i=0;i<GuiClassObject.tacBack.length;i++)
			{
				for(int j=0;j<GuiClassObject.tacBack.length-1;j++)
				{
					int comparingTacs=Character.compare(GuiClassObject.tacBack[i][j],GuiClassObject.tacBack[i][j+1]);
					int comparingTacsWithDefault=Character.compare(GuiClassObject.tacBack[i][j],'n');
					//int comparingTacsWithDefault2=Character.compare(GuiClassObject.tacBack[i][j+1],'n');
					if(comparingTacs==0 && comparingTacsWithDefault!=0 )//&& comparingTacsWithDefault2!=0)
					{
						System.out.println("Working");
						if((j+1)==GuiClassObject.tacBack[i].length-1)
						{
							symbol=GuiClassObject.tacBack[i][j];
							for(int k=0;k<GuiClassObject.tacBack[i].length;k++)
							{
								GuiClassObject.tacButtons[i][k].setBackground(Color.RED);
								//GuiClassObject.tacButtons[i][k].setOpaque(true);
								//GuiClassObject.tacButtons[i][k].setBorder(null);
							}
							break;
						}
						else continue;
					}
					else break;
				}
				System.out.println("Outoftheblock");
			}

			//columns
			for(int j=0;j<GuiClassObject.tacBack.length;j++)
			{
				for(int i=0;i<GuiClassObject.tacBack.length-1;i++)
				{
					int comparingTacs=Character.compare(GuiClassObject.tacBack[i][j],GuiClassObject.tacBack[i+1][j]);
					int comparingTacsWithDefault=Character.compare(GuiClassObject.tacBack[i][j],'n');
					//int comparingTacsWithDefault2=Character.compare(GuiClassObject.tacBack[i][j+1],'n');
					if(comparingTacs==0 && comparingTacsWithDefault!=0 )//&& comparingTacsWithDefault2!=0)
					{
						System.out.println("Working");
						if((i+1)==GuiClassObject.tacBack[i].length-1)
						{
							symbol=GuiClassObject.tacBack[i][j];
							for(int k=0;k<GuiClassObject.tacBack[i].length;k++)
							{
								GuiClassObject.tacButtons[k][j].setBackground(Color.RED);
								//GuiClassObject.tacButtons[i][k].setOpaque(true);
								//GuiClassObject.tacButtons[i][k].setBorder(null);
							}
							break;
						}
						else continue;
					}
					else break;
				}
				System.out.println("Outoftheblock");
			}

			//mainDiagonal
			for(int i=0,j=0;i<GuiClassObject.tacBack.length-1;i++,j++)
			{
				int comparingTacs=Character.compare(GuiClassObject.tacBack[i][j],GuiClassObject.tacBack[i+1][j+1]);
				int comparingTacsWithDefault=Character.compare(GuiClassObject.tacBack[i][j],'n');
				//int comparingTacsWithDefault2=Character.compare(GuiClassObject.tacBack[i][j+1],'n');
				if(comparingTacs==0 && comparingTacsWithDefault!=0 )//&& comparingTacsWithDefault2!=0)
				{
					
					System.out.println("Working");
					if((j+1)==GuiClassObject.tacBack[i].length-1)
					{
						symbol=GuiClassObject.tacBack[i][j];
						for(int k=0,l=0;k<GuiClassObject.tacBack[i].length;k++,l++)
						{
							GuiClassObject.tacButtons[l][k].setBackground(Color.RED);
							//GuiClassObject.tacButtons[i][k].setOpaque(true);
							//GuiClassObject.tacButtons[i][k].setBorder(null);
						}
						break;
					}
					else continue;
				}
				//System.out.println("Outoftheblock");
				else break;
			}

			//secondaryDiagonal
			for(int i=0,j=2;i<GuiClassObject.tacBack.length-1;i++,j--)
			{
				int comparingTacs=Character.compare(GuiClassObject.tacBack[i][j],GuiClassObject.tacBack[i+1][j-1]);
				int comparingTacsWithDefault=Character.compare(GuiClassObject.tacBack[i][j],'n');
				//int comparingTacsWithDefault2=Character.compare(GuiClassObject.tacBack[i][j+1],'n');
				if(comparingTacs==0 && comparingTacsWithDefault!=0 )//&& comparingTacsWithDefault2!=0)
				{
					
					System.out.println("Working");
					if((j+1)==GuiClassObject.tacBack[i].length-1)
					{
						symbol=GuiClassObject.tacBack[i][j];
						for(int k=0,l=2;k<GuiClassObject.tacBack[i].length;k++,l--)
						{
							GuiClassObject.tacButtons[l][k].setBackground(Color.RED);
							//GuiClassObject.tacButtons[i][k].setOpaque(true);
							//GuiClassObject.tacButtons[i][k].setBorder(null);
						}
						break;
					}
					else continue;
				}
				//System.out.println("Outoftheblock");
				else break;
			}
		}
		else gameState=3;
		if(gameState!=3)
		{
			System.out.println(symbol);
			int comparingSymbol=Character.compare(symbol,'t');
			if(comparingSymbol==0) gameState=0;
			else
			{
				int comparingSymbolO=Character.compare(symbol,'O');
				//int comparingSymbolX=Character.compare(symbol,'X');
				if(comparingSymbolO==0) gameState=1;
				else gameState=2;
			}
		}
		System.out.println(gameState);
		
		return gameState;
	}

	public void computersGame(int x,int y)
	{
		if(turn==1)
		{
			if(Character.compare(GuiClassObject.tacBack[1][1],'n')==0)
			{
				GuiClassObject.tacBack[1][1]='X';
				GuiClassObject.tacButtons[1][1].setText("X");
				GuiClassObject.tacButtons[1][1].setEnabled(false);
			}
			else if(Character.compare(GuiClassObject.tacBack[0][0],'n')==0)
			{
				GuiClassObject.tacBack[0][0]='X';
				GuiClassObject.tacButtons[0][0].setText("X");
				GuiClassObject.tacButtons[0][0].setEnabled(false);
			}
		}
		if(turn==2)
		{
			if(Character.compare(GuiClassObject.tacBack[1][1],'X')==0)
			{
				if(y==0)
				{
					if(this.y==0)
					{
						for(int i=0;i<GuiClassObject.tacBack.length;i++)
						{
							if(Character.compare(GuiClassObject.tacBack[i][0],'n')==0)
							{
								GuiClassObject.tacBack[i][0]='X';
								GuiClassObject.tacButtons[i][0].setText("X");
								GuiClassObject.tacButtons[i][0].setEnabled(false);
								break;
							}
						}
					}
					else
					{
						for(int j=0;j<GuiClassObject.tacBack.length;j++)
						{
							if(Character.compare(GuiClassObject.tacBack[this.x][j],'n')==0)
							{
								GuiClassObject.tacBack[this.x][j]='X';
								GuiClassObject.tacButtons[this.x][j].setText("X");
								GuiClassObject.tacButtons[this.x][j].setEnabled(false);
								break;
							}
						}
					}
				}
				else if (y==2)
				{
					if(this.y==2)
					{
						for(int i=0;i<GuiClassObject.tacBack.length;i++)
						{
							if(Character.compare(GuiClassObject.tacBack[i][2],'n')==0)
							{
								GuiClassObject.tacBack[i][2]='X';
								GuiClassObject.tacButtons[i][2].setText("X");
								GuiClassObject.tacButtons[i][2].setEnabled(false);
								break;
							}
						}
					}
					else 
					{
						for(int j=0;j<GuiClassObject.tacBack.length;j++)
						{
							if(Character.compare(GuiClassObject.tacBack[this.x][j],'n')==0)
							{
								GuiClassObject.tacBack[this.x][j]='X';
								GuiClassObject.tacButtons[this.x][j].setText("X");
								GuiClassObject.tacButtons[this.x][j].setEnabled(false);
								break;
							}
						}
					}
				}
				else if(x==0)
				{
					if(this.x==0)
					{
						for(int i=0;i<GuiClassObject.tacBack.length;i++)
						{
							if(Character.compare(GuiClassObject.tacBack[0][i],'n')==0)
							{
								GuiClassObject.tacBack[0][i]='X';
								GuiClassObject.tacButtons[0][i].setText("X");
								GuiClassObject.tacButtons[0][i].setEnabled(false);
								break;
							}
						}
					}
					else
					{
						for(int j=0;j<GuiClassObject.tacBack.length;j++)
						{
							if(Character.compare(GuiClassObject.tacBack[j][this.y],'n')==0)
							{
								GuiClassObject.tacBack[j][this.y]='X';
								GuiClassObject.tacButtons[j][this.y].setText("X");
								GuiClassObject.tacButtons[j][this.y].setEnabled(false);
								break;
							}
						}
					}
				}
				else if (x==2)
				{
					if(this.x==2)
					{
						for(int i=0;i<GuiClassObject.tacBack.length;i++)
						{
							if(Character.compare(GuiClassObject.tacBack[2][i],'n')==0)
							{
								GuiClassObject.tacBack[2][i]='X';
								GuiClassObject.tacButtons[2][i].setText("X");
								GuiClassObject.tacButtons[2][i].setEnabled(false);
								break;
							}
						}
					}
					else
					{
						for(int j=0;j<GuiClassObject.tacBack.length;j++)
						{
							if(Character.compare(GuiClassObject.tacBack[j][this.y],'n')==0)
							{
								GuiClassObject.tacBack[j][this.y]='X';
								GuiClassObject.tacButtons[j][this.y].setText("X");
								GuiClassObject.tacButtons[j][this.y].setEnabled(false);
								break;
							}
						}
					}
				}
			}	
			else
			{
				if(x+y==2)
				{
					GuiClassObject.tacBack[y][x]='X';
					GuiClassObject.tacButtons[y][x].setText("X");
					GuiClassObject.tacButtons[y][x].setEnabled(false);
				}
				else if(x==2 && y==2)
				{
					GuiClassObject.tacBack[0][2]='X';
					GuiClassObject.tacButtons[0][2].setText("X");
					GuiClassObject.tacButtons[0][2].setEnabled(false);
				}
				else if(x==1)
				{
					for(int i=0;i<GuiClassObject.tacBack.length;i++)
					{
						if(Character.compare(GuiClassObject.tacBack[1][i],'n')==0)
							{
								GuiClassObject.tacBack[1][i]='X';
								GuiClassObject.tacButtons[1][i].setText("X");
								GuiClassObject.tacButtons[1][i].setEnabled(false);
								break;
							}
					}
				}
				else if(y==1)
				{
					for(int i=0;i<GuiClassObject.tacBack.length;i++)
					{
						if(Character.compare(GuiClassObject.tacBack[i][1],'n')==0)
							{
								GuiClassObject.tacBack[i][1]='X';
								GuiClassObject.tacButtons[i][1].setText("X");
								GuiClassObject.tacButtons[i][1].setEnabled(false);
								break;
							}
					}
				}

			}
		}
		if(turn==3)
		{
			int count=0;
			//rows
			for(int i=0;i<GuiClassObject.tacBack.length;i++)
			{
				count=0;
				for(int j=0;j<GuiClassObject.tacBack.length;j++)
				{
					int comparingTacs=Character.compare(GuiClassObject.tacBack[i][j],'X');
					//int comparingTacsWithDefault=Character.compare(GuiClassObject.tacBack[i][j],'n');
					//int comparingTacsWithDefault2=Character.compare(GuiClassObject.tacBack[i][j+1],'n');
					if(comparingTacs==0 )//&& comparingTacsWithDefault2!=0)
					{
						count++;
						System.out.println("Working");
						if(count==2)
						{
							///symbol=GuiClassObject.tacBack[i][j];
							for(int k=0;k<GuiClassObject.tacBack[i].length;k++)
							{
								//GuiClassObject.tacButtons[i][k].setBackground(Color.RED);
								//GuiClassObject.tacButtons[i][k].setOpaque(true);
								//GuiClassObject.tacButtons[i][k].setBorder(null);
								if(Character.compare(GuiClassObject.tacBack[i][k],'n')==0)
								{
									GuiClassObject.tacBack[i][k]='X';
									GuiClassObject.tacButtons[i][k].setText("X");
									GuiClassObject.tacButtons[i][k].setEnabled(false);
									return;
								}
								else count = 0;
							}
							break;
						}
						else continue;
					}
					else continue;
				}
				System.out.println("Outoftheblock");
			}
			//columns
			for(int j=0;j<GuiClassObject.tacBack.length;j++)
			{
				count=0;
				for(int i=0;i<GuiClassObject.tacBack.length;i++)
				{
					int comparingTacs=Character.compare(GuiClassObject.tacBack[i][j],'X');
					//int comparingTacsWithDefault=Character.compare(GuiClassObject.tacBack[i][j],'n');
					//int comparingTacsWithDefault2=Character.compare(GuiClassObject.tacBack[i][j+1],'n');
					if(comparingTacs==0 )//&& comparingTacsWithDefault2!=0)
					{
						count++;;
						System.out.println("Working");
						if(count==2)
						{
							//symbol=GuiClassObject.tacBack[i][j];
							for(int k=0;k<GuiClassObject.tacBack[i].length;k++)
							{
								//GuiClassObject.tacButtons[k][j].setBackground(Color.RED);
								//GuiClassObject.tacButtons[i][k].setOpaque(true);
								//GuiClassObject.tacButtons[i][k].setBorder(null);
								if(Character.compare(GuiClassObject.tacBack[k][j],'n')==0)
								{
									GuiClassObject.tacBack[k][j]='X';
									GuiClassObject.tacButtons[k][j].setText("X");
									GuiClassObject.tacButtons[k][j].setEnabled(false);
									return;
								}
								else count = 0;
							}
							break;
						}
						else continue;
					}
					else continue;
				}
				System.out.println("Outoftheblock");
			}
			//mainDiagonal
			count=0;
			for(int i=0,j=0;i<GuiClassObject.tacBack.length;i++,j++)
			{
				int comparingTacs=Character.compare(GuiClassObject.tacBack[i][j],'X');
				//int comparingTacsWithDefault=Character.compare(GuiClassObject.tacBack[i][j],'n');
				//int comparingTacsWithDefault2=Character.compare(GuiClassObject.tacBack[i][j+1],'n');
				if(comparingTacs==0 )//&& comparingTacsWithDefault2!=0)
				{
					count++;
					System.out.println("Working");
					if(count==2)
					{
						//symbol=GuiClassObject.tacBack[i][j];
						for(int k=0,l=0;k<GuiClassObject.tacBack[i].length;k++,l++)
						{
							//GuiClassObject.tacButtons[l][k].setBackground(Color.RED);
							//GuiClassObject.tacButtons[i][k].setOpaque(true);
							//GuiClassObject.tacButtons[i][k].setBorder(null);
							if(Character.compare(GuiClassObject.tacBack[k][l],'n')==0)
								{
									GuiClassObject.tacBack[k][l]='X';
									GuiClassObject.tacButtons[k][l].setText("X");
									GuiClassObject.tacButtons[k][l].setEnabled(false);
									return;
								}
								else count = 0;
						}
						break;
					}
					else continue;
				}
				//System.out.println("Outoftheblock");
				else continue;
			}
			//secondaryDiagonal
			count=0;
			for(int i=0,j=2;i<GuiClassObject.tacBack.length;i++,j--)
			{
				int comparingTacs=Character.compare(GuiClassObject.tacBack[i][j],'X');
				//int comparingTacsWithDefault=Character.compare(GuiClassObject.tacBack[i][j],'n');
				//int comparingTacsWithDefault2=Character.compare(GuiClassObject.tacBack[i][j+1],'n');
				if(comparingTacs==0)//&& comparingTacsWithDefault2!=0)
				{
					count++;
					System.out.println("Working");
					if(count==2)
					{
						//symbol=GuiClassObject.tacBack[i][j];
						for(int k=0,l=2;k<GuiClassObject.tacBack[i].length;k++,l--)
						{
							//GuiClassObject.tacButtons[l][k].setBackground(Color.RED);
							//GuiClassObject.tacButtons[i][k].setOpaque(true);
							//GuiClassObject.tacButtons[i][k].setBorder(null);
							if(Character.compare(GuiClassObject.tacBack[l][k],'n')==0)
								{
									GuiClassObject.tacBack[l][k]='X';
									GuiClassObject.tacButtons[l][k].setText("X");
									GuiClassObject.tacButtons[l][k].setEnabled(false);
									return;
								}
								else count = 0;
						}
						break;
					}
					else continue;
				}
				//System.out.println("Outoftheblock");
				else continue;
			}
			if(count!=2)
			{
				for(int i=0;i<GuiClassObject.tacBack.length;i++)
				{
					for(int j=0;j<GuiClassObject.tacBack[i].length;j++)
					{
						if(Character.compare(GuiClassObject.tacBack[i][j],'n')==0)
						{
							GuiClassObject.tacBack[i][j]='X';
							GuiClassObject.tacButtons[i][j].setText("X");
							GuiClassObject.tacButtons[i][j].setEnabled(false);
							return;
						}
					}
				}
			}
		}
		if(turn==4)
		{
			int count=0;
			//rows
			for(int i=0;i<GuiClassObject.tacBack.length;i++)
			{
				count=0;
				for(int j=0;j<GuiClassObject.tacBack.length;j++)
				{
					int comparingTacs=Character.compare(GuiClassObject.tacBack[i][j],'O');
					//int comparingTacsWithDefault=Character.compare(GuiClassObject.tacBack[i][j],'n');
					//int comparingTacsWithDefault2=Character.compare(GuiClassObject.tacBack[i][j+1],'n');
					if(comparingTacs==0 )//&& comparingTacsWithDefault2!=0)
					{
						count++;
						System.out.println("Working");
						if(count==2)
						{
							///symbol=GuiClassObject.tacBack[i][j];
							for(int k=0;k<GuiClassObject.tacBack[i].length;k++)
							{
								//GuiClassObject.tacButtons[i][k].setBackground(Color.RED);
								//GuiClassObject.tacButtons[i][k].setOpaque(true);
								//GuiClassObject.tacButtons[i][k].setBorder(null);
								if(Character.compare(GuiClassObject.tacBack[i][k],'n')==0)
								{
									GuiClassObject.tacBack[i][k]='X';
									GuiClassObject.tacButtons[i][k].setText("X");
									GuiClassObject.tacButtons[i][k].setEnabled(false);
									return;
								}
								else count = 0;
							}
							break;
						}
						else continue;
					}
					else continue;
				}
				System.out.println("Outoftheblock");
			}
			//columns
			for(int j=0;j<GuiClassObject.tacBack.length;j++)
			{
				count=0;
				for(int i=0;i<GuiClassObject.tacBack.length;i++)
				{
					int comparingTacs=Character.compare(GuiClassObject.tacBack[i][j],'O');
					//int comparingTacsWithDefault=Character.compare(GuiClassObject.tacBack[i][j],'n');
					//int comparingTacsWithDefault2=Character.compare(GuiClassObject.tacBack[i][j+1],'n');
					if(comparingTacs==0 )//&& comparingTacsWithDefault2!=0)
					{
						count++;;
						System.out.println("Working");
						if(count==2)
						{
							//symbol=GuiClassObject.tacBack[i][j];
							for(int k=0;k<GuiClassObject.tacBack[i].length;k++)
							{
								//GuiClassObject.tacButtons[k][j].setBackground(Color.RED);
								//GuiClassObject.tacButtons[i][k].setOpaque(true);
								//GuiClassObject.tacButtons[i][k].setBorder(null);
								if(Character.compare(GuiClassObject.tacBack[k][j],'n')==0)
								{
									GuiClassObject.tacBack[k][j]='X';
									GuiClassObject.tacButtons[k][j].setText("X");
									GuiClassObject.tacButtons[k][j].setEnabled(false);
									return;
								}
								else count = 0;
							}
							break;
						}
						else continue;
					}
					else continue;
				}
				System.out.println("Outoftheblock");
			}
			//mainDiagonal
			count=0;
			for(int i=0,j=0;i<GuiClassObject.tacBack.length;i++,j++)
			{
				int comparingTacs=Character.compare(GuiClassObject.tacBack[i][j],'O');
				//int comparingTacsWithDefault=Character.compare(GuiClassObject.tacBack[i][j],'n');
				//int comparingTacsWithDefault2=Character.compare(GuiClassObject.tacBack[i][j+1],'n');
				if(comparingTacs==0 )//&& comparingTacsWithDefault2!=0)
				{
					count++;
					System.out.println("Working");
					if(count==2)
					{
						//symbol=GuiClassObject.tacBack[i][j];
						for(int k=0,l=0;k<GuiClassObject.tacBack[i].length;k++,l++)
						{
							//GuiClassObject.tacButtons[l][k].setBackground(Color.RED);
							//GuiClassObject.tacButtons[i][k].setOpaque(true);
							//GuiClassObject.tacButtons[i][k].setBorder(null);
							if(Character.compare(GuiClassObject.tacBack[k][l],'n')==0)
								{
									GuiClassObject.tacBack[k][l]='X';
									GuiClassObject.tacButtons[k][l].setText("X");
									GuiClassObject.tacButtons[k][l].setEnabled(false);
									return;
								}
								else count = 0;
						}
						break;
					}
					else continue;
				}
				//System.out.println("Outoftheblock");
				else continue;
			}
			//secondaryDiagonal
			count=0;
			for(int i=0,j=2;i<GuiClassObject.tacBack.length;i++,j--)
			{
				int comparingTacs=Character.compare(GuiClassObject.tacBack[i][j],'O');
				//int comparingTacsWithDefault=Character.compare(GuiClassObject.tacBack[i][j],'n');
				//int comparingTacsWithDefault2=Character.compare(GuiClassObject.tacBack[i][j+1],'n');
				if(comparingTacs==0)//&& comparingTacsWithDefault2!=0)
				{
					count++;
					System.out.println("Working");
					if(count==2)
					{
						//symbol=GuiClassObject.tacBack[i][j];
						for(int k=0,l=2;k<GuiClassObject.tacBack[i].length;k++,l--)
						{
							//GuiClassObject.tacButtons[l][k].setBackground(Color.RED);
							//GuiClassObject.tacButtons[i][k].setOpaque(true);
							//GuiClassObject.tacButtons[i][k].setBorder(null);
							if(Character.compare(GuiClassObject.tacBack[l][k],'n')==0)
								{
									GuiClassObject.tacBack[l][k]='X';
									GuiClassObject.tacButtons[l][k].setText("X");
									GuiClassObject.tacButtons[l][k].setEnabled(false);
									return;
								}
								else count = 0;
						}
						break;
					}
					else continue;
				}
				//System.out.println("Outoftheblock");
				else continue;
			}
			if(count!=2)
			{
				for(int i=0;i<GuiClassObject.tacBack.length;i++)
				{
					for(int j=0;j<GuiClassObject.tacBack[i].length;j++)
					{
						if(Character.compare(GuiClassObject.tacBack[i][j],'n')==0)
						{
							GuiClassObject.tacBack[i][j]='X';
							GuiClassObject.tacButtons[i][j].setText("X");
							GuiClassObject.tacButtons[i][j].setEnabled(false);
							return;
						}
					}
				}
			}
		}
		this.x=x;
		this.y=y;
	}

	public void actionPerformed(ActionEvent e)
	{
		//System.out.println("Working");
		//System.out.println(e.getActionCommand());
		if(e.getSource().equals(GuiClassObject.startButton)) 
		//if(e.getActionCommand().equals("Start the Game."))
		{
			System.out.println("Working");
			flag=0;
			turn=0;
			for(int i=0;i<GuiClassObject.tacButtons.length;i++)
			{
				for(int j=0;j<GuiClassObject.tacButtons[i].length;j++)
					GuiClassObject.tacButtons[i][j].setEnabled(true);
			}
			GuiClassObject.startButton.setEnabled(false);
			for(int i=0;i<GuiClassObject.playerChangingButton.length;i++)
				GuiClassObject.playerChangingButton[i].setEnabled(false);
		}
		// if(e.getSource().equals(GuiClassObject.jp))
		// {
		// 	System.out.println("Working");
		// 	Object o = e.getSource();
		// 	for(int i=0;i<GuiClassObject.tacButtons.length;i++)
		// 	{
		// 		for(int j=0;j<GuiClassObject.tacButtons[i].length;j++)
		// 		{
		// 			if(o==GuiClassObject.tacButtons[i][j])
		// 			{
		// 				GuiClassObject.tacButtons[i][j].setText("Its Working");
		// 				System.out.println("Working");
		// 			}
		// 		}
		// 	}
		if(!GuiClassObject.startButton.isEnabled())
		{
			int gameState=-1;
			if(GuiClassObject.gamingPlayers==0)
			{
				for(int i=0;i<GuiClassObject.tacButtons.length;i++)
				{
					for(int j=0;j<GuiClassObject.tacButtons[i].length;j++)
					{
						if(e.getSource()==GuiClassObject.tacButtons[i][j])
						{
							//GuiClassObject.tacButtons[i][j].setText("Its Working");
							//System.out.println("Working");
							if(flag==0)
							{
								GuiClassObject.tacButtons[i][j].setText("O");
								GuiClassObject.tacButtons[i][j].setEnabled(false);
								GuiClassObject.tacBack[i][j] = 'O';
								gameState=gameStatus();
								flag=1;
							}
							else if (flag==1)
							{
								GuiClassObject.tacButtons[i][j].setText("X");
								GuiClassObject.tacButtons[i][j].setEnabled(false);
								GuiClassObject.tacBack[i][j] = 'X';
								gameState=gameStatus();	
								flag=0;
							}
							if(gameState!=0)
							{
								//gameover
								if(gameState==1)
								{
									//player1
									JOptionPane.showMessageDialog(GuiClassObject.jf,"Congratulations, Player 1 Won the game.\n");
								}
								if(gameState==2)
								{
									//player2
									JOptionPane.showMessageDialog(GuiClassObject.jf,"Congratulations, Player 2 Won the game.\n");
								}
								if(gameState==3)
								{
									//Draw
									JOptionPane.showMessageDialog(GuiClassObject.jf,"It's a draw.\n");
								}
								GuiClassObject.startButton.setText("<HTML>Start a <FONT COLOR=RED><B>new</B></FONT> Game.</HTML>");
								GuiClassObject.startButton.setEnabled(true);
								for(int k=0;k<GuiClassObject.playerChangingButton.length;k++)
									GuiClassObject.playerChangingButton[k].setEnabled(true);

								for(int k=0;k<GuiClassObject.tacBack.length;k++)
								{
									for(int l=0;l<GuiClassObject.tacBack[k].length;l++)
										GuiClassObject.tacBack[k][l] = 'n';
								}
								for(int k=0;k<GuiClassObject.tacButtons.length;k++)
								{
									for(int l=0;l<GuiClassObject.tacButtons[k].length;l++)
									{
										GuiClassObject.tacButtons[k][l].setEnabled(false);
										GuiClassObject.tacButtons[k][l].setText(null);
										GuiClassObject.tacButtons[k][l].setBackground(null);
									}
								}
							}
							else continue;
						}
					}
				}

			}
			if(GuiClassObject.gamingPlayers==1)
			{
				for(int i=0;i<GuiClassObject.tacButtons.length;i++)
				{
					for(int j=0;j<GuiClassObject.tacButtons[i].length;j++)
					{
						if(e.getSource().equals(GuiClassObject.tacButtons[i][j]))
						{
							GuiClassObject.tacButtons[i][j].setText("O");
							GuiClassObject.tacButtons[i][j].setEnabled(false);
							GuiClassObject.tacBack[i][j]='O';
							turn++;
							computersGame(i,j);
							System.out.println("Turn-"+turn);
							gameState=gameStatus();
							if(gameState!=0)
							{
								//gameover
								if(gameState==1)
								{
									//player1
									JOptionPane.showMessageDialog(GuiClassObject.jf,"Congratulations, You Won the game.\n");
								}
								if(gameState==2)
								{
									//player2
									JOptionPane.showMessageDialog(GuiClassObject.jf,"Sorry, Comupter Won the game.\n");
								}
								if(gameState==3)
								{
									//Draw
									JOptionPane.showMessageDialog(GuiClassObject.jf,"It's a draw.\n");
								}
								GuiClassObject.startButton.setText("<HTML>Start a <FONT COLOR=RED><B>new</B></FONT> Game with the Computer.</HTML>");
								GuiClassObject.startButton.setEnabled(true);
								for(int k=0;k<GuiClassObject.playerChangingButton.length;k++)
									GuiClassObject.playerChangingButton[k].setEnabled(true);

								for(int k=0;k<GuiClassObject.tacBack.length;k++)
								{
									for(int l=0;l<GuiClassObject.tacBack[k].length;l++)
										GuiClassObject.tacBack[k][l] = 'n';
								}
								for(int k=0;k<GuiClassObject.tacButtons.length;k++)
								{
									for(int l=0;l<GuiClassObject.tacButtons[k].length;l++)
									{
										GuiClassObject.tacButtons[k][l].setEnabled(false);
										GuiClassObject.tacButtons[k][l].setText(null);
										GuiClassObject.tacButtons[k][l].setBackground(null);
									}
								}
							}
						}
					}
				}
			}
		}
		for(int i=0;i<GuiClassObject.playerChangingButton.length;i++)
		{
			if(e.getSource().equals(GuiClassObject.playerChangingButton[i]))
			{
				GuiClassObject.cl.next(GuiClassObject.jp2);
				if(e.getActionCommand().equals("<HTML>Click to Play with <B>Computer</B></HTML>."))
				{
					GuiClassObject.startButton.setText("<HTML> Start the game with <B>Computer</B></HTML>");
					GuiClassObject.gamingPlayers=1;
				}
				if(e.getActionCommand().equals("<HTML>Click to play <B>TWO Player Game</B></HTML>."))
				{
					GuiClassObject.startButton.setText("Start the Game.");
					GuiClassObject.gamingPlayers=0;
				}
			}
		}
	}
}