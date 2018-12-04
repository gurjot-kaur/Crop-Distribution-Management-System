
package Business.Produce;

import Business.UserAccount.UserAccount;

/**
 *
 * @author Welcome
 */
public class Produce {
    
    private String cropName;
    private int cropQuantity;
    private double cropPrice;
    private String farmerName;
    

    public String getCropName() {
        return cropName;
    }

    public void setCropName(String cropName) {
        this.cropName = cropName;
    }

    public int getCropQuantity() {
        return cropQuantity;
    }

    public void setCropQuantity(int cropQuantity) {
        this.cropQuantity = cropQuantity;
    }

    public double getCropPrice() {
        return cropPrice;
    }

    public void setCropPrice(double cropPrice) {
        this.cropPrice = cropPrice;
    }

    public String getFarmerName() {
        return farmerName;
    }

    public void setFarmerName(String farmerName) {
        this.farmerName = farmerName;
    }

    
     @Override
    public String toString() {
        return cropName;
    }
    
}
