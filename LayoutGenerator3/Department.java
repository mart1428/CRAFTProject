package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Department {
    private String name;
    private int area;
    private int cargo;                                      //Department Index
    private String shape;
    private ArrayList<int[]> areaComb = new ArrayList<int[]>();
    private Scanner scanner = new Scanner(System.in);


//-------------Methods-------------
    public void details(){
        String s;
        s = "-----Details-----\n" +
            "Department Name:\t\t" + this.name + "\n" +
            "Department Area:\t\t" + this.area + "\n" +
            "Department Cargo:\t\t" + this.cargo + "\n" +
            "Department Shape:\t\t" + this.shape + "\n"+
            "-----------------";
        System.out.println(s);
    }






//-------------Constructors, Getters, and Setters-------------
    public Department(String name, int area, int cargo, String shape){
        this.name = name;
        this.area = area;
        this.cargo = cargo;
        this.shape = shape;
    }

    public Department(String name, int area, int cargo){
        this(name, area, cargo, null);
    }

    public Department(String name, int area){
        this(name, area, 0);
    }

    public Department(String name){
        this(name, 0);
    }

    public void setName(String name){
        this.name = name;
        System.out.println("Name has been modified.");
    }

    public void setName(){
        System.out.print("Enter department name: ");
        name = scanner.nextLine();
        setName(name);
    }

    public String getName(){
        return this.name;
    }

    public void setArea(int area){
        this.area = area;
        System.out.println("Area has been modified.");
    }

    public void setArea(){
        System.out.print("Enter department name: ");
        area = scanner.nextInt();
        scanner.nextLine();
        setArea(area);
    }

    public int getArea(){
        return this.area;
    }

    public void setCargo(int cargo){
        this.cargo = cargo;
        System.out.println("Cargo has been modified.");
    }

    public void setCargo(){
        System.out.print("Enter department cargo: ");
        cargo = scanner.nextInt();
        scanner.nextLine();
        setCargo(cargo);
    }

    public int getCargo(){
        return this.cargo;
    }

    public void setShape(String shape){
        this.shape = shape;
        System.out.println("Shape has been modified.");
    }

    public void setShape(){
        System.out.println("Enter department shape: ");
        shape = scanner.nextLine();
        setShape(shape);
    }

    public String getShape(){
        return this.shape;
    }
}