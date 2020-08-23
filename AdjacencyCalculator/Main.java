package src;
import java.util.Scanner;
import java.util.ArrayList;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Enter number of departments: ");
		int numOfDepartments = scanner.nextInt();
		System.out.println("Enter number of adjacent departments: ");
		int numOfAdjDepartments = scanner.nextInt();
		
		ArrayList<Department> Departments = new ArrayList<Department>();
	    ArrayList<AdjacentDepartment> AdjacentDepartments = new ArrayList<AdjacentDepartment>();
        
	    for (int x = 0; x < numOfDepartments; x++)
        {
           System.out.println("Enter Department Name: ");
           scanner.nextLine();
           String name = scanner.nextLine();
           System.out.println("Enter Dep Index: ");
           int index = scanner.nextInt();
           Department department = new Department(name, index);
           Departments.add(department);
        }
	    
	    for (int x = 0; x < numOfAdjDepartments; x++)
        {
            Department[] adjacentDepartments = new Department[2];

            System.out.println("Enter First Department Index: ");
            int firstDepIndex = scanner.nextInt();
            for (int y = 0; y < numOfDepartments; y++)
            {
                if(Departments.get(y).Index == firstDepIndex)
                {
                    adjacentDepartments[0] = Departments.get(y);
                }
            }
            System.out.println("Enter Second Department Index: ");
            int secondDepIndex = scanner.nextInt();
            for (int y = 0; y < numOfDepartments; y++)
            {
                if (Departments.get(y).Index == secondDepIndex)
                {
                    adjacentDepartments[1] = Departments.get(y);
                }
            }
            System.out.println("Enter Closeness Rating: ");
            double ClosenessRating = scanner.nextInt();

            AdjacentDepartment adjacentDepartment = new AdjacentDepartment(adjacentDepartments[0], adjacentDepartments[1], ClosenessRating);
            AdjacentDepartments.add(adjacentDepartment);
        }

        AdjacencyScoreCalculator Calculator = new AdjacencyScoreCalculator(numOfDepartments, Departments, AdjacentDepartments);
        double result = Calculator.CalculateTotal();
        
        System.out.println("Total Result: " + result);
	}
}
