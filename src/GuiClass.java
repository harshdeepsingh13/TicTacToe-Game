

import java.awt.*;
import javax.swing.*;

public class GuiClass
{
	JFrame jf;
	JButton startButton;
	JButton playerChangingButton[] = new JButton[2];
	String playerChangingString[] = {"<HTML>Click to Play with <B>Computer</B></HTML>.","<HTML>Click to play <B>TWO Player Game</B></HTML>."};
	JButton tacButtons[][] = new JButton[3][3];
	//char tacBack[][] = new char[3][3];
	char tacBack[][]={{'n','n','n'},{'n','n','n'},{'n','n','n'}};
	JPanel jp,jp2;
	CardLayout cl;
	int gamingPlayers=0;
	GuiClass(String s)
	{
		ResponseClass responseObject = new ResponseClass(this);
		try
		{
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		}
		catch(Exception e) 
		{
			e.printStackTrace();
		}
		jf=new JFrame(s);
		//JOptionPane.showMessageDialog(jf,"Hey");
		cl= new CardLayout();
		jp2 = new JPanel();
		jp2.setLayout(cl);
		jf.setDefaultCloseOperation(jf.EXIT_ON_CLOSE);
		startButton = new JButton("Start the Game.");
		startButton.addActionListener(responseObject);
		jf.add(startButton,BorderLayout.NORTH);
		jp = new JPanel();
		jp.setLayout(new GridLayout(3,3,0,0));
		for(int i=0;i<tacButtons.length;i++)
		{
			for(int j=0;j<tacButtons[i].length;j++)
			{
				tacButtons[i][j] = new JButton();
				tacButtons[i][j].setEnabled(false);
				tacButtons[i][j].addActionListener(responseObject);
				tacButtons[i][j].setFont(new Font(Font.SANS_SERIF,Font.PLAIN,30));
				jp.add(tacButtons[i][j]);
			}
		}
		jf.add(jp2,BorderLayout.SOUTH);
		for(int i=0;i<playerChangingButton.length;i++)
		{
			playerChangingButton[i] = new JButton(playerChangingString[i]);
			playerChangingButton[i].addActionListener(responseObject);
			jp2.add(playerChangingButton[i]);
		}
		jp.setPreferredSize(new Dimension(285,285));
		jf.add(jp,BorderLayout.CENTER);
		//jf.pack();
		jf.pack();
		//jf.setSize(400,400);
		//jf.setLayout(bl);
		jf.setResizable(false);

		GraphicsConfiguration gc = jf.getGraphicsConfiguration();
		Rectangle bounds = gc.getBounds();
		Dimension size = jf.getPreferredSize();
		jf.setLocation((int) ((bounds.width / 2) - (size.getWidth() / 2)),(int) ((bounds.height / 2) - (size.getHeight() / 2))); 

		jf.setVisible(true);
	}
	public static void main(String... args)
	{
		new GuiClass("TicTacToe Game.");
		System.out.println();

	}
}

