# -*- coding: utf-8 -*-
"""
Created on Sun Jul 19 10:13:02 2020

@author: Christopher Martin
"""

from Department import Department
import random 

class LayoutGenerator:
    def __init__(self, fLength = 0, fWidth = 0, dept_list = []):
        self.__fLength = fLength
        self.__fWidth = fWidth
        self.__fArea = self.__fLength * self.__fWidth
        self.__deptList = dept_list
        self.__totalDept = len(self.__deptList)
        self.__base = self.createBase()
        self.__generatedLayout = []
    
    def __str__(self):
        s = '---------------------------------------------------------------\n'+\
            'Facility Length:\t\t' + str(self.__fLength) +'\n' +\
            'Facility Width:\t\t\t' + str(self.__fWidth) + '\n' +\
            'Facility Area:\t\t\t' + str(self.__fArea) + '\n' +\
            'Department List:\t\t' + str(self.__deptList) + '\n' +\
            'Total Deparment:\t\t' + str(self.__totalDept) + '\n' +\
            '---------------------------------------------------------------\n'
            
        return s
    
    def addDepartment(self):
        add_flag = False            #add_flag => True when addition is successful
        deptList = self.__deptList
        deptCount = len(deptList)
        dept = deptList[random.randint(0,deptCount-1)]
        deptComb = self.getDeptCombination(dept)
        # print(deptComb)
        deptCombCount = len(deptComb)-1
        lastDim = ()
        while (not add_flag) and deptCombCount > 0:
            success_flag = False
            for i in range(deptCombCount):
                comb = deptComb[random.randint(0,deptCombCount-1)]
                print(comb)
                if comb[0] <= self.__fWidth and comb[1]<= self.__fLength: 
                    for row in range(0,comb[0]):
                        for col in range(0,comb[1]):
                            self.__base[row][col] = dept.getCargo()
                    success_flag = True
                    
                if success_flag:
                    add_flag = True
                    lastDim = (comb[0],comb[1])
                    break
                else:
                    deptComb.remove(comb)
            deptCombCount -= 1
            
            if not add_flag:
                dept = deptList[random.randint(0,deptCount-1)]
                deptComb = self.getDeptCombination(dept)
            
        deptList.remove(dept)
        
        if(lastDim[1] < self.__fLength and lastDim[0] < self.__fWidth):
            rightSpace = (self.__fWidth,self.__fLength - lastDim[1])
            print(rightSpace)
            add_flag = False
            deptCount = len(deptList)
            deptComb = self.getDeptCombination(dept)
            
        

    
    def getDeptCombination(self,dept):
        return dept.getAreaComb()

    def createBase(self):
        base = []
        for i in range(self.__fWidth):
            insideList = []
            for j in range(self.__fLength):
                insideList.append(0)
            base.append(insideList)
            
        self.__base = base
        
    def printBase(self):
        s = ''
        for row in self.__base:
            for col in row:
                s += str(col)
            s +='\n'
            
        print(s)
        
    def getDeptList(self):
        return self.__deptList
    
    def setDeptList(self,deptList):
        self.__deptList = deptList
        self.__totalDept = len(self.__deptList)
        
    def getfLength(self):
        return self.__fLength
    
    def setfLength(self, fLength):
        self.__fLength = fLength
        self.__fArea = self.__fLength * self.__fWidth
        
    def getfWidth(self):
        return self.__fWidth
    
    def setfWidth(self,fWidth):
        self.__fWidth = fWidth
        self.__fArea = self.__fLength * self.__fWidth
        
    def getBase(self):
        return self.__base
        
        
###############################################################################
def run():
    print('-----Test 1-----')
    test1 = LayoutGenerator()
    test1.setfLength(4)
    test1.setfWidth(5)
    test1.createBase()
    print(test1.getBase())
    test1.printBase()
    print(test1)
    print('=====End of Test 1=====')
    print()
    
    print('-----Test 2-----')
    dept_list = [Department(10, cargo = 1)]
    dept_list[0].countAreaCombination()
    # print(dept_list[0].getAreaComb())
    test2 = LayoutGenerator(dept_list = dept_list)
    test2.setfWidth(10)
    test2.setfLength(10)
    test2.createBase()
    test2.addDepartment()
    test2.printBase()
    print('=====End of Test 2=====')
    print()
    
    print('-----Test 3-----')
    dept_list = [Department(25, cargo = 1),Department(121,cargo = 2)]
    for dept in dept_list:
        dept.countAreaCombination()
    test3 = LayoutGenerator(fLength = 10, fWidth = 10, dept_list = dept_list)
    test3.createBase()
    test3.addDepartment()
    test3.printBase()
###############################################################################
run_flag = True
if run_flag:
    run()