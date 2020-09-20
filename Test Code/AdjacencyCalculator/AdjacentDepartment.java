package src;

public class AdjacentDepartment {
	Department[] Departments = new Department[2];
	public double ClosenessRating;

    public AdjacentDepartment(Department firstDepartment, Department secondDepartment, double score)
    {
        Departments[0] = firstDepartment;
        Departments[1] = secondDepartment;
        ClosenessRating = score;
    }

    public boolean CheckDepartments(Department firstDepartment, Department secondDepartment)
    {
        if (Departments[0].Index == firstDepartment.Index && Departments[1].Index == secondDepartment.Index)
        {
            return true;
        }
        else if (Departments[1].Index == firstDepartment.Index && Departments[0].Index == secondDepartment.Index)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
}
