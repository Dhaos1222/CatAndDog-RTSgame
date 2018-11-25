package esk.dhaos.model;

import java.awt.Image;
import java.awt.Toolkit;

import esk.dhaos.view.BaseFrame;
import esk.dhaos.view.MyPanel;

public class Dog extends Role{

//	public Cat target = null;
//	public Cat attacker = null;
	
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
			this.isLife = false;
//			this.attacker.isAttacking = false;
//			this.isAttacking = false;
//			this.underAttack = false;
//			this.attacker.target = null;
//			this.attacker.attacker = null;
			this.myPanel.Dogs.remove(this);
		}

    }

    public void move(){
		right = false;
		left = false;
		up = false;
		down = false;
		if(this.myPanel.timer%20==0)
		{
			if((int)(Math.random()*10)%2==0)
				desX -= 20;
			else
				desX += 20;
			if((int)(Math.random()*10)%2==0)
				desY += 20;
			else
				desY -= 20;
		}
		if(x!=desX&&y!=desY)
		{
			int disX = desX-x;
			int disY = desY-y;
			if(disX>=15)
				right = true;
			else if(disX<=-15)
				left = true;
			if(disY>=15)
				down = true;
			else if(disY<=-15)
				up = true;
		}
		for(int i = 0;i<this.myPanel.Cats.size();i++)
		{
			Cat cat = this.myPanel.Cats.get(i);

			//进入攻击距离开始攻击
			if(Math.sqrt(Math.abs((x-cat.x)*(x-cat.x))+Math.abs((y-cat.y)*(y-cat.y)))<50)
			{
    			if(this.isAttacking==false)
    			{
					this.isAttacking = true;
					cat.underAttack = true;
					//cat.attacker = this;
    			}
			}
			else
			{
				cat.underAttack = false;
				//target.underAttack = false;
				this.isAttacking = false;
			}

			//this.isAttacking = false;
		}
		
        if(up){   
        	if(y>=60)
        	y=y-step;
        	else
        	{
        		desX = x;
        		desY = y;
        	}
        }  
        if(down){  
        	if(y<myPanel.getHeight()-145)
            y=y+step;
        	else
        	{
        		desX = x;
        		desY = y;
        	}
        }  
        if(left){
        	if(x>80)
            x=x-step;
        	else
        	{
        		desX = x;
        		desY = y;
        	}
        }  
        if(right){
        	if(x<myPanel.getWidth()-110)
            x=x+step;
        	else
        	{
        		desX = x;
        		desY = y;
        	}
        }

    }
    
}
