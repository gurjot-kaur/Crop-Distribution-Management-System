/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.ProduceReview;

import java.util.ArrayList;

/**
 *
 * @author gurjo
 */
public class ProduceReviewDirectory {

    private ArrayList<ProduceReview> produceReviewList;
    private static ProduceReviewDirectory produceReviewInstance;

    public static ProduceReviewDirectory getInstance() {
        if (produceReviewInstance == null) {
            System.out.println("Inside get instance");
            produceReviewInstance = new ProduceReviewDirectory();
        }
        return produceReviewInstance;
    }

    public ProduceReviewDirectory() {
        produceReviewList = new ArrayList<ProduceReview>();
    }

    public ArrayList<ProduceReview> getProduceReviewList() {
        return produceReviewList;
    }

    public void setProduceReviewList(ArrayList<ProduceReview> produceReviewList) {
        this.produceReviewList = produceReviewList;
    }

    public ProduceReview addProduceReview() {
        ProduceReview produceReview = new ProduceReview();
        produceReviewList.add(produceReview);
        return produceReview;
    }

    public void removeProduceReview(ProduceReview produceReview) {
        produceReviewList.remove(produceReview);
    }

}
