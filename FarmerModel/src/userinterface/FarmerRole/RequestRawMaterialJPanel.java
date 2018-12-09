/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.FarmerRole;

import userinterface.CustomerRole.*;
import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Organization.FarmerOrganization;
import Business.Organization.Organization;
import Business.Organization.StaffOrganization;
import Business.Produce.Produce;
import Business.Produce.ProduceDirectory;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.ProduceRequest;
import java.awt.CardLayout;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author raunak
 */
public class RequestRawMaterialJPanel extends javax.swing.JPanel {

    private JPanel userProcessContainer;
    private Enterprise enterprise;
    private UserAccount userAccount;
     private ProduceDirectory produceDirectory;
    
    /**
     * Creates new form RequestLabTestJPanel
     */
    public RequestRawMaterialJPanel(JPanel userProcessContainer, UserAccount account, Enterprise enterprise,ProduceDirectory produceDirectory) {
        initComponents();
        
        this.userProcessContainer = userProcessContainer;
        this.enterprise = enterprise;
        this.userAccount = account;
        this.produceDirectory = produceDirectory;
        valueLabel.setText(enterprise.getName());
        populateCropCombo();
        populateRMCombo();


       
                }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        requestTestJButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        messageJTextField = new javax.swing.JTextField();
        backJButton = new javax.swing.JButton();
        valueLabel = new javax.swing.JLabel();
        enterpriseLabel = new javax.swing.JLabel();
        cropCombo = new javax.swing.JComboBox();
        rmCoboBox = new javax.swing.JComboBox();
        jButton1 = new javax.swing.JButton();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        requestTestJButton.setText("Request Test");
        requestTestJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                requestTestJButtonActionPerformed(evt);
            }
        });
        add(requestTestJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 140, -1, -1));

        jLabel1.setText("Message");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(96, 40, -1, -1));
        add(messageJTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 37, 89, -1));

        backJButton.setText("<<Back");
        backJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backJButtonActionPerformed(evt);
            }
        });
        add(backJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(69, 138, -1, -1));

        valueLabel.setText("<value>");
        add(valueLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 10, 130, -1));

        enterpriseLabel.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        enterpriseLabel.setText("EnterPrise :");
        add(enterpriseLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 120, 30));

        add(cropCombo, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 80, 90, -1));

        rmCoboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rmCoboBoxActionPerformed(evt);
            }
        });
        add(rmCoboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 40, 60, -1));

        jButton1.setText("RefreshRM");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 80, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void requestTestJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_requestTestJButtonActionPerformed
        
        //String message = messageJTextField.getText();
        //int materialQuantity = Integer.parseInt(messageJTextField.getText());
        
        String message = (String) rmCoboBox.getSelectedItem();
        String rawMaterial = (String) cropCombo.getSelectedItem();
        if(rawMaterial.equalsIgnoreCase("rice") && message.equalsIgnoreCase("food scraps")){
            JOptionPane.showMessageDialog(null,"Not a suitable raw material for rice");
           
        } 
        ProduceRequest request = new ProduceRequest();
        request.setMessage(message);
        request.setSender(userAccount);
        request.setStatus("Sent");
        request.setRawMaterialQty(Integer.parseInt(messageJTextField.getText()));

        Organization org = null;
        for (Organization organization : enterprise.getOrganizationDirectory().getOrganizationList()){
            if (organization instanceof StaffOrganization){
                org = organization;
                break;
            }
        }
        if (org!=null){
            org.getWorkQueue().getWorkRequestList().add(request);
            userAccount.getWorkQueue().getWorkRequestList().add(request);
        }
        
    }//GEN-LAST:event_requestTestJButtonActionPerformed

    private void backJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backJButtonActionPerformed
        
        userProcessContainer.remove(this);
        Component[] componentArray = userProcessContainer.getComponents();
        Component component = componentArray[componentArray.length - 1];
        FarmerWorkAreaJPanel cwjp = (FarmerWorkAreaJPanel) component;
        cwjp.populateRequestRMTable();
        CardLayout layout = (CardLayout)userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
        
    }//GEN-LAST:event_backJButtonActionPerformed

    private void rmCoboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rmCoboBoxActionPerformed
        
    }//GEN-LAST:event_rmCoboBoxActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
    populateRMCombo();        
    }//GEN-LAST:event_jButton1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backJButton;
    private javax.swing.JComboBox cropCombo;
    private javax.swing.JLabel enterpriseLabel;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JTextField messageJTextField;
    private javax.swing.JButton requestTestJButton;
    private javax.swing.JComboBox rmCoboBox;
    private javax.swing.JLabel valueLabel;
    // End of variables declaration//GEN-END:variables

    private void populateCropCombo() {
        for(Produce produce: produceDirectory.getProduceList())
        {
            Object row[] = new Object[2];
            row[0]= produce.getCropName();

            cropCombo.addItem(row[0]);     
        }
            
    }

    private void populateRMCombo() {
        rmCoboBox.removeAllItems();
        String crop = (String) cropCombo.getSelectedItem();
        String rawMaterial = (String) rmCoboBox.getSelectedItem();
        
        if (crop.equalsIgnoreCase("rice"))
        {
            rmCoboBox.removeAllItems();
            rmCoboBox.addItem("grass clippings");
            rmCoboBox.addItem("food scraps");
            rmCoboBox.addItem("Pest A");
        }
        
        else if (crop.equalsIgnoreCase("potato"))
        {   
            rmCoboBox.removeAllItems();
            rmCoboBox.addItem("abc");
        }
        else if (crop.equalsIgnoreCase("tomato"))
        {   
            rmCoboBox.removeAllItems();
            rmCoboBox.addItem("Pest A");
            rmCoboBox.addItem("Pest B");
            rmCoboBox.addItem("Pest C");    
        }
        else if (crop.equalsIgnoreCase("wheat"))
        {   
            rmCoboBox.removeAllItems();
            rmCoboBox.addItem("Pest A");
            rmCoboBox.addItem("Pest B");
            rmCoboBox.addItem("Pest C");    
        }
        else if (crop.equalsIgnoreCase("carrot"))
        {   
            rmCoboBox.removeAllItems();
            rmCoboBox.addItem("Pest A");
            rmCoboBox.addItem("Pest B");
            rmCoboBox.addItem("Pest C");    
        }
        else if (crop.equalsIgnoreCase("cucumber"))
        {   
            rmCoboBox.removeAllItems();
            rmCoboBox.addItem("Pest A");
            rmCoboBox.addItem("Pest B");
            rmCoboBox.addItem("Pest C");    
        }
        
        
        //populateRMCombo();
    }

   
}
