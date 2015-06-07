/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mb;

import beans.Box;
import com.google.gson.Gson;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import org.primefaces.context.RequestContext;
import org.primefaces.event.SelectEvent;
import java.lang.reflect.Type;
import com.google.gson.reflect.TypeToken;
/**
 *
 * @author rrodriguez
 */
@ManagedBean(name="reporteBean")
@RequestScoped
public class ReporteBean {
         
    private Date date1;
    private Date date2;
    private List<SelectItem> listaBoxs = new ArrayList<SelectItem>();;
    private String nombreBox;
    Gson gson  = new Gson();
    private String json = "";
    
  
    
    
    public ReporteBean(){
             this.llenarListadeBox();
     
    }
    public void llenarListadeBox(){
        json = this.obtenerBox();
        Type tipoObjeto = new TypeToken<List <Box>>(){}.getType();
        ArrayList<Box> boxs = gson.fromJson(this.json, tipoObjeto);
        for(int i=0;i<boxs.size();i++){
          listaBoxs.add(new SelectItem(boxs.get(i).getId_box(),boxs.get(i).getNombre()));
        }
    }
    public void onDateSelect(SelectEvent event) {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Date Selected", format.format(event.getObject())));
    }
     
    public void click() {
        RequestContext requestContext = RequestContext.getCurrentInstance();
         
        requestContext.update("form:display");
        requestContext.execute("PF('dlg').show()");
    }

    public List<SelectItem> getListaBoxs() {

        return listaBoxs;
    }

    public void setListaBoxs(List<SelectItem> listaBoxs) {
        this.listaBoxs = listaBoxs;
    }

    public String getNombreBox() {
        return nombreBox;
    }

    public void setNombreBox(String nombreBox) {
        this.nombreBox = nombreBox;
    }
    
    public Date getDate1() {
        return date1;
    }
 
    public void setDate1(Date date1) {
        this.date1 = date1;
    }
 
    public Date getDate2() {
        return date2;
    }
 
    public void setDate2(Date date2) {
        this.date2 = date2;
    }

    private static String obtenerBox() {
        wsclientg3.Grupo3_Service service = new wsclientg3.Grupo3_Service();
        wsclientg3.Grupo3 port = service.getGrupo3Port();
        return port.obtenerBox();
    }
    
    private static String calcularPorcentajeOcupacionBox(int box, java.lang.String fecha1, java.lang.String fecha2) {
        wsclientg4.ObtenerPorcentajeOcupacionBox_Service service = new wsclientg4.ObtenerPorcentajeOcupacionBox_Service();
        wsclientg4.ObtenerPorcentajeOcupacionBox port = service.getObtenerPorcentajeOcupacionBoxPort();
        return port.calcularPorcentajeOcupacionBox(box, fecha1, fecha2);
    }
  
 
 
}