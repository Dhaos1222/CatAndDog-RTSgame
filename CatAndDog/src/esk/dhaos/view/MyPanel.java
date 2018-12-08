package esk.dhaos.view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JPanel;

import esk.dhaos.model.Cat;
import esk.dhaos.model.Dog;
import esk.dhaos.thread.DrawableThread;

public class MyPanel extends JPanel{
	

	public Image bgImage;

	public Image endImage;
	
	public Image move;
	
	public int timer=0;
	
	public int top=0;
	
	public Vector<Cat> Cats=new Vector<Cat>();
	public Vector<Dog> Dogs=new Vector<Dog>();
	public DrawableThread drawableThread;
	
	public boolean isSelect = false;
	public boolean isMoving = false;
	public int sx;
	public int sy;
	public int dx;
	public int dy;
	
	public MyPanel() 
	{
		bgImage = Toolkit.getDefaultToolkit().getImage(MyPanel.class.getResource("/images/bg.png"));

		move = Toolkit.getDefaultToolkit().getImage(MyPanel.class.getResource("/images/move.png"));
		
		this.drawableThread=new DrawableThread(this);

		this.drawableThread.start();
		
	}
	
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		g.drawImage(this.bgImage, 0,top,this.bgImage.getWidth(this) , this.bgImage.getHeight(this), null);
		
		timer++;
		
		for(int i = 0;i<Cats.size();i++)
		{
			this.Cats.get(i).drawSelf(g);
		}
		
		for(int i = 0;i<Dogs.size();i++)
		{
			this.Dogs.get(i).drawSelf(g);
		}
		if(isSelect)
		    selectUnit(g,sx,sy,dx-sx,dy-sy);
		if(isMoving)
			move(g,dx,dy,35,35);
	}
	//区域选择
	public void selectUnit(Graphics g, int x, int y, int width, int height)
	{
		g.setColor(Color.WHITE);
		g.drawRect(x,y,width,height);
	}
	//移动光标
	public void move(Graphics g, int x, int y, int width, int height)
	{
		g.drawImage(this.move,x-15,y-20,35,35,null);
	}
}
