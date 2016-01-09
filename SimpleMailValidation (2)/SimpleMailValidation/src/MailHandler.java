/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import com.sun.mail.pop3.POP3SSLStore;
import java.awt.List;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
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
    private Store store;
    private Folder folder;
    private Message[] msg;
    public List to=new List();
    public List from=new List();
    public List subject=new List();

    public MailHandler(Store store)
    {
        this.store=store;
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







    public void parseMessages(boolean isNew) throws IOException, Exception
    {
        System.out.println("Parsing Message");
        try
        {
//            if(!isNew)
               msg = folder.getMessages();
//            else msg = folder.search(new FlagTerm(new Flags(Flags.Flag.SEEN), false));
            
            FetchProfile fProf = new FetchProfile();
            fProf.add(FetchProfile.Item.ENVELOPE);
            folder.fetch(msg, fProf);
             System.out.println("Printing massage  : "+msg.length);

            System.out.println("All Messages\n");
            for(int i=0;i<msg.length;i++)
           {
                System.out.println("Messages " +(i+1)+" :");
                dumpMessage(msg[i],i);
            }
        }
        catch(MessagingException ex)
        {
            Logger.getLogger(MailHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void dumpMessage(Part p,int i) throws IOException, Exception
    {
        if(p instanceof Message)
        {
            dumpEnvelope((Message)p,i);
        }
        
    }

    public void getDetailMsg(int i,MailViewPanel mp)
    {
        try
        {
               System.out.println("in getDetailmsg");
               Part p=msg[i];
            String cType = p.getContentType();
            mp.getEditorPane().setContentType(cType);

            System.out.println(cType);

            String content= getText(p);

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

    private String getText(Part p) throws
                MessagingException, IOException {
        if (p.isMimeType("text/html")) {
            System.out.println("text/html found");
            String s = (String)p.getContent();
            return s;
        }

        if(p.isMimeType("text/plain")){
            System.out.println("text/plain found");
            return plainToHtml((String)p.getContent());
        }

        if (p.isMimeType("multipart/alternative")) {
            // prefer html text over plain text
            System.out.println("multipert/alternative found");
            Multipart mp = (Multipart)p.getContent();
            String text = null;
            for (int i = 0; i < mp.getCount(); i++) {
                Part bp = mp.getBodyPart(i);
                if (bp.isMimeType("text/plain")) {
                    if (text == null)
                        text = getText(bp);
                    continue;
                } else if (bp.isMimeType("text/html")) {
                    String s = getText(bp);
                    if (s != null)
                        return s;
                } else {
                    return getText(bp);
                }
            }
            return text;
        } else if (p.isMimeType("multipart/*")) {
            System.out.println("multipert/* found");
            Multipart mp = (Multipart)p.getContent();
            System.out.println("multipert test");
            for (int i = 0; i < mp.getCount(); i++) {
                System.out.println("multipert in loop ");
                String s = getText(mp.getBodyPart(i));
                System.out.println("multipert after gettext call ");
                if (s != null)
                    return s;
            }
        }

        return null;
    }

    private void dumpEnvelope(Message message,int i) throws IOException, Exception
    {
           System.out.println("Finding from and subject");
        try
        {
            Address[] addr;
            if((addr = message.getFrom()) != null)
            {

               from.add(addr[0].toString());
                for(int j = 0; j < addr.length; j++)
                {
                    System.out.println("From : "+addr[0].toString());
                }
            }

            if((addr=message.getRecipients(Message.RecipientType.TO))!=null)
            {
                    to.add(addr[0].toString());
                for(int j=0;j<addr.length;j++)
                {        
                    System.out.println("To : "+addr[j].toString());
                }
            }
              subject.add(message.getSubject());
            System.out.println("Subject : "+message.getSubject());
             //
//            Multipart mp = (Multipart) message.getContent();
//            int count = mp.getCount();
//            for (int i = 0; i < count; i++)
//            {
//
//            }
            //
         //   String s;
           //   s=message.getDescription();
             // System.out.println("discription : "+s);
           //  Object con=new Object();
            //  con=message.getContent();
              //  System.out.println("content : "+message.getContent());
             //   System.out.println("content : to sitring " + con.toString());
        }
        catch(MessagingException ex)
        {
            Logger.getLogger(MailHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //
//            public void dumpPart(Part p) throws Exception
//            {
//                // Dump input stream ..
//                InputStream is = p.getInputStream();
//                // If "is" is not already buffered, wrap a BufferedInputStream
//                // around it.
//                if (!(is instanceof BufferedInputStream))
//                {
//                    is = new BufferedInputStream(is);
//                }
//                int c;
//                System.out.println("Message : ");
//                while ((c = is.read()) != -1)
//                {
//                    System.out.write(c);
//                }
//            }
    //

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
