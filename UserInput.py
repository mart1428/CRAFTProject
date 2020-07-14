# -*- coding: utf-8 -*-
"""
Created on Tue Jul 14 11:06:53 2020

@author: Christopher Martin
"""
import csv

class UserInput:
    def __init__(self, f_length = 0, f_width = 0):
        self.f_length = f_length  #Facility length
        self.f_width = f_width    #Facility width
        self.f_area = self.f_length * self.f_width
        self.dept = 0 #Number of departments
        self.deptdetails = {}  #Dictionary for department details {name: (length, width)}
        self.adj_preference = [] #Dict for adjacency preferences
    
    def __str__(self):
        s = '---------------------------------------------\n'\
            'Facility Length:\t\t' + str(self.f_length) +'\n'\
            'Facility Width:\t\t\t' + str(self.f_width) + '\n'\
            'Facility Area:\t\t\t' + str(self.f_area) +'\n'\
            'Number of Deparments:\t' + str(self.dept) + '\n'
            
        for k,v in self.deptdetails.items():
            s += k + ',\nLength:\t' + str(v[0]) + '\nWidth:\t' + str(v[1]) + '\nArea:\t' + str(v[2]) + '\n'
         
        s += 'Adjacency Preference:\n'
        for i in self.adj_preference:
            s += '\t' + i[0] + ' with ' + i[1] + '\n'
        
        s += '---------------------------------------------\n'
        return s
    
    def run(self):
        self.f_length = int(input('Enter Facility Length: '))
        self.f_width = int(input('Enter Facility Width: '))
        self.f_area = self.f_length * self.f_width
        run_flag = True
        count = 1
        print('Input "quit" to exit the loop')
        while run_flag:
            dpt = input('Enter Department ' + str(count) +' name: ')
            if dpt.lower() != 'quit':
                dpt_length = int(input('Enter ' + dpt + ' length: '))
                dpt_width = int(input('Enter ' + dpt + ' width: '))
                dpt_area = dpt_length * dpt_width
                self.deptdetails[dpt] = (dpt_length, dpt_width, dpt_area)
                count += 1
                self.dept += 1
            else:
                run_flag = False
        
        run_flag = True
        print('Input "quit" to exit the loop')

        while run_flag:
            print('===========Input format: dept1,dept2===========')
            pref = input('Enter preference: ')
            if pref != 'quit':           
                dept1 = pref[:pref.find(',')]
                dept2 = pref[pref.find(',')+1:]
                #print(dept1,dept2)
                flag = False     #Identify repeater
                for i,j in self.adj_preference:
                    if (dept1 == i and dept2 == j) or (dept1 == j and dept2 == i):
                        flag = True
                        break
                
                if ((self.deptdetails.get(dept1) != None and self.deptdetails.get(dept2) != None) and not flag):
                    self.adj_preference.append((dept1,dept2))
                else:
                    print('One or more departments are not identified or the preference is repeated.\n')

            else:
                run_flag = False
            
    
    def export(self, file):
        '''Export to CSV'''
        with open(file+'.csv', 'w', newline = '') as opened_file:
            csv_writer = csv.writer(opened_file)
            csv_writer.writerows([['Facility Length', self.f_length],\
                                  ['Facility Width', self.f_width],\
                                  ['Facility Area', self.f_area],\
                                  ['Number 0f Departments', self.dept]])
            csv_writer.writerow(['Adjacency Preference', self.adj_preference])
            for k,v in self.deptdetails.items():
                csv_writer.writerow([k,v[0],v[1],v[2]])
                






def run():
    user = UserInput()
    user.run()
    print(user)
    print(user.deptdetails)
    print(user.adj_preference)
    user.export('Test')
    


run_flag = True
if run_flag:
    run()