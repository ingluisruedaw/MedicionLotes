package Model;
// Generated 17/05/2016 02:10:33 PM by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * Area generated by hbm2java
 */
public class Area  implements java.io.Serializable {


     private long id;
     private Terreno terreno;
     private String titulo;
     private double distanciaMaxima;
     private double espaciado;
     private double total;
     private Set puntoses = new HashSet(0);

    public Area() {
    }

	
    public Area(long id, Terreno terreno, String titulo, double distanciaMaxima, double espaciado, double total) {
        this.id = id;
        this.terreno = terreno;
        this.titulo = titulo;
        this.distanciaMaxima = distanciaMaxima;
        this.espaciado = espaciado;
        this.total = total;
    }
    public Area(long id, Terreno terreno, String titulo, double distanciaMaxima, double espaciado, double total, Set puntoses) {
       this.id = id;
       this.terreno = terreno;
       this.titulo = titulo;
       this.distanciaMaxima = distanciaMaxima;
       this.espaciado = espaciado;
       this.total = total;
       this.puntoses = puntoses;
    }
   
    public long getId() {
        return this.id;
    }
    
    public void setId(long id) {
        this.id = id;
    }
    public Terreno getTerreno() {
        return this.terreno;
    }
    
    public void setTerreno(Terreno terreno) {
        this.terreno = terreno;
    }
    public String getTitulo() {
        return this.titulo;
    }
    
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public double getDistanciaMaxima() {
        return this.distanciaMaxima;
    }
    
    public void setDistanciaMaxima(double distanciaMaxima) {
        this.distanciaMaxima = distanciaMaxima;
    }
    public double getEspaciado() {
        return this.espaciado;
    }
    
    public void setEspaciado(double espaciado) {
        this.espaciado = espaciado;
    }
    public double getTotal() {
        return this.total;
    }
    
    public void setTotal(double total) {
        this.total = total;
    }
    public Set getPuntoses() {
        return this.puntoses;
    }
    
    public void setPuntoses(Set puntoses) {
        this.puntoses = puntoses;
    }




}


