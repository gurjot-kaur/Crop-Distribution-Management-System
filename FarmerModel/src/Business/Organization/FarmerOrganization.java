/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Produce.ProduceDirectory;
import Business.Role.FarmerRole;
import Business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author gurjo
 */
public class FarmerOrganization extends Organization {

    //private ProduceDirectory produceDirectory;

    public FarmerOrganization() {
        super(Type.Farmer.getValue());
        //this.produceDirectory = new ProduceDirectory();
    }

   /* public ProduceDirectory getProduceDirectory() {
        return produceDirectory;
    }

    public void setProduceDirectory(ProduceDirectory produceDirectory) {
        this.produceDirectory = produceDirectory;
    }*/

    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList();
        roles.add(new FarmerRole());
        return roles;
    }
}
