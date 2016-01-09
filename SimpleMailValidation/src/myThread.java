/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import java.awt.*;
import java.lang.reflect.InvocationTargetException;
/**
 *
 * @author 3PSN
 */
public class myThread extends Thread
{
        JFrame frame=new JFrame("Please wait");
        JProgressBar pb=new JProgressBar();
        boolean toStop;
      public myThread()
    {
      setDaemon(true);
        frame.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
        toStop=true;
        System.out.println("work");
      }

     public void exit()
    {
        System.exit(1);
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
        frame.setSize(400,65);
        frame.setLocation(0,150);
       frame.setVisible(true);
       System.out.println("testing");
       System.out.println(toStop);
       while(toStop)
       {
            System.out.println(toStop);
            try {
                sleep(3000);
            } catch (InterruptedException ex) {
                Logger.getLogger(myThread.class.getName()).log(Level.SEVERE, null, ex);
            }
       }
       frame.setVisible(false);
    //   frame.setVisible(false);
     /* R
      unnable runner = new Runnable() {
        public void run() {

        }
      };
      while(true) {
        try {
          SwingUtilities.invokeAndWait(runner);
          // our job for each step is to just sleep
     //     Thread.sleep(DELAY);
        } catch (InterruptedException ignoredException) {
        } catch (InvocationTargetException ignoredException) {
        }
      }*/

    }

    


    public static void main(String arg[])
		{
		myThread m1=new myThread();
                m1.start();
        try {

            sleep(5000);
            /* try {
            m1.wait(1000);
            } catch (InterruptedException ex) {
            Logger.getLogger(myThread.class.getName()).log(Level.SEVERE, null, ex);
            }*/
        } catch (InterruptedException ex) {
            Logger.getLogger(myThread.class.getName()).log(Level.SEVERE, null, ex);
        }

			}

}
