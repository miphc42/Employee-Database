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
import java.io.File;
import java.util.*;
import java.io.*;
public class MyHashTable {
    public static boolean fullOrPart = true;
    // ATTRIBUTES
    // buckets is an array of ArrayList.  Each item in an ArrayList is a StudentInfo
    // object holding a reference value pointing to a student.
    static ArrayList<EmployeeInfo>[] buckets;

    // CONSTRUCTOR
    public MyHashTable(){
    }
    public MyHashTable(int howManyBuckets) {
        // Construct the hash table (open hashing/closed addressing) as an array of howManyBuckets ArrayLists.

        // Instantiate buckets as an array to have an ArrayList as each element of the array.
        buckets = new ArrayList[howManyBuckets];

        // For each element in the array, instantiate its ArrayList.
        for (int i = 0; i < howManyBuckets; i++) {
            buckets[i] = new ArrayList();  // Instantiate the ArrayList for bucket i.
        }
    }


    // METHODS

    public int calcBucket(int employeeNumber) {
        return (employeeNumber % buckets.length);
    }

    public void addToTable(EmployeeInfo theEmployee) {
        buckets[calcBucket(theEmployee.employeeNumber)].add(theEmployee);
        // Add the student referenced by theStudent to the hash table.
    }

    public EmployeeInfo removeFromTable(int employeeNumber) {
        EmployeeInfo temp = getFromTable(employeeNumber);
        buckets[calcBucket(employeeNumber)].remove(getFromTable(employeeNumber));
        return temp;
    }

    public EmployeeInfo getFromTable(int employeeNumber) {
        // Return the reference value for that student, return null if student isn't in the table.
        EmployeeInfo temp = null;
        for (EmployeeInfo info: buckets[calcBucket(employeeNumber)]) {
            if (info.employeeNumber == employeeNumber) {
                temp = info;
                break;
            }
        }
        return temp;
    }

    public boolean isInTable (int employeeNumber){
        boolean temp = false;
        if (getFromTable(employeeNumber)!=null){
            temp = true;
        }
        return temp; // Return true if that student is in the hash table, false otherwise.
    }
    
    public void editTable(EmployeeInfo theEmployee, int x){
        for (int i = 0; i < buckets[calcBucket(x)].size(); i++){
            if(buckets[calcBucket(x)].get(i).employeeNumber == x){      
                buckets[calcBucket(x)].remove(i);
                buckets[calcBucket(theEmployee.employeeNumber)].add(theEmployee);
                displayEmployees();
            }
        }
    }

    //New method to visualize the data structure
    public void displayEmployees(){
        System.out.println("Displaying all Employees: ");
        for(int i = 0; i < buckets.length; i++){
            if(buckets[i].size() > 0) {
                System.out.println("Bucket[" + i + "]: ");
                for (int c = 0; c < buckets[i].size(); c++) {
                    System.out.println(buckets[i].get(c) + " ");
                }
            }
            else{
                System.out.println("Bucket[" + i + "]: \nNothing");
            }
        }
        System.out.println();
    }
    
    public void writeToFile() throws IOException{
        clearFile();
        File file = new File("PermanentStorage.txt");
        FileWriter fw = new FileWriter(file, true);
        BufferedWriter bw = new BufferedWriter(fw);
        for(int i = 0; i < buckets.length; i++){
            if(buckets[i].size() > 0) {
                for (int c = 0; c < buckets[i].size(); c++) {
                    EmployeeInfo temp = buckets[i].get(c);
                    if(temp instanceof FTE){
                        FTE fte= (FTE) temp;
                        bw.write("FullTime"+","+fte.employeeNumber+","+fte.firstName+","+fte.lastName+","+fte.gender+","+fte.workLocation+","+fte.deductionRate+","+fte.annualSalary+","+fte.image+"\n");
                    }
                    else if(temp instanceof PTE){
                        PTE pte = (PTE) temp;
                        bw.write("PartTime"+","+pte.employeeNumber+","+pte.firstName+","+pte.lastName+","+pte.gender+","+pte.workLocation+","+pte.deductionRate+","+pte.hourlyWage+","+pte.hoursPerWeek+","+pte.weeksPerYear+","+pte.image+"\n");
                    }
                }
            }
        }
        
        bw.close();
    }
    public void clearFile() throws FileNotFoundException{
        PrintWriter pw = new PrintWriter("PermanentStorage.txt");
        pw.close();     
    }
    public void clearTable(){
        if(buckets!=null){
        for (int i = 0; i <buckets.length; i++){
            buckets[i].clear();
        }
        }
    }
}