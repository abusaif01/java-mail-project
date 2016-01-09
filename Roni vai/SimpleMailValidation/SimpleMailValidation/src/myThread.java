/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import javax.swing.*;
import java.awt.*;
/**
 *
 * @author 3PSN
 */
public class myThread extends Thread
{
        JFrame frame=new JFrame("Please wait");
        JProgressBar pb=new JProgressBar();

     public void mytThread()
    {
        
     }
    @Override
    public void run()
    {
        Container con=frame.getContentPane();
        frame.setLayout(new GridLayout(1,1));
        pb.setIndeterminate(true);
        pb.setString("Loading mails....");
        pb.setStringPainted(true);
        frame.add(pb);
        frame.setSize(500,65);
	frame.setLocation(300,200);
        frame.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
    public static void main(String arg[])
		{
			new myThread().start();
			}

}
