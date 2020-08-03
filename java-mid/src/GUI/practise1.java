package GUI;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class practise1 {
	
	public static void main(String[] args) {
		JFrame f = new JFrame("Test Null Input");
		JPanel p = new JPanel();
		JButton b = new JButton("检测");
		JTextField t = new JTextField();
		t.setPreferredSize(new Dimension(80,30));
		
		p.add(t);
		p.add(b);
		
		b.addActionListener( new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String input = t.getText();
				try {
					int num = Integer.parseInt(input);
				} catch(NumberFormatException ex) {
					JOptionPane.showMessageDialog(f, "输入框内容不是整数");
				}
				
			}
		});
		
		
		f.add(p);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setSize(400,400);
		f.setVisible(true);
		
		
	}

}
