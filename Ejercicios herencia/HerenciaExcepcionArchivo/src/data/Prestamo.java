/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author HéctorAugusto
 */
public class Prestamo {
    
    private String soporte;
    private Date fecha;

    public Prestamo(String soporte, Date fecha) {
        this.soporte = soporte;
        this.fecha = fecha;
    }
    
    public Date fechaVencimiento(){
        
        Calendar calendario = Calendar.getInstance();
        calendario.setTime(fecha);
        calendario.add(Calendar.DAY_OF_YEAR, 3);
        return calendario.getTime();
    }
}
