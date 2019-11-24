/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Area;
import static Model.HibernateUtil.getSessionFactory;
import Model.Puntos;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author 20102122476
 */
public class PuntosController {
    public static List<Puntos>PuntosShow(){
        Session Sesion=getSessionFactory().openSession();
        Sesion=getSessionFactory().openSession();
        List<Puntos> puntos=Sesion.createCriteria(Puntos.class).list();
        Sesion.close();
        return puntos;
    }
    public static Puntos PuntosShow(long Id){
        Session Sesion=getSessionFactory().openSession();
        Sesion=getSessionFactory().openSession();
        Puntos puntos=(Puntos) Sesion.createCriteria(Puntos.class).add(Restrictions.eq("id", Id)).uniqueResult();
        Sesion.close();
        return puntos;
    }
    public static List<Puntos> PuntosShow(Area area){
        Session Sesion=getSessionFactory().openSession();
        Sesion=getSessionFactory().openSession();
        List<Puntos> puntos=Sesion.createCriteria(Puntos.class).add(Restrictions.eq("area", area)).list();
        Sesion.close();
        return puntos;
    }
    public static boolean CreatePuntos(long Id, Area area, double x, double y) {
        Session Sesion=getSessionFactory().openSession();
        Sesion.beginTransaction();
        try{
            Puntos puntos=new Puntos();
            puntos.setId(Id);
            puntos.setArea(area);
            puntos.setX(x);
            puntos.setY(y);
            Sesion.save(puntos);
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
