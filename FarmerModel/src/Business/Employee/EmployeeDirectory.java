/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Employee;

import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author raunak
 */
public class EmployeeDirectory {
    
    private ArrayList<Employee> employeeList;

    public EmployeeDirectory() {
        employeeList = new ArrayList();
    }

    public ArrayList<Employee> getEmployeeList() {
        return employeeList;
    }
    
    public Employee createEmployee(String name){
        Employee employee = new Employee();
        
        if(checkIfUniqueEmployee(name))
        {
            employee.setName(name);
        employeeList.add(employee);
        }
        else {JOptionPane.showMessageDialog(null, name+"already exists");}
        return employee;
    }

    private boolean checkIfUniqueEmployee(String name) {
        
        boolean flag = true;         
        for (Employee em : employeeList){             
            if (em.getName().equals(name))                 
                flag = false;            
            else                 
                flag = true;        
        }                   
        return flag;
    }
}