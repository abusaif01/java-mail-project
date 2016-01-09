
import java.awt.GridLayout;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.MessagingException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.table.TableColumn;
import java.awt.event.*;
import javax.mail.Store;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * MailList1.java
 *
 * Created on Mar 7, 2011, 2:19:00 AM
 */

/**
 *
 * @author SWORD
 */
public class MailList1 extends javax.swing.JFrame {

    /** Creates new form MailList1 */
    private  int totalmsg,newmsg;
    int  row=10;
    MailHandler smHandler;
    public MailList1() {
     
        
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    public void showMailList(Store store)
    {
       // totalmsg=10;
        smHandler = new MailHandler(store);
        smHandler.openFolder("INBOX");
        try
        {
            totalmsg = smHandler.getMessageCount();
            newmsg = smHandler.getNewMessageCount();
            initComponents();
            TableColumn tableColumnSettings0=jt_mailList.getTableHeader().getColumnModel().getColumn(0);

           // int width;
           // width=tableColumnSettings0.getWidth();

            tableColumnSettings0.setMaxWidth(200);
            tableColumnSettings0.setMinWidth(180);
       
           // width=tableColumnSettings0.getWidth();
           // System.out.println(width);
          //  TableColumn tableColumnSettings1=jt_mailList.getTableHeader().getColumnModel().getColumn(1);
          //  width=tableColumnSettings1.getWidth();
          //  System.out.println(width);
            System.out.println(totalmsg + " "+newmsg);
            tf_inbox.setText("Inbox("+totalmsg+"/"+newmsg+")");
            try {
                smHandler.parseMessages(false);
            } catch (IOException ex) {
                Logger.getLogger(MailList1.class.getName()).log(Level.SEVERE, null, ex);
            } catch (Exception ex) {
                Logger.getLogger(MailList1.class.getName()).log(Level.SEVERE, null, ex);
            }

            System.out.println("going to print from and subject in maillist");
            for(int i=0;i<totalmsg;i++)
            {
                jt_mailList.setValueAt(smHandler.from.getItem(i),i, 0);
                jt_mailList.setValueAt(smHandler.subject.getItem(i),i, 1);
            System.out.println("Massage "+(i+1)+" #: "+smHandler.from.getItem(i)+"  :: "+smHandler.subject.getItem(i));
            }
               System.out.println("complete printing");

           // smHandler.closeFolder();

        }
        catch(MessagingException ex)
        {
           // Logger.getLogger(MailViewPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
       

    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jProgressBar1 = new javax.swing.JProgressBar();
        tf_inbox = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jt_mailList = new javax.swing.JTable();
        openMailButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tf_inbox.setText("Inbox()");

        jt_mailList.setModel(new javax.swing.table.DefaultTableModel(
            new String [] {
                "From", "Subject"
            },totalmsg
        ));
        jScrollPane1.setViewportView(jt_mailList);

        openMailButton.setText("Open Mail");
        openMailButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                openMailButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(tf_inbox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 343, Short.MAX_VALUE)
                .addComponent(openMailButton)
                .addContainerGap())
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 474, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tf_inbox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(openMailButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 361, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void openMailButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_openMailButtonActionPerformed
        // TODO add your handling code here:

       int index;
       index=jt_mailList.getSelectedRow();
       System.out.println(index);
       MailViewPanel mp=new MailViewPanel();
       smHandler.getDetailMsg(index, mp);
//       frame= new JFrame("Detail Mail");
//       frame.setLayout(new GridLayout(1,2));
//        frame.setSize(1000,800);
      /*  JButton closeButton=new JButton("Close");
        closeButton.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent e)
            {
            frame.dispose();
        }

        }); */
        mp.setTextFieldFrom(smHandler.from.getItem(index));
        mp.setTextFieldSubject(smHandler.subject.getItem(index));
        mp.setTextFieldTO(smHandler.to.getItem(index));
        mp.setVisible(true);
       // frame.add(closeButton);
    }//GEN-LAST:event_openMailButtonActionPerformed
    


    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
             //  MailList1 mls = new MailList1();
              // mls.showMailList("aa", "sss");
              // mls.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jt_mailList;
    private javax.swing.JButton openMailButton;
    private javax.swing.JTextField tf_inbox;
    // End of variables declaration//GEN-END:variables

}
