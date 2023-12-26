/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tooth.care;

/**
 *
 * @author KAJAN
 */
public class Patient {
    private String patientID;
    private String patientName;
    private int Age;
    private String Gender;
    private String Address;
    private int MobileNumber;

    public Patient(String patientID, String patientName, int Age, String Gender, String Address, int MobileNumber) {
        this.patientID = patientID;
        this.patientName = patientName;
        this.Age = Age;
        this.Gender = Gender;
        this.Address = Address;
        this.MobileNumber = MobileNumber;
    }

    public String getPatientID() {
        return patientID;
    }

    public void setPatientID(String patientID) {
        this.patientID = patientID;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public int getAge() {
        return Age;
    }

    public void setAge(int Age) {
        this.Age = Age;
    }

    public String getGender() {
        return Gender;
    }

    public void setGender(String Gender) {
        this.Gender = Gender;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }

    public int getMobileNumber() {
        return MobileNumber;
    }

    public void setMobileNumber(int MobileNumber) {
        this.MobileNumber = MobileNumber;
    }

    
  
}
