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
public class PTE extends EmployeeInfo {
    public double hourlyWage;
    public double hoursPerWeek;
    public double weeksPerYear;
    public PTE(int employeeNumber, String firstName, String lastName, int gender, int workLocation, double deductionRate, double hourlyWage, double hoursPerWeek, double weeksPerYear, String image){
        super(employeeNumber, firstName, lastName, gender, workLocation, deductionRate, image);
        this.hourlyWage = hourlyWage;
        this.hoursPerWeek = hoursPerWeek;
        this.weeksPerYear = weeksPerYear;
    }
    public double calcAnnualGrossIncome(){
        return hourlyWage*hoursPerWeek*weeksPerYear;
    }
    public double calcAnnualNetIncome(){
        return (hourlyWage*hoursPerWeek*weeksPerYear)*(1-(deductionRate/100));
    }
}
