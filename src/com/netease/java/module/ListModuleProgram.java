package com.netease.java.module;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.apache.commons.lang.math.RandomUtils;

import com.google.common.collect.Lists;

public class ListModuleProgram {

    private static List<? extends Fruit> fruits = new ArrayList<Fruit>();
    private static List<? super Fruit> fruitSuper = new ArrayList<Fruit>();
    
    public static void test(){
        
        List<Fruit> data = Lists.newArrayList();
        Apple apple= new Apple();
        apple.setName("zhou");
        data.add(apple);
        
        fruits = data;
        Fruit fruit = fruits.get(0);
        System.out.println(((Apple)fruit).getName());
        
        fruitSuper.add(new Apple());
       // Fruit fruit2 = fruitSuper.get(0);
    }
    public static void main(String[] args) {
        test();
        int count =0;
        Random random = new Random();
        int one = 0;
        int sec = 0;
        int third = 0;
        int four = 0;
        int five = 0;
        int six = 0;
        int seven= 0;
        int eight = 0;
        int nigh = 0;
        int ten = 0;
        int other =0;
        while(count <=1000000){
            double ff = random.nextGaussian();
            if(Math.abs(ff) >=0 && Math.abs(ff) <0.4){
                //System.out.println(Math.abs(ff));
                one++;
            //System.out.println(random.nextGaussian());
            }else 
            if(Math.abs(ff) >=0.4 && Math.abs(ff) <0.8){
                //System.out.println(Math.abs(ff));
                sec++;
            //System.out.println(random.nextGaussian());
            }else 
            if(Math.abs(ff) >=0.8 && Math.abs(ff) <1.2){
                //System.out.println(Math.abs(ff));
                third++;
            //System.out.println(random.nextGaussian());
            }else
            if(Math.abs(ff) >=1.2&& Math.abs(ff) <1.6){
                //System.out.println(Math.abs(ff));
                four++;
            //System.out.println(random.nextGaussian());
            }else 
            if(Math.abs(ff) >=1.6 && Math.abs(ff) <2.0){
                //System.out.println(Math.abs(ff));
                five++;
            //System.out.println(random.nextGaussian());
            }else if(Math.abs(ff) >=2.0 && Math.abs(ff) <2.4){
                //System.out.println(Math.abs(ff));
                six++;
            //System.out.println(random.nextGaussian());
            }
            else if(Math.abs(ff) >=2.4 && Math.abs(ff) <2.8){
                //System.out.println(Math.abs(ff));
                seven++;
            //System.out.println(random.nextGaussian());
            }else
            if(Math.abs(ff) >=2.8 && Math.abs(ff) <3.2){
                //System.out.println(Math.abs(ff));
                eight++;
            //System.out.println(random.nextGaussian());
            }else if(Math.abs(ff)>3.2&& Math.abs(ff) <=3.6 ){
                nigh++;
            } else if(Math.abs(ff) >3.6 && Math.abs(ff)<=4.0){
                ten++;
            }  else{
                System.out.println(Math.abs(ff));
                other++;
            }
            count++;
            
        }
        System.out.println("one "+one+" sec "+sec +" third "+third +" four "+four+" five "+five
                +" six "+six+" seven "+seven+" eight "+eight+" nigh "+nigh+" ten "+ten+" other "+other);
    }
        
}
class Food {
    protected String name = "123";
    
   
    public String getName() {
        return this.name ;
    }
}



class Fruit  extends Food{
    protected String name = "123";
    
   
    public String getName() {
        return this.name ;
    }
}

class Apple extends Fruit {
    public String name = "11";
    
    public void setName(String name) {
        this.name = name;
    }
}

class Pear extends Apple {
    public String name = "11";
    
    public void setName(String name) {
        this.name = name;
    }
}
