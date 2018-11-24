package esk.dhaos.listener;


import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import javax.swing.event.MouseInputListener;

import esk.dhaos.model.Cat;
import esk.dhaos.model.Dog;
import esk.dhaos.view.BaseFrame;

public class FrameMouseListener implements MouseInputListener{

	public BaseFrame baseFrame;
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub

		if(e.getButton()==MouseEvent.BUTTON1)
		{
			for(int i = 0;i<this.baseFrame.myPanel.Cats.size();i++)
			{
				Cat cat = this.baseFrame.myPanel.Cats.get(i);
				if(e.getX()>(cat.x+10)&&e.getX()<(cat.x+cat.width-5)&&e.getY()>(cat.y+30)&&e.getY()<(cat.y+cat.height+20))
				{
					cat.isChoose = true;
				}
			}
		}
		else if(e.getButton()==MouseEvent.BUTTON3)
		{
			for(int i = 0;i<this.baseFrame.myPanel.Cats.size();i++)
			{
				Cat cat = this.baseFrame.myPanel.Cats.get(i);
				if(cat.isChoose)
				{
					this.baseFrame.myPanel.isMoving = true;
					cat.desX = e.getX()-28;
					cat.desY = e.getY()-55;
//					for(int j = 0;j<this.baseFrame.myPanel.Dogs.size();j++)
//					{
//						Dog dog = this.baseFrame.myPanel.Dogs.get(j);
//						if(e.getX()>(dog.x+10)&&e.getX()<(dog.x+dog.width-5)&&e.getY()>(dog.y+30)&&e.getY()<(dog.y+dog.height+20))
//						{
//							cat.isAttacking = true;
//						}
						
//						if(Math.sqrt(Math.abs((cat.x-dog.x)*(cat.x-dog.x))+Math.abs((cat.y-dog.y)*(cat.y-dog.y)))<50)
//							cat.isAttacking = true;
//					}
//					int xDis = e.getX()-28-cat.x;
//					int yDis = e.getY()-55-cat.y;		
				}
			}
		}

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub	
		this.baseFrame.myPanel.isMoving = false;
		this.baseFrame.myPanel.sx = e.getX()-5;
		this.baseFrame.myPanel.sy = e.getY()-30;
		this.baseFrame.myPanel.dx = this.baseFrame.myPanel.sx;
		this.baseFrame.myPanel.dy = this.baseFrame.myPanel.sy;
		System.out.println("clicked:"+this.baseFrame.myPanel.sx);
		System.out.println("clicked:"+this.baseFrame.myPanel.dy);

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		this.baseFrame.setCursor(null);
		for(int i = 0;i<this.baseFrame.myPanel.Cats.size();i++)
		{
			Cat cat = this.baseFrame.myPanel.Cats.get(i);
			if(cat.x>this.baseFrame.myPanel.sx-20&&cat.y>this.baseFrame.myPanel.sy-40&&cat.x<this.baseFrame.myPanel.dx&&cat.y<this.baseFrame.myPanel.dy-20)
			{
				cat.isChoose = true;
			}
		}
		this.baseFrame.myPanel.isSelect = false;
		this.baseFrame.myPanel.isMoving = false;
	}
	
	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		Cursor cu = new Cursor(Cursor.CROSSHAIR_CURSOR);
		this.baseFrame.setCursor(cu);
		this.baseFrame.myPanel.dx = e.getX()-5;
		this.baseFrame.myPanel.dy = e.getY()-30;
		System.out.println(this.baseFrame.myPanel.dx);
		System.out.println(this.baseFrame.myPanel.dy);
		this.baseFrame.myPanel.isSelect = true;
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		for(int i = 0;i<this.baseFrame.myPanel.Cats.size();i++)
		{
			Cat cat = this.baseFrame.myPanel.Cats.get(i);
			if(e.getX()>(cat.x+10)&&e.getX()<(cat.x+cat.width-5)&&e.getY()>(cat.y+30)&&e.getY()<(cat.y+cat.height+20))
			{
				Cursor cu = new Cursor(Cursor.HAND_CURSOR);
				this.baseFrame.setCursor(cu);
			}
			else
				this.baseFrame.setCursor(null);
		}
	}
}
