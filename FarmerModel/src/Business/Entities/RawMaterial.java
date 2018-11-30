/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Entities;

/**
 *
 * @author Welcome
 */
public class RawMaterial {
    private String materialName;
    private int materialQuantity;
    private double materialPrice;
    public String getMaterialName() {
        return materialName;
    }

    public void setMaterialName(String materialName) {
        this.materialName = materialName;
    }

    public int getMaterialQuantity() {
        return materialQuantity;
    }

    public void setMaterialQuantity(int materialQuantity) {
        this.materialQuantity = materialQuantity;
    }

    public double getMaterialPrice() {
        return materialPrice;
    }

    public void setMaterialPrice(double materialPrice) {
        this.materialPrice = materialPrice;
    }
    
}
