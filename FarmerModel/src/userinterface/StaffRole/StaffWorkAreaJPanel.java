/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.StaffRole;

import userinterface.CustomerRole.*;
import Business.EcoSystem;
import Business.Enterprise.*;
import Business.Enterprise.USFDEnterprise;
import Business.Network.Network;
import Business.Organization.*;
import Business.Produce.Produce;
import Business.Produce.ProduceDirectory;
import Business.ProduceReview.ProduceReview;
import Business.ProduceReview.ProduceReviewDirectory;
import Business.RawMaterialReview.RawMaterialReview;
import Business.RawMaterialReview.RawMaterialReviewDirectory;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.*;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.ListSelectionModel;
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import sun.applet.AppletViewer;
import static userinterface.WarehouseManagerRole.WarehouseWorkAreaJPanel.flag;

/**
 *
 * @author raunak
 */
public class StaffWorkAreaJPanel extends javax.swing.JPanel {

    private JPanel userProcessContainer;
    private StaffOrganization organization;
    private USFDEnterprise enterprise;
    private UserAccount userAccount;
    private ProduceDirectory produceDirectory;
    private ProduceReviewDirectory prDirectory;
    private RawMaterialReviewDirectory rmrDirectory;
    

    /**
     * Creates new form DoctorWorkAreaJPanel
     */
    private EcoSystem business;
    /**
     * Creates new form DoctorWorkAreaJPanel
     */
    public StaffWorkAreaJPanel(JPanel userProcessContainer, UserAccount account, StaffOrganization organization, Enterprise enterprise,EcoSystem business,ProduceDirectory produceDirectory,ProduceReviewDirectory prDirectory,RawMaterialReviewDirectory rmrDirectory ) {
        initComponents();
        
        this.userProcessContainer = userProcessContainer;
        this.organization = organization;
        this.enterprise = (USFDEnterprise)enterprise;
        this.userAccount = account;
        this.business = business;
        this.produceDirectory = produceDirectory;
        this.prDirectory = prDirectory;
        this.rmrDirectory = rmrDirectory;
        
        valueLabel.setText(enterprise.getName());
        populateCustomerRequestTable();
        populateProduceTable();
        populateCustomerReviewTable();
        populateSupplierReviewTable();
        
        
        
        if (flag == true)
        {  
            sendToFarmerJButton.setEnabled(true);
            sendToWarehouseJButton.setEnabled(false);
        }
        

    }
    
     public void populateSupplierReviewTable(){
        DefaultTableModel model = (DefaultTableModel)supplierReviewTable.getModel();
        
        model.setRowCount(0);
        
        for(RawMaterialReview review : rmrDirectory.getRawMaterialReviewList()){
            Object[] row = new Object[6];
            row[0] = review;
            row[1] = review.getSupplierName();
            row[2] = review.getProduceQuality();
            row[3] = review.getProduceShelfLife();
            row[4] = review.getAdditionalReviews();
            
            model.addRow(row);
        }
        
    }

    
    public void populateCustomerReviewTable(){
        DefaultTableModel model = (DefaultTableModel)customerReviewTable.getModel();
        
        model.setRowCount(0);
        
        for(ProduceReview review : prDirectory.getProduceReviewList()){
            Object[] row = new Object[6];
            row[0] = review;
            row[1] = review.getFarmerName();
            row[2] = review.getProduceQuality();
            row[3] = review.getProduceShelfLife();
            row[4] = review.getAdditionalReviews();
            
            model.addRow(row);
        }
        
    }

    public void populateCustomerRequestTable(){
     DefaultTableModel model = (DefaultTableModel)workRequestJTable1.getModel();
        
        model.setRowCount(0);
        
        for(WorkRequest request : organization.getWorkQueue().getWorkRequestList()){
            Object[] row = new Object[6];
            row[0] = request;
            row[1] = request.getSender().getEmployee().getName();
            row[2] = request.getReceiver() == null ? null : request.getReceiver().getEmployee().getName();
            row[3] = request.getStatus();
            row[4] = request.getCropQty();
            row[5] = request.getRawMaterialQty();
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

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        supplierReviewTable = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane7 = new javax.swing.JScrollPane();
        customerReviewTable = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        lineBtn = new javax.swing.JButton();
        barBtn = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        workRequestJTable1 = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        produceTable = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        sendToFarmerJButton = new javax.swing.JButton();
        sendToWarehouseJButton = new javax.swing.JButton();
        sendToSupp = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        refreshJButton = new javax.swing.JButton();
        valueLabel = new javax.swing.JLabel();
        enterpriseLabel = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        customerReviewTable1 = new javax.swing.JTable();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        supplierReviewTable.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        supplierReviewTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Raw Material", "Supplier Name", "Quality Review", "Shelf Life Review", "Additional Review"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(supplierReviewTable);

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setText("Customer Reviews");

        customerReviewTable.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        customerReviewTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Crop Name", "Farmer Name", "Quality Review", "Shelf Life Review", "Additional Review"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane7.setViewportView(customerReviewTable);

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setText("Farmer Reviews");

        lineBtn.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lineBtn.setText("Line Chart");
        lineBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lineBtnActionPerformed(evt);
            }
        });

        barBtn.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        barBtn.setText("Bar Chart");
        barBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                barBtnActionPerformed(evt);
            }
        });

        workRequestJTable1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        workRequestJTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Message", "Sender", "Receiver", "Status", "Crop Quantity", "Raw Material Quantity"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        workRequestJTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                workRequestJTable1MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(workRequestJTable1);
        if (workRequestJTable1.getColumnModel().getColumnCount() > 0) {
            workRequestJTable1.getColumnModel().getColumn(0).setResizable(false);
            workRequestJTable1.getColumnModel().getColumn(1).setResizable(false);
            workRequestJTable1.getColumnModel().getColumn(2).setResizable(false);
            workRequestJTable1.getColumnModel().getColumn(3).setResizable(false);
            workRequestJTable1.getColumnModel().getColumn(4).setResizable(false);
            workRequestJTable1.getColumnModel().getColumn(5).setResizable(false);
        }

        produceTable.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        produceTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Crop Name", "Quantity", "Price", "Farmer"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(produceTable);
        if (produceTable.getColumnModel().getColumnCount() > 0) {
            produceTable.getColumnModel().getColumn(0).setResizable(false);
            produceTable.getColumnModel().getColumn(1).setResizable(false);
            produceTable.getColumnModel().getColumn(2).setResizable(false);
        }

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel5.setText("Produce Inventory");

        sendToFarmerJButton.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        sendToFarmerJButton.setText("Send to Farmer");
        sendToFarmerJButton.setEnabled(false);
        sendToFarmerJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sendToFarmerJButtonActionPerformed(evt);
            }
        });

        sendToWarehouseJButton.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        sendToWarehouseJButton.setText("Send to Warehouse Manager");
        sendToWarehouseJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sendToWarehouseJButtonActionPerformed(evt);
            }
        });

        sendToSupp.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        sendToSupp.setText("Send to Supplier");
        sendToSupp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sendToSuppActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Customer Request");

        refreshJButton.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        refreshJButton.setText("Refresh");
        refreshJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshJButtonActionPerformed(evt);
            }
        });

        enterpriseLabel.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        enterpriseLabel.setText("EnterPrise :");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Staff");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jScrollPane7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 730, Short.MAX_VALUE)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.LEADING))
                                .addGap(85, 85, 85)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(lineBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(barBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(365, 365, 365)
                        .addComponent(sendToSupp, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(53, 53, 53)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                    .addComponent(sendToFarmerJButton, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(refreshJButton, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(95, 95, 95)
                                    .addComponent(sendToWarehouseJButton))
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 835, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel1)
                                    .addGap(372, 372, 372)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(enterpriseLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(valueLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(334, 334, 334))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(351, 351, 351)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(261, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jLabel6)
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(enterpriseLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(valueLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(sendToFarmerJButton)
                    .addComponent(sendToWarehouseJButton)
                    .addComponent(refreshJButton))
                .addGap(18, 18, 18)
                .addComponent(sendToSupp)
                .addGap(31, 31, 31)
                .addComponent(jLabel5)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(lineBtn)
                        .addGap(16, 16, 16)
                        .addComponent(barBtn)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addGap(6, 6, 6)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(25, Short.MAX_VALUE))
        );

        add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1210, 820));

        customerReviewTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Crop Name", "Farmer Name", "Quality Review", "Shelf Life Review", "Additional Review"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane6.setViewportView(customerReviewTable1);

        add(jScrollPane6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 580, 730, 210));
    }// </editor-fold>//GEN-END:initComponents

    private void refreshJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshJButtonActionPerformed
        populateCustomerRequestTable();
    }//GEN-LAST:event_refreshJButtonActionPerformed

    private void sendToFarmerJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sendToFarmerJButtonActionPerformed
        // TODO add your handling code here:
        int selectedRow = workRequestJTable1.getSelectedRow();
        
        if (selectedRow < 0){
            return;
        }
        
        ProduceRequest request = (ProduceRequest)workRequestJTable1.getValueAt(selectedRow, 0);
        request.setStatus("sent to farmer ");
        populateCustomerRequestTable();
        userAccount.getWorkQueue().getWorkRequestList().add(request);
        
        Organization org = null;
        for (Organization organization : enterprise.getOrganizationDirectory().getOrganizationList()){
            if (organization instanceof FarmerOrganization){
                org = organization;
                break;
            }
        }
        if (org!=null){
            org.getWorkQueue().getWorkRequestList().add(request);
        }
        
    }//GEN-LAST:event_sendToFarmerJButtonActionPerformed

    private void sendToWarehouseJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sendToWarehouseJButtonActionPerformed
        // TODO add your handling code here:
      int selectedRow = workRequestJTable1.getSelectedRow();
        
        if (selectedRow < 0){
            return;
        }
        
        ProduceRequest request = (ProduceRequest)workRequestJTable1.getValueAt(selectedRow, 0);
        request.setStatus("sent to warehouse");
        populateCustomerRequestTable();
        userAccount.getWorkQueue().getWorkRequestList().add(request);
        
        Organization org = null;
        for (Organization organization : enterprise.getOrganizationDirectory().getOrganizationList()){
            if (organization instanceof WarehouseOrganization){
                org = organization;
                break;
            }
            else if (organization instanceof WarehouseOrganization){
                org = organization;
                break;
            }
        }
        if (org!=null){
            org.getWorkQueue().getWorkRequestList().add(request);
        }
        
        
         sendToWarehouseJButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                    JButton source = (JButton) e.getSource();
                    source.setEnabled(false);
                    source.setBackground(Color.GREEN);
            }
    });
    }//GEN-LAST:event_sendToWarehouseJButtonActionPerformed
    
    private void sendToSupplierJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sendToSupplierJButtonActionPerformed
        int selectedRow = workRequestJTable1.getSelectedRow();
        
        if (selectedRow < 0){
            return;
        }
        
        ProduceRequest request = (ProduceRequest)workRequestJTable1.getValueAt(selectedRow, 0);
        request.setStatus("sent to Manufacturer.Supplier ");
        populateCustomerRequestTable();
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

    private void sendToSuppActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sendToSuppActionPerformed
         int selectedRow = workRequestJTable1.getSelectedRow();
        
        if (selectedRow < 0){
            return;
        }
        
        ProduceRequest request = (ProduceRequest)workRequestJTable1.getValueAt(selectedRow, 0);
        request.setStatus("sent to supplier ");
        populateCustomerRequestTable();
        userAccount.getWorkQueue().getWorkRequestList().add(request);
        
        Organization org = null;
        for (Network network: business.getNetworkList()){
               
            for (Enterprise e: network.getEnterpriseDirectory().getEnterpriseList())
            {   
                
                if (e instanceof ManufacturerEnterprise)
                {
                   for (Organization organization : e.getOrganizationDirectory().getOrganizationList()){
            
            if (organization instanceof ManufacturerSupplierOrganization){
                org = organization;
                System.out.println(org);
                break;
            }
        }
            if (org!=null){
            org.getWorkQueue().getWorkRequestList().add(request);
            } 
                }
                
            }
        }
        
    }//GEN-LAST:event_sendToSuppActionPerformed

    private void workRequestJTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_workRequestJTable1MouseClicked
       disableWarehouseButton();
    }//GEN-LAST:event_workRequestJTable1MouseClicked

    private void barBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_barBtnActionPerformed
         DefaultCategoryDataset dataset = new DefaultCategoryDataset();
         int j= 0;
        
         for (j=0;j<workRequestJTable1.getRowCount();j++)
        {
            if (!(Integer.parseInt(String.valueOf(workRequestJTable1.getModel().getValueAt(j,4))) == 0))
            {
                String tempName = workRequestJTable1.getModel().getValueAt(j,0).toString();
            dataset.setValue(Integer.parseInt(String.valueOf(workRequestJTable1.getModel().getValueAt(j,4))), "CROPS", tempName);
            //System.out.println(dataset);
        }
        }
        
      
        JFreeChart chart = ChartFactory.createBarChart3D("DEMAND ANALYSIS REPORT","CROPS", "QUANTITY", dataset, PlotOrientation.VERTICAL, false, true, false);
        
        CategoryPlot barchart = chart.getCategoryPlot();
        barchart.setRangeGridlinePaint(Color.black);
        ChartFrame frame = new ChartFrame("Bar chart" , chart);
        frame.setVisible(true);
        frame.setSize(500,500);
        
        
    }//GEN-LAST:event_barBtnActionPerformed

    private void lineBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lineBtnActionPerformed
           DefaultCategoryDataset dataset = new DefaultCategoryDataset();
         int j= 0;
        
         for (j=0;j<workRequestJTable1.getRowCount();j++)
        {
            if (!(Integer.parseInt(String.valueOf(workRequestJTable1.getModel().getValueAt(j,4))) == 0))
            {   String tempName = workRequestJTable1.getModel().getValueAt(j,0).toString();
            dataset.setValue(Integer.parseInt(String.valueOf(workRequestJTable1.getModel().getValueAt(j,4))), "CROPS", tempName);
            //System.out.println(dataset);
        }
        }
        
      
        JFreeChart chart = ChartFactory.createLineChart3D("DEMAND ANALYSIS REPORT","CROPS", "QUANTITY", dataset, PlotOrientation.VERTICAL, false, true, false);
        
        CategoryPlot barchart = chart.getCategoryPlot();
        barchart.setRangeGridlinePaint(Color.black);
        ChartFrame frame = new ChartFrame("Bar chart" , chart);
        frame.setVisible(true);
        frame.setSize(500,500);
    }//GEN-LAST:event_lineBtnActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton barBtn;
    private javax.swing.JTable customerReviewTable;
    private javax.swing.JTable customerReviewTable1;
    private javax.swing.JLabel enterpriseLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JButton lineBtn;
    private javax.swing.JTable produceTable;
    private javax.swing.JButton refreshJButton;
    private javax.swing.JButton sendToFarmerJButton;
    private javax.swing.JButton sendToSupp;
    private javax.swing.JButton sendToWarehouseJButton;
    private javax.swing.JTable supplierReviewTable;
    private javax.swing.JLabel valueLabel;
    private javax.swing.JTable workRequestJTable1;
    // End of variables declaration//GEN-END:variables

    private void populateProduceTable() {
        DefaultTableModel model = (DefaultTableModel)produceTable.getModel();
        
        model.setRowCount(0);
        
        for(Produce produce : produceDirectory.getProduceList()){
            Object[] row = new Object[4];
            row[0] = produce;
            row[1] = produce.getCropQuantity();
            row[2] = produce.getCropPrice();
            //row[3] = userAccount.getUsername();
            row[3] = produce.getFarmerName();
            model.addRow(row);
            
        }
        checkforProduce();
    }
    
             

    private void checkforProduce() {
        
        int i = 1;
        
        for (int j = 0; j < produceTable.getRowCount(); j++) {
           int tempQuantity = Integer.parseInt((String.valueOf(produceTable.getModel().getValueAt(j, i)))) ;
            if(tempQuantity == 0){
                  int delay = 4000; //milliseconds
            ActionListener taskPerformer = new ActionListener() {
                public void actionPerformed(ActionEvent evt) {
                JOptionPane.showMessageDialog(null,"Send produce request for" + "to farmer");
      }
  };
                Timer myTimer = new Timer(delay, taskPerformer);
                myTimer.setRepeats(false);
                myTimer.start();
                //JOptionPane.showMessageDialog(null,"Send produce request to farmer");
            }
        }
    }

    private void disableWarehouseButton() {
        int selectedRow = workRequestJTable1.getSelectedRow();
        String requestedCrop = workRequestJTable1.getModel().getValueAt(selectedRow, 0).toString();
        int i = 0;
        String tempName = null;
        for(int j = 0;j < produceTable.getRowCount(); j++) {
            tempName = produceTable.getModel().getValueAt(j, i).toString();
             //System.out.println(tempName);
                if(!(tempName.equals(requestedCrop))){
               continue; 
                }
                else {sendToWarehouseJButton.setEnabled(true);}
        }
        }
    
    
}
