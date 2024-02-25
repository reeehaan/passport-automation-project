package org.example.projectpassport.SystemUsers;


import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import org.example.projectpassport.SqlConnection;


import java.sql.*;

public class User {



    SqlConnection conn1 = new SqlConnection();
    PreparedStatement statement ;
    ResultSet resultSet;

    Connection c ;
    public void insertNewUser(String fullname, String username, String password,String email){
        try {

                 c = conn1.connectDb();


                String sql = "INSERT INTO user_login(username,password,full_name,email)VALUES(?,?,?,?)";
                statement = c.prepareStatement(sql);

                statement.setString(1, username);
                statement.setString(2, password);
                statement.setString(3, fullname);
                statement.setString(4, email);

                int rowsInserted = statement.executeUpdate();

                if (rowsInserted > 0) {
                    //successLabal.setText("Successfully Registered ");
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Passport System");
                    alert.setContentText("You have successfully Registered");
                    alert.showAndWait();
                } else {
                    //successLabal.setText("Registration Fails");
                    Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setTitle("Passport System");
                    alert.setContentText("Registration fails");
                    alert.showAndWait();
                }


        }catch (SQLException exception){
            System.out.println("Connection fails in new user registration");
        }
    }
    public boolean userLogin(String username, String password){
            try{

                c = conn1.connectDb();
                Statement s = c.createStatement();
                resultSet = s.executeQuery("SELECT * FROM user_login WHERE username='" + username + "'");

                if (!resultSet.next()) {
                    //System.out.println("user not found !!!");
                    //usernameWarningLabel.setText("user not found");
                    Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setTitle("Passport System");
                    alert.setContentText("User not found");
                    alert.showAndWait();
                } else {
                    String dbpassword = resultSet.getString("password");

                    if (password.equals(dbpassword)) {
                            //System.out.println("Login Success :)");
                        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                        alert.setTitle("Passport System");
                        alert.setContentText("Login Successful");
                        alert.showAndWait();
                            return true;

                    } else {
                        //System.out.println("Password is Incorrect");
                        //passwordWarningLabel1.setText("incorrect password");
                        Alert alert = new Alert(Alert.AlertType.WARNING);
                        alert.setTitle("Passport System");
                        alert.setContentText("Wrong password");
                        alert.showAndWait();
                    }
                }

            }catch (SQLException exception){
                System.out.println("Connection fails in new user registration");
            }
        return false;
    }

    public void userApplicationformSubmite(String firstName,String lastName,String nic,String address,String nationality,String dateOfBirth,String gender,String phoneNo,String email,String birthCertificateNo,String profession){
        try{

            c = conn1.connectDb();
            String sql = "INSERT INTO registrationForm (first_name,last_name,nic,address,nationality,dob,gender,phone_no,email,birthCertificate_no,profession,police_status,admin_status)VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?) ";
            PreparedStatement statement = c.prepareStatement(sql);
            statement.setString(1, firstName);
            statement.setString(2, lastName);
            statement.setString(3, nic);
            statement.setString(4, address);
            statement.setString(5, nationality);
            statement.setString(6, dateOfBirth);
            statement.setString(7, gender);
            statement.setString(8, phoneNo);
            statement.setString(9, email);
            statement.setString(10, birthCertificateNo);
            statement.setString(11, profession);
            statement.setString(12, "pending");
            statement.setString(13, "processing");


            int rowsInserted = statement.executeUpdate();

            if (rowsInserted > 0) {

                //applicationSucceslabel.setText("Submitted");
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Passport System");
                alert.setContentText("Application is submitted");
                alert.showAndWait();
            } else {
                //applicationSucceslabel.setText("Submit fails");
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Passport System");
                alert.setContentText("Fail to submit");
                alert.showAndWait();
            }
        }catch (SQLException exception){
            System.out.println("Connection fails in submitting application form");
        }
    }

    public int getApplicationFormId(String nic){
        try{
            c = conn1.connectDb();
            Statement s = c.createStatement();
            resultSet = s.executeQuery("SELECT idregistrationForm FROM registrationForm WHERE nic='" + nic + "'");
            resultSet.next();
            return resultSet.getInt("idregistrationForm");

        }catch (SQLException exception){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Passport System");
            alert.setContentText("Fail to get Application ID");
            alert.showAndWait();
        }
        return 0;
    }
    public void changeAppointment(String id,String date,String time){
        try{
            c =conn1.connectDb();
            String sql = "UPDATE registrationForm SET appointment_date = '"+ date +"',appointment_time = '"+ time +"' WHERE idregistrationForm = '"+id+"'";
            statement = c.prepareStatement(sql);
            statement.executeUpdate();
            int rowsInserted = statement.executeUpdate();

            if (rowsInserted > 0) {
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Passport System");
                alert.setContentText("Appointment is added");
                alert.showAndWait();
            } else {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Passport System");
                alert.setContentText("Fail to add appointment");
                alert.showAndWait();
            }
        }catch (SQLException exception){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Passport System");
            alert.setContentText("Connection fails in add appointment");
            alert.showAndWait();
        }
    }



}
