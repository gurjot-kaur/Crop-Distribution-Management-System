/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Role;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Entities.Produce;
import Business.Entities.ProduceDirectory;
import Business.Organization.FarmerOrganization;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import java.util.ArrayList;
import javax.swing.JPanel;
import userinterface.FarmerRole.FarmerWorkAreaPanel;

/**
 *
 * @author gurjo
 */
public class FarmerRole extends Role {
    
    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise, EcoSystem business, ProduceDirectory produceDirectory) {
        return new FarmerWorkAreaPanel(userProcessContainer,account, (FarmerOrganization)organization,enterprise,produceDirectory);
    }
    
}

