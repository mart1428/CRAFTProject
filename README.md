# CRAFTProject
This is a program that generates the most **optimal** layout for a facility. The purpose of this program is to find the most optimal layout for a facility. The layout generated would reduce the time spent walking around between rooms by the employees, resulting in a more effective worker.  

## CRAFT - Computerized Relative Allocation of Facilities Technique.
This program will firstly read the inputs and save them to their corresponding Departments and Adjacent Score. Then, LayoutGenerator will gather these information and build the base layout with number 0. The generator will then **randomly** add the given departments to the base layout producing a layout and its' score. The score will be saved and the generator will find another layout and compare the score to the previously saved score. The generator will replace the layout and score if it has a higher score than the previous score. The generator will generate layouts until *maxIteration* has been reached. 

Description:
* AdjacencyScoreGenerator.java -
* AdjacentDepartment.java -
* Department.java - This file contains a Department class which will be used in finding the optimal layout.
* LayoutGenerator.java - This file contains the generator to find the optimal layout.
* Main.java - This file responsible for running the whole program (contains main method).
* UserInput.java - This file responsible for obtaining the inputs required for the generator.



*Final code is written in java and available in Final folder.*

*PS: The area for each department is being set to 1.*
