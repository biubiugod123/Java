package GUI;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
 
public class JTabletest {
    public static void main(String[] args) {
 
        JFrame f = new JFrame("LoL");
        f.setSize(400, 300);
        f.setLocation(200, 200);
        f.setLayout(new BorderLayout());
 
        String[] columnNames = new String[] { "id", "name", "hp", "damage" };
        String[][] heros = new String[][] { { "1", "盖伦", "616", "100" },
                { "2", "提莫", "512", "102" }, { "3", "奎因", "832", "200" } };
        JTable t = new JTable(heros, columnNames);
 
        JScrollPane sp = new JScrollPane(t);
 
        // 设置列宽度
        t.getColumnModel().getColumn(0).setPreferredWidth(100);
 
        f.add(sp, BorderLayout.CENTER);
 
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 
        f.setVisible(true);
    }
}