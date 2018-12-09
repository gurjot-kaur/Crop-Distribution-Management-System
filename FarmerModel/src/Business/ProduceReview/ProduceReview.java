/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.ProduceReview;

/**
 *
 * @author gurjo
 */
public class ProduceReview {
    String cropName;
    String farmerName;
    String produceQuality;
    String produceShelfLife;
    String additionalReviews;

    public String getCropName() {
        return cropName;
    }

    public void setCropName(String cropName) {
        this.cropName = cropName;
    }

    public String getFarmerName() {
        return farmerName;
    }

    public void setFarmerName(String farmerName) {
        this.farmerName = farmerName;
    }
    
    public String getProduceQuality() {
        return produceQuality;
    }

    public void setProduceQuality(String productQuality) {
        this.produceQuality = productQuality;
    }

    public String getProduceShelfLife() {
        return produceShelfLife;
    }

    public void setProduceShelfLife(String productShelfLife) {
        this.produceShelfLife = productShelfLife;
    }

    public String getAdditionalReviews() {
        return additionalReviews;
    }

    public void setAdditionalReviews(String additionalReviews) {
        this.additionalReviews = additionalReviews;
    }
    
    @Override
    public String toString(){
        return cropName;
    }
    
}
