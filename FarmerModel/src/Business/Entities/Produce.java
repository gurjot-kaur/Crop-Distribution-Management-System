
package Business.Entities;

import Business.Role.FarmerRole;

/**
 *
 * @author Welcome
 */
public class Produce {
    
    private String cropName;
    private int cropQuantity;
    private double cropPrice;
  

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
    
    @Override
    public String toString(){
        return cropName;
    }
}
