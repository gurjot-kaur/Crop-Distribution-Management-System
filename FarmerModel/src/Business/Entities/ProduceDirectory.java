/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Entities;

import java.util.ArrayList;

/**
 *
 * @author gurjo
 */
public class ProduceDirectory {
    
    private ArrayList<Produce> produceDirectory;

    public ProduceDirectory() {
        produceDirectory = new ArrayList<Produce>();
    }

    public ArrayList<Produce> getProduceDirectory() {
        return produceDirectory;
    }

    public Produce addProduce() {
        Produce produce = new Produce();
        produceDirectory.add(produce);
        return produce;
    }
    
    public void removeProduce(Produce p) {
        produceDirectory.remove(p);
    }
    
    public Produce searchProduce(String cropName) {
        for( Produce p: produceDirectory) {
            if(cropName.equals(p.getCropName())) {
                return p;
            }
        }
        return null;
    }
    
   
}
