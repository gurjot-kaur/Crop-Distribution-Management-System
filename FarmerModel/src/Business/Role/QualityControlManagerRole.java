/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Role;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Enterprise.USFDEnterprise;
import Business.Organization.FarmerOrganization;
import Business.Organization.Organization;
import Business.Produce.ProduceDirectory;
import Business.UserAccount.UserAccount;
import javax.swing.JPanel;
import userinterface.FarmerRole.FarmerWorkAreaJPanel;
import userinterface.QualityControlManagerRole.QualityControlWorkAreaJPanel;

/**
 *
 * @author gurjo
 */
public class QualityControlManagerRole extends Role {
    
     @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise, EcoSystem business,ProduceDirectory produceDirectory) {
        return new QualityControlWorkAreaJPanel(userProcessContainer,account, (FarmerOrganization)organization,(USFDEnterprise)enterprise,business);

    }
}
