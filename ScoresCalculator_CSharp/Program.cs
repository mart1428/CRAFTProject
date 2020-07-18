using System;
using System.Collections.Generic;
/*
Darren Wihandi
VS 16.5
*/
namespace ScoresCalculator
{
    class Program
    {
        static void Main(string[] args)
        {
            Console.WriteLine("Enter number of Departments: ");
            int numOfDepartments = Convert.ToInt32(Console.ReadLine());
            Console.WriteLine("Enter number of adjacent departments: ");
            int numOfAdjDepartments = Convert.ToInt32(Console.ReadLine());

            List<Department> Departments = new List<Department>();
            List<AdjacentDepartment> AdjacentDepartments = new List<AdjacentDepartment>();

            for (int x = 0; x < numOfDepartments; x++)
            {
                
                Console.WriteLine("Enter Department Name: ");
                string name = Console.ReadLine();
                Console.WriteLine("Enter Dep Index: ");
                int index = Convert.ToInt32(Console.ReadLine());
                Department department = new Department(name, index);
                Departments.Add(department);
            }

            for (int x = 0; x < numOfAdjDepartments; x++)
            {
                List<Department> adjacentDepartments = new List<Department>();

                Console.WriteLine("Enter First Department Index: ");
                int firstDepIndex = Convert.ToInt32(Console.ReadLine());
                for (int y = 0; y < numOfDepartments; y++)
                {
                    if(Departments[y].Index == firstDepIndex)
                    {
                        adjacentDepartments.Add(Departments[y]);
                    }
                }
                Console.WriteLine("Enter Second Department Index: ");
                int secondDepIndex = Convert.ToInt32(Console.ReadLine());
                for (int y = 0; y < numOfDepartments; y++)
                {
                    if (Departments[y].Index == secondDepIndex)
                    {
                        adjacentDepartments.Add(Departments[y]);
                    }
                }
                Console.WriteLine("Enter Closeness Rating: ");
                double ClosenessRating = Convert.ToDouble(Console.ReadLine());

                AdjacentDepartment adjacentDepartment = new AdjacentDepartment(adjacentDepartments[0], adjacentDepartments[1], ClosenessRating);
                AdjacentDepartments.Add(adjacentDepartment);
            }

            AdjacencyScoreCalculator Calculator = new AdjacencyScoreCalculator(numOfDepartments, Departments, AdjacentDepartments);
            double result = Calculator.CalculateTotal();
            
            Console.WriteLine("Total Result: " + result);
        }
    }
}
