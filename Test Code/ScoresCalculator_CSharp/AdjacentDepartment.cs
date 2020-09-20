using System;
using System.Collections.Generic;
using System.Text;

namespace ScoresCalculator
{
    public class AdjacentDepartment
    {
        public List<Department> Departments = new List<Department>();
        public double ClosenessRating { set; get; }

        public AdjacentDepartment(Department firstDepartment, Department secondDepartment, double score)
        {
            Departments.Add(firstDepartment);
            Departments.Add(secondDepartment);
            ClosenessRating = score;
        }

        public bool CheckDepartments(Department firstDepartment, Department secondDepartment)
        {
            if (Departments[0].Index == firstDepartment.Index && Departments[1].Index == secondDepartment.Index)
            {
                return true;
            }
            else if (Departments[0].Index == firstDepartment.Index && Departments[1].Index == secondDepartment.Index)
            {
                return true;
            }
            else
            {
                return false;
            }
        }
    }
}
