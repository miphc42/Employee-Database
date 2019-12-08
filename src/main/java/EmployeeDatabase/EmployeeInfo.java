/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EmployeeDatabase;

/**
 *
 * @author miphc
 */
public class EmployeeInfo {
    public  int employeeNumber;
    public  String firstName;
    public  String lastName;
    public  int gender;
    String workLocation;
    double deductionRate;
    public String image;
    public String email;

    public EmployeeInfo() {
        employeeNumber = -1;
        firstName = "a";
        lastName = "z";
        gender = -1;
        workLocation = "";
        deductionRate = -1;
        email = "";
    }

    public EmployeeInfo(int employeeNumber, String firstName, String lastName, int gender, String workLocation, double deductionRate, String image, String email) {
        this.employeeNumber = employeeNumber;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.workLocation = workLocation;
        this.deductionRate = deductionRate;
        this.image = image;
        this.email = email;
    }
}

