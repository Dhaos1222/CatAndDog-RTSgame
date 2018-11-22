package esk.dhaos.model;

import java.awt.Image;
import java.awt.Toolkit;

import esk.dhaos.view.BaseFrame;
import esk.dhaos.view.MyPanel;

public class Cat extends Role{
	
	public Cat(MyPanel myPanel) {
		
		super(myPanel);
		
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
	}
}
