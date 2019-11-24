/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import static Model.HibernateUtil.getSessionFactory;
import Model.Puntos;
import Model.Terreno;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author 20102122476
 */
public class TerrenoController {
    public static List<Terreno>TerrenoShow(){
        Session Sesion=getSessionFactory().openSession();
        Sesion=getSessionFactory().openSession();
        List<Terreno> terreno=Sesion.createCriteria(Terreno.class).list();
        Sesion.close();
        return terreno;
    }
    public static Terreno TerrenoShow(long Id){
        Session Sesion=getSessionFactory().openSession();
        Sesion=getSessionFactory().openSession();
        Terreno terreno=(Terreno) Sesion.createCriteria(Terreno.class).add(Restrictions.eq("id", Id)).uniqueResult();
        Sesion.close();
        return terreno;
    }
    public static boolean CreateTerreno(long Id, String direccion, double total, String descripcion) {
        Session Sesion=getSessionFactory().openSession();
        Sesion.beginTransaction();
        try{
            Terreno terreno=new Terreno();
            terreno.setId(Id);
            terreno.setDireccion(direccion);
            terreno.setTotal(total);
            terreno.setDescripcion(descripcion);
            Sesion.save(terreno);
            Sesion.getTransaction().commit();
            Sesion.close();
            return true;
        }catch(Exception e){
            System.err.println(e);
            Sesion.close();
            return false;
        }
    }
}
