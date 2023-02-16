package com.example.emloyeesproject.cotroller;

import com.example.emloyeesproject.model.EmployeeManagement;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;

@Controller

public class PageController {
    private EmployeeManagement employeeManagement;
    public PageController(){
        employeeManagement=new EmployeeManagement();
    }
    @GetMapping
    public String display(Model model){
        model.addAttribute("employees",employeeManagement.display());
        return "/list";
    }
    @PostMapping("/create")
      public String create(HttpServletRequest request,Model model) {
        employeeManagement.create(request);
        return display(model);
    }
    @PostMapping("/delete")
    public String delete(HttpServletRequest request,Model model){
        employeeManagement.delete(request);
        return display(model);
    }
    @PostMapping("/update")
    public String update(HttpServletRequest request,Model model){
        employeeManagement.update(request);
        return display(model);
    }
}
