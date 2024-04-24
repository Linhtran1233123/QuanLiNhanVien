package com.example.emloyeesproject.model;

import javax.servlet.http.HttpServletRequest;

public interface IEmployeeManagement {


    Object display();

    void create(HttpServletRequest request);

    void delete(HttpServletRequest request);

    void update(HttpServletRequest request);
}
