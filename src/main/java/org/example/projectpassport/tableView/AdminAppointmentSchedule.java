package org.example.projectpassport.tableView;


import java.util.SimpleTimeZone;

public class AdminAppointmentSchedule {
    private String idregistrationForm;
    private String first_name;
    private String phone_no;
    private  String email;
    private String admin_status;
    public AdminAppointmentSchedule(){

    }
    public AdminAppointmentSchedule(String idregistrationForm,String first_name,String phone_no,String email,String admin_status){
        this.idregistrationForm = idregistrationForm;
        this. first_name = first_name;
        this. phone_no = phone_no;
        this.email = email;
        this.admin_status = admin_status;
    }

    public String getIdregistrationForm() {
        return idregistrationForm;
    }

    public void setIdregistrationForm(String idregistrationForm) {
        this.idregistrationForm = idregistrationForm;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getPhone_no() {
        return phone_no;
    }

    public void setPhone_no(String phone_no) {
        this.phone_no = phone_no;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAdmin_status() {
        return admin_status;
    }

    public void setAdmin_status(String admin_status) {
        this.admin_status = admin_status;
    }
}
