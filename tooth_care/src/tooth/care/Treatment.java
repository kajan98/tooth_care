/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tooth.care;

/**
 *
 * @author KAJAN
 */
public class Treatment {
    
    private String treatmentID;
    private String appointmentID;
    private String patientID;
    private String surgeon;
    private boolean cleaning;
    private boolean filling;
    private boolean whitening;
    private boolean nerveFilling;
    private boolean rootCanalTherapy;

    public Treatment(String treatmentID, String appointmentID, String patientID, String surgeon, boolean cleaning, boolean filling, boolean whitening, boolean nerveFilling, boolean rootCanalTherapy) {
        this.treatmentID = treatmentID;
        this.appointmentID = appointmentID;
        this.patientID = patientID;
        this.surgeon = surgeon;
        this.cleaning = cleaning;
        this.filling = filling;
        this.whitening = whitening;
        this.nerveFilling = nerveFilling;
        this.rootCanalTherapy = rootCanalTherapy;
    }

    public String getTreatmentID() {
        return treatmentID;
    }

    public void setTreatmentID(String treatmentID) {
        this.treatmentID = treatmentID;
    }

    public String getAppointmentID() {
        return appointmentID;
    }

    public void setAppointmentID(String appointmentID) {
        this.appointmentID = appointmentID;
    }

    public String getPatientID() {
        return patientID;
    }

    public void setPatientID(String patientID) {
        this.patientID = patientID;
    }

    public String getSurgeon() {
        return surgeon;
    }

    public void setSurgeon(String surgeon) {
        this.surgeon = surgeon;
    }

    public boolean isCleaning() {
        return cleaning;
    }

    public void setCleaning(boolean cleaning) {
        this.cleaning = cleaning;
    }

    public boolean isFilling() {
        return filling;
    }

    public void setFilling(boolean filling) {
        this.filling = filling;
    }

    public boolean isWhitening() {
        return whitening;
    }

    public void setWhitening(boolean whitening) {
        this.whitening = whitening;
    }

    public boolean isNerveFilling() {
        return nerveFilling;
    }

    public void setNerveFilling(boolean nerveFilling) {
        this.nerveFilling = nerveFilling;
    }

    public boolean isRootCanalTherapy() {
        return rootCanalTherapy;
    }

    public void setRootCanalTherapy(boolean rootCanalTherapy) {
        this.rootCanalTherapy = rootCanalTherapy;
    }
    
    
    
    
    
    
    
}
