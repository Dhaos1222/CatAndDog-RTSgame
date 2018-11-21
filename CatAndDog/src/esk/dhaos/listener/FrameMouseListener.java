package esk.dhaos.listener;

import java.awt.Cursor;
import java.awt.event.MouseEvent;
import javax.swing.event.MouseInputListener;

import esk.dhaos.model.Cat;
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
				else
					cat.isChoose = false;
			}
		}
		else if(e.getButton()==MouseEvent.BUTTON3)
		{
			for(int i = 0;i<this.baseFrame.myPanel.Cats.size();i++)
			{
				Cat cat = this.baseFrame.myPanel.Cats.get(i);
				if(cat.isChoose)
				{
					int xDis = e.getX()-28-cat.x;
					int yDis = e.getY()-55-cat.y;
					while(xDis!=0&&yDis!=0)
					{
						cat.x += xDis;
						cat.y += yDis;
					}
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
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		this.baseFrame.setCursor(null);
	}
	
	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		Cursor cu = new Cursor(Cursor.CROSSHAIR_CURSOR);
		this.baseFrame.setCursor(cu);
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
