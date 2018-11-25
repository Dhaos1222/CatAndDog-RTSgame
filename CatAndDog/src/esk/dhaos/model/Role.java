package esk.dhaos.model;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

import esk.dhaos.view.MyPanel;

public class Role extends Thread{
	public MyPanel myPanel;
	
	public int width = 48;
	
	public int height = 48;

	public int x;
	
	public int y;
	
	public int desX;
	
	public int desY;
	
	public boolean isLife = true;
	
	public int hp;

	public boolean isChoose = false;
	public boolean underAttack = false;
	//避免AOE攻击，限定单体攻击
	public boolean isAttacking = false;
	
	static int step = 1;
	
    public boolean up = false;  
    public boolean down = false;  
    public boolean left = false;  
    public boolean right = false; 
    

	public int imageindex=0;
	public int i = 0;

	
	public Image[] images_up;
	public Image[] images_down;
	public Image[] images_left;
	public Image[] images_right;
	public Image[] images_noChoose;
	public Image[] images_attack;
	
	public Role(MyPanel myPanel)
	{
		this.myPanel=myPanel;
		
	}
	
	public void underAttacking()
	{
		if(this.hp>0)
		    this.hp-=10;
	}
	
	public void drawSelf(Graphics g) {
		if(isLife)
		{
			g.setColor(new Color(234,75,53));
			g.fillRect(x-3,y,this.hp/2,3);
			g.setColor(new Color(190,195,199));
			g.drawRect(x-3,y,51,4);
			if(isChoose)
			{
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
			//被攻击
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
	
    public void run() {  
        while(true){
            move();  
            try {  
                Thread.sleep(10);  
            } catch (InterruptedException e) {  
                e.printStackTrace();  
            } 
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
}
