# -*- coding: utf-8 -*-
"""
Created on Mon Jul 13 13:44:54 2020

@author: Christopher Martin
"""

import csv

          
class RowNode:
    ''' RowNode(length = None, cargo = None)
    Create rows of Column Node'''
    def __init__(self, length = None, cargo = None):
        self.length = length
        self.cargo = cargo
        
    def __str__(self):
        if self.cargo != None:
            s = str(self.cargo) + '\n'
            for j in range(self.length-1):
                s +=  str(self.cargo) + '\n'
            return s
        else:
            return None
    
    # def printRow(self):
    #     for j in range(self.length):
    #         print(self.cargo, end='\n')
        
        
class ColumnNode:
    ''' ColumnNode(length = None, cargo = None, delimiter ='')
    Create columns with certain length, cargo and delimiter'''
    def __init__(self, length = None, cargo = None, delimiter = ''):
        self.length = length   #Number of rows
        self.cargo = cargo   #What the rows contain
        self.delimiter = delimiter
        
    def __str__(self):
        if self.cargo != None:
            s = str(self.cargo)
            for i in range(self.length-1):
                s += self.delimiter + str(self.cargo)
            return s
        else:
            return None
    
    # def printColumn(self):
    #     for i in range(self.length):
    #         print(str(self.cargo), end=self.delimiter)
    #     print()
        
class LayoutBuilder:
    def __init__(self,row = None, column = None):
        self.baseRow = int(row)
        self.baseColumn = int(column)
        self.baseLayout = None
        self.department = 0
        
    def __str__(self):
        if self.baseLayout != None:
            s = ''
            for row in self.baseLayout:
                for col in row:
                    s += str(col)
                s += '\n'
            return s
        else:
            return None
        
        
    def printLayout(self):
        for row in range(self.baseRow):
            for column in range(self.baseColumn):
                print('0', end='')
            print()
 
    def createBaseLayout(self):
        base = []
        for i in range(self.baseRow):
            col = []
            for j in range(self.baseColumn):
                col.append(0)
            base.append(col)
        self.baseLayout = base
        
    def addDepartment(self,Node):
        cargo = Node.cargo.cargo            
        rowLength = Node.length
        colLength = Node.cargo.length
        if self.department == 0:
            # print('rowLength: ', rowLength)
            # print('colLength: ', colLength)
            if rowLength >= self.baseRow:
                print('Base Layout is too small')
            elif colLength >= self.baseColumn:
                print('Base Layout is too small')
            else:
                i = 0
                for row in self.baseLayout:
                    j = 0
                    for column in row:
                        if j < colLength and i < rowLength:
                            self.baseLayout[i][j] = cargo
                        j += 1
                    i += 1
                            
            self.department += 1
    
        else:
            pass
    
    
    
    
    
    
    
def run():
    row = int(input('Enter number of rows: '))
    col = int(input('Enter number of columns: '))
    cargo = int(input('Enter cargo: '))
    dept1 = RowNode(row,ColumnNode(col,cargo))
    print('Department 1')
    print(dept1)
    f_row = int(input('Enter number of rows (Facility): '))
    f_col = int(input('Enter number of columns (Facility): '))
    layout = LayoutBuilder(f_row,f_col)
    layout.createBaseLayout()
    print('Facility Base Layout (Before adding departments)')
    print(layout)
    layout.addDepartment(dept1)
    print('Facility Base Layout (After adding 1 department)')
    print(layout)
    
    
    
    
    
def areaCombinations(area):
    ''' (int) -> [(int,int),(int,int),...]
    Returns a list of length times width resulting the given area'''
    
    combinations = []
    i = 0
    j = 0
    for i in range(area+1):
        for j in range(area+1):
            if i*j == area:
                combinations.append((i,j))
            
            j += 1
        i += 1
    return combinations
    
    
    
# c = ColumnNode(2,1,'|')      
# r = RowNode(2,c)
# v = LayoutBuilder(3,3)
# v.createBaseLayout()
# print(v.baseLayout)
# v.addDepartment(r)
# print(r)
# print(v.baseLayout)
# print(v)

test_flag = False
if test_flag:
    run()
