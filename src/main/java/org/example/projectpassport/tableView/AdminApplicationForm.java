package org.example.projectpassport.tableView;

public class AdminApplicationForm {
    private String idregistrationForm;
    private String first_name;
    private String last_name;
    private String nic;
    private String address;
    private String nationality;
    private String dob;
    private String gender;
    private String birthCertificate_no;
    private String profession;
    private String police_status;

    public AdminApplicationForm(String idregistrationForm, String first_name, String last_name, String nic, String address, String nationality, String dob, String gender, String birthCertificate_no, String profession, String police_status) {
        this.idregistrationForm = idregistrationForm;
        this.first_name = first_name;
        this.last_name = last_name;
        this.nic = nic;
        this.address = address;
        this.nationality = nationality;
        this.dob = dob;
        this.gender = gender;
        this.birthCertificate_no = birthCertificate_no;
        this.profession = profession;
        this.police_status = police_status;
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

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getNic() {
        return nic;
    }

    public void setNic(String nic) {
        this.nic = nic;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getBirthCertificate_no() {
        return birthCertificate_no;
    }

    public void setBirthCertificate_no(String birthCertificate_no) {
        this.birthCertificate_no = birthCertificate_no;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public String getPolice_status() {
        return police_status;
    }

    public void setPolice_status(String police_status) {
        this.police_status = police_status;
    }
}
