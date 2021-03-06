
import java.io.IOException;
import java.net.ConnectException;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.event.HyperlinkEvent;
import javax.swing.text.html.HTMLDocument;
import javax.swing.text.html.HTMLFrameHyperlinkEvent;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * BrowserPanel.java
 *
 * Created on Mar 1, 2011, 11:46:40 AM
 */

/**
 *
 * @author Md. Salahuddin
 */
public class BrowserPanel extends javax.swing.JPanel {

    /** Creates new form BrowserPanel */
    public BrowserPanel(URL url) {
        initComponents();
        addressBar.setText(url.toString());
        try
        {
            jEditorPane1.setPage(url);
        }
        catch(IOException ex)
        {
            Logger.getLogger(BrowserPanel.class.getName()).log(Level.SEVERE, null, ex);
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

        jLabel1 = new javax.swing.JLabel();
        addressBar = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jEditorPane1 = new javax.swing.JEditorPane();
        backToMailButton = new javax.swing.JButton();
        backButton = new javax.swing.JButton();
        forwardButton = new javax.swing.JButton();

        jLabel1.setText("Address");

        addressBar.setEditable(false);

        jEditorPane1.setContentType("text/html");
        jEditorPane1.setEditable(false);
        jEditorPane1.addHyperlinkListener(new javax.swing.event.HyperlinkListener() {
            public void hyperlinkUpdate(javax.swing.event.HyperlinkEvent evt) {
                jEditorPane1HyperlinkUpdate(evt);
            }
        });
        jScrollPane1.setViewportView(jEditorPane1);

        backToMailButton.setText("Exit");

        backButton.setText("<");
        backButton.setEnabled(false);

        forwardButton.setText(">");
        forwardButton.setEnabled(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 514, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(backButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(forwardButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(addressBar, javax.swing.GroupLayout.DEFAULT_SIZE, 367, Short.MAX_VALUE))
                    .addComponent(backToMailButton))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addressBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(backButton)
                    .addComponent(forwardButton)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 370, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(backToMailButton)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jEditorPane1HyperlinkUpdate(javax.swing.event.HyperlinkEvent evt)//GEN-FIRST:event_jEditorPane1HyperlinkUpdate
    {//GEN-HEADEREND:event_jEditorPane1HyperlinkUpdate
        // TODO add your handling code here:
        HyperlinkEvent.EventType eventType = evt.getEventType();
        if (eventType == HyperlinkEvent.EventType.ACTIVATED) {
            if (evt instanceof HTMLFrameHyperlinkEvent) {
                HTMLFrameHyperlinkEvent linkEvent =
                        (HTMLFrameHyperlinkEvent) evt;
                HTMLDocument document =
                        (HTMLDocument) jEditorPane1.getDocument();
                document.processHTMLFrameHyperlinkEvent(linkEvent);
            } else {
                try
                {
                    jEditorPane1.setPage(evt.getURL());
                    addressBar.setText(evt.getURL().toString());
                }
                catch(ConnectException ex)
                {
                    jEditorPane1.setText("<b><center><font size='20'>Unable to connect</font></center></b>");
                    Logger.getLogger(MailViewPanel.class.getName()).log(Level.SEVERE, null, ex);
                }
                catch(UnknownHostException ex)
                {
                    jEditorPane1.setText("<b><center><font size='20'>Unknown Host</font></center></b>");
                    Logger.getLogger(MailViewPanel.class.getName()).log(Level.SEVERE, null, ex);
                }
                catch(IOException ex)
                {
                    Logger.getLogger(MailViewPanel.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }//GEN-LAST:event_jEditorPane1HyperlinkUpdate


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField addressBar;
    private javax.swing.JButton backButton;
    private javax.swing.JButton backToMailButton;
    private javax.swing.JButton forwardButton;
    private javax.swing.JEditorPane jEditorPane1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables

}
