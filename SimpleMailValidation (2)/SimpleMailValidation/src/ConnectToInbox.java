/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import com.sun.mail.pop3.POP3SSLStore;
import javax.mail.*;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author SWORD
 */
public class ConnectToInbox {
    private String userName;
    private String password;
    private String protocol;
    private String url;
    private Store store;
    private Session session = null;
    private Folder folder;

    public void setUserPassword(String userName, String password)
    {
        this.userName = userName;
        this.password = password;
    }

    public void setURL(String url)
    {
        this.url = url;
    }

    public void setProtocol(String protocol)
    {
        this.protocol = protocol;
    }

    public void connect()
    {
        try
        {
            Properties prop = System.getProperties();
            prop.setProperty("mail.pop3.socketFactory.class", "javax.net.SSLSocketFactory");
            prop.setProperty("mail.pop3.socketFactory.port", "995");
            URLName urlName = new URLName(protocol, url, 995, "", userName, password);
            session = Session.getInstance(prop, null);
            store = new POP3SSLStore(session, urlName);
            store.connect();
            System.out.println("Connection establised");
        }
        catch(MessagingException ex)
        {
            Logger.getLogger(MailHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Store getStore()
    {
          return store;
    }

}
