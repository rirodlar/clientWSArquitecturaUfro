/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mb;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author rrodriguez
 */
@ManagedBean(name="reservaControlBean")
@RequestScoped
public class ReservaControlBean {

 
   private Boolean panelIsVisible;
   private String selectedOptions;
    
    public ReservaControlBean() {
        
     
    }

   public void changePanelState(){
        panelIsVisible =  Boolean.TRUE;
    }

    public Boolean getPanelIsVisible() {
        return panelIsVisible;
    }

    public void setPanelIsVisible(Boolean panelIsVisible) {
        this.panelIsVisible = panelIsVisible;
    }

    public String getSelectedOptions() {
        return selectedOptions;
    }

    public void setSelectedOptions(String selectedOptions) {
        this.selectedOptions = selectedOptions;
    }
    
    
   

  
    
    
}
