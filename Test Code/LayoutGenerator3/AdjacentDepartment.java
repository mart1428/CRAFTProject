package src;

public class AdjacentDepartment {
	Department[] Departments = new Department[2];
	private double ClosenessRating;

    public AdjacentDepartment(Department firstDepartment, Department secondDepartment, double score)
    {
        Departments[0] = firstDepartment;
        Departments[1] = secondDepartment;
        ClosenessRating = score;
    }

    public boolean CheckDepartments(Department firstDepartment, Department secondDepartment)
    {
        if (Departments[0].getCargo() == firstDepartment.getCargo() && Departments[1].getCargo() == secondDepartment.getCargo())
        {
            return true;
        }
        else if (Departments[1].getCargo() == firstDepartment.getCargo() && Departments[0].getCargo() == secondDepartment.getCargo())
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    
    
    public void setClosenessRating(double num) {
    	this.ClosenessRating = num;
    }
    
    public double getClosenessRating() {
    	return this.ClosenessRating;
    }
}
