
import java.awt.BorderLayout;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.MessagingException;
import javax.swing.JFrame;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Md. Salahuddin
 */
public class SimpleMailValidationMain {
    public static void main(String args[])
    {
        JFrame frame = new JFrame("Simple Mail Validation tool");
        frame.setLayout(new BorderLayout());
        MailViewPanel mp = new MailViewPanel();
        frame.add(mp);
        mp.readMail();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(640,480);
        frame.setVisible(true);
    }
}
