using System;
using System.Collections.Generic;
using System.Text;

namespace ScoresCalculator
{
    public class Department
    {
        public string Name { set; get; }
        public int Index { set; get; }

        public Department(string name, int index)
        {
            Name = name;
            Index = index;
        }
    }
}
