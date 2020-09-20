package src;

import java.util.ArrayList;

public class AdjacencyScoreCalculator {
	public int NumberOfDepartments;
    public ArrayList<Department> Departments;
    public ArrayList<AdjacentDepartment> AdjacentDepartments;

    public AdjacencyScoreCalculator(int numberOfDepartments, ArrayList<Department> departments, ArrayList<AdjacentDepartment> adjacentDepartments)
    {
        NumberOfDepartments = numberOfDepartments;
        Departments = departments;
        AdjacentDepartments = adjacentDepartments;
    }

    public double CalculateTotal()
    {
        double result = 0;
        int StartingIndex = 0;
        for (int x = 0; x < NumberOfDepartments; x++)
        {
            for (int y = StartingIndex; y < NumberOfDepartments; y++)
            { 
                result += CalculateFromTwo(Departments.get(x), Departments.get(y));
            }
            StartingIndex++;
        }
        return result;
    }

    public double CalculateFromTwo(Department firstDepartment, Department secondDepartment)
    {
        double AdjacentScore = 0;
        double ClosenessRating = 0;
        int AdjacentDepartmentsSize = AdjacentDepartments.size();

        for(int x = 0; x < AdjacentDepartmentsSize; x++)
        {
            if (AdjacentDepartments.get(x).CheckDepartments(firstDepartment, secondDepartment)) {
                ClosenessRating = AdjacentDepartments.get(x).getClosenessRating();
                AdjacentScore = 1;
            }
        }

        double FinalScore = ClosenessRating*AdjacentScore;
        return FinalScore;
    }
    
    //simpler version rofl, just get total ratings from the adjacent array
    public double CalculateTotalv2() {
    	double result = 0;
    	for (int x = 0; x < this.AdjacentDepartments.size(); x++) {
    		result += this.AdjacentDepartments.get(x).getClosenessRating();
    	}
    	return result;
    }
}
