package esk.dhaos.view;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.ArrayList;

import javax.swing.JPanel;

import esk.dhaos.model.Cat;
import esk.dhaos.model.Dog;
import esk.dhaos.thread.DrawableThread;

public class MyPanel extends JPanel{
	
	//存放背景图片
	public Image bgImage;
	//游戏结束图片
	public Image endImage;
	
	public int timer=0;
	
	public int top=0;
	
	public ArrayList<Cat> Cats=new ArrayList<Cat>();
	public ArrayList<Dog> Dogs=new ArrayList<Dog>();
	public DrawableThread drawableThread;
	
	
	public MyPanel() 
	{
		bgImage = Toolkit.getDefaultToolkit().getImage(MyPanel.class.getResource("/images/bg.png"));
		//创建线程
		this.drawableThread=new DrawableThread(this);
		//启动线程
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
			//this.Dogs.get(i).drawSelf(g);
		}
		
	}
}
