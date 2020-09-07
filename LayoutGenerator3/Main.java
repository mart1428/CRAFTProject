package src;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    private Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        /*UserInput start = new UserInput();
        int facilityLength = start.getFacilityLength();
        int facilityWidth = start.getFacilityWidth();
        */
    	ArrayList<Department> departmentList = new ArrayList<>();
    	
    	//to create simplelayout
    	for (int x = 1; x <= 6; x++) {
    		Department department = new Department("1", 1, x, null);
            departmentList.add(department);
    	}
        

        //ArrayList<String[]> adjacencyPreference = start.getAdjacencyPreference();
        //ArrayList<Float> preferenceRating = start.getPreferenceRating();
        ArrayList<Float> closenessRating;           //No methods available yet


        switch(3){
            case 1: // adjacent department test case
        LayoutGenerator startGen = new LayoutGenerator(3, 2, departmentList);
        //startGen.setMaxIteration();
        startGen.GetSimpleLayout();
        startGen.printSimpleLayout();

        startGen.getLinkedDepartments();
        startGen.populateAdjacentDepartments();
        //startGen.printAdjacentDepartments();
        startGen.populateAdjacentRatings();

        double score1 = startGen.calculateAdjacencyScore();
        System.out.println("normal: " + score1);
        double score2 = startGen.calculateAdjacencyScorev2();
        System.out.println("simple: " + score2);

        break;

            case 2: //test case  with full user input
                UserInput start = new UserInput();
                LayoutGenerator gen = new LayoutGenerator(start.getFacilityLength(),
                        start.getFacilityWidth(), start.getDepartmentList(), 10000);

                gen.getLinkedDepartments();
//        gen.populateAdjacentDepartments();
//        gen.populateAdjacentRatings();
//        System.out.println("Score (normal): " + gen.calculateAdjacencyScore());
//        System.out.println("Score (simple): " + gen.calculateAdjacencyScorev2());'

                gen.findOptimalLayout();

                gen.printOptimalLayout();
            break;

            case 3: //test case 3 with specified facility length, width, department list and 10000 iterations
                int facilityLength = 2;
                int facilityWidth = 2;
                Department a = new Department("A", 1, 1, null);
                Department b = new Department("B", 1, 2, null);
                Department c = new Department("C", 1, 3, null);
                Department d = new Department("D", 1, 4, null);


                    ArrayList<Department> deptList = new ArrayList<Department>(Arrays.asList(a, b, c, d));
                    LayoutGenerator gen2 = new LayoutGenerator(facilityLength, facilityWidth, deptList, 10000);
                    gen2.getLinkedDepartments();
                    gen2.findOptimalLayout();
                    gen2.printOptimalLayout();


        }





    }
}
