package esk.dhaos.model;

import java.awt.Image;
import java.awt.Toolkit;

import esk.dhaos.view.BaseFrame;
import esk.dhaos.view.MyPanel;

public class Dog extends Role{

	public Dog(MyPanel myPanel) {
		
		super(myPanel);
		
		this.x=(BaseFrame.frameWidth-this.width)/2+200;
		
		this.y=BaseFrame.frameHeight-this.height*2-400;
		
		this.images_down=new Image[] {
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
	}

}
