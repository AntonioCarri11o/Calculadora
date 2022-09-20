package com.mycompany.mavenproject1;

public class Operacion {
    private  int id;
    private String type;
    private String created_at;
    private double n1;
    private double n2;
    private double result;

    public double getN1() {
        return n1;
    }

    public void setN1(double n1) {
        this.n1 = n1;
    }

    public double getN2() {
        return n2;
    }

    public void setN2(double n2) {
        this.n2 = n2;
    }

    public double getResult() {
        return result;
    }

    public void setResult(double result) {
        this.result = result;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public double suma(){
        result=n1+n2;
        return result;
    }
    public double resta(){
        result=n1-n2;
        return result;
    }
    public double producto(){
        result=n1*n2;
        return result;
    }
    public double division(){
        result=n1/n2;
        return result;
    }
    public double pow(){
        result= Math.pow(n1,n2);
        return result;
    }
    public double raiz(){
        result =Math.sqrt(n1);
        n2=2;
        return result;
    }
}
