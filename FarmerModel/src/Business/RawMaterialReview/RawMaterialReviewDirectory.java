/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.RawMaterialReview;

import java.util.ArrayList;

/**
 *
 * @author gurjo
 */
public class RawMaterialReviewDirectory {
    
    private ArrayList<RawMaterialReview> rawMaterialReviewList;
    private static RawMaterialReviewDirectory rmrInstance;

    public static RawMaterialReviewDirectory getInstance() {
        if (rmrInstance == null) {
            System.out.println("Inside get instance");
            rmrInstance = new RawMaterialReviewDirectory();
        }
        return rmrInstance;
    }

    public RawMaterialReviewDirectory() {
        rawMaterialReviewList = new ArrayList<RawMaterialReview>();
    }

    public ArrayList<RawMaterialReview> getRawMaterialReviewList() {
        return rawMaterialReviewList;
    }

    public void setRawMaterialReviewList(ArrayList<RawMaterialReview> rawMaterialReviewList) {
        this.rawMaterialReviewList = rawMaterialReviewList;
    }
    


    public RawMaterialReview addRawMaterialReview() {
        RawMaterialReview rmr = new RawMaterialReview();
        rawMaterialReviewList.add(rmr);
        return rmr;
    }

    public void removeRawMaterialReview(RawMaterialReview rmr) {
        rawMaterialReviewList.remove(rmr);
    }
}
