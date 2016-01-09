import java.util.logging.Logger;
import javax.swing.*;
import java.awt.*;
import java.lang.reflect.InvocationTargetException;

public class myThread extends Thread
{
        JFrame frame=new JFrame("Please wait");
        JProgressBar pb=new JProgressBar();
        int l,w;
    public void mytThread(int w,int l)
    {
            setDaemon(true);
            this.l=l;
            this.w=w;
	
        frame.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
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
        frame.setLocation(w,l);
       frame.setVisible(true);
      Runnable runner = new Runnable() {
        public void run() {
                 
        }
      };
      while(true) {
        try {
          SwingUtilities.invokeAndWait(runner);
        } catch (InterruptedException ignoredException) {
        } catch (InvocationTargetException ignoredException) {
        }
      }



    }


    public static void main(String arg[])
		{
		myThread m1=new myThread(10,10);
                myThread m2=new myThread(10,10);
                m1.start();
                m2.start();
			}

}
