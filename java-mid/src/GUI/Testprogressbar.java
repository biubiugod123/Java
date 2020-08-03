package GUI;

import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JProgressBar;



public class Testprogressbar {
	
	public static void main(String[] args) {
		JFrame f = new JFrame("ProgressBar");
		JProgressBar b = new JProgressBar();
		
		b.setMaximum(100);
		b.setValue(0);
		
		f.add(b);
		f.setSize(400,300);
		f.setLayout(new FlowLayout());
		
		Thread t = new Thread() {
			int progress = 0;
			long time = 100;
			
			public void run() {
				while(progress <= 100) {
					progress++;
				
				if(progress == 100) {
					JOptionPane.showMessageDialog(f, "成功！");
					progress = 0;
				}
				
				b.setValue(progress);
				b.setStringPainted(true);
				
				try {
					Thread.sleep(time);
					
				} catch(InterruptedException e) {
					e.printStackTrace();
				}
			}
			}
			
		};
		
		t.start();
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
		
				
		
		
		
	}

}
