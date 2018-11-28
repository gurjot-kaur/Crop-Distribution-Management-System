/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Role.ManufacturerAdminRole;
import Business.Role.Manufacturer_DistributorRole;
import Business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author gurjo
 */
public class Manufacturer_DistributorOrganization extends Organization{
    
    public Manufacturer_DistributorOrganization(){
        super(Type.ManufacturerDistributor.getValue());
    }
    
    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList();
        roles.add(new Manufacturer_DistributorRole());
        return roles;
    }  
}
