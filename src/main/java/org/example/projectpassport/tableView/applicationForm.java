package org.example.projectpassport.tableView;

public class applicationForm {
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

    // Constructor
    public applicationForm(String idregistrationForm, String first_name, String last_name, String nic,
                           String address, String nationality, String dob, String gender, String birthCertificate_no,
                           String profession) {
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
    }

    public String getIdregistrationForm() {
        return idregistrationForm;
    }

    public String getFirst_name() {
        return first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public String getNic() {
        return nic;
    }

    public String getAddress() {
        return address;
    }

    public String getNationality() {
        return nationality;
    }

    public String getDob() {
        return dob;
    }

    public String getGender() {
        return gender;
    }

    public String getBirthCertificate_no() {
        return birthCertificate_no;
    }

    public String getProfession() {
        return profession;
    }



    // Getter methods

}


