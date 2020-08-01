package chris.LayoutGenerator;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class LayoutGenerator {
    private int facilityLength;
    private int facilityWidth;
    private int maxIteration;
    private ArrayList<Department> departmentList;
    private ArrayList<ArrayList<Integer>> optimalLayout;
    private ArrayList<Float> closenessRating;                                         //an array containing closeness rating
    private ArrayList<Float> preferenceRating;
    private Scanner scanner = new Scanner(System.in);
    private Random random = new Random();

    //-----Methods-----
    public void findOptimalLayout(){
        ArrayList<ArrayList<Integer>> optimalLayout = new ArrayList<>();
        float optimalScore = 0;
        int count = 1;

        //Need a loop
        while(count<=this.maxIteration) {

            System.out.print("Iteration " + count + ".");       //Generating a random Layout
            ArrayList<ArrayList<Integer>> layout;
            layout = createBase();

            ArrayList<Integer> departmentIndex = new ArrayList<>();
            for (int dept = 0; dept <= this.departmentList.size() - 1; dept++) {
                departmentIndex.add(this.departmentList.get(dept).getCargo());
            }

            for (int r = 0; r <= this.facilityWidth - 1; r++) {
                ArrayList<Integer> row = layout.get(r);
                for (int c = 0; c <= this.facilityLength - 1; c++) {

                    int idx = random.nextInt(departmentIndex.size());
                    row.set(c, departmentIndex.get(idx));
                    departmentIndex.remove(idx);
                }
                layout.set(r, row);
            }

            //        System.out.println(layout.toString());
            System.out.print(".");      //Adjacency Score
            //Adjacency Score

            System.out.println(".");    //Comparing adjacency score
            this.optimalLayout = layout;  //Modify with the most optimal layout

            count++;
            System.out.println(layout.toString());;
        }
    }

    public ArrayList<ArrayList<Integer>> createBase(){
        ArrayList<ArrayList<Integer>> base = new ArrayList<>();
        for(int r = 0; r <= this.facilityWidth-1; r++){
            ArrayList<Integer> row = new ArrayList<>();
            for(int col = 0; col <= this.facilityLength-1; col++){
                row.add(0);
            }
            base.add(row);
        }
        return base;
    }

    public void printOptimalLayout(){
        ArrayList<ArrayList<Integer>> layout = this.optimalLayout;
        for(int i = 0; i <= layout.size()-1; i++){
            System.out.println(layout.get(i).toString());
        }
    }

    //-----Constructors, Getters, Setters-----
    public LayoutGenerator(int facilityLength, int facilityWidth, ArrayList<Department> departmentList, int maxIteration){
        this.facilityLength = facilityLength;
        this.facilityWidth = facilityWidth;
        this.departmentList = departmentList;
        this.maxIteration = maxIteration;
    }

    public LayoutGenerator(int facilityLength, int facilityWidth, ArrayList<Department> departmentList){
        this(facilityLength,facilityWidth,departmentList, 10000);
    }

    public LayoutGenerator(int facilityLength, int facilityWidth){
        this(facilityLength, facilityWidth, null);
    }

    public LayoutGenerator(){
        this(0,0);
    }

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
        System.out.println("Facility Width has been modified.");
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

    public void setMaxIteration(int maxIteration){
        this.maxIteration = maxIteration;
        System.out.println("Max iteration has been modified.");
    }

    public void setMaxIteration(){
        System.out.print("Enter max iteration: ");
        maxIteration = scanner.nextInt();
        scanner.nextLine();
        setMaxIteration(maxIteration);
    }

    public int getMaxIteration(){
        return this.maxIteration;
    }
}
