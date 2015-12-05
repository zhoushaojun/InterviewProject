package com.netease.google.guava;

import com.google.common.base.Objects;
import com.google.common.collect.ComparisonChain;
import com.google.common.collect.Ordering;

public class ObjectTest {
    public int age;
    public ObjectTest(int age) {
        this.age =age;
        // TODO Auto-generated constructor stub
    }
    public static void main(String[] args) {
        StudentTest();
    }
    public static void StudentTest(){
        
        Student student=new Student("peida",23,80);
        Student student1=new Student("aida",23,36);
        Student student2=new Student("jerry",24,90);
        Student student3=new Student("peida",23,80);
        
        System.out.println("==========equals===========");
        System.out.println(student.equals(student2));
        System.out.println(student.equals(student1));
        System.out.println(student.equals(student3));
        
        System.out.println("==========hashCode===========");
        System.out.println(student.hashCode());
        System.out.println(student1.hashCode());
        System.out.println(student3.hashCode());
        System.out.println(student2.hashCode());
        
        System.out.println("==========toString===========");
        System.out.println(student.toString());
        System.out.println(student1.toString());
        System.out.println(student2.toString());
        System.out.println(student3.toString());
        
        System.out.println("==========compareTo===========");
        System.out.println(student.compareTo(student1));
        System.out.println(student.compareTo(student2));
        System.out.println(student2.compareTo(student1));
        System.out.println(student2.compareTo(student));
        
    }

}

class Student implements Comparable<Student>{
    public String name;
    public int age;
    public int score;
    
    
    Student(String name, int age,int score) {
        this.name = name;
        this.age = age;
        this.score=score;
    }
    
    @Override
    public int hashCode() {
        return Objects.hashCode(name, age);
    }
    
    
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Student) {
            Student that = (Student) obj;
            return Objects.equal(name, that.name)
                    && Objects.equal(age, that.age)
                    && Objects.equal(score, that.score);
        }
        return false;
    }
    
    @Override
    public String toString() {
        return Objects.toStringHelper(this)
                .addValue(name)
                .addValue(age)
                .addValue(score)
                .toString();
    }
    
    
    @Override
    public int compareTo(Student other) {
        return ComparisonChain.start()
        .compare(name, other.name)
        .compare(age, other.age)
        .compare(score, other.score, Ordering.natural().nullsLast())
        .result();
    }
}
