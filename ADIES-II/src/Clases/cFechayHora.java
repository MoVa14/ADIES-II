/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import com.toedter.calendar.JDateChooser;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author moise
 */
public class cFechayHora {
    
    public static String fecha(){
        Date fecha = new Date();
        SimpleDateFormat formatofecha = new SimpleDateFormat("yyyy-MM-dd");
        return formatofecha.format(fecha);
    }
    
    public String ffecha( JDateChooser fecha){
        SimpleDateFormat ff = new SimpleDateFormat("yyyy-MM-dd");
        String fn = ff.format(fecha.getDate());
        return fn;
    }
}
