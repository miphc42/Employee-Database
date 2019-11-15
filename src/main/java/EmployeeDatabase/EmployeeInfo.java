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
    int workLocation;
    double deductionRate;
    public String image;

    public EmployeeInfo() {
        employeeNumber = -1;
        firstName = "a";
        lastName = "z";
        gender = -1;
        workLocation = -1;
        deductionRate = -1;
    }

    public EmployeeInfo(int employeeNumber, String firstName, String lastName, int gender, int workLocation, double deductionRate, String image) {
        this.employeeNumber = employeeNumber;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.workLocation = workLocation;
        this.deductionRate = deductionRate;
        this.image = image;
    }
}

