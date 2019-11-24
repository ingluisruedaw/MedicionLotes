/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Area;
import static Model.HibernateUtil.getSessionFactory;
import Model.Terreno;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author 20102122476
 */
public class AreaController {
    public static List<Area>AreaShow(){
        Session Sesion=getSessionFactory().openSession();
        Sesion=getSessionFactory().openSession();
        List<Area> area=Sesion.createCriteria(Area.class).list();
        Sesion.close();
        return area;
    }
    public static Area AreaShow(long Id){
        Session Sesion=getSessionFactory().openSession();
        Sesion=getSessionFactory().openSession();
        Area area=(Area) Sesion.createCriteria(Area.class).add(Restrictions.eq("id", Id)).uniqueResult();
        Sesion.close();
        return area;
    }
    public static List<Area> AreaShow(Terreno terreno){
        Session Sesion=getSessionFactory().openSession();
        Sesion=getSessionFactory().openSession();
        List<Area> area=Sesion.createCriteria(Area.class).add(Restrictions.eq("terreno", terreno)).list();
        Sesion.close();
        return area;
    }
    public static boolean CreateArea(long Id, Terreno terreno, String titulo, double distanciaMaxima, double espaciado, double total) {
        Session Sesion=getSessionFactory().openSession();
        Sesion.beginTransaction();
        try{
            Area area=new Area();
            area.setId(Id);
            area.setTerreno(terreno);
            area.setTitulo(titulo);
            area.setDistanciaMaxima(distanciaMaxima);
            area.setEspaciado(espaciado);
            area.setTotal(total);
            Sesion.save(area);
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
