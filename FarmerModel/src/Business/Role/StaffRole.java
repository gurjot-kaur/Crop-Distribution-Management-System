/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Role;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Enterprise.USFDEnterprise;
import Business.Organization.Organization;
import Business.Organization.StaffOrganization;
import Business.UserAccount.UserAccount;
import javax.swing.JPanel;
import userinterface.StaffRole.StaffWorkAreaJPanel;

/**
 *
 * @author raunak
 */
public class StaffRole extends Role{

    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise, EcoSystem business) {

        return new StaffWorkAreaJPanel(userProcessContainer, account,(StaffOrganization)organization, (USFDEnterprise)enterprise,business);

    }
    
    
}
