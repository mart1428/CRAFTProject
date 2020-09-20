package src;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class LayoutGenerator {
    private int facilityLength;
    private int facilityWidth;
    private int maxIteration;
    private ArrayList<Department> departmentList;
    private ArrayList<ArrayList<Integer>> optimalLayout;
    //private ArrayList<Float> closenessRating;                                         //an array containing closeness rating
    private ArrayList<Float> preferenceRating;
    private Scanner scanner = new Scanner(System.in);
    private Random random = new Random();

    private ArrayList<ArrayList<Integer>> SimpleLayout;
    private ArrayList<AdjacentDepartment> AdjacentDepartments;	//actual adjacentDepartments based on layout
    private ArrayList<AdjacentDepartment> LinkedDepartments; 	//for scores, not based on layout
   
    
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
                departmentIndex.add(this.departmentList.get(dept).getCargo());	//get cargo number from the List
            }

            for (int r = 0; r <= this.facilityWidth - 1; r++) {
                ArrayList<Integer> row = layout.get(r);
                for (int c = 0; c <= this.facilityLength - 1; c++) {
                	
                	System.out.println("test" + departmentIndex.size());
                    int idx = random.nextInt(departmentIndex.size());	//get random dept from array
                    System.out.println("test2" + idx);
                    row.set(c, departmentIndex.get(idx));
                    departmentIndex.remove(idx);		//remove from array
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
    
    
    //create simple layout, 123456... in order, 1 area each, based on layout dimensions
    //for testing purposes
    public void GetSimpleLayout() {
    	ArrayList<ArrayList<Integer>> simpleLayout = new ArrayList<>();		//2d array
    	simpleLayout = createBase();
    	
    	ArrayList<Integer> departmentIndex = new ArrayList<>();
    	for (int dept = 0; dept < this.departmentList.size(); dept++) {
            departmentIndex.add(this.departmentList.get(dept).getCargo());	//get cargo number from the List
        }
    	
    	int count = 0;
    	for (int x = 0; x < this.facilityWidth; x++) {
    		for (int y = 0; y < this.facilityLength; y++) {
    			ArrayList<Integer> row = simpleLayout.get(x);
    			row.set(y, departmentIndex.get(count));
    			simpleLayout.set(x, row);
    			count++;
    		}
    	}
    	
    	this.SimpleLayout = simpleLayout;
    }
    
    public void printSimpleLayout() {
    	ArrayList<ArrayList<Integer>> layout = this.SimpleLayout;
    	for (int x = 0; x < this.facilityWidth; x++) {
    		for (int y = 0; y < this.facilityLength; y++) {
    			ArrayList<Integer> row = new ArrayList<>();
    			row = layout.get(x);
    			System.out.print(row.get(y));
    		}
    		System.out.print("\n");
    	}
    }
    
    //populate adjacent departments based on layout generated
    //the one below takes the layout from SimpleLayout, but method can be used for any layout
    public void populateAdjacentDepartments() {
    	ArrayList<ArrayList<Integer>> layout = this.SimpleLayout;
    	ArrayList<AdjacentDepartment> adjacentDepartments = new ArrayList<>();
    	
    	//horizontally
    	for (int x = 0; x < this.facilityWidth; x++) {
    		for (int y = 1; y < this.facilityLength; y++) {
    			ArrayList<Integer> row = new ArrayList<>();
    			row = layout.get(x);
    			
    			Department[] Departments = new Department[2];
    			for (int z = 0; z < this.departmentList.size(); z++) {
    				if (row.get(y-1) == departmentList.get(z).getCargo()) {
    					Departments[0] = departmentList.get(z);
    				}
    				
    				if (row.get(y) == departmentList.get(z).getCargo()) {
    					Departments[1] = departmentList.get(z);
    				}
    			}
    			
    			 AdjacentDepartment adjacentDepartment = new AdjacentDepartment(Departments[0], Departments[1], 0);
    			 /*System.out.print(adjacentDepartment.Departments[0].getCargo());
    			 System.out.print(adjacentDepartment.Departments[1].getCargo());
    			 System.out.print("\n");
    			 */adjacentDepartments.add(adjacentDepartment);
    		}
    	}
    	
    	//vertically
    	for (int x = 1; x < this.facilityWidth; x++) {
    		ArrayList<Integer> firstrow = new ArrayList<>();
			firstrow = layout.get(x-1);
			ArrayList<Integer> secondrow = new ArrayList<>();
			secondrow = layout.get(x);
			
    		for (int y = 0; y < this.facilityLength; y++) {
    			Department[] Departments = new Department[2];
    			for (int z = 0; z < this.departmentList.size(); z++) {
    				if (firstrow.get(y) == departmentList.get(z).getCargo()) {
    					Departments[0] = departmentList.get(z);
    				}
    				
    				if (secondrow.get(y) == departmentList.get(z).getCargo()) {
    					Departments[1] = departmentList.get(z);
    				}
    			}
    			
    			 AdjacentDepartment adjacentDepartment = new AdjacentDepartment(Departments[0], Departments[1], 0);
    			 /*System.out.print(adjacentDepartment.Departments[0].getCargo());
    			 System.out.print(adjacentDepartment.Departments[1].getCargo());
    			 System.out.print("\n");
    			 */adjacentDepartments.add(adjacentDepartment);
    		}
    	}
    	
    	this.AdjacentDepartments = adjacentDepartments;
    }
    
    //get linked departments/scores from user (used scanner here)
    public void getLinkedDepartments() {		
    	System.out.println("Enter number of adjacent departments: ");
		int numOfAdjDepartments = scanner.nextInt();
		
		ArrayList<AdjacentDepartment> linkedDepartments = new ArrayList<AdjacentDepartment>();
		for (int x = 0; x < numOfAdjDepartments; x++)
        {
            Department[] adjacentDepartment = new Department[2];

            System.out.println("Enter First Department Index: ");
            int firstDepIndex = scanner.nextInt();
            for (int y = 0; y < this.departmentList.size(); y++)
            {
                if(this.departmentList.get(y).getCargo() == firstDepIndex)
                {
                    adjacentDepartment[0] = this.departmentList.get(y);
                }
            }
            System.out.println("Enter Second Department Index: ");
            int secondDepIndex = scanner.nextInt();
            for (int y = 0; y < this.departmentList.size(); y++)
            {
                if (this.departmentList.get(y).getCargo() == secondDepIndex)
                {
                    adjacentDepartment[1] = this.departmentList.get(y);
                }
            }
            System.out.println("Enter Closeness Rating: ");
            double ClosenessRating = scanner.nextInt();

            AdjacentDepartment linkedDepartment = new AdjacentDepartment(adjacentDepartment[0], adjacentDepartment[1], ClosenessRating);
            linkedDepartments.add(linkedDepartment);
            this.LinkedDepartments = linkedDepartments;
        }
    }
    
    
    //get ratings from LinkedDepartments to the actual AdjacentDepartments(from layout, not user)
    public void populateAdjacentRatings() {
    	for (int x = 0; x < this.AdjacentDepartments.size(); x++) {
    		for (int y = 0; y < this.LinkedDepartments.size(); y++) {
    			if (this.LinkedDepartments.get(y).CheckDepartments(this.AdjacentDepartments.get(x).Departments[0], 
    							this.AdjacentDepartments.get(x).Departments[1])) {
    				this.AdjacentDepartments.get(x).setClosenessRating(this.LinkedDepartments.get(y).getClosenessRating());
    			}
    		}
    	}
    }
    
    
    //calculate adjacency score, used SimpleLayout for the one below below but can be used for any layout
    public double CalculateAdjacencyScore() {
    	AdjacencyScoreCalculator calculator = new AdjacencyScoreCalculator(this.departmentList.size(), this.departmentList, this.AdjacentDepartments);
    	return calculator.CalculateTotal();
    }
    //simpler version
    public double CalculateAdjacencyScorev2() {
    	AdjacencyScoreCalculator calculator = new AdjacencyScoreCalculator(this.departmentList.size(), this.departmentList, this.AdjacentDepartments);
    	return calculator.CalculateTotalv2();
    }
    
    //for debugging purposes(ignore)
    public void printAdjacentDepartments() {
    	for (int x = 0; x < this.AdjacentDepartments.size(); x++) {
    		System.out.print(AdjacentDepartments.get(x).Departments[0].getCargo());
    		System.out.print(AdjacentDepartments.get(x).Departments[1].getCargo());
    		System.out.print("\n");
    	}
    }
    
    //create layout of zeroes
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
