package esk.dhaos.model;

import java.awt.Image;
import java.awt.Toolkit;

import esk.dhaos.view.BaseFrame;
import esk.dhaos.view.MyPanel;

public class Dog extends Role{

	public Cat attacker = null;
	
	public Dog(MyPanel myPanel) {
		
		super(myPanel);
		
		this.hp = 100;
		
		this.x=(BaseFrame.frameWidth-this.width)/2+200+(int)(Math.random()*100);
		this.desX=this.x;
		this.y=BaseFrame.frameHeight-this.height*2-400+(int)(Math.random()*100);
		this.desY=this.y;
		this.images_noChoose=new Image[] {
				Toolkit.getDefaultToolkit().getImage(Dog.class.getResource("/images/DogDown_1.png")),
				Toolkit.getDefaultToolkit().getImage(Dog.class.getResource("/images/DogDown_2.png")),
				Toolkit.getDefaultToolkit().getImage(Dog.class.getResource("/images/DogDown_3.png")),
				Toolkit.getDefaultToolkit().getImage(Dog.class.getResource("/images/DogDown_4.png")),
		};
		
		this.images_up=new Image[] {
				Toolkit.getDefaultToolkit().getImage(Dog.class.getResource("/images/DogUp_1.png")),
				Toolkit.getDefaultToolkit().getImage(Dog.class.getResource("/images/DogUp_2.png")),
				Toolkit.getDefaultToolkit().getImage(Dog.class.getResource("/images/DogUp_3.png")),
				Toolkit.getDefaultToolkit().getImage(Dog.class.getResource("/images/DogUp_4.png"))
		};
		
		this.images_left=new Image[] {
				Toolkit.getDefaultToolkit().getImage(Dog.class.getResource("/images/DogLeft_1.png")),
				Toolkit.getDefaultToolkit().getImage(Dog.class.getResource("/images/DogLeft_2.png")),
				Toolkit.getDefaultToolkit().getImage(Dog.class.getResource("/images/DogLeft_3.png")),
				Toolkit.getDefaultToolkit().getImage(Dog.class.getResource("/images/DogLeft_4.png"))
		};
		
		this.images_right=new Image[] {
				Toolkit.getDefaultToolkit().getImage(Dog.class.getResource("/images/DogRight_1.png")),
				Toolkit.getDefaultToolkit().getImage(Dog.class.getResource("/images/DogRight_2.png")),
				Toolkit.getDefaultToolkit().getImage(Dog.class.getResource("/images/DogRight_3.png")),
				Toolkit.getDefaultToolkit().getImage(Dog.class.getResource("/images/DogRight_4.png"))
		};
		
		this.images_attack=new Image[] {
				Toolkit.getDefaultToolkit().getImage(Cat.class.getResource("/images/CatAttack_1.png")),
				Toolkit.getDefaultToolkit().getImage(Cat.class.getResource("/images/CatAttack_2.png")),
				Toolkit.getDefaultToolkit().getImage(Cat.class.getResource("/images/CatAttack_1.png")),
				Toolkit.getDefaultToolkit().getImage(Cat.class.getResource("/images/CatAttack_2.png"))
		};
	}
	
    public void underAttacking()
    {
		if(this.hp>0)
		    this.hp-=1;
		else
		{
			this.myPanel.Dogs.remove(this);
			this.attacker.isAttacking = false;
		}

    }

}
