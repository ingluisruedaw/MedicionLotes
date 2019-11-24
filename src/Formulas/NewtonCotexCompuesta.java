/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Formulas;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 *
 * @author luisu
 */
public class NewtonCotexCompuesta {
    
    
    public BigDecimal Trapecio_Compuesta(BigDecimal[] fx, BigDecimal h, int escala){        
        BigDecimal multiplicando=new BigDecimal("2");
        
        BigDecimal divisor=new BigDecimal("2");
        BigDecimal temp;        temp=h.divide(divisor,9,RoundingMode.HALF_UP);
        
        BigDecimal[] f=new BigDecimal[fx.length];
        f[0]=fx[0];
        for(int i=1;i<fx.length;i++){
            if(i!=(fx.length-1)){
                f[i]=(multiplicando.multiply(fx[i]));
            }else{
                f[i]=fx[i];
            }
        }
        BigDecimal Resultado=new BigDecimal("0");
        for(int i=1;i<f.length;i++){
            Resultado=Resultado.add(f[i]);
        }
        Resultado=Resultado.multiply(temp);
        Resultado=Resultado.setScale(escala, BigDecimal.ROUND_HALF_UP/*RoundingMode.HALF_UP*/);
        return Resultado;
    }
    
    public BigDecimal Simpson_1_3_Compuesta(BigDecimal[] fx, BigDecimal h, int escala){      
        BigDecimal multiplicando=new BigDecimal("4");
        
        BigDecimal divisor=new BigDecimal("3");
        BigDecimal temp;        temp=h.divide(divisor,9,RoundingMode.HALF_UP);
        
        BigDecimal[] f=new BigDecimal[fx.length];
        f[0]=fx[0];
        for(int i=1;i<fx.length;i++){
            if(i!=(fx.length-1)){
                f[i]=(multiplicando.multiply(fx[i]));
                if(i%2==0) multiplicando=new BigDecimal("2");
                else multiplicando=new BigDecimal("4");
            }else{
                f[i]=fx[i];
            }
        }
        BigDecimal Resultado=new BigDecimal("0");
        for(int i=1;i<f.length;i++){
            Resultado=Resultado.add(f[i]);
        }
        Resultado=Resultado.multiply(temp);
        Resultado=Resultado.setScale(escala, BigDecimal.ROUND_HALF_UP/*RoundingMode.HALF_UP*/);
        return Resultado;
    }
    
    public BigDecimal Simpson_3_8_Compuesta(BigDecimal[] fx, BigDecimal h, int escala){      
        BigDecimal multiplicando=new BigDecimal("3");
        
        BigDecimal divisor=new BigDecimal("8");
        BigDecimal temp;        temp=(multiplicando.multiply(h)).divide(divisor,9,RoundingMode.HALF_UP);
        
        BigDecimal[] f=new BigDecimal[fx.length];
        f[0]=fx[0];
        System.out.println(fx[0]);
        for(int i=0;i<(fx.length-1);i=i+3){
            System.out.println("i: "+i);
            f[i+1]=(multiplicando.multiply(fx[i+1]));
            f[i+2]=(multiplicando.multiply(fx[i+2]));
            multiplicando=new BigDecimal("2");
            if((i+3)!=(fx.length-1)){
                f[i+3]=(multiplicando.multiply(fx[i+3]));
                multiplicando=new BigDecimal("3");              
            }else{
                f[i+3]=fx[i+3];
                System.out.println(f[i+3]);
            }
        }
        BigDecimal Resultado=new BigDecimal("0");
        for(int i=0;i<f.length;i++){
            Resultado=Resultado.add(f[i]);            
        }
        Resultado=Resultado.multiply(temp);
        Resultado=Resultado.setScale(escala, BigDecimal.ROUND_HALF_UP/*RoundingMode.HALF_UP*/);
        return Resultado;
    }
}
