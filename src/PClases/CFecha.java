/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package PClases;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 *
 * @author Flia Navarro Moreno
 */
public class CFecha {
    private int dia, mes, año;
    Date time;
    private String fecha1;
    Calendar fecha = new GregorianCalendar();
    
    public String getAño() {
        año = fecha.get(Calendar.YEAR);
        String año = ""+this.año;
        return año;
    }

    public String getDia() {
        dia = fecha.get(Calendar.DAY_OF_MONTH);
        String dia = this.dia>9?""+fecha.get(Calendar.DAY_OF_MONTH):"0"+fecha.get(Calendar.DAY_OF_MONTH);
        return dia;
    }
    
    public Date getTime() {
        time = fecha.getTime();
        return time;
    }

    public String getMes() {
        mes = fecha.get(Calendar.MONTH)+1;
        String mes = this.mes>9?""+(fecha.get(Calendar.MONTH)+1):"0"+(fecha.get(Calendar.MONTH)+1);
        return mes;
    }
    
    public String getFecha() {
        fecha1= this.getDia()+"/"+this.getMes()+"/"+this.getAño();
        return fecha1;
    }
    
    
}
