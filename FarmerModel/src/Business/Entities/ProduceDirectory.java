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
    private ArrayList<Produce> produceList;
    
    public ProduceDirectory(){
        produceList = new ArrayList<Produce>();    
    }

    public ArrayList<Produce> getProduceList() {
        return produceList;
    }

    public void setProduceList(ArrayList<Produce> produceList) {
        this.produceList = produceList;
    }
    
     public Produce addProduce() {
        Produce produce = new Produce();
        produceList.add(produce);
        return produce;
    }
    
    public void removeProduce(Produce produce) {
        produceList.remove(produce);
    }
    
    
}
