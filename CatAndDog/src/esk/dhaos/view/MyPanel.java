package esk.dhaos.view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.ArrayList;

import javax.swing.JPanel;

import esk.dhaos.model.Cat;
import esk.dhaos.model.Dog;
import esk.dhaos.thread.DrawableThread;

public class MyPanel extends JPanel{
	
	//��ű���ͼƬ
	public Image bgImage;
	//��Ϸ����ͼƬ
	public Image endImage;
	
	public int timer=0;
	
	public int top=0;
	
	public ArrayList<Cat> Cats=new ArrayList<Cat>();
	public ArrayList<Dog> Dogs=new ArrayList<Dog>();
	public DrawableThread drawableThread;
	
	public boolean isSelect = false;
	public int sx;
	public int sy;
	public int dx;
	public int dy;
	
	public MyPanel() 
	{
		bgImage = Toolkit.getDefaultToolkit().getImage(MyPanel.class.getResource("/images/bg.png"));
		//�����߳�
		this.drawableThread=new DrawableThread(this);
		//�����߳�
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
	}
	
	public void selectUnit(Graphics g, int x, int y, int width, int height)
	{
		g.setColor(Color.WHITE);
		g.drawRect(x,y,width,height);
	}
}
