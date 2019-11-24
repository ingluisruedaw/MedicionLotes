/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.AreaController;
import Controller.PuntosController;
import Controller.TerrenoController;
import Formulas.NewtonCotex;
import Formulas.NewtonCotexCompuesta;
import Model.Area;
import static Model.HibernateUtil.getSessionFactory;
import Model.Terreno;
import java.math.BigDecimal;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author 20102122476
 */
public class AreasView extends javax.swing.JFrame {
    Graficas migrafica=new Graficas(Graficas.AREA,"Area Del Terreno");
    /**
     * Creates new form AreasView
     */
    public AreasView() {
        initComponents();
        this.setTitle("Zeus - Luis Rueda, Todos Los Derechos Reservados");
        this.setLocationRelativeTo(null);
        LoadArea();
        LoadTerrenos();
    }
    public void ClearArea(){
        txidarea.setText("");
        txtituloarea.setText("");
        txdist_max.setText("");
        txespaciado.setText("");
        txresultado.setText("");
    }
    public void LoadArea(){        
        Session Sesion=getSessionFactory().openSession();
        String hql="SELECT Max(id) FROM Area";
        Query query=Sesion.createQuery(hql);
        List results=query.list();
        String temp=results.toString();
        Sesion.close();
        try{
        temp=String.valueOf(Long.parseLong(temp.replaceAll("\\[", "").replaceAll("\\]", ""))+1);
        txidarea.setText(String.valueOf(temp));
        }catch(NumberFormatException es){
            txidarea.setText(String.valueOf("1"));
        }
    }
    public String SearchPuntos(){        
        Session Sesion=getSessionFactory().openSession();
        String hql="SELECT Max(id) FROM Puntos";
        Query query=Sesion.createQuery(hql);
        List results=query.list();
        String temp=results.toString();
        Sesion.close();
        try{
        temp=String.valueOf(Long.parseLong(temp.replaceAll("\\[", "").replaceAll("\\]", ""))+1);
        System.out.println("Id: "+temp);
        return (String.valueOf(temp));
        }catch(NumberFormatException es){
            return (String.valueOf("1"));
        }
    }
    public void centrar_datos(int colum){
        DefaultTableCellRenderer modelocentrar = new DefaultTableCellRenderer();
        modelocentrar.setHorizontalAlignment(SwingConstants.CENTER);
        tabla.getColumnModel().getColumn(colum).setCellRenderer(modelocentrar); 
        modelocentrar.setVerticalAlignment(JLabel.CENTER);
    }
    public void LimpiarTabla(){
        tabla.setModel(new javax.swing.table.DefaultTableModel(new Object [][] {},new String [] {}));
    }
    public void Centrar_Titulos(){
        JTableHeader jtableHeader = tabla.getTableHeader();
        DefaultTableCellRenderer rend = (DefaultTableCellRenderer) tabla.getTableHeader().getDefaultRenderer();
        rend.setHorizontalAlignment(JLabel.CENTER);
        rend.setVerticalAlignment(JLabel.CENTER);
        jtableHeader.setDefaultRenderer(rend);
    }
    public void CargarTabla(String Titulos[],String Filas[]){
        String [][] data = new String[Filas.length][2];        
        for(int i=0;i<Filas.length;i++){
            data[i][0]=Filas[i];
        }
        DefaultTableModel dtm = new DefaultTableModel(data,Titulos);
        tabla.setModel(dtm);
        Centrar_Titulos();
        for(int i=0;i<(tabla.getColumnCount());i++){
            try{
                centrar_datos(i);
            }catch(ArrayIndexOutOfBoundsException ex){
                i=(tabla.getRowCount()-1);
            }
        }
    }
    public static void LoadTerrenos(){
        DefaultComboBoxModel datos=new DefaultComboBoxModel();
        List<Terreno> terreno=TerrenoController.TerrenoShow();
        for(Terreno o: terreno){
            datos.addElement(o.getId()+":"+o.getDescripcion());
        }
        cbidterreno.setModel(datos);
    }
    public void Graficar(){
        double[] x=new double[tabla.getRowCount()];
        double[] y=new double[tabla.getRowCount()];
        for(int i=0;i<x.length;i++){
            x[i]=Double.parseDouble(String.valueOf(tabla.getValueAt(i,0)));
            y[i]=Double.parseDouble(String.valueOf(tabla.getValueAt(i,1)));
        }
        double [] r={1,2,3,4};
        double [] l={1,3.5,4.2,5.6};
        migrafica.agregarGrafica("Area", x, y);
        panelgrafica=migrafica.obtienePanel();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel8 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txidarea = new javax.swing.JTextField();
        txtituloarea = new javax.swing.JTextField();
        txdist_max = new javax.swing.JTextField();
        jButton14 = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        txespaciado = new javax.swing.JTextField();
        txresultado = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txescala = new javax.swing.JComboBox();
        jButton1 = new javax.swing.JButton();
        cbidterreno = new javax.swing.JComboBox();
        jButton15 = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jButton11 = new javax.swing.JButton();
        jButton12 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        panelgrafica = migrafica.obtienePanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jPanel8.setBackground(new java.awt.Color(255, 255, 204));
        jPanel8.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Datos Area & Puntos Tabla", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));

        jLabel8.setText("Id: ");

        jLabel9.setText("Terreno_Id: ");

        jLabel10.setText("Titulo: ");

        jLabel11.setText("Dist_ Max: ");

        txidarea.setEditable(false);

        jButton14.setText("Registrar");
        jButton14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton14ActionPerformed(evt);
            }
        });

        jLabel12.setText("Espaciado: ");

        jLabel13.setText("Total: ");

        txresultado.setEditable(false);

        jLabel3.setText("Escala: ");

        txescala.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9" }));
        txescala.setSelectedIndex(2);

        jButton1.setText("Add");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton15.setText("Solucionar");
        jButton15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton15ActionPerformed(evt);
            }
        });

        jPanel6.setBackground(new java.awt.Color(255, 255, 204));
        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "N.C. Combinadas", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));

        jButton11.setText("Trapecio");
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11Newton_Cotex_Combinadas_Trapecio(evt);
            }
        });

        jButton12.setText("Simpson");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton11, javax.swing.GroupLayout.DEFAULT_SIZE, 91, Short.MAX_VALUE)
                    .addComponent(jButton12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addComponent(jButton11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton12)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel11)
                            .addComponent(jLabel9)
                            .addComponent(jLabel8)
                            .addComponent(jLabel10)
                            .addComponent(jLabel12)
                            .addComponent(jLabel13)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txresultado, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel8Layout.createSequentialGroup()
                                .addComponent(txespaciado)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton1))
                            .addComponent(txdist_max, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtituloarea, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txidarea, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txescala, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cbidterreno, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                        .addGap(0, 26, Short.MAX_VALUE)
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txidarea, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(cbidterreno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(txtituloarea, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(txdist_max, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(txespaciado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(txresultado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txescala, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(jButton15)
                        .addGap(35, 35, 35)
                        .addComponent(jButton14))
                    .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(71, Short.MAX_VALUE))
        );

        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "x", "f(x)"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tabla);

        panelgrafica.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout panelgraficaLayout = new javax.swing.GroupLayout(panelgrafica);
        panelgrafica.setLayout(panelgraficaLayout);
        panelgraficaLayout.setHorizontalGroup(
            panelgraficaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 210, Short.MAX_VALUE)
        );
        panelgraficaLayout.setVerticalGroup(
            panelgraficaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 370, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelgrafica, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(panelgrafica, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton14ActionPerformed
        // TODO add your handling code here:
        if(txidarea.getText().length()!=0&&cbidterreno.getSelectedItem().toString().length()!=0&&txtituloarea.getText().length()!=0&&txdist_max.getText().length()!=0&&txespaciado.getText().length()!=0&&txresultado.getText().length()!=0){
            String[] temp= ((String) cbidterreno.getSelectedItem()).split(":");
            Terreno terreno=TerrenoController.TerrenoShow(Long.parseLong(temp[0]));
            if(AreaController.CreateArea(Long.parseLong(txidarea.getText()), terreno, txtituloarea.getText(), Double.parseDouble(txdist_max.getText()), Double.parseDouble(txespaciado.getText()), Double.parseDouble(txresultado.getText()))){
                Area area=AreaController.AreaShow(Long.parseLong(txidarea.getText()));
                long idpuntos=Long.parseLong(SearchPuntos());
                for(int i=0;i<tabla.getRowCount();i++){
                    if(PuntosController.CreatePuntos(idpuntos, area,Double.parseDouble((String) tabla.getValueAt(i, 0)), Double.parseDouble((String) tabla.getValueAt(i, 1)))){
                    }
                    idpuntos=Long.parseLong(SearchPuntos());
                }
                ClearArea();
                LimpiarTabla();
                LoadTerrenos();                
                JOptionPane.showMessageDialog(this, "Terreno Registrado");
            }else{
                JOptionPane.showMessageDialog(this, "Error Al Registrar");
            }
        }else{
            JOptionPane.showMessageDialog(this, "Todos Los Campos Son Obligatorios");
        }
    }//GEN-LAST:event_jButton14ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        txresultado.setText("");
        migrafica.Borrar();
        int puntos=1+Integer.parseInt(txdist_max.getText())/Integer.parseInt(txespaciado.getText());
        String[] Titulos={"x","f(x)"};
        String[] x=new String[puntos];
        BigDecimal temp=new BigDecimal("0");
        BigDecimal espaciado=new BigDecimal(txespaciado.getText());
        for(int i=0;i<x.length;i++){
            x[i]=String.valueOf(temp);
            temp=temp.add(espaciado);
        }
        CargarTabla(Titulos,x);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton15ActionPerformed
        // TODO add your handling code here:
        int puntos=tabla.getRowCount();
        int control=0;
        System.out.println("Puntos: "+puntos);
        if(puntos==2&&control==0){
            /*trapecio*/
            BigDecimal[] fx=new BigDecimal[tabla.getRowCount()];
            for(int i=0;i<fx.length;i++){
                fx[i]=new BigDecimal(tabla.getValueAt(i,1).toString());
            }
            NewtonCotex nc=new NewtonCotex();
            BigDecimal a=new BigDecimal(tabla.getValueAt(0,0).toString());
            BigDecimal b=new BigDecimal(tabla.getValueAt((tabla.getRowCount()-1),0).toString());
            txresultado.setText(String.valueOf(nc.Trapecio(fx, a,b,Integer.parseInt(String.valueOf(txescala.getSelectedItem())))));
            control=1;
            Graficar();
        }
        if(puntos==3&&control==0){
            //simpson 1/3
            BigDecimal[] fx=new BigDecimal[tabla.getRowCount()];
            for(int i=0;i<fx.length;i++){
                fx[i]=new BigDecimal(tabla.getValueAt(i,1).toString());
            }
            NewtonCotex nc=new NewtonCotex();
            BigDecimal a=new BigDecimal(tabla.getValueAt(0,0).toString());
            BigDecimal b=new BigDecimal(tabla.getValueAt((tabla.getRowCount()-1),0).toString());
            txresultado.setText(String.valueOf(nc.Simpson_1_3(fx,a,b,Integer.parseInt(String.valueOf(txescala.getSelectedItem())))));
            control=1;
            Graficar();
        }
        if(puntos==4&&control==0){
            //simpson 3/8 //
            BigDecimal[] fx=new BigDecimal[tabla.getRowCount()];
            for(int i=0;i<fx.length;i++){
                fx[i]=new BigDecimal(tabla.getValueAt(i,1).toString());
            }
            NewtonCotex nc=new NewtonCotex();
            BigDecimal a=new BigDecimal(tabla.getValueAt(0,0).toString());
            BigDecimal b=new BigDecimal(tabla.getValueAt((tabla.getRowCount()-1),0).toString());
            txresultado.setText(String.valueOf(nc.Simpson_3_8(fx,a,b,Integer.parseInt(String.valueOf(txescala.getSelectedItem())))));
            control=1;
            Graficar();
        }
        if(puntos==5&&control==0){
            //boole 5 puntos //
            BigDecimal[] fx=new BigDecimal[tabla.getRowCount()];
            for(int i=0;i<fx.length;i++){
                fx[i]=new BigDecimal(tabla.getValueAt(i,1).toString());
            }
            NewtonCotex nc=new NewtonCotex();
            BigDecimal a=new BigDecimal(tabla.getValueAt(0,0).toString());
            BigDecimal b=new BigDecimal(tabla.getValueAt((tabla.getRowCount()-1),0).toString());
            txresultado.setText(String.valueOf(nc.boole_5(fx,a,b,Integer.parseInt(String.valueOf(txescala.getSelectedItem())))));
            control=1;
            Graficar();
        }
        if(puntos==6&&control==0){
            //boole 6 puntos //
            BigDecimal[] fx=new BigDecimal[tabla.getRowCount()];
            for(int i=0;i<fx.length;i++){
                fx[i]=new BigDecimal(tabla.getValueAt(i,1).toString());
            }
            NewtonCotex nc=new NewtonCotex();
            BigDecimal a=new BigDecimal(tabla.getValueAt(0,0).toString());
            BigDecimal b=new BigDecimal(tabla.getValueAt((tabla.getRowCount()-1),0).toString());
            txresultado.setText(String.valueOf(nc.boole_6(fx,a,b,Integer.parseInt(String.valueOf(txescala.getSelectedItem())))));
            control=1;
            Graficar();
        }

        //trapecio compuesta
        if(puntos>=2&&control==0&&(puntos-1)%2!=0&&(puntos-1)%3!=0){
            BigDecimal[] fx=new BigDecimal[tabla.getRowCount()];
            for(int i=0;i<fx.length;i++){
                fx[i]=new BigDecimal(tabla.getValueAt(i,1).toString());
            }
            NewtonCotexCompuesta nc=new NewtonCotexCompuesta();
            txresultado.setText(String.valueOf(nc.Trapecio_Compuesta(fx,new BigDecimal(txespaciado.getText()),Integer.parseInt(String.valueOf(txescala.getSelectedItem())))));
            control=1;
            Graficar();
        }
        //simpson 1/3 compuesta
        if(puntos>=3&&control==0&&(puntos-1)%2==0&&(puntos-1)%3!=0){
            BigDecimal[] fx=new BigDecimal[tabla.getRowCount()];
            for(int i=0;i<fx.length;i++){
                fx[i]=new BigDecimal(tabla.getValueAt(i,1).toString());
            }
            NewtonCotexCompuesta nc=new NewtonCotexCompuesta();
            txresultado.setText(String.valueOf(nc.Simpson_1_3_Compuesta(fx,new BigDecimal(txespaciado.getText()),Integer.parseInt(String.valueOf(txescala.getSelectedItem())))));
            control=1;
            Graficar();
        }
        //simpson 3/8 compuesta
        if(puntos>=4&&control==0&&(puntos-1)%2!=0&&(puntos-1)%3==0){
            BigDecimal[] fx=new BigDecimal[tabla.getRowCount()];
            for(int i=0;i<fx.length;i++){
                fx[i]=new BigDecimal(tabla.getValueAt(i,1).toString());
            }
            NewtonCotexCompuesta nc=new NewtonCotexCompuesta();
            txresultado.setText(String.valueOf(nc.Simpson_3_8_Compuesta(fx,new BigDecimal(txespaciado.getText()),Integer.parseInt(String.valueOf(txescala.getSelectedItem())))));
            control=1;
            Graficar();
        }
    }//GEN-LAST:event_jButton15ActionPerformed

    private void jButton11Newton_Cotex_Combinadas_Trapecio(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11Newton_Cotex_Combinadas_Trapecio
        // TODO add your handling code here:
        if(Integer.parseInt(txdist_max.getText())>=2){
            BigDecimal[] fx=new BigDecimal[2];
            BigDecimal Resultado=new BigDecimal("0");
            for(int i=0;i<(tabla.getRowCount()-1);i++){
                NewtonCotex nc=new NewtonCotex();
                fx[0]=new BigDecimal(tabla.getValueAt(i,1).toString());
                fx[1]=new BigDecimal(tabla.getValueAt(i+1,1).toString());
                BigDecimal a=new BigDecimal(tabla.getValueAt(i,0).toString());
                BigDecimal b=new BigDecimal(tabla.getValueAt(i+1,0).toString());
                Resultado=Resultado.add(nc.Trapecio(fx, a,b,Integer.parseInt(String.valueOf(txescala.getSelectedItem()))));
            }
            txresultado.setText(String.valueOf(Resultado));
        }else JOptionPane.showMessageDialog(this,"esta formula solo aplica para 2 puntos","Error",JOptionPane.ERROR_MESSAGE);
    }//GEN-LAST:event_jButton11Newton_Cotex_Combinadas_Trapecio

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JComboBox cbidterreno;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton15;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel panelgrafica;
    private javax.swing.JTable tabla;
    private javax.swing.JTextField txdist_max;
    private javax.swing.JComboBox txescala;
    private javax.swing.JTextField txespaciado;
    private javax.swing.JTextField txidarea;
    private javax.swing.JTextField txresultado;
    private javax.swing.JTextField txtituloarea;
    // End of variables declaration//GEN-END:variables
}
