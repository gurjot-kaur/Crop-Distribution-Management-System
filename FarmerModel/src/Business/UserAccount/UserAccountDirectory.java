/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.UserAccount;

import Business.Employee.Employee;
import Business.Role.Role;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author raunak
 */
public class UserAccountDirectory {
    
    private ArrayList<UserAccount> userAccountList;

    public UserAccountDirectory() {
        userAccountList = new ArrayList();
    }

    public ArrayList<UserAccount> getUserAccountList() {
        return userAccountList;
    }
    
    public UserAccount authenticateUser(String username, String password){
        for (UserAccount ua : userAccountList)
            if (ua.getUsername().equals(username) && ua.getPassword().equals(password)){
                return ua;
            }
        return null;
    }
    
    public UserAccount createUserAccount(String username, String password, Employee employee, Role role){
        UserAccount userAccount = new UserAccount();
       
        if (checkIfUsernameIsUnique(username))
        {
            userAccount.setUsername(username);
            userAccount.setPassword(password);
            userAccount.setEmployee(employee);
            userAccount.setRole(role);
            userAccountList.add(userAccount);
        }
        else {
            JOptionPane.showMessageDialog(null,username+" already exists");
        }
        
        return userAccount;
    }
    
    public boolean checkIfUsernameIsUnique(String username){
        boolean flag = true;
        for (UserAccount ua : userAccountList){
            if (ua.getUsername().equals(username))
                flag = false;
            else
                flag = true;
        } 
        
        return flag;
    }
}
