/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Organization.Organization.Type;
import java.util.ArrayList;

/**
 *
 * @author raunak
 */
public class OrganizationDirectory {
    
    private ArrayList<Organization> organizationList;

    public OrganizationDirectory() {
        organizationList = new ArrayList();
    }

    public ArrayList<Organization> getOrganizationList() {
        return organizationList;
    }
    
    public Organization createOrganization(Type type){
        Organization organization = null;
        if (type.getValue().equals(Type.Farmer.getValue())){
            organization = new FarmerOrganization();
            organizationList.add(organization);
        }
        else if (type.getValue().equals(Type.USFDAdmin.getValue())){
            organization = new USFDAdminOrganization();
            organizationList.add(organization);
        }
        else if (type.getValue().equals(Type.ManufacturerAdmin.getValue())){
            organization = new ManufacturerAdminOrganization();
            organizationList.add(organization);
        }
        else if (type.getValue().equals(Type.Customer.getValue())){
            organization = new CustomerOrganization();
            organizationList.add(organization);
        }
         else if (type.getValue().equals(Type.Supplier.getValue())){
            organization = new SupplierOrganization();
            organizationList.add(organization);
        }
         else if (type.getValue().equals(Type.Warehouse.getValue())){
            organization = new WarehouseOrganization();
            organizationList.add(organization);
        }
         else if (type.getValue().equals(Type.USFDDistributor.getValue())){
            organization = new USFD_DistributorOrganization();
            organizationList.add(organization);
        }
        else if (type.getValue().equals(Type.Production.getValue())){
            organization = new ProductionOrganization();
            organizationList.add(organization);
        }
        else if (type.getValue().equals(Type.ManufacturerDistributor.getValue())){
            organization = new Manufacturer_DistributorOrganization();
            organizationList.add(organization);
        }
        return organization;
    }
}