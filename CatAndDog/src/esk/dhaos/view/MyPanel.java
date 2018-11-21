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
	
	//��ű���ͼƬ
	public Image bgImage;
	//��Ϸ����ͼƬ
	public Image endImage;
	
	public int timer=0;
	
	public int top=0;
	
	public ArrayList<Cat> Cats=new ArrayList<Cat>();
	public ArrayList<Dog> Dogs=new ArrayList<Dog>();
	public DrawableThread drawableThread;
	
	
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
			//this.Dogs.get(i).drawSelf(g);
		}
		
	}
}
