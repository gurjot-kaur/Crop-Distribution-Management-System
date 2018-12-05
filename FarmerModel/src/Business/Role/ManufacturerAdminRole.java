/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Role;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Enterprise.ManufacturerEnterprise;
import Business.Organization.Organization;
import Business.Produce.ProduceDirectory;
import Business.RawMaterial.RawMaterialDirectory;
import Business.UserAccount.UserAccount;

import javax.swing.JPanel;
import userinterface.ManufacturerAdminRole.MAdminWorkAreaJPanel;

/**
 *
 * @author raunak
 */
public class ManufacturerAdminRole extends Role{

    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise, EcoSystem business,ProduceDirectory produceDirectory, RawMaterialDirectory rmDirectory) {
        return new MAdminWorkAreaJPanel(userProcessContainer, (ManufacturerEnterprise)enterprise);
    }

    
    
}
