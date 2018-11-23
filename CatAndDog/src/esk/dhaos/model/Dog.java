package esk.dhaos.model;

import java.awt.Image;
import java.awt.Toolkit;

import esk.dhaos.view.BaseFrame;
import esk.dhaos.view.MyPanel;

public class Dog extends Role{

	public Dog(MyPanel myPanel) {
		
		super(myPanel);
		
		this.hp = 100;
		
		this.x=(BaseFrame.frameWidth-this.width)/2+200;
		this.desX=this.x;
		this.y=BaseFrame.frameHeight-this.height*2-400;
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
				Toolkit.getDefaultToolkit().getImage(Dog.class.getResource("/images/DogAttack_1.png")),
				Toolkit.getDefaultToolkit().getImage(Dog.class.getResource("/images/DogAttack_2.png")),
				Toolkit.getDefaultToolkit().getImage(Dog.class.getResource("/images/DogAttack_1.png")),
				Toolkit.getDefaultToolkit().getImage(Dog.class.getResource("/images/DogAttack_2.png"))
		};
	}

}
