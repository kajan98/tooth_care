/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tooth.care;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import javax.swing.JOptionPane;


/**
 *
 * @author KAJAN
 */
public class tooth_care_controller {
    
    private Patient patient;
    private Newappointment appointment;
    private Treatment treatment;
    private tooth_care view;
    private List<Patient> patientList;
    private List<Treatment> treatmentList;
    private List<Newappointment> appointmentList;

    
    
    

    public tooth_care_controller(Patient patient, Newappointment appointment, Treatment treatment, tooth_care view) {
        this.patient = patient;
        this.appointmentList = appointmentList;
        this.treatmentList = treatmentList;
        this.patientList = patientList;
        this.appointment = appointment;
        this.treatment = treatment;
        this.view = view;
        
        
 
        
    }

    tooth_care_controller(List<Patient> patientList, List<Newappointment> appointmentList, List<Treatment> treatmentList) {
           this.patientList = patientList;
        this.appointmentList = appointmentList;
        this.treatmentList = treatmentList;
    }
    public List<Patient> getPatientList() {
        return patientList;
    }

    public void setPatientList(List<Patient> patientList) {
        this.patientList = patientList;
    }

    public List<Newappointment> getAppointmentList() {
        return appointmentList;
    }

    public void setAppointmentList(List<Newappointment> appointmentList) {
        this.appointmentList = appointmentList;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Newappointment getAppointment() {
        return appointment;
    }

    public void setAppointment(Newappointment appointment) {
        this.appointment = appointment;
    }

    public Treatment getTreatment() {
        return treatment;
    }

    public void setTreatment(Treatment treatment) {
        this.treatment = treatment;
    }

    public tooth_care getView() {
        return view;
    }

    public void setView(tooth_care view) {
        this.view = view;
    }

    public List<Treatment> getTreatmentList() {
        return treatmentList;
    }

    public void setTreatmentList(List<Treatment> treatmentList) {
        this.treatmentList = treatmentList;
    }
   
    private boolean isPatientDuplicate(String patientID) {
        for (Patient patient : patientList) {
            if (patient.getPatientID().equals(patientID)) {
                return true; // Patient with the same ID already exists
            }
        }
        return false; // No duplicate patient ID found
    }

    void handlePatientDetailsInput(String patientID, String patientName, String Age, String Gender, String Address, String MobileNumber) {
               // Convert the Age and MobileNumber strings to their respective data types
        try {
            int age = Integer.parseInt(Age);
            int mobileNumber = Integer.parseInt(MobileNumber);

            // Check for duplicate patient ID
            if (isPatientDuplicate(patientID)) {
                JOptionPane.showMessageDialog(null, "Patient with the same ID already exists.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Validate age and mobileNumber
            if (age <= 0) {
                JOptionPane.showMessageDialog(null, "Please enter a valid age greater than 0", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Create a new Patient object
            Patient newPatient = new Patient(patientID, patientName, age, Gender, Address, mobileNumber);

            // Add the new patient to the patientList
            patientList.add(newPatient);
            


            // You can perform additional logic or update the view if needed
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Please enter valid numeric values for age and mobile number", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    void handleUpdatePatient(String patientID, String patientName, int age, String Gender, String Address, int mobileNumber) {
                // Find the patient in the list based on patientID
        Optional<Patient> optionalPatient = patientList.stream()
                .filter(patient -> patient.getPatientID().equals(patientID))
                .findFirst();

        // Update the patient if found
        optionalPatient.ifPresent(patient -> {
            patient.setPatientName(patientName);
            patient.setAge(age);
            patient.setGender(Gender);
            patient.setAddress(Address);
            patient.setMobileNumber(mobileNumber);
        });
    }

    public boolean addNewAppointment(String appointmentID, String patientID, String surgeon, String appointmentfeeValue, String dateString, String timeString) {            
           if (isPatientAlreadyHasAppointment(patientID)) {
        // You can show an error message or take appropriate action
       JOptionPane.showMessageDialog(null, "Patient Book the aonther Appointment", "INFORMATION", JOptionPane.INFORMATION_MESSAGE);
        return false;
    }     
       
       Newappointment newAppointment = new Newappointment(appointmentID, patientID, surgeon, appointmentfeeValue, dateString, timeString);
            appointmentList.add(newAppointment);

            
        return false;
   }

    boolean updateAppointment(String existingAppointmentID, String updatedPatientID, String updatedSurgeon, String updatedAppointmentFee, String updatedDateString, String updatedTimeString) {
                // Find the appointment in the list based on existingAppointmentID
        Optional<Newappointment> optionalAppointment = appointmentList.stream()
                .filter(appointment -> appointment.getAppointmentID().equals(existingAppointmentID))
                .findFirst();

        // Update the appointment if found
        return optionalAppointment.map(appointment -> {
            appointment.setPatientID(updatedPatientID);
            appointment.setSurgeon(updatedSurgeon);
            appointment.setAppointmentfee(updatedAppointmentFee);
            appointment.setDate(updatedDateString);
            appointment.setTime(updatedTimeString);
            return true; // Indicate that the update was successful
        }).orElse(false); // Indicate that the update failed (appointment not found)
    }
        
    public List<String[]> getAppointmentDetailsForDisplay() {
        List<String[]> appointmentDetails = new ArrayList<>();

        for (Newappointment appointment : appointmentList) {
            String patientID = appointment.getPatientID();
            String patientName = getPatientName(patientID); // Using the previously defined method
            String appointmentID = appointment.getAppointmentID();
            String surgeon = appointment.getSurgeon();
            String date = appointment.getDateString(); // Assuming there is a method to get the date string
            String time = appointment.getTimeString(); // Assuming there is a method to get the time string

            String[] details = {appointmentID, patientID, patientName, surgeon, date, time};
            appointmentDetails.add(details);
        }

        return appointmentDetails;
    }

    private String getPatientName(String patientID) {
        Optional<Patient> optionalPatient = patientList.stream()
                .filter(patient -> patient.getPatientID().equals(patientID))
                .findFirst();

        return optionalPatient.map(Patient::getPatientName).orElse(null);
    
    }
        
    public boolean addNewTreatment(String treatmentID, String appointmentID, String patientID, String surgeon, boolean cleaning, boolean filling, boolean whitening, boolean nerveFilling, boolean rootCanalTherapy, String fee) {
    // Create a new Treatment object
    Treatment newTreatment = new Treatment(treatmentID, appointmentID, patientID, surgeon, cleaning, filling, whitening, nerveFilling, rootCanalTherapy);

    // Add the new treatment to the list
    treatmentList.add(newTreatment);

    // You may want to return a success indicator or handle any other logic here
    return true;
}

    private boolean isPatientAlreadyHasAppointment(String patientID) {
      // Check if the patient already has an appointment
    return appointmentList.stream()
            .anyMatch(appointment -> appointment.getPatientID().equals(patientID));
}
    
    public Optional<Newappointment> getAppointmentDetailsByAppointmentID(String appointmentID) {
        return appointmentList.stream()
                .filter(appointment -> appointment.getAppointmentID().equals(appointmentID))
                .findFirst();
    }

    public String getPatientIDFromAppointment(String selectedAppointmentID) {
    Optional<Newappointment> optionalAppointment = appointmentList.stream()
            .filter(appointment -> appointment.getAppointmentID().equals(selectedAppointmentID))
            .findFirst();

    // If appointment found, return the patient ID; otherwise, return null
    return optionalAppointment.map(Newappointment::getPatientID).orElse(null);
}

    public String getSurgeonFromAppointment(String appointmentID) {
        Optional<Newappointment> optionalAppointment = appointmentList.stream()
                .filter(appointment -> appointment.getAppointmentID().equals(appointmentID))
                .findFirst();

        // If appointment found, return the surgeon name; otherwise, return null
        return optionalAppointment.map(Newappointment::getSurgeon).orElse(null);
    }

    boolean addNewTreatment(String TreatmentID, String AppointmentID, String PatientID, String SurgeonName, boolean Cleaning, boolean Filling, boolean Whitening, boolean NerveFilling, boolean RootCanalTherapy) {
                Treatment newTreatment = new Treatment(TreatmentID, AppointmentID, PatientID, SurgeonName, Cleaning, Filling, Whitening, NerveFilling, RootCanalTherapy);
        return treatmentList.add(newTreatment);
    
    }

    boolean isTreatmentIDDuplicate(String TreatmentID) {
        // Check if the treatmentID already exists in the treatmentList
        return treatmentList.stream().anyMatch(treatment -> treatment.getTreatmentID().equals(TreatmentID));
    }

    boolean updateTreatment(String selectedTreatmentID, String updatedTreatmentID, String selectedAppointmentID, String updatedPatientID, String updatedSurgeonName, boolean updatedCleaning, boolean updatedFilling, boolean updatedWhitening, boolean updatedNerveFilling, boolean updatedRootCanalTherapy) {
       // Find the treatment in your treatmentList based on the selectedTreatmentID
    Optional<Treatment> optionalTreatment = treatmentList.stream()
            .filter(treatment -> treatment.getTreatmentID().equals(selectedTreatmentID))
            .findFirst();

    // If treatment found, update its details
    if (optionalTreatment.isPresent()) {
        Treatment treatmentToUpdate = optionalTreatment.get();
        treatmentToUpdate.setTreatmentID(updatedTreatmentID);
        treatmentToUpdate.setAppointmentID(selectedAppointmentID); // If the appointmentID is also updatable, change it accordingly
        treatmentToUpdate.setPatientID(updatedPatientID);
        treatmentToUpdate.setSurgeon(updatedSurgeonName);
        treatmentToUpdate.setCleaning(updatedCleaning);
        treatmentToUpdate.setFilling(updatedFilling);
        treatmentToUpdate.setWhitening(updatedWhitening);
        treatmentToUpdate.setNerveFilling(updatedNerveFilling);
        treatmentToUpdate.setRootCanalTherapy(updatedRootCanalTherapy);

        // Return true to indicate a successful update
        return true;
    }

    // Return false to indicate that the treatment was not found
    return false;
    }

    boolean updateTreatmentInList(String selectedTreatmentID, Treatment updatedTreatment) {
        // Find the index of the treatment in your treatmentList based on the selectedTreatmentID
    int indexOfTreatment = -1;
    for (int i = 0; i < treatmentList.size(); i++) {
        if (treatmentList.get(i).getTreatmentID().equals(selectedTreatmentID)) {
            indexOfTreatment = i;
            break;
        }
    }

    // If the treatment is found, update it in the list
    if (indexOfTreatment != -1) {
        treatmentList.set(indexOfTreatment, updatedTreatment);

        // Return true to indicate a successful update
        return true;
    }

    // Return false to indicate that the treatment was not found
    return false;
    }

    boolean deleteTreatment(String selectedTreatmentID) {
       // Find the index of the treatment in your treatmentList based on the selectedTreatmentID
    int indexOfTreatment = -1;
    for (int i = 0; i < treatmentList.size(); i++) {
        if (treatmentList.get(i).getTreatmentID().equals(selectedTreatmentID)) {
            indexOfTreatment = i;
            break;
        }
    }

    // If the treatment is found, remove it from the list
    if (indexOfTreatment != -1) {
        treatmentList.remove(indexOfTreatment);



        // Return true to indicate a successful deletion
        return true;
    }

    // Return false to indicate that the treatment was not found
    return false;
   
    }

    void deletePatient(String patientID) {
        // Find the patient in the list based on patientID
    Optional<Patient> optionalPatient = patientList.stream()
            .filter(patient -> patient.getPatientID().equals(patientID))
            .findFirst();

    // If the patient is found, remove it from the list
    optionalPatient.ifPresent(patient -> patientList.remove(patient));

    }

    void deleteAppointment(String appointmentID) {
        // Find the appointment in the list based on appointmentID
    Optional<Newappointment> optionalAppointment = appointmentList.stream()
            .filter(appointment -> appointment.getAppointmentID().equals(appointmentID))
            .findFirst();

    // If the appointment is found, remove it from the list
    optionalAppointment.ifPresent(appointment -> appointmentList.remove(appointment));
    }
   
    public Optional<Treatment> getTreatmentDetailsByTreatmentID(String treatmentID) {
    return treatmentList.stream()
            .filter(treatment -> treatment.getTreatmentID().equals(treatmentID))
            .findFirst();
}

    //method to get the appointment ID from treatment ID
    public String getAppointmentIDFromTreatment(String treatmentID) {
        Optional<Treatment> optionalTreatment = getTreatmentDetailsByTreatmentID(treatmentID);
        return optionalTreatment.map(Treatment::getAppointmentID).orElse(null);
    }

    // method to get the patient ID from treatment ID
    public String getPatientIDFromTreatment(String treatmentID) {
        Optional<Treatment> optionalTreatment = getTreatmentDetailsByTreatmentID(treatmentID);
        return optionalTreatment.map(Treatment::getPatientID).orElse(null);
    }

    // method to get the surgeon name from treatment ID
    public String getSurgeonFromTreatment(String treatmentID) {
        Optional<Treatment> optionalTreatment = getTreatmentDetailsByTreatmentID(treatmentID);
        return optionalTreatment.map(Treatment::getSurgeon).orElse(null);
    }

    public boolean authenticateUser(String Username, String Password) {
        String hardcodedUsername = "admin";
        String hardcodedPassword = "admin123";

        return Username.equals(hardcodedUsername) && Password.equals(hardcodedPassword);
    }

}



   

        
    
    

