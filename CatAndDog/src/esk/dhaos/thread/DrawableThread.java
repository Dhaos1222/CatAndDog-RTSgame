package esk.dhaos.thread;

import esk.dhaos.view.MyPanel;

public class DrawableThread extends Thread{
	public MyPanel myPanel;
	
	public DrawableThread(MyPanel myPanel)
	{
		this.myPanel=myPanel;
	}
	
	public void run()
	{
		while(true)
		{
			this.myPanel.repaint();//重新绘制 调用paintComponent方法
			
			try {
				Thread.sleep(1);
			}
			catch (InterruptedException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
	}
}
