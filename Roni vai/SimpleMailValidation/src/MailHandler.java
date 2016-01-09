/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import com.sun.mail.pop3.POP3SSLStore;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.mail.*;
import javax.mail.internet.ContentType;
import javax.mail.search.FlagTerm;

/**
 *
 * @author Md. Salahuddin
 */
public class MailHandler {
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
        }
        catch(MessagingException ex)
        {
            Logger.getLogger(MailHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void openFolder(String folderName)
    {
        try
        {
            folder = store.getDefaultFolder();
            folder = folder.getFolder(folderName);
            if(folder == null)
            {
                return;
            }
            folder.open(Folder.READ_ONLY);
        }
        catch(MessagingException ex)
        {
            Logger.getLogger(MailHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void closeFolder() throws MessagingException
    {
        folder.close(false);
        store.close();
    }

    public int getMessageCount() throws MessagingException
    {
        return folder.getMessageCount();
    }

    public int getNewMessageCount() throws MessagingException
    {
        return folder.getNewMessageCount();
    }

    public void parseMessages(MailViewPanel mp, boolean isNew)
    {
        Message[] msg;
        try
        {
//            if(!isNew)
               msg = folder.getMessages();
//            else msg = folder.search(new FlagTerm(new Flags(Flags.Flag.SEEN), false));
            
            FetchProfile fProf = new FetchProfile();
            fProf.add(FetchProfile.Item.ENVELOPE);
            folder.fetch(msg, fProf);

            System.out.println("All Messages\n");
//            for(int i=0;i<msg.length;i++)
//            {
                System.out.println("Messages : ");
                dumpMessage(mp, msg[10]);
//            }
        }
        catch(MessagingException ex)
        {
            Logger.getLogger(MailHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void dumpMessage(MailViewPanel mp, Part p)
    {
        if(p instanceof Message)
        {
            dumpEnvelope((Message)p);
        }
        try
        {
            String cType = p.getContentType();
            //mp.getEditorPane().setContentType(cType);
            System.out.println("Content Type : " + (new ContentType(cType)).toString());

            String content="";
            if(p.isMimeType("text/html"))
            {
                content = (String)p.getContent();
            }
            if(p.isMimeType("text/plain"))
            {
                content = plainToHtml((String)p.getContent());
            }
            mp.getEditorPane().setText(content);
//            System.out.println((String)p.getContent());
        }
        catch(IOException ex)
        {
            Logger.getLogger(MailHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch(MessagingException ex)
        {
            Logger.getLogger(MailHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void dumpEnvelope(Message message)
    {
        try
        {
            Address[] addr;
            if((addr = message.getFrom()) != null)
            {
                for(int j = 0; j < addr.length; j++)
                {
                    System.out.println("From : "+addr[j].toString());
                }
            }

            if((addr=message.getRecipients(Message.RecipientType.TO))!=null)
            {
                for(int j=0;j<addr.length;j++)
                {
                    System.out.println("To : "+addr[j].toString());
                }
            }

            System.out.println("Subject : "+message.getSubject());
            
        }
        catch(MessagingException ex)
        {
            Logger.getLogger(MailHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public String plainToHtml(String plain)
    {
        String urlRegex = "(?i)\\b((?:https?://|www\\d{0,3}[.]|[a-z0-9.\\-]+[.][a-z]{2,4}/)(?:[^\\s()<>]+|\\(([^\\s()<>]+|(\\([^\\s()<>]+\\)))*\\))+(?:\\(([^\\s()<>]+|(\\([^\\s()<>]+\\)))*\\)|[^\\s`!()\\[\\]{};:\'\".,<>?«»“”‘’]))";
        Pattern patt = Pattern.compile(urlRegex);
        Matcher matcher = patt.matcher(plain);
        plain = matcher.replaceAll("<a href=\"$1\">$1</a>");
        String emailRegx = "\\b[A-Z0-9._%-]+@[A-Z0-9.-]+\\.[A-Z]{2,4}\\b";
        patt = Pattern.compile(emailRegx, Pattern.CASE_INSENSITIVE);
        matcher = patt.matcher(plain);
        plain = matcher.replaceAll("<a href=\"mailto:$0\">$0</a>");
        patt = Pattern.compile("\n");
        matcher = patt.matcher(plain);
        plain = matcher.replaceAll("<br />");
        return plain;
    }
}
