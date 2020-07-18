using System;
using System.Collections.Generic;
using System.Security.Cryptography.X509Certificates;
using System.Text;

namespace ScoresCalculator
{
    public class AdjacencyScoreCalculator
    {
        public int NumberOfDepartments { set; get; }
        public List<Department> Departments;
        public List<AdjacentDepartment> AdjacentDepartments;

        public AdjacencyScoreCalculator(int numberOfDepartments, List<Department> departments, List<AdjacentDepartment> adjacentDepartments)
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
                    result += CalculateFromTwo(Departments[x], Departments[y]);
                }
            }

            return result;
        }

        public double CalculateFromTwo(Department firstDepartment, Department secondDepartment)
        {
            double AdjacentScore = 0;
            double ClosenessRating = 0;
            int AdjacentDepartmentsSize = AdjacentDepartments.Count;

            for(int x = 0; x < AdjacentDepartmentsSize; x++)
            {
                if (AdjacentDepartments[x].CheckDepartments(firstDepartment, secondDepartment)) {
                    ClosenessRating = AdjacentDepartments[x].ClosenessRating;
                    AdjacentScore = 1;
                }
            }

            double FinalScore = ClosenessRating*AdjacentScore;
            return FinalScore;
        }



    }
}
