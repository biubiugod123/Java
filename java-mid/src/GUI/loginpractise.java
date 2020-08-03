package GUI;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.SQLException;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

;

public class loginpractise {
	
	public static void main(String[] args) {
		JFrame f = new JFrame("Login test");
		JPanel p1 = new JPanel();
		JPanel p2 = new JPanel();
		JTextField tfusername = new JTextField();
		JPasswordField tfpassword = new JPasswordField();
		JButton b = new JButton("登陆");
		JLabel l1 = new JLabel("账号： ");
		JLabel l2 = new JLabel("密码： ");
		
		f.setLayout(null);
		tfusername.setPreferredSize(new Dimension(80,30));
		tfpassword.setPreferredSize(new Dimension(80,30));
		
		p1.add(l1);
		p1.add(tfusername);
		p1.add(l2);
		p1.add(tfpassword);
		p2.add(b);
		
		
		b.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String username = tfusername.getText();
				char [] passwords = tfpassword.getPassword();
				if(username.length() == 0 || passwords.length == 0) {
					JOptionPane.showMessageDialog(f, "账户或密码不能为空");
				}
				else {
					try {
						Class.forName("com.mysql.jdbc.Driver");
					} catch(ClassNotFoundException e1){
						e1.printStackTrace();
					}
					try (Connection c = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/how2java?characterEncoding=UTF-8", "root","admin");
							Statement s = c.createStatement();)
							{
						String name = username;
						String password = String.valueOf(passwords);
						
						String sql = "select * from user where name = '" + name + "' and password = '" + password + "'";
						ResultSet rs = s.executeQuery(sql);
						
						if(rs.next()) {
							JOptionPane.showMessageDialog(f, "登陆成功");
						}
						else {
							JOptionPane.showMessageDialog(f, "账户或密码错误");
						}
						
						
					} catch(SQLException e2) {
						e2.printStackTrace();
					}
	
				}
				
			}
		}
				);
		
		
		p1.setBounds(25,0,300,200);
		p2.setBounds(125,50,130,120);
		f.add(p1);
		f.add(p2);
		
		
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setSize(400,400);
		f.setVisible(true);
		
		
		
		
		
	}

}
