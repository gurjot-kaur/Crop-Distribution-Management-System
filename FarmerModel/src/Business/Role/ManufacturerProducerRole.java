/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Role;

import Business.EcoSystem;
import Business.Enterprise.*;
import Business.Organization.*;
import Business.Produce.ProduceDirectory;
import Business.RawMaterial.RawMaterialDirectory;
import Business.UserAccount.UserAccount;
import javax.swing.JPanel;
import userinterface.ProducerRole.ManufacturerProducerJPanel;

/**
 *
 * @author gurjo
 */
public class ManufacturerProducerRole extends Role {
    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise, EcoSystem business,ProduceDirectory produceDirectory, RawMaterialDirectory rmDirectory) {
        return new ManufacturerProducerJPanel(userProcessContainer,account, (ManufacturerProductionOrganization)organization,(ManufacturerEnterprise)enterprise,business,rmDirectory);
    }

}
