package com.learn.api;

public class Math {
    public int add(int a, int b){
        return a+b;
    }
    public int sub(int a, int b){
        return a-b;
    }
    public int mul(int a, int b){
        return a*b;
    }
    public int div(int a, int b){
        return a/b;
    }
    public boolean isInt(String val)
    {
        try{
            Integer.parseInt(val);
            return true;
        }
        catch (Exception e){
            return false;
        }
    }
}
