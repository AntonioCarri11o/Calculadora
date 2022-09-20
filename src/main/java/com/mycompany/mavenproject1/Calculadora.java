/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.mavenproject1;

import model.DaoOperacion;

import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Antonio Carrillo
 */
public class Calculadora {

    public static void main(String[] args) {
        Scanner scanner= new Scanner(System.in);
        String numbertoString;
        DaoOperacion daoOperacion= new DaoOperacion();
        Operacion operacion= new Operacion();
        Validar validar= new Validar();
        boolean error;
        double n1;
        double n2;
        double result;
        int opc=9;
        while (opc!=8){
            System.out.println("Escoje una opción");
            System.out.println("1.-Suma de dos números");
            System.out.println("2.-Resta de dos números");
            System.out.println("3.-Multiplicación de dos números");
            System.out.println("4.-División de un número entre otro");
            System.out.println("5.-Exponentes");
            System.out.println("6.-Raiz");
            System.out.println("7.-Historial");
            System.out.println("8.-Salir");
            String opcToString=scanner.next();
            error=validar.isInt(opcToString);
            if(error==true){
                System.out.println("Tipo de dato incorrecto");
            }else{
                opc=Integer.parseInt(opcToString);
                error=true;
            }
            switch (opc){
                case 6:
                    System.out.println("Ingresa un número");
                    numbertoString=scanner.next();
                    error=validar.isDouble(numbertoString);
                    while (error!=false){
                        System.out.println("Ese no es un número, intenta nuevamente");
                        numbertoString=scanner.next();
                        error=validar.isDouble(numbertoString);
                    }
                    if(error==false){
                        n1=Double.parseDouble(numbertoString);
                        operacion.setN1(n1);
                    }
                    result=operacion.raiz();
                    System.out.println("El resultado es: "+operacion.getResult());
                    operacion.setType("raiz");
                    daoOperacion.saveOperation(operacion);
                    break;
                case 7:
                    System.out.println("Historial");
                    System.out.println("ID | Tipo | primer valor | segundo valor | Resultado | Fecha y hora");
                    List<Operacion> listOperations=daoOperacion.listOperations();
                    String row="";
                    for(int i=0; i<listOperations.size(); i++){
                        operacion=listOperations.get(i);
                        row=operacion.getId()+" | "+operacion.getType()+" | "+operacion.getN1()+" | "+operacion.getN2()+" | "+operacion.getResult()+" | "+operacion.getCreated_at();
                        System.out.println(row);
                    }
                    break;
                case 8:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Ingresa un numero");
                    numbertoString=scanner.next();
                    error=validar.isDouble(numbertoString);
                    while (error!=false){
                        System.out.println("Ese no es un número, intenta nuevamente");
                        numbertoString=scanner.next();
                        error=validar.isDouble(numbertoString);
                    }
                    if(error==false){
                        n1=Double.parseDouble(numbertoString);
                        operacion.setN1(n1);
                    }
                    System.out.println("Ingresa otro número");
                    numbertoString=scanner.next();
                    error=validar.isDouble(numbertoString);
                    while (error!=false){
                        System.out.println("Ese no es un número, intenta nuevamente");
                        numbertoString=scanner.next();
                        error=validar.isDouble(numbertoString);
                    }
                    if(error==false){
                        n2=Double.parseDouble(numbertoString);
                        operacion.setN2(n2);
                    }
                    switch (opc){
                        case 1:
                            result=operacion.suma();
                            System.out.println("El resultado es: "+operacion.getResult());
                            operacion.setType("suma");
                            daoOperacion.saveOperation(operacion);
                            break;
                        case 2:
                            result=operacion.resta();
                            System.out.println("El resultado es: "+operacion.getResult());
                            operacion.setType("resta");
                            daoOperacion.saveOperation(operacion);
                            break;
                        case 3:
                            result=operacion.producto();
                            System.out.println("El resultado es: "+operacion.getResult());
                            operacion.setType("producto");
                            daoOperacion.saveOperation(operacion);
                            break;
                        case 4:
                            result=operacion.division();
                            System.out.println("El resultado es: "+operacion.getResult());
                            operacion.setType("division");
                            daoOperacion.saveOperation(operacion);
                            break;
                        case 5:
                            result=operacion.pow();
                            System.out.println("El resultado es: "+operacion.getResult());
                            operacion.setType("potencia");
                            daoOperacion.saveOperation(operacion);
                            break;
                        default:
                            System.out.println("Esa no es una opción");
                            break;
                    }
                    break;
            }
        }
    }
}
//RODOLFO ANTONIO CARRILLO FUENTES                                                                  4B