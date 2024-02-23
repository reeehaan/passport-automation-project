package org.example.projectpassport.SystemUsers;

import javafx.scene.control.Alert;
import org.example.projectpassport.SqlConnection;

import java.sql.*;


public class Police {
    SqlConnection conn = new SqlConnection();
    ResultSet resultSet;
    PreparedStatement ps;

    Connection c;

    public boolean policeLogin(String username, String password){
        try {
            c = conn.connectDb();
            Statement s = c.createStatement();
            resultSet = s.executeQuery("SELECT * FROM police_login WHERE username='" + username + "'");
            if(!resultSet.next()){
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Passport System");
                alert.setContentText("User not found");
                alert.showAndWait();
            }else {
                String dbpassword = resultSet.getString("password");
                if(password.equals(dbpassword)){
                    Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                    alert.setTitle("Passport System");
                    alert.setContentText("Successful login");
                    alert.showAndWait();
                    return true;
                }else {
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

    public void policeStatusGood(String id){
        try{
            c = conn.connectDb();
            ps = c.prepareStatement("SELECT * FROM registrationForm WHERE idregistrationForm = '" + id + "'");
            resultSet= ps.executeQuery();
            if(resultSet.next()){
                String udpateSql = "UPDATE registrationForm SET police_status = 'Good' WHERE idregistrationForm = '" + id + "'";
                ps = c.prepareStatement(udpateSql);
                ps.executeUpdate();
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Passport System");
                alert.setContentText("Police Status updated GOOD");
                alert.showAndWait();

            }else {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Passport System");
                alert.setContentText("Enter the Application ID");
                alert.showAndWait();
            }

        }catch (SQLException exception){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Passport System");
            alert.setContentText("Update fails");
            alert.showAndWait();
        }
    }

    public void policeStatusBad(String id){
        try{
            c = conn.connectDb();
            ps = c.prepareStatement("SELECT * FROM registrationForm WHERE idregistrationForm = '" + id + "'");
            resultSet= ps.executeQuery();
            if(resultSet.next()){
                String udpateSql = "UPDATE registrationForm SET police_status = 'Bad' WHERE idregistrationForm = '" + id + "'";
                ps = c.prepareStatement(udpateSql);
                ps.executeUpdate();
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Passport System");
                alert.setContentText("Police Status updated BAD");
                alert.showAndWait();

            }else {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Passport System");
                alert.setContentText("Enter the Application ID");
                alert.showAndWait();
            }

        }catch (SQLException exception){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Passport System");
            alert.setContentText("Update fails");
            alert.showAndWait();
        }
    }

}
