import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.table.*;
public class window extends JFrame //implements ActionListener
{
		JLabel L1,L2,L3;
		JTextField T1,T2,T3;
		JButton B1,B2,B3,B4;
		List ls=new List();
		
	public window()
	{
		super ("test Frame");
		ls.add("saif");
		Container con=getContentPane();
		setLayout(new FlowLayout());
		JTable tb=new JTable();
	//	tb.setRowHeight(50);
		tb.setModel(new DefaultTableModel(new String[] {"saif","test"},10));
		add(tb);
		setSize(300,400);
		setLocation(50,100);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		}


		public static void main(String arg[])
		{
			new window();
			}


	}