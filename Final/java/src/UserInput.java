package src;

import java.util.ArrayList;
import java.util.Scanner;

public class UserInput {
    private int facilityLength;
    private int facilityWidth;
    private ArrayList<Department> departmentList = new ArrayList<>();
    private ArrayList<String[]> adjacencyPreference = new ArrayList<>();
    private ArrayList<Float> preferenceRating = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    public UserInput() {
        System.out.print("Enter facility length: ");
        this.facilityLength = (int) scanner.nextFloat();
        scanner.nextLine();
        System.out.print("Enter facility width: ");
        this.facilityWidth = (int) scanner.nextFloat();
        scanner.nextLine();

        boolean flag = true;
        do {
            System.out.print("Enter department name: ");
            String name = scanner.nextLine();
            System.out.print("Enter department area: ");
            int area = scanner.nextInt();
            scanner.nextLine();
            System.out.print("Enter department cargo: ");
            int cargo = scanner.nextInt();
            scanner.nextLine();
            System.out.print("Enter department shape(optional): ");
            String shape = scanner.nextLine();
            if (shape.isEmpty()) {
                shape = null;
            }
            Department department = new Department(name, area, cargo, shape);
            this.departmentList.add(department);

            System.out.print("Exit[Y/n]: ");
            String option = scanner.nextLine();
            if (option.equals("Y")) {
                flag = false;
            }
        } while (flag);

//        flag = true;
//        System.out.print("Set adjacency preference[Y/n]: ");
//        String option = scanner.nextLine();
//        if(option.equals("n")){
//            flag = false;
//        }

//        while(flag){
//            System.out.print("Enter department 1 name: ");
//            String dept1 = scanner.nextLine();
//            if(!hasDept(dept1)){
//                System.out.print("Department could not be found. ");
//            }else{
//                System.out.print("Enter department 2 name: ");
//                String dept2 = scanner.nextLine();
//                if(!hasDept(dept2)){
//                    System.out.print("Department could not be found. ");
//                }else{
//                    System.out.print("Enter closeness rating [1-10]: ");
//                    float rate = scanner.nextFloat();
//                    scanner.nextLine();
//                    String[] adj = new String[]{dept1,dept2};
//                    this.adjacencyPreference.add(adj);
//                    this.preferenceRating.add(rate);
//                }
//            }
//
//            System.out.print("Exit[Y/n]: ");
//            option = scanner.nextLine();
//            if(option.equals("Y")){
//                flag = false;
//            }
//        }
    }

    //-----Methods-----
    public boolean hasDept(String department){
        for(int i = 0; i <= departmentList.size()-1; i++){
            if(department.equals(departmentList.get(i).getName())){
                return true;
            }
        }

        return false;
    }

    //-----Getters, Setters-----

    public void setFacilityLength(int facilityLength){
        this.facilityLength = facilityLength;
        System.out.println("Facility length has been modified.");
    }

    public void setFacilityLength(){
        System.out.print("Enter facility length: ");
        facilityLength = scanner.nextInt();
        scanner.nextLine();
        setFacilityLength(facilityLength);
    }

    public int getFacilityLength(){
        return this.facilityLength;
    }

    public void setFacilityWidth(int facilityWidth){
        this.facilityWidth = facilityWidth;
        System.out.println("Facility width has been modified.");
    }

    public void setFacilityWidth(){
        System.out.print("Enter facility width: ");
        facilityWidth = scanner.nextInt();
        scanner.nextLine();
        setFacilityWidth(facilityWidth);
    }

    public int getFacilityWidth(){
        return this.facilityWidth;
    }

    public ArrayList<Department> getDepartmentList(){
        return this.departmentList;
    }

    public ArrayList<String[]> getAdjacencyPreference(){
        return this.adjacencyPreference;
    }

    public ArrayList<Float> getPreferenceRating(){
        return this.preferenceRating;
    }
}
