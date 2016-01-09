/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import com.sun.mail.pop3.POP3SSLStore;
import javax.mail.*;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
/*
 * MailSetupPanel.java
 *
 * Created on Mar 3, 2011, 2:13:42 AM
 */

/**
 *
 * @author SWORD
 */
public class MailSetupPanel extends javax.swing.JFrame
{

    /** Creates new form MailSetupPanel */
    private String user_name;
    private String password;
    private String protocol;
    private String url;
    private Session session = null;
    private Store store;
    MailList1 mls=new MailList1();;

    javax.swing.JFrame frame = new javax.swing.JFrame("Simple Mail Validation tool");
    myThread m1=new myThread();
    public MailSetupPanel() {
        initComponents();
        if(defaultSettingCheckBox.isSelected())
        {
            incommingMailServerLebel.setEnabled(false);
            incommingMailServerTextFiled.setEnabled(false);
            
        }
        
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        tf_user_name = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        pf_password = new javax.swing.JPasswordField();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        protocolComboBox = new javax.swing.JComboBox();
        incommingMailServerLebel = new javax.swing.JLabel();
        incommingMailServerTextFiled = new javax.swing.JTextField();
        b_ok = new javax.swing.JButton();
        defaultSettingCheckBox = new javax.swing.JCheckBox();
        jPanel3 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        acountTypeComboBox = new javax.swing.JComboBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "User Information", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N
        jPanel1.setLayout(new java.awt.GridLayout(2, 2, 5, 5));

        jLabel1.setText("E-mail Address");
        jPanel1.add(jLabel1);
        jPanel1.add(tf_user_name);

        jLabel2.setText("Password");
        jPanel1.add(jLabel2);
        jPanel1.add(pf_password);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Server Information", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N
        jPanel2.setLayout(new java.awt.GridLayout(2, 2, 5, 5));

        jLabel3.setText("Protocol");
        jPanel2.add(jLabel3);

        protocolComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "IMAP", "POP3", "POP3 With SSL" }));
        jPanel2.add(protocolComboBox);

        incommingMailServerLebel.setText("Incoming Mail Server");
        jPanel2.add(incommingMailServerLebel);
        jPanel2.add(incommingMailServerTextFiled);

        b_ok.setText("ok");
        b_ok.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_okActionPerformed(evt);
            }
        });

        defaultSettingCheckBox.setSelected(true);
        defaultSettingCheckBox.setText("Use Default setting");
        defaultSettingCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                defaultSettingCheckBoxActionPerformed(evt);
            }
        });

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Account Selection"));

        jLabel5.setText("Account Type");

        acountTypeComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Gmail", "Yahoo" }));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 177, Short.MAX_VALUE)
                .addComponent(acountTypeComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 23, Short.MAX_VALUE)
                .addComponent(acountTypeComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(defaultSettingCheckBox)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 324, Short.MAX_VALUE)
                .addComponent(b_ok)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 476, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 476, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                        .addComponent(defaultSettingCheckBox)
                        .addGap(38, 38, 38))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(b_ok)
                        .addContainerGap())))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void b_okActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_okActionPerformed
        // TODO add your handling code here:
        user_name="abu.saif01@gmail.com";
        password="01714388766";
      //  user_name=tf_user_name.getText();
      //  password=pf_password.getText();
        System.out.println(user_name+" "+password);
        setVisible(false);
        System.out.println("chk1");

        
         
       class mailListThread extends Thread
        {
               
           public mailListThread()
            {
                
           }

            @Override
           public void run()
            {
                try {
                    establisConnection();
                } catch (MessagingException ex) {
                    Logger.getLogger(MailSetupPanel.class.getName()).log(Level.SEVERE, null, ex);
                }
                mls.showMailList(store);
                mls.setVisible(true);
                System.out.println("chk2");
             /*   frame.setLayout(new BorderLayout());
                frame.setSize(1000,800);
                frame.add(mp);
                frame.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
                frame.setVisible(true);
*/
           }
        }
       
       mailListThread rmsth=new mailListThread();
        m1.start();
        
        rmsth.start();
        class managewindow extends Thread
        {

           public managewindow()
            {

           }

            @Override
           public void run()
            {
                while(!(mls.isVisible()))
                {
                    try {
                       // System.out.println("not visible");
                        sleep(2000);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(MailSetupPanel.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                System.out.println("after loop");
                m1.toStop=false;
            }
        }

         managewindow mngw =new managewindow();
         mngw.start();
        //m1.toStop=false;
}//GEN-LAST:event_b_okActionPerformed


    private void establisConnection() throws MessagingException
       {
         if(defaultSettingCheckBox.isSelected())
            {
                String acountTypeFromCombo,protocolFromCombo;
                acountTypeFromCombo=acountTypeComboBox.getSelectedItem().toString();
                protocolFromCombo=protocolComboBox.getSelectedItem().toString();
                if((acountTypeFromCombo.equals("Gmail")) && (protocolFromCombo.equals("IMAP")))
                {
                    System.out.println(acountTypeFromCombo+" "+protocolFromCombo);
                    connectTOGmailIMAP();
                }
                else if((acountTypeFromCombo.equals("Gmail")) && (protocolFromCombo.equals("POP3 With SSL")))
                {
                    System.out.println(acountTypeFromCombo+" "+protocolFromCombo);
                    connectToGmailPOP3SSL();
                }
                else if((acountTypeFromCombo.equals("Gmail")) && (protocolFromCombo.equals("POP3")))
                {
                    System.out.println(acountTypeFromCombo+" "+protocolFromCombo);
                    connectToGmailPOP3();
                }
                else if((acountTypeFromCombo.equals("Yahoo")) && (protocolFromCombo.equals("POP3")))
                {
                    System.out.println(acountTypeFromCombo+" "+protocolFromCombo);
                    connectToYahooPOP3();
                }
            }
        }

     private void connectTOGmailIMAP()
     {
        System.out.println("ConnectTOGamilIMAP called");
        protocol="imaps";
        url="imap.gmail.com";
        Properties prop = System.getProperties();
        prop.setProperty("mail.store.protocol",protocol);
        try
        {
            System.out.println("connect called");
            session = Session.getDefaultInstance(prop, null);
            store = session.getStore(protocol);
            store.connect(url,user_name,password);
            System.out.println("Connection establised");
        }
        catch(MessagingException ex)
        {
            Logger.getLogger(MailHandler.class.getName()).log(Level.SEVERE, null, ex);
         }
    }

    private void connectToGmailPOP3SSL() throws MessagingException
    {
           System.out.println("connectToGmailPOP3SSL called");
         String SSL_FACTORY = "javax.net.ssl.SSLSocketFactory";
        protocol="pop3";
        url="pop.gmail.com";
        Properties pop3Props = new Properties();

        pop3Props.setProperty("mail.pop3.socketFactory.class", SSL_FACTORY);
        pop3Props.setProperty("mail.pop3.socketFactory.fallback", "false");
        pop3Props.setProperty("mail.pop3.port",  "995");
        pop3Props.setProperty("mail.pop3.socketFactory.port", "995");

        URLName urlname = new URLName(protocol,url, 995, "",
                user_name, password);

        session = Session.getInstance(pop3Props, null);
        store = new POP3SSLStore(session, urlname);
        store.connect();
        System.out.println("Connection establised");
       }
    private void connectToGmailPOP3() throws MessagingException
    {
           System.out.println("connectToGmailPOP3 called");
        protocol="pop3";
        url="pop.gmail.com";
        Properties pop3Props = new Properties();
        pop3Props.setProperty("mail.pop3.port",  "995");
        pop3Props.setProperty("mail.pop3.socketFactory.port", "995");

        URLName urlname = new URLName(protocol,url, 995, "",
                user_name, password);

        session = Session.getInstance(pop3Props, null);
        store = new POP3SSLStore(session, urlname);
        store.connect();
        System.out.println("Connection establised");
       }

    
    private void connectToYahooPOP3() throws MessagingException
    {
        //port 110;
        System.out.println("connectToYahooPOP3 called");
         String SSL_FACTORY = "javax.net.ssl.SSLSocketFactory";
        url="pop.mail.yahoo.com";
        protocol="pop3";
        Properties prop = new Properties();
          //  prop.setProperty("mail.pop3.socketFactory.class",
          //                              "javax.net.ssl.SSLSocketFactory");
           // prop.setProperty("mail.pop3.socketFactory.fallback", "false");
            prop.setProperty("mail.pop3.port", "110");
            prop.setProperty("mail.pop3.socketFactory.port", "110");

            prop.put("mail.pop3.host", url);
            prop.put("mail.store.protocol", "pop3");
            session = Session.getDefaultInstance(prop,null);
            store = session.getStore();
            store.connect(url,user_name,password);

        System.out.println("Connection establised");
    }



    private void defaultSettingCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_defaultSettingCheckBoxActionPerformed
        // TODO add your handling code here:
        if(defaultSettingCheckBox.isSelected())
        {
            incommingMailServerLebel.setEnabled(false);
            incommingMailServerTextFiled.setEnabled(false);

        }
        else{
            incommingMailServerLebel.setEnabled(true);
            incommingMailServerTextFiled.setEnabled(true);
            CustomizedSetting customizedSetting =new CustomizedSetting();
            customizedSetting.setVisible(true);
        }
    }//GEN-LAST:event_defaultSettingCheckBoxActionPerformed

    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MailSetupPanel().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox acountTypeComboBox;
    private javax.swing.JButton b_ok;
    private javax.swing.JCheckBox defaultSettingCheckBox;
    private javax.swing.JLabel incommingMailServerLebel;
    private javax.swing.JTextField incommingMailServerTextFiled;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPasswordField pf_password;
    private javax.swing.JComboBox protocolComboBox;
    private javax.swing.JTextField tf_user_name;
    // End of variables declaration//GEN-END:variables

}