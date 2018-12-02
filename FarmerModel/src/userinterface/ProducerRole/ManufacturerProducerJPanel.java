/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.ProducerRole;

import userinterface.*;
import userinterface.SupplierRole.*;
import userinterface.StaffRole.*;
import userinterface.CustomerRole.*;
import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Enterprise.ManufacturerEnterprise;
import Business.Organization.*;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.*;
import java.awt.CardLayout;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author raunak
 */
public class ManufacturerProducerJPanel extends javax.swing.JPanel {

    private JPanel userProcessContainer;
    private ManufacturerProductionOrganization organization;
    private ManufacturerEnterprise enterprise;
    private UserAccount userAccount;

    /**
     * Creates new form DoctorWorkAreaJPanel
     */
    private EcoSystem business;
    /**
     * Creates new form DoctorWorkAreaJPanel
     */
    public ManufacturerProducerJPanel(JPanel userProcessContainer, UserAccount account, ManufacturerProductionOrganization organization, Enterprise enterprise,EcoSystem business) {
        initComponents();
        
        this.userProcessContainer = userProcessContainer;
        this.organization = organization;
        this.enterprise = (ManufacturerEnterprise)enterprise;
        this.userAccount = account;
        this.business = business;
        valueLabel.setText(enterprise.getName());
        populateSuppRequestTable();
      
        
    }


    public void populateSuppRequestTable(){
    DefaultTableModel model = (DefaultTableModel)workRequestRMJTable.getModel();
        
        model.setRowCount(0);
        
        for(WorkRequest request : organization.getWorkQueue().getWorkRequestList()){
            Object[] row = new Object[4];
            row[0] = request;
            row[1] = request.getSender().getEmployee().getName();
            row[2] = request.getReceiver() == null ? null : request.getReceiver().getEmployee().getName();
            row[3] = request.getStatus();
            
            model.addRow(row);
        }
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        enterpriseLabel = new javax.swing.JLabel();
        valueLabel = new javax.swing.JLabel();
        refreshJButton = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        workRequestRMJTable = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        processJButton = new javax.swing.JButton();
        assignJButton = new javax.swing.JButton();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        enterpriseLabel.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        enterpriseLabel.setText("EnterPrise :");
        add(enterpriseLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(21, 27, 127, 30));

        valueLabel.setText("<value>");
        add(valueLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(178, 27, 158, 26));

        refreshJButton.setText("Refresh");
        refreshJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshJButtonActionPerformed(evt);
            }
        });
        add(refreshJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(528, 90, -1, -1));

        workRequestRMJTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Message", "Sender", "Receiver", "Status"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, true, true, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(workRequestRMJTable);

        add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(194, 133, 375, 96));

        jLabel1.setText("Customer Request");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(147, 94, -1, -1));

        processJButton.setText("Process");
        processJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                processJButtonActionPerformed(evt);
            }
        });
        add(processJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 270, -1, -1));

        assignJButton.setText("Assign to me");
        assignJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                assignJButtonActionPerformed(evt);
            }
        });
        add(assignJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 270, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void refreshJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshJButtonActionPerformed
        populateSuppRequestTable();
    }//GEN-LAST:event_refreshJButtonActionPerformed

    private void sendToSupplierJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sendToSupplierJButtonActionPerformed
        int selectedRow = workRequestRMJTable.getSelectedRow();
        
        if (selectedRow < 0){
            return;
        }
        
        ProduceRequest request = (ProduceRequest)workRequestRMJTable.getValueAt(selectedRow, 0);
        request.setStatus("sent to Manufacturer.Supplier ");
        populateSuppRequestTable();
        userAccount.getWorkQueue().getWorkRequestList().add(request);
        
        Organization org = null;
        for (Organization organization : enterprise.getOrganizationDirectory().getOrganizationList()){
            if (organization instanceof ManufacturerSupplierOrganization){
                org = organization;
                break;
            }
        }
        if (org!=null){
            org.getWorkQueue().getWorkRequestList().add(request);
        }
        
    }//GEN-LAST:event_sendToSupplierJButtonActionPerformed

    private void processJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_processJButtonActionPerformed

        int selectedRow = workRequestRMJTable.getSelectedRow();

        if (selectedRow < 0){
            return;
        }

        ProduceRequest request = (ProduceRequest)workRequestRMJTable.getValueAt(selectedRow, 0);

        request.setStatus("Processing");

        ProcessProduceRequestRMJPanel processWorkRequestJPanel = new ProcessProduceRequestRMJPanel(userProcessContainer, request);
        userProcessContainer.add("ProcessProduceRequestRMJPanel", processWorkRequestJPanel);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);

    }//GEN-LAST:event_processJButtonActionPerformed

    private void assignJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_assignJButtonActionPerformed

        int selectedRow = workRequestRMJTable.getSelectedRow();

        if (selectedRow < 0){
            return;
        }

        WorkRequest request = (WorkRequest)workRequestRMJTable.getValueAt(selectedRow, 0);
        request.setReceiver(userAccount);
        request.setStatus("Pending");
        populateSuppRequestTable();

    }//GEN-LAST:event_assignJButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton assignJButton;
    private javax.swing.JLabel enterpriseLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton processJButton;
    private javax.swing.JButton refreshJButton;
    private javax.swing.JLabel valueLabel;
    private javax.swing.JTable workRequestRMJTable;
    // End of variables declaration//GEN-END:variables
}
