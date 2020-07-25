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
            
        return base
        
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
    
    def findComb(self, count = 10000):
        deptList = self.__deptList.copy()
        totalDept = self.__totalDept
        cargoList = []
        for cargo in deptList:
            cargoList.append(cargo.getCargo())
          
        while count != 0:
            cargoList = []
            for cargo in deptList:
                cargoList.append(cargo.getCargo())
                
            arrangedCargo = []
            while len(cargoList) > 0:
                cargoIdx = random.randint(0,len(cargoList)-1)
                arrangedCargo.append(cargoList[cargoIdx])
                cargoList.pop(cargoIdx)
                
            # print(arrangedCargo)
            layout = self.__base.copy()
            
            #Assume each dept has area = 1
            for row in range(len(layout)):
                for col in range(len(layout[row])):
                    layout[row][col] = arrangedCargo.pop()
                    
                    
            for i in range(len(layout)):
                layout[i] = tuple(tuple(layout[i]))
                
            layout = tuple(layout)
            # print(layout)
            
            count -= 1
            
            if(layout not in self.__generatedLayout):
                self.__generatedLayout.append(layout)
                
    def getGeneratedLayout(self):
        return self.__generatedLayout
        
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
    
def sub1():
    print('-----Test 1 Sub 1-----')
    dept1 = Department(area = 25, shape = 'square', cargo = 1)
    dept2 = Department(area = 25, shape = 'square', cargo = 2)
    dept3 = Department(area = 25, shape = 'square', cargo = 3)
    dept4 = Department(area = 25, shape = 'square', cargo = 4)
    dept5 = Department(area = 25, shape = 'square', cargo = 5)
    dept6 = Department(area = 25, shape = 'square', cargo = 6)
    dept_list = [dept1,dept2,dept3,dept4,dept5,dept6]

    for dept in dept_list:
        dept.countAreaCombination()
    test = LayoutGenerator(fLength = 3, fWidth = 2, dept_list = dept_list)
    test.createBase()
    test.findComb()
    # test.printBase()
    layoutList = test.getGeneratedLayout()

    # print(layoutList)
    print('LayoutGenerated:',len(layoutList))
    
    print('=====End of Test 1 Sub 1=====')
    print('')
    print('-----Test 2 Sub 1-----')
    dept1 = Department(area = 25, shape = 'square', cargo = 1)
    dept2 = Department(area = 25, shape = 'square', cargo = 2)
    dept3 = Department(area = 25, shape = 'square', cargo = 3)
    dept4 = Department(area = 25, shape = 'square', cargo = 4)
    dept5 = Department(area = 25, shape = 'square', cargo = 5)
    dept6 = Department(area = 25, shape = 'square', cargo = 6)
    dept7 = Department(area = 25, shape = 'square', cargo = 7)
    dept8 = Department(area = 25, shape = 'square', cargo = 8)
    dept9 = Department(area = 25, shape = 'square', cargo = 9)
    dept_list = [dept1,dept2,dept3,dept4,dept5,dept6,dept7,dept8,dept9]
    
    test2 = LayoutGenerator(fLength = 3, fWidth = 3, dept_list = dept_list)
    test2.createBase()
    test2.findComb(10000)
    layoutList2 = test2.getGeneratedLayout()
    print('Layout Generated:',len(layoutList2))
    print('=====End of Test 2 Sub 1=====')
    print('')
    print('-----Test 3 Sub 1-----')
    dept1 = Department(area = 25, shape = 'square', cargo = 1)
    dept2 = Department(area = 25, shape = 'square', cargo = 2)
    dept3 = Department(area = 25, shape = 'square', cargo = 3)
    dept4 = Department(area = 25, shape = 'square', cargo = 4)
    dept5 = Department(area = 25, shape = 'square', cargo = 5)
    dept6 = Department(area = 25, shape = 'square', cargo = 6)
    dept7 = Department(area = 25, shape = 'square', cargo = 7)
    dept8 = Department(area = 25, shape = 'square', cargo = 8)
    dept_list=[dept1,dept2,dept3,dept4,dept5,dept6,dept7,dept8]
    test3 = LayoutGenerator(fLength = 2, fWidth = 4, dept_list = dept_list)
    
    test3.createBase()
    test3.findComb(10000)
    layoutList3 = test3.getGeneratedLayout()
    print('Layout Generated:',len(layoutList3))
    print('=====End of Test 3 Sub 1=====')
    print('')
    
###############################################################################
run_flag = False
sub_test1 = True
if run_flag:
    run()
    
if sub_test1:
    sub1()
    
###############################################################################
