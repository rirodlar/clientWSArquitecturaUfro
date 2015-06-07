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
@ManagedBean(name = "loginManagedBean")
@RequestScoped
public class LoginManagedBean {

    private String rut;
    private String email;
    
    public LoginManagedBean() {
    }
    
    public void login(){
        System.out.print("login");
        System.out.print("RUT: "+this.rut);
        System.out.print("EMAIL: "+this.email);
    } 

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    
}
