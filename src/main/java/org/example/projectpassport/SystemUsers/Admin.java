package org.example.projectpassport.SystemUsers;

import javafx.scene.control.Alert;
import org.example.projectpassport.SqlConnection;

import java.sql.*;

public class Admin {
    SqlConnection conn = new SqlConnection();

    PreparedStatement ps;
    ResultSet resultSet;

    Connection c ;
    public boolean adminLogin(String username , String password){
        try{
            c = conn.connectDb();
            Statement s = c.createStatement();
            resultSet = s.executeQuery("SELECT * FROM admin_login WHERE username='" + username + "'");

            if (!resultSet.next()) {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Passport System");
                alert.setContentText("Admin username not found");
                alert.showAndWait();
            } else {
                String dbpassword = resultSet.getString("password");

                if (password.equals(dbpassword)) {
                    Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                    alert.setTitle("Passport System");
                    alert.setContentText("You have successfully Login");
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
        }catch (SQLException exception) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Passport System");
            alert.setContentText("Login Connection Fails");
            alert.showAndWait();
        }
        return false;
    }
    public void adminStatusApprove(String id){
        try{
            c = conn.connectDb();
            ps = c.prepareStatement("SELECT * FROM registrationForm WHERE idregistrationForm = '" + id + "'");
            resultSet =ps.executeQuery();
            if(resultSet.next()){
                String udpateSql = "UPDATE registrationForm SET admin_status = 'Approved' WHERE idregistrationForm = '" + id + "'";
                ps = c.prepareStatement(udpateSql);
                ps.executeUpdate();
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Passport System");
                alert.setContentText("Admin status updated:  Approved");
                alert.showAndWait();

            }else {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Passport System");
                alert.setContentText("Enter the Application ID");
                alert.showAndWait();
            }

        }catch (SQLException exception){

        }
    }

    public void adminStatusReject(String id){
        try{
            c = conn.connectDb();
            ps = c.prepareStatement("SELECT * FROM registrationForm WHERE idregistrationForm = '" + id + "'");
            resultSet =ps.executeQuery();
            if(resultSet.next()){
                String udpateSql = "UPDATE registrationForm SET admin_status = 'Rejected' WHERE idregistrationForm = '" + id + "'";
                ps = c.prepareStatement(udpateSql);
                ps.executeUpdate();
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Passport System");
                alert.setContentText("Admin status updated: Rejected");
                alert.showAndWait();

            }else {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Passport System");
                alert.setContentText("Enter the Application ID");
                alert.showAndWait();
            }

        }catch (SQLException exception){

        }
    }
    public void AdminAddAppointment(String id,String date,String time){
        try{
            c =conn.connectDb();
            String sql = "UPDATE registrationForm SET appointment_date = '"+ date +"',appointment_time = '"+ time +"' WHERE idregistrationForm = '"+id+"'";
            ps = c.prepareStatement(sql);
            ps.executeUpdate();
            int rowsInserted = ps.executeUpdate();

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
