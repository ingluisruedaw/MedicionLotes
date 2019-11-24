/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.LogarithmicAxis;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

public class Graficas {
    JFreeChart grafica;
    XYSeriesCollection datos = new XYSeriesCollection();
    String titulo;
    String tx;
    String ty;
    final static int LINEAL=1;
    final static int POLAR=2;
    final static int DISPERSION=3;
    final static int AREA=4;
    final static int LOGARITMICA=5;
    final static int SERIETIEMPO=6;
    final static int PASO=7;
    final static int PASOAREA=8;
    public Graficas(int tipo, String titulo){
        this.titulo=titulo;
        tipoGrafica(tipo);
    }
    public void tipoGrafica(int tipo){
        switch(tipo){
            case LINEAL:
                grafica=ChartFactory.createXYLineChart(titulo, tx, ty, datos, PlotOrientation.VERTICAL, true, true, true);
                break;
            case POLAR:
                grafica=ChartFactory.createPolarChart(titulo, datos, true, true, true);
                break;
            case DISPERSION:
                grafica=ChartFactory.createScatterPlot(titulo, tx, ty, datos, PlotOrientation.VERTICAL, true, true, true);
                break;
            case AREA:
                grafica=ChartFactory.createXYAreaChart(titulo, tx, ty, datos, PlotOrientation.VERTICAL, true, true, true);
                break;
            case LOGARITMICA:
                grafica=ChartFactory.createXYLineChart(titulo, tx, ty, datos, PlotOrientation.VERTICAL, true, true, true);
                XYPlot ejes=grafica.getXYPlot();
                NumberAxis rango= new LogarithmicAxis(ty);
                ejes.setRangeAxis(rango);
                break;
            case SERIETIEMPO:
                grafica=ChartFactory.createTimeSeriesChart(titulo, tx, ty, datos, true, true, true);
                break;
            case PASO:
                grafica=ChartFactory.createXYStepChart(titulo, tx, ty, datos, PlotOrientation.VERTICAL, true, true, true);
                break;
            case PASOAREA:
                grafica=ChartFactory.createXYStepAreaChart(titulo, tx, ty, datos, PlotOrientation.VERTICAL, true, true, true);
                break;
        }
    }
    public void agregarGrafica(String id, double[] x,double[] y){
        datos.removeAllSeries();
        XYSeries s=new XYSeries(id);
        int n=x.length;
        for(int i=0;i<n;i++){
            s.add(x[i],y[i]);
        }
        datos.addSeries(s);
    }
    public JPanel obtienePanel(){
        return new ChartPanel(grafica);
    }
    public void Borrar(){
        datos.removeAllSeries();
    }
}

