package esk.dhaos.model;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import esk.dhaos.view.BaseFrame;
import esk.dhaos.view.MyPanel;

public class Cat extends Role{
	
//	public Dog target = null;
//	public Dog attacker = null;
	public Dog aim = null;
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
				Toolkit.getDefaultToolkit().getImage(Dog.class.getResource("/images/DogAttack_1.png")),
				Toolkit.getDefaultToolkit().getImage(Dog.class.getResource("/images/DogAttack_2.png")),
				Toolkit.getDefaultToolkit().getImage(Dog.class.getResource("/images/DogAttack_1.png")),
				Toolkit.getDefaultToolkit().getImage(Dog.class.getResource("/images/DogAttack_2.png"))
		};
	}
	
	
	public void drawSelf(Graphics g)
	{
		if(isLife)
		{
			if(isChoose)
			{
				g.setColor(new Color(234,75,53));
				g.fillRect(x-3,y,this.hp/2,3);
				g.setColor(new Color(190,195,199));
				g.drawRect(x-3,y,51,4);
				if(up)
				{
				    g.drawImage(this.images_up[imageindex],x,y,width,height,null);
				}
				else if(left)
				{

				    g.drawImage(this.images_left[imageindex],x,y,width,height,null);
				}
				else if(right)
				{

				    g.drawImage(this.images_right[imageindex],x,y,width,height,null);
				}
				else
				{
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
			if(underAttack)
			{
		        g.drawImage(this.images_attack[imageindex],x,y,width,height,null);
		        if(this.myPanel.timer%20==0)
		            underAttacking();
			}
			
			if(this.myPanel.timer%150==0)
				this.imageindex++;
			
			if(this.imageindex==this.images_up.length)
				this.imageindex=0;
		}
	}
	
    public void move(){
		right = false;
		left = false;
		up = false;
		down = false;
    	if(isChoose)
    	{
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
    			if(cat!=this)
    			{
    				//防止碰撞（重叠）
    				if(desX>cat.desX-5&&desX<cat.desX+5&&desY>cat.desY-5&&desY<cat.desY+5)
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
    			}	
    		}
    		
//    		for(int i = 0;i<this.myPanel.Dogs.size();i++)
//    		{
//    			Dog dog = this.myPanel.Dogs.get(i);
//
//    			//进入攻击距离开始攻击
//    			if(Math.sqrt(Math.abs((x-dog.x)*(x-dog.x))+Math.abs((y-dog.y)*(y-dog.y)))<50)
//    			{
//        			if(this.isAttacking==false)
//        			{
//    					this.isAttacking = true;
//    					dog.underAttack = true;
//    					//target.attacker = this;
//        			}
//    			}
//    			else
//    			{
//        			dog.underAttack = false;
//    				//target.underAttack = false;
//    				this.isAttacking = false;
//    			}
//    			//this.isAttacking = false;
//    		}
    		
    		if(this.isAttacking==false)
    		{
        		for(int i = 0;i<this.myPanel.Dogs.size();i++)
        		{
        			Dog dog = this.myPanel.Dogs.get(i);
        			//进入攻击距离开始攻击
        			if(Math.sqrt(Math.abs((x-dog.x)*(x-dog.x))+Math.abs((y-dog.y)*(y-dog.y)))<50)
        			{
        				//保存攻击目标
        				aim = dog;
        				//转换为攻击状态
        				this.isAttacking = true;
        			}
        			//this.isAttacking = false;
        		}
    		}
    		else
			{
    			if(Math.sqrt(Math.abs((x-aim.x)*(x-aim.x))+Math.abs((y-aim.y)*(y-aim.y)))<50)
    			{
    				aim.underAttack = true;
    			}
    			else
    			{
    				this.isAttacking = false;
    				aim.underAttack = false;
    			}
				//target.attacker = this;
			}
    		
            if(up){   
            	if(y>=60)
            	y=y-step;
            }  
            if(down){  
            	if(y<myPanel.getHeight()-145)
                y=y+step;
            }  
            if(left){
            	if(x>80)
                x=x-step;
            }  
            if(right){
            	if(x<myPanel.getWidth()-110)
                x=x+step;
            }
        }
    	else
    	{
    		desX = x;
    		desY = y;
    	}
    }
    public void underAttacking()
    {
		if(this.hp>0)
		    this.hp-=1;
		else
		{	
			this.isLife = false;
//			this.isAttacking = false;
//			this.underAttack = false;
//			this.attacker.isAttacking = false;
//			this.attacker.target = null;
//			this.attacker.attacker = null;
			this.isAttacking = false;
			this.underAttack = false;
			this.aim.underAttack = false;
			this.myPanel.Cats.remove(this);
		}

    }
}
