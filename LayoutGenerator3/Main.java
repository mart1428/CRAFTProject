package chris.LayoutGenerator;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        UserInput start = new UserInput();
        int facilityLength = start.getFacilityLength();
        int facilityWidth = start.getFacilityWidth();
        ArrayList<Department> departmentList = start.getDepartmentList();
        ArrayList<String[]> adjacencyPreference = start.getAdjacencyPreference();
        ArrayList<Float> preferenceRating = start.getPreferenceRating();
        ArrayList<Float> closenessRating;           //No methods available yet

        LayoutGenerator startGen = new LayoutGenerator(facilityLength, facilityWidth, departmentList);
        startGen.setMaxIteration();
        startGen.findOptimalLayout();
    }
}
