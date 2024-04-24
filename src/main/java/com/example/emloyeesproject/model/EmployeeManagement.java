package com.example.emloyeesproject.model;

import javax.servlet.http.HttpServletRequest;
import java.security.PrivateKey;
import java.util.ArrayList;
import java.util.Iterator;

public class EmployeeManagement implements IEmployeeManagement {
    private ArrayList<Employee> employees;
    int index;
    public EmployeeManagement(){
        this.employees=new ArrayList<>();
        employees.add(new Employee(1,"linh"));
        index=1;
    }
    public ArrayList<Employee> display(){
        return employees;
    }
    public void create(HttpServletRequest request){
        String name=request.getParameter("name");
        index+=1;
        employees.add(new Employee(index,name));
    }
    public void delete(HttpServletRequest request){
        int id=Integer.parseInt(request.getParameter("id"));
        Iterator<Employee> iterator= employees.iterator();
        while (iterator.hasNext()){
            Employee employee=iterator.next();
            if(employee.getId()==id){
                iterator.remove();
            }
        }
    }
    public void update(HttpServletRequest request){
        String name=request.getParameter("name");
        int id=Integer.parseInt(request.getParameter("id"));
        for (Employee e:employees
             ) {
            if(e.getId()==id){
                e.setName(name);
                break;

            }
        }
    }

}
