/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Role.ProducerRole;
import Business.Role.Role;
import Business.Role.USFD_DistributorRole;
import java.util.ArrayList;

/**
 *
 * @author gurjo
 */
public class USFD_DistributorOrganization extends Organization {
    
    public USFD_DistributorOrganization(){
        super(Type.USFDDistributor.getValue());
    }
    
    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList();
        roles.add(new USFD_DistributorRole());
        return roles;
    }  
}
