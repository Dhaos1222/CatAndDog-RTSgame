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
	
	//��������
	public FrameMouseListener frameMouseListener;
	
	//���̼�����
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
		//�����Ļ�ķֱ���
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		
		//���ô��ڵĴ�С��λ��
		setBounds(((int)screenSize.getWidth()-frameWidth)/2,0,frameWidth,frameHeight);
		
		//��ֹ�ı䴰�ڴ�С
		setResizable(false);
		
		//���ַ�ʽ
		setLayout(null);
		
		//����MyPanel����
		this.myPanel = new MyPanel();
		
		//����MyPanel�����λ�úʹ�С
		this.myPanel.setBounds(0,0,frameWidth,frameHeight);
		
		//�������ӵ�������
		this.add(this.myPanel);
			
		//��ʾ����
		setVisible(true);
		
		//���ô��ڵĹر���Ϊ
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
