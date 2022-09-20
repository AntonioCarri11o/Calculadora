package com.mycompany.mavenproject1;

public class Validar {
    public boolean isDouble(String number){
        double doubleNumber;
        boolean error=false;
        try{
            doubleNumber=Double.parseDouble(number);
        }catch (Exception e){
            error=true;
        }
        return error;
    }
     public boolean isInt(String number){
        boolean error=false;
        int intNumber;
        try{
            intNumber=Integer.parseInt(number);
        }catch (Exception e){
            error=true;
        }
        return error;
     }
}
