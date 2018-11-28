/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Role;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Entities.ProduceDirectory;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import javax.swing.JPanel;

/**
 *
 * @author raunak
 */
public abstract class Role {
    
    public enum RoleType{
        USFDAdmin("Admin"),
        ManufacturerAdmin("Admin"),
        Customer("Customer"),
        Farmer("Farmer"),
        Supplier("Supplier"),
        WarehouseManager("Warehouse Manager"),
        USFD_Distributor("Distributor"),
        Manufacturer_Distributor("Distributor"),
        Producer("Producer");
        
        private String value;
        private RoleType(String value){
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        @Override
        public String toString() {
            return value;
        }
    }
    
    public abstract JPanel createWorkArea(JPanel userProcessContainer,UserAccount account,Organization organization,Enterprise enterprise, EcoSystem business);

    @Override
    public String toString() {
        return this.getClass().getName();
    }
    
    
}