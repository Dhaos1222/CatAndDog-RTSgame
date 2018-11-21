package esk.dhaos.model;

import java.awt.Graphics;
import java.awt.Image;

import esk.dhaos.view.MyPanel;

public class Role extends Thread{
	public MyPanel myPanel;
	
	public int width = 48;
	
	public int height = 48;

	public int x;
	
	public int y;
	
	public boolean isLife = true;
	
	//�ж��Ƿ�ѡ��
	public boolean isChoose = false;
	
	//�жϽ�ɫ�Ƿ��ƶ�
	static int step = 3;
	
    public boolean up = false;  
    public boolean down = false;  
    public boolean left = false;  
    public boolean right = false; 
    
	//��ŵ�ǰͼƬ�±�
	public int imageindex=0;
	public int i = 0;
	//��ɫ����
	public Image[] images_up;
	public Image[] images_down;
	public Image[] images_left;
	public Image[] images_right;
	
	public Role(MyPanel myPanel)
	{
		this.myPanel=myPanel;
		
	}
	
	public void drawSelf(Graphics g) {
		if(up)
		    g.drawImage(this.images_up[imageindex],x,y,width,height,null);
		else if(left)
		    g.drawImage(this.images_left[imageindex],x,y,width,height,null);
		else if(right)
		    g.drawImage(this.images_right[imageindex],x,y,width,height,null);
		else
		    g.drawImage(this.images_down[imageindex],x,y,width,height,null);
		
		if(this.myPanel.timer%150==0)
			this.imageindex++;
		
		if(this.imageindex==this.images_down.length)
			this.imageindex=0;
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
	
    //��ɫ�ƶ��ķ���
    public void move(){  
        if(up){  
            //�ı��ɫ�ڵ�ͼ�е�λ��  
        	if(y>=60)
            y=y-step;  
            //�ı��ɫ�ƶ�����ڹ̶�Ԫ�ص��ƫ����   
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
}
