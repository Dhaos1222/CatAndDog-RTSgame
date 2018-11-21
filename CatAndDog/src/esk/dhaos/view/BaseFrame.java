package esk.dhaos.view;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;

import esk.dhaos.listener.FrameKeyListener;
import esk.dhaos.listener.FrameMouseListener;
import esk.dhaos.view.MyPanel;

public class BaseFrame extends JFrame{
	
	public static int frameWidth=900;
	
	public static int frameHeight=890;
	
	public MyPanel myPanel;
	
	//鼠标监听器
	public FrameMouseListener frameMouseListener;
	
	//键盘监听器
	public FrameKeyListener frameKeyListener;
	
	public void setKeyListener()
	{
		this.frameKeyListener=new FrameKeyListener();
		this.frameKeyListener.baseFrame=this;
		this.addKeyListener(this.frameKeyListener);
	}
	
	public void setMouseListener()
	{
		this.frameMouseListener=new FrameMouseListener();
		this.frameMouseListener.baseFrame=this;
		this.addMouseListener(this.frameMouseListener);
		this.addMouseMotionListener(this.frameMouseListener);
	}
	
	public BaseFrame()
	{
		super("CatAndDog");
		//获得屏幕的分辨率
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		
		//设置窗口的大小和位置
		setBounds(((int)screenSize.getWidth()-frameWidth)/2,0,frameWidth,frameHeight);
		
		//禁止改变窗口大小
		setResizable(false);
		
		//布局方式
		setLayout(null);
		
		//创建MyPanel对象
		this.myPanel = new MyPanel();
		
		//设置MyPanel对象的位置和大小
		this.myPanel.setBounds(0,0,frameWidth,frameHeight);
		
		//将组件添加到窗口中
		this.add(this.myPanel);
			
		//显示窗口
		setVisible(true);
		
		//设置窗口的关闭行为
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
