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
import Business.RawMaterial.RawMaterialDirectory;
import Business.UserAccount.UserAccount;
import javax.swing.JPanel;
import userinterface.FarmerRole.FarmerWorkAreaJPanel;

/**
 *
 * @author gurjo
 */
public class FarmerRole extends Role {
    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise, EcoSystem business,ProduceDirectory produceDirectory, RawMaterialDirectory rmDirectory) {
        return new FarmerWorkAreaJPanel(userProcessContainer,account, (FarmerOrganization)organization,(USFDEnterprise)enterprise,business,produceDirectory,rmDirectory);

    }

}

