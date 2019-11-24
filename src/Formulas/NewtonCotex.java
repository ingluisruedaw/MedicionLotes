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
public class NewtonCotex {
    /*Dos puntos*/
    public BigDecimal Trapecio(BigDecimal[] fx, BigDecimal a, BigDecimal b, int escala){       
        BigDecimal temp,temp2;
        BigDecimal resultado=new BigDecimal("0");
        BigDecimal divisor=new BigDecimal("2");
        temp=b.add(a.negate());
        temp2=(fx[0].add(fx[1])).divide(divisor,9,RoundingMode.HALF_UP);
        resultado=temp.multiply(temp2);
        resultado=resultado.setScale(escala, BigDecimal.ROUND_HALF_UP/*RoundingMode.HALF_UP*/);
        return resultado;
    }
    
    /*tres puntos*/
    public BigDecimal Simpson_1_3(BigDecimal[] fx, BigDecimal a, BigDecimal b,int escala){
        BigDecimal divisor,temp;
        BigDecimal resultado=new BigDecimal("0");
        divisor=new BigDecimal("6");
        temp=b.add(a.negate());
        fx[1]=new BigDecimal("4").multiply(fx[1]);
        resultado=(temp.multiply(((fx[0].add(fx[1]).add(fx[2])).divide(divisor,9,RoundingMode.HALF_UP))));
        resultado=resultado.setScale(escala, BigDecimal.ROUND_HALF_UP/*RoundingMode.HALF_UP*/);
        return resultado;
    }
    
    /*cuatro puntos*/
    public BigDecimal Simpson_3_8(BigDecimal[] fx, BigDecimal a, BigDecimal b,int escala){
        BigDecimal divisor,resultado,temp;
        resultado=new BigDecimal("0");          divisor=new BigDecimal("8");
        temp=b.add(a.negate());
        fx[1]=new BigDecimal("3").multiply(fx[1]);
        fx[2]=new BigDecimal("3").multiply(fx[2]);
        resultado=temp.multiply((fx[0].add(fx[1]).add(fx[2]).add(fx[3])).divide(divisor,9,RoundingMode.HALF_UP));
        resultado=resultado.setScale(escala, BigDecimal.ROUND_HALF_UP/*RoundingMode.HALF_UP*/);
        return resultado;
    }
    
    /*cinco puntos*/
    public BigDecimal boole_5(BigDecimal[] fx, BigDecimal a, BigDecimal b, int escala){
        BigDecimal divisor,resultado,temp;
        divisor=new BigDecimal("90");
        temp=b.add(a.negate());
        fx[0]=new BigDecimal("7").multiply(fx[0]);
        fx[1]=new BigDecimal("32").multiply(fx[1]);
        fx[2]=new BigDecimal("12").multiply(fx[2]);
        fx[3]=new BigDecimal("32").multiply(fx[3]);
        fx[4]=new BigDecimal("7").multiply(fx[4]);
        resultado=temp.multiply((fx[0].add(fx[1]).add(fx[2]).add(fx[3]).add(fx[4])).divide(divisor,9,RoundingMode.HALF_UP));
        resultado=resultado.setScale(escala, BigDecimal.ROUND_HALF_UP/*RoundingMode.HALF_UP*/);
        return resultado;
    }
    
    /*seis puntos*/
    public BigDecimal boole_6(BigDecimal[] fx, BigDecimal a, BigDecimal b, int escala){
        BigDecimal divisor,resultado,temp;
        divisor=new BigDecimal("288");
        temp=b.add(a.negate());
        fx[0]=new BigDecimal("19").multiply(fx[0]);
        fx[1]=new BigDecimal("75").multiply(fx[1]);
        fx[2]=new BigDecimal("50").multiply(fx[2]);
        fx[3]=new BigDecimal("50").multiply(fx[3]);
        fx[4]=new BigDecimal("75").multiply(fx[4]);
        fx[5]=new BigDecimal("19").multiply(fx[5]);
        resultado=temp.multiply((fx[0].add(fx[1]).add(fx[2]).add(fx[3]).add(fx[4]).add(fx[5])).divide(divisor,9,RoundingMode.HALF_UP));
        resultado=resultado.setScale(escala, BigDecimal.ROUND_HALF_UP/*RoundingMode.HALF_UP*/);
        return resultado;
    }
}
