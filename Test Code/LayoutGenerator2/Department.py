# -*- coding: utf-8 -*-
"""
Created on Sat Jul 18 20:22:27 2020

@author: Christopher Martin
"""


import numpy as np
import random

class Department:
    def __init__(self, area = 0, shape = 'None', cargo = 0):
        # self.length = length         # As in rows, and assume it is flexible (Could be change to other length)
        # self.width = width           # As in columns , and assume it is flexible as self.length
        self.__area = area         # Assuming square and Rectangle
        self.__shape = shape           # Department shape (To expand possibilities later)
        self.__areaComb = self.countAreaCombination()
        self.__cargo = cargo          # For department number
        self.__totalComb = 0
    
    def __str__(self):
        s = '-----------------------------------------------------' +'\n' +\
            'Area:\t\t\t\t' + str(self.__area) + '\n' +\
            'Shape:\t\t\t\t' + str(self.__shape) + '\n' +\
            'Area Combinations:\t' + str(self.__areaComb) +'\n' +\
            'Cargo:\t\t\t\t' + str(self.__cargo) + '\n' +\
            'Total Combinations:\t' + str(self.__totalComb) +'\n' +\
            '-----------------------------------------------------' + '\n'
            
        return s
    
    def countAreaCombination(self):
        ''' (int) -> [(int,int),(int,int),...]
        Returns a list of length times width resulting the given area'''
        
        combinations = []
        i = 0
        j = 0
        for i in range(self.__area+1):
            for j in range(self.__area+1):
                if i*j == self.__area:
                    combinations.append((i,j))
                
                j += 1
            i += 1
        self.__areaComb = combinations
        
        if self.__shape.lower() == 'square':
            for (i,j) in combinations:
                if i != j:
                    combinations.remove((i,j))
                    
            self.__areaComb = combinations
        
    
    # def calculateArea(self):
    #     #Considering square/rectangle shape
    #     if self.length != None and self.width != None:
    #         self.area = self.length * self.width
            
    def countComb(self):
        ''' Count combinations'''
        count = 0
        if self.__shape.lower() != 'square':
            count = len(self.__areaComb)
        else:
            for (i,j) in self.__areaComb:
                if(i == j):
                    count += 1
                    
        self.__totalComb = count
        
    def printDepartment(self,maxPrint = 0):
        comb_list = self.__areaComb
        count = self.__totalComb
        if maxPrint <= 0:
            maxPrint = count
        elapse = 0
        if self.__shape.lower() != 'square':
            while count > 0 or elapse < maxPrint:
                s = ''
                i = random.randint(0,count-1)
                # i = 0
                s = str(self.__cargo)*comb_list[i][1] + '\n'
                s = s*comb_list[i][0]
                print(s)
                comb_list.pop(i)
                count -= 1
                elapse += 1
                # i +=1
        
        elif self.__shape.lower() == 'square':
            for (i,j) in comb_list:
                if i != j:
                    comb_list.remove((i,j))
            while count > 0 or elapse < maxPrint:
                s = ''
                i = random.randint(0,count-1)
                s = str(self.__cargo) * comb_list[i][1] +'\n'
                s *= comb_list[i][0]
                print(s)
                comb_list.pop(i)
                count -= 1
                elapse += 1

    def setArea(self,area):
        self.__area = area
        
    def getArea(self):
        return self.__area
    
    def setShape(self,shape):
        self.__shape = shape.lower()
        if self.__shape.lower() == 'square':
            self.countAreaCombination()
            combList = self.__areaComb
            for (i,j) in combList:
                if (i != j):
                    combList.remove((i,j))
                    
            self.__areaComb = combList
            self.__totalComb = len(self.__areaComb)
        
    def getShape(self):
        return self.__shape
    
    def getAreaComb(self):
        return self.__areaComb
    
    def setAreaComb(self,areaComb):     ##############ONLY FOR TESTING########
        self.__areaComb = areaComb
        
    def setCargo(self,cargo):
        self.__cargo = cargo
        
    def getCargo(self):
        return self.__cargo

########################################################
def run():
    print('-----Test 1-----')
    test = Department()
    test.setArea(4)
    test.setCargo(1)
    test.countAreaCombination()
    test.countComb()
    print(test)
    print('Printing Department...')
    test.printDepartment()    
    test.setShape('Square')
    print(test)
    print('=====End of Test 1=====')
    
    
    
    print('-----Test 2-----')
    test2 = Department()
    test2.setArea(25)
    test2.setCargo(2)
    # test2.calculateArea()
    test2.countAreaCombination()
    test2.setShape('sQuaRe')
    test2.countComb()
    print(test2)
    print('Printing Department...')
    test2.printDepartment()
    print('=====End of Test 2=====')
    
    
    
    print('-----Test 3-----')
    test3 = Department()
    test3.setAreaComb([(1,1),(2,2),(3,3),(4,4),(5,5)])
    test3.setShape('square')
    test3.setCargo(3)
    test3.countComb()
    print(test3)
    print('Printing Department...')
    test3.printDepartment()
    print('=====End of Test 3=====')


run_flag = True
if run_flag:
    run()
