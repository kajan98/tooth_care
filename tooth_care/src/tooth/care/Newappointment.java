/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tooth.care;

import com.toedter.calendar.JDateChooser;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JSpinner;

/**
 *
 * @author KAJAN
 */
public class Newappointment {
    
    private String appointmentID;
    private String patientID;
    private String Surgeon;
    private String appointmentfee;
    private JDateChooser date;
    private JSpinner time;


    Newappointment(String appointmentID, String patientID, String surgeon, String appointmentFee, String dateString, String timeString) {
        this.appointmentID = appointmentID;
        this.patientID = patientID;
        this.Surgeon = surgeon;
        this.appointmentfee = appointmentFee;
        this.date = date;
        this.time = time;
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
        return Surgeon;
    }

    public void setSurgeon(String Surgeon) {
        this.Surgeon = Surgeon;
    }

    public String getAppointmentfee() {
        return appointmentfee;
    }

    public void setAppointmentfee(String appointmentfee) {
        this.appointmentfee = appointmentfee;
    }

    public JDateChooser getDate() {
        return date;
    }

    public void setDate(JDateChooser date) {
        this.date = date;
    }

    public JSpinner getTime() {
        return time;
    }

    public void setTime(JSpinner time) {
        this.time = time;
    }

    void setDate(String updatedDateString) {
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        try {
            Date updatedDate = dateFormat.parse(updatedDateString);
            // Now you have the updatedDate, you can perform further actions here
            // For example, update some UI component or process the date in some way
        } catch (ParseException e) {
            // Handle the case where the provided string is not a valid date
            e.printStackTrace(); // You might want to log the exception or show an error message
        }
    }

    void setTime(String updatedTimeString) {
                SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm");

        try {
            Date updatedTime = timeFormat.parse(updatedTimeString);
            // Now you have the updatedTime, you can perform further actions here
            // For example, update some UI component or process the time in some way
        } catch (ParseException e) {
            // Handle the case where the provided string is not a valid time
            e.printStackTrace(); // You might want to log the exception or show an error message
        }
    }

    String getDateString() {
        if (date != null) {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            return dateFormat.format(date);
        } else {
            return ""; // or handle null date as needed
        }
    }

    String getTimeString() {
        if (time != null) {
            SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm");
            return timeFormat.format(time);
        } else {
            return ""; // or handle null time as needed
        }
    }

    

}



    
    
    

