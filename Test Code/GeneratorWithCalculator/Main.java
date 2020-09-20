package src;

import java.util.ArrayList;
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

        LayoutGenerator startGen = new LayoutGenerator(3, 2, departmentList);
        //startGen.setMaxIteration();
        startGen.GetSimpleLayout();
        startGen.printSimpleLayout();
        
        startGen.getLinkedDepartments();
        startGen.populateAdjacentDepartments();
        //startGen.printAdjacentDepartments();
        startGen.populateAdjacentRatings();
        
        double score1 = startGen.CalculateAdjacencyScore();
        System.out.println("normal: " + score1);
        double score2 = startGen.CalculateAdjacencyScorev2();
        System.out.println("simple: " + score2);
       
       
    }
}
