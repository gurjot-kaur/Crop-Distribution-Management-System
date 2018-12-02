/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Role.ManufacturerWarehouseManagerRole;
import Business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author Welcome
 */
public class ManufacturerWarehouseOrganization extends Organization{

  

   public ManufacturerWarehouseOrganization() {
        super(Type.ManufacturerWarehouse.getValue());
    }

    @Override
    public ArrayList<Role> getSupportedRole() {
         ArrayList<Role> roles = new ArrayList();
        roles.add(new ManufacturerWarehouseManagerRole() );
        return roles;
    }
    
}
