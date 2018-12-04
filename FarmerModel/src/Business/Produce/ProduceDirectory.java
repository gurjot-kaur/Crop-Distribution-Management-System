/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Produce;

import java.util.ArrayList;

/**
 *
 * @author gurjot
 */
public class ProduceDirectory {
    private ArrayList<Produce>produceList;
    
    public ProduceDirectory(){
        produceList = new ArrayList<Produce>();
        System.out.println("produce list"+ produceList);
        
    }

    public void setProduceList(ArrayList<Produce> produceList) {
        this.produceList = produceList;
    }

    public ArrayList<Produce> getProduceList() {
        return produceList;
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
