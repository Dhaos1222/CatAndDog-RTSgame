package esk.dhaos.model;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import esk.dhaos.view.BaseFrame;
import esk.dhaos.view.MyPanel;

public class Cat extends Role{
	
	public Cat(MyPanel myPanel) {
		
		super(myPanel);
		
		this.hp = 100;
		
		this.x=(BaseFrame.frameWidth-this.width)/2-200;
		this.desX = this.x;
		this.y=BaseFrame.frameHeight-this.height*2-200;
		this.desY = this.y;
		
		this.images_noChoose=new Image[] {
				Toolkit.getDefaultToolkit().getImage(Cat.class.getResource("/images/CatDown_1.png")),
				Toolkit.getDefaultToolkit().getImage(Cat.class.getResource("/images/CatDown_2.png")),
				Toolkit.getDefaultToolkit().getImage(Cat.class.getResource("/images/CatDown_3.png")),
				Toolkit.getDefaultToolkit().getImage(Cat.class.getResource("/images/CatDown_4.png"))
		};
		
		this.images_up=new Image[] {
				Toolkit.getDefaultToolkit().getImage(Cat.class.getResource("/images/CatUp_1.png")),
				Toolkit.getDefaultToolkit().getImage(Cat.class.getResource("/images/CatUp_2.png")),
				Toolkit.getDefaultToolkit().getImage(Cat.class.getResource("/images/CatUp_3.png")),
				Toolkit.getDefaultToolkit().getImage(Cat.class.getResource("/images/CatUp_4.png"))
		};
		
		this.images_left=new Image[] {
				Toolkit.getDefaultToolkit().getImage(Cat.class.getResource("/images/CatLeft_1.png")),
				Toolkit.getDefaultToolkit().getImage(Cat.class.getResource("/images/CatLeft_2.png")),
				Toolkit.getDefaultToolkit().getImage(Cat.class.getResource("/images/CatLeft_3.png")),
				Toolkit.getDefaultToolkit().getImage(Cat.class.getResource("/images/CatLeft_4.png"))
		};
		
		this.images_right=new Image[] {
				Toolkit.getDefaultToolkit().getImage(Cat.class.getResource("/images/CatRight_1.png")),
				Toolkit.getDefaultToolkit().getImage(Cat.class.getResource("/images/CatRight_2.png")),
				Toolkit.getDefaultToolkit().getImage(Cat.class.getResource("/images/CatRight_3.png")),
				Toolkit.getDefaultToolkit().getImage(Cat.class.getResource("/images/CatRight_4.png"))
		};
		
		this.images_down=new Image[] {
				Toolkit.getDefaultToolkit().getImage(Cat.class.getResource("/images/CatChooseDown_1.png")),
				Toolkit.getDefaultToolkit().getImage(Cat.class.getResource("/images/CatChooseDown_2.png")),
				Toolkit.getDefaultToolkit().getImage(Cat.class.getResource("/images/CatChooseDown_3.png")),
				Toolkit.getDefaultToolkit().getImage(Cat.class.getResource("/images/CatChooseDown_4.png"))
		};
		
		this.images_attack=new Image[] {
				Toolkit.getDefaultToolkit().getImage(Cat.class.getResource("/images/CatAttack_1.png")),
				Toolkit.getDefaultToolkit().getImage(Cat.class.getResource("/images/CatAttack_2.png")),
				Toolkit.getDefaultToolkit().getImage(Dog.class.getResource("/images/CatAttack_1.png")),
				Toolkit.getDefaultToolkit().getImage(Dog.class.getResource("/images/CatAttack_2.png"))
		};
	}
	
	public void drawSelf(Graphics g)
	{
		if(isChoose)
		{
			g.setColor(new Color(234,75,53));
			g.fillRect(x-3,y,this.hp/2,3);
			g.setColor(new Color(190,195,199));
			g.drawRect(x-3,y,51,4);
			if(up)
			{
				if(isAttacking)
			        g.drawImage(this.images_attack[imageindex],x,y-48,width,height,null);
			    g.drawImage(this.images_up[imageindex],x,y,width,height,null);
			}
			else if(left)
			{
				if(isAttacking)
			        g.drawImage(this.images_attack[imageindex],x-48,y,width,height,null);
			    g.drawImage(this.images_left[imageindex],x,y,width,height,null);
			}
			else if(right)
			{
				if(isAttacking)
			        g.drawImage(this.images_attack[imageindex],x+48,y,width,height,null);
			    g.drawImage(this.images_right[imageindex],x,y,width,height,null);
			}
			else
			{
				if(isAttacking)
			        g.drawImage(this.images_attack[imageindex],x,y+48,width,height,null);
			    g.drawImage(this.images_down[imageindex],x,y,width,height,null);
			}
			
		}
		else
		{
			if(up)
			    g.drawImage(this.images_up[imageindex],x,y,width,height,null);
			else if(left)
			    g.drawImage(this.images_left[imageindex],x,y,width,height,null);
			else if(right)
			    g.drawImage(this.images_right[imageindex],x,y,width,height,null);
			else
			    g.drawImage(this.images_noChoose[imageindex],x,y,width,height,null);
			
		}
		if(this.myPanel.timer%150==0)
			this.imageindex++;
		
		if(this.imageindex==this.images_up.length)
			this.imageindex=0;
	}
}
