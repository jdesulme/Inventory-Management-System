/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ims.Controller;

import ims.DataLayer.DataAccess;
import ims.Model.Pizza;
import ims.Model.UIOrder;
import java.util.Map;

/**
 * Controller to handle order
 * Get Order details from UI and updates to database
 * @author kumar
 */
public class OrderHandler {
    
    UIOrder uiOrder = null;
    
    public OrderHandler(UIOrder uiOrder){
        
        this.uiOrder = uiOrder;        
    }
    
    public void placeOrder(){
        
        Map<Pizza,Integer> orderList = uiOrder.gerOrderList();
        
        if(orderList != null)
        {
            DataAccess dataAccess = new DataAccess();
            //TODO: Branch Id
            int billId = dataAccess.GenerateBillId(uiOrder.getTotalCost(), 1);
            
            System.out.println(billId);
            
            for (Map.Entry<Pizza, Integer> entry : orderList.entrySet()) {
                Pizza pizza = entry.getKey();
                Integer integer = entry.getValue();               
                
                dataAccess.insertOrder(billId, pizza.getPizzaId(),integer);
            }
        }
        
    }
}
