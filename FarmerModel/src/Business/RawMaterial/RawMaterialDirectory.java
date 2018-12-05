/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.RawMaterial;

import java.util.ArrayList;

/**
 *
 * @author Welcome
 */
public class RawMaterialDirectory {
    private ArrayList <RawMaterial> rawMaterial;
    private static RawMaterialDirectory rmInstance;
    
    public static RawMaterialDirectory getInstance()
    {
        if (rmInstance == null)
        {
            rmInstance = new RawMaterialDirectory();
        }
        return rmInstance;
    }
    
    public RawMaterialDirectory()
    {
        rawMaterial = new ArrayList<RawMaterial>();
    }

    public ArrayList<RawMaterial> getRawMaterial() {
        return rawMaterial;
    }

    public void setRawMaterial(ArrayList<RawMaterial> rawMaterial) {
        this.rawMaterial = rawMaterial;
    }
    
    public RawMaterial addRM()
    {
        RawMaterial rm = new RawMaterial();
        rawMaterial.add(rm);
        return rm;
    }
    
    public void removeRM(RawMaterial rm)
    {
        rawMaterial.remove(rm);
         
    }
}
