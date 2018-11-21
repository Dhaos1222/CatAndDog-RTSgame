package esk.dhaos.listener;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import esk.dhaos.model.Cat;
import esk.dhaos.model.Dog;
import esk.dhaos.view.BaseFrame;

public class FrameKeyListener implements KeyListener{

	public BaseFrame baseFrame;
	
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		switch (e.getKeyCode()) {
        case KeyEvent.VK_UP:
        	for(int i = 0;i<this.baseFrame.myPanel.Cats.size();i++)
        	    this.baseFrame.myPanel.Cats.get(i).up = true;  
            break;  
        case KeyEvent.VK_DOWN:
        	for(int i = 0;i<this.baseFrame.myPanel.Cats.size();i++)
        	    this.baseFrame.myPanel.Cats.get(i).down = true;  
            break;  
        case KeyEvent.VK_LEFT:
        	for(int i = 0;i<this.baseFrame.myPanel.Cats.size();i++)
        	    this.baseFrame.myPanel.Cats.get(i).left = true;  
            break;  
        case KeyEvent.VK_RIGHT:
        	for(int i = 0;i<this.baseFrame.myPanel.Cats.size();i++)
        	    this.baseFrame.myPanel.Cats.get(i).right = true;  
            break;
		case KeyEvent.VK_F1:
			Cat cat = new Cat(this.baseFrame.myPanel);
			cat.start();
			this.baseFrame.myPanel.Cats.add(cat);
			break;
		case KeyEvent.VK_F2:
			Dog dog = new Dog(this.baseFrame.myPanel);
			dog.start();
			this.baseFrame.myPanel.Dogs.add(dog);
			break;
        default:  
            break;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		switch (e.getKeyCode()) {
        case KeyEvent.VK_UP:  
        	for(int i = 0;i<this.baseFrame.myPanel.Cats.size();i++)
        	    this.baseFrame.myPanel.Cats.get(i).up = false;  
            break;  
        case KeyEvent.VK_DOWN:  
        	for(int i = 0;i<this.baseFrame.myPanel.Cats.size();i++)
        	    this.baseFrame.myPanel.Cats.get(i).down = false;  
            break;  
        case KeyEvent.VK_LEFT: 
        	for(int i = 0;i<this.baseFrame.myPanel.Cats.size();i++)
        	    this.baseFrame.myPanel.Cats.get(i).left = false;  
            break;  
        case KeyEvent.VK_RIGHT:  
        	for(int i = 0;i<this.baseFrame.myPanel.Cats.size();i++)
        	    this.baseFrame.myPanel.Cats.get(i).right = false;  
            break;  
        default:  
            break;
		}
	}

}
