package org.example.projectpassport;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import org.example.projectpassport.SystemUsers.Admin;
import org.example.projectpassport.SystemUsers.Police;
import org.example.projectpassport.SystemUsers.User;
import org.example.projectpassport.tableView.AdminApplicationForm;
import org.example.projectpassport.tableView.AdminAppointmentSchedule;
import org.example.projectpassport.tableView.applicationForm;

import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;


public class HelloController implements Initializable {
    @FXML
    private TableView<applicationForm> tableView;

    @FXML
    private TableColumn<org.example.projectpassport.tableView.applicationForm, String> colAddress;

    @FXML
    private TableColumn<applicationForm, String> colAppId;

    @FXML
    private TableColumn<applicationForm, String> colDob;

    @FXML
    private TableColumn<applicationForm, String> colFN;

    @FXML
    private TableColumn<applicationForm, String> colBirthCertificate;

    @FXML
    private TableColumn<applicationForm, String> colGender;

    @FXML
    private TableColumn<applicationForm, String> colLN;

    @FXML
    private TableColumn<applicationForm, String> colProfession;

    @FXML
    private TableColumn<applicationForm, String> colNationality;

    @FXML
    private TableColumn<applicationForm, String> colNic;
    //Admin Dashboard Columns

    @FXML
    private TableColumn<AdminApplicationForm, String> AdColAddress;

    @FXML
    private TableColumn<AdminApplicationForm, String> AdColAppId;

    @FXML
    private TableColumn<AdminApplicationForm, String> AdColDob;

    @FXML
    private TableColumn<AdminApplicationForm, String > AdColBirthCertificateNo;

    @FXML
    private TableColumn<AdminApplicationForm, String> AdColFn;

    @FXML
    private TableColumn<AdminApplicationForm, String> AdColGender;

    @FXML
    private TableColumn<AdminApplicationForm, String> AdColLn;

    @FXML
    private TableColumn<AdminApplicationForm, String > AdColProfession;

    @FXML
    private TableColumn<AdminApplicationForm, String> AdColNationality;

    @FXML
    private TableColumn<AdminApplicationForm, String> AdColNic;

    @FXML
    private TableColumn<AdminApplicationForm, String> AdColPoliceStatus;
    @FXML
    private TableView<AdminApplicationForm> AdminTableView;
    @FXML
    private TableColumn<AdminAppointmentSchedule, String> colAppointmentEmail;

    @FXML
    private TableColumn<AdminAppointmentSchedule, String> colAppointmentId;

    @FXML
    private TableColumn<AdminAppointmentSchedule, String> colAppointmentName;

    @FXML
    private TableColumn<AdminAppointmentSchedule, String> colAppointmentPhone;

    @FXML
    private TableColumn<AdminAppointmentSchedule, String> colAppointmentStatus;
    @FXML
    private TableView<AdminAppointmentSchedule> AppointmentTableView;





    @FXML
    public Pane userRegistration, home, userLogin, adminLogin, policeLogin, applicationForm, adminDashboard, policeDashboard, checkStatus, dashboard, AdminAppointmentDetails,changeAppointment;

    @FXML
    public TextField regName, regUsername, regPassword, regEmail;
    //new user registration.
    @FXML
    public TextField ULUsername, ULUserPassword;
    //user login
    @FXML
    //admin login
    public TextField ADusername, ADpassword;

    @FXML
    public TextField PLusernameTextBox, PLpasswordTextBox;
    @FXML
    public TextField applicationFN, applicationLN, applicationNIC, applicationAddress, applicationNationality,  applicationPhoneNo, applicationEmail, applicationBirthCertificateNo, applicationIdTextBox;

    @FXML
    public RadioButton maleRadioButton, femaleRadioButton,employedRadioButton,unEmployedRadioButton;
    @FXML
    public Label successLabal, applicationSucceslabel, applicantIdLabel;
    @FXML
    //registration form labels.
    public Label regFullNamelabel1, regUsernamelabel2, regPasswordlabel3, regEmaillabel4;
    @FXML
    //userLogin form labels.
    public Label usernameWarningLabel, passwordWarningLabel1;
    //policLogin form labels.
    @FXML
    public Label PLusernameWarrningLabel, PLpasswordWarraingLabel;

    @FXML
    public Label ADusernameWarraingLabel, ADpasswordWarringLabel;
    @FXML
    public Button AppStatusBackButton, AppStatusHomeButton;
    @FXML
    //check status label
    public Label displayFirstNameLabel, displayLastNameLabel, displayNicLabel, displayAddressLabel, displayNationalityLabel, displayDateOfBirthLabel, displayGenderLabel, displayPhoneNumberlabel, displayEmailLabel, displayBirthCertificate, displayProffession, displayPoliceStatusLabel, displayAdminStatsuLabel,ApplicationIdNotFound;
    @FXML
    public TextField PLIdtextField;
    @FXML
    public TextField AdminApplicationId;
    @FXML
    //adminDashboard
    public Label AdminAppIdNotFound;
    @FXML
    public DatePicker DobDatePicker;
    @FXML
    private ComboBox<String> AppointmentTimeComboBox;
    @FXML
    private DatePicker AppointmentDatePicker;

    @FXML
    //admin appointment.
    public TextField txtId,txtEmail,txtPhone;

    User user = new User();
    Admin admin = new Admin();
    Police police = new Police();
    SqlConnection conn = new SqlConnection();
    Connection c;


    public void userRegister(ActionEvent event) {
        userRegistration.toFront();
    }

    public void toHome(ActionEvent event) {
        home.toFront();
    }


    public void loginButton(ActionEvent event) {
        userLogin.toFront();
    }

    public void userBack(ActionEvent event) {
        home.toFront();
    }


    public void userLoginButton(ActionEvent event) {
        //user login
        String username = ULUsername.getText();
        String password = ULUserPassword.getText();


        if(user.userLogin(username,password)){
            dashboard.toFront();
        }

    }

    public void adminLoginButton(ActionEvent event) {
        adminLogin.toFront();
    }

    public void policeLoginButton(ActionEvent event) {
        policeLogin.toFront();
    }

    public void adminBackButton(ActionEvent event) {
        home.toFront();

    }

    public void policeBackButton(ActionEvent event) {
        home.toFront();
    }

    public void backUserLoginButton(ActionEvent event) {
        userLogin.toFront();
        ULUsername.setText("");
        ULUserPassword.setText("");
    }

    public void backHomeButton(ActionEvent event) {
        home.toFront();
        ULUsername.setText("");
        ULUserPassword.setText("");


    }

    public void userRegisterButton(ActionEvent event) {
        //new user registration

        if (regName.getText().isEmpty()) {
            //System.out.println("Enter your name");
            regFullNamelabel1.setText("Enter the full name");
        } else if (regUsername.getText().isEmpty()) {
            //System.out.println("Enter your username");
            regUsernamelabel2.setText("Enter the username");
        } else if (regPassword.getText().isEmpty()) {
            //System.out.println("Enter the password");
            regPasswordlabel3.setText("Enter the password");
        } else if (regEmail.getText().isEmpty()) {
            //System.out.println("Enter the email");
            regEmaillabel4.setText("Enter the Email");
        } else {
            String fullname = regName.getText();
            String username = regUsername.getText();
            String password = regPassword.getText();
            String email = regEmail.getText();


            //passing the values to User class method called insertnewUser.
            user.insertNewUser(fullname, username, password, email);
        }
    }


    public void applicationSubmiteButton(ActionEvent event) {

        String firstName = applicationFN.getText();
        String lastName = applicationLN.getText();
        String nic = applicationNIC.getText();
        String address = applicationAddress.getText();
        String nationality = applicationNationality.getText();
        String dateOfBirth = String.valueOf(DobDatePicker.getValue());
        String phoneNo = applicationPhoneNo.getText();
        String email = applicationEmail.getText();
        String birthCertificateNo = applicationBirthCertificateNo.getText();



        boolean male = false;
        boolean female = false;
        String gender = null;
        if (maleRadioButton.isSelected()) {
            male = true;
        } else if (femaleRadioButton.isSelected()) {
            female = true;
        } else {
            System.out.println("Select the gender ");
        }


        if (male) {
            gender = "male";
        } else if (female) {
            gender = "female";
        }


        boolean employed = false;
        boolean unemployed = false;
        String profession = null;

        if(employedRadioButton.isSelected()){
            employed = true;
        }else if(unEmployedRadioButton.isSelected()){
            unemployed = true;
        }else{
            System.out.println("Select the profession");
        }

        if(employed){
            profession = "employed";
        }else if(unemployed){
            profession = "Un employed";
        }


        //method userApplicationformSubmite
        user.userApplicationformSubmite(firstName,lastName,nic,address,nationality,dateOfBirth,gender,phoneNo,email,birthCertificateNo,profession);
        applicantIdLabel.setText(String.valueOf(user.getApplicationFormId(nic)));


    }


    public void RequestFormButton(ActionEvent event) {
        applicationForm.toFront();
    }

    public void applicationFormBackButton(ActionEvent event) {
        dashboard.toFront();
        applicationFN.setText("");
        applicationLN.setText("");
        applicationNIC.setText("");
        applicationAddress.setText("");
        applicationNationality.setText("");
        applicationPhoneNo.setText("");
        applicationEmail.setText("");
        applicationBirthCertificateNo.setText("");
        applicantIdLabel.setText("");

    }

    public void AdLoginButton(ActionEvent event) {
        //go to admin panel.

        String username = ADusername.getText();
        String password = ADpassword.getText();

        if(admin.adminLogin(username,password)){
            laodDataIntoAdminTable();
            adminDashboard.toFront();
        }
    }



    public void checkStatusButton(ActionEvent event) {
        checkStatus.toFront();
    }

    public void AppStatusBackButton(ActionEvent event) {
        dashboard.toFront();
        displayFirstNameLabel.setText(" ");
        displayLastNameLabel.setText(" ");
        displayNicLabel.setText(" ");
        displayAddressLabel.setText(" ");
        displayNationalityLabel.setText(" ");
        displayDateOfBirthLabel.setText(" ");
        displayGenderLabel.setText(" ");
        displayPhoneNumberlabel.setText(" ");
        displayEmailLabel.setText(" ");
        displayBirthCertificate.setText(" ");
        displayProffession.setText(" ");
        displayPoliceStatusLabel.setText(" ");
        displayAdminStatsuLabel.setText(" ");
        applicationIdTextBox.setText(" ");


    }

    public void AppStatusHomeButton(ActionEvent event) {
        home.toFront();
        displayFirstNameLabel.setText(" ");
        displayLastNameLabel.setText(" ");
        displayNicLabel.setText(" ");
        displayAddressLabel.setText(" ");
        displayNationalityLabel.setText(" ");
        displayDateOfBirthLabel.setText(" ");
        displayGenderLabel.setText(" ");
        displayPhoneNumberlabel.setText(" ");
        displayEmailLabel.setText(" ");
        displayBirthCertificate.setText(" ");
        displayProffession.setText(" ");
        displayPoliceStatusLabel.setText(" ");
        displayAdminStatsuLabel.setText(" ");
        applicationIdTextBox.setText(" ");
    }


    public void appStatusDisplayButton(ActionEvent event) {
        //application display code
        String applicationId = applicationIdTextBox.getText();

        try {
            c= conn.connectDb();
//            conn = DriverManager.getConnection(url, sqlusername, sqlpassword);
            Statement statement = c.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM  registrationForm WHERE idregistrationForm ='" + applicationId + "'");

            if (!resultSet.next()) {
                //System.out.println("Applicatin ID not found");
                //ApplicationIdNotFound.setText("Application ID not found");
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Passport System");
                alert.setContentText("Invalid Application ID ");
                alert.showAndWait();

            } else {
                displayFirstNameLabel.setText(resultSet.getString("first_name"));
                displayLastNameLabel.setText(resultSet.getString("last_name"));
                displayNicLabel.setText(resultSet.getString("nic"));
                displayAddressLabel.setText(resultSet.getString("address"));
                displayNationalityLabel.setText(resultSet.getString("nationality"));
                displayDateOfBirthLabel.setText(resultSet.getString("dob"));
                displayGenderLabel.setText(resultSet.getString("gender"));
                displayPhoneNumberlabel.setText(resultSet.getString("phone_no"));
                displayEmailLabel.setText(resultSet.getString("email"));
                displayBirthCertificate.setText(resultSet.getString("birthCertificate_no"));
                displayProffession.setText(resultSet.getString("profession"));
                displayPoliceStatusLabel.setText(resultSet.getString("police_status"));
                displayAdminStatsuLabel.setText(resultSet.getString("admin_status"));
            }

        } catch (SQLException exception) {
            System.out.println("Connection fails");
        }
    }

    public void PLloginButton(ActionEvent event) {
        String username = PLusernameTextBox.getText();
        String password = PLpasswordTextBox.getText();

        if (police.policeLogin(username,password)) {
            loadDataIntoPoliceTable();
            policeDashboard.toFront();

        }

    }

    public void PLHomeButton(ActionEvent event) {
        home.toFront();
        PLusernameTextBox.setText("");
        PLpasswordTextBox.setText("");

    }

    public void ADHomeButton(ActionEvent event) {
        home.toFront();
        ADusername.setText("");
        ADpassword.setText("");
    }

   public void PLGoodButton(ActionEvent event) {
       //Police button imp "good"

       String id = PLIdtextField.getText();
       police.policeStatusGood(id);

    }

    public void PLBadButton(ActionEvent event) throws SQLException {
    // police button imp "bad"
       String id = PLIdtextField.getText();
       police.policeStatusBad(id);
    }
//
    private void loadDataIntoPoliceTable() {
        ObservableList<applicationForm> list = FXCollections.observableArrayList();

        c = conn.connectDb();
        try {
            PreparedStatement ps = c.prepareStatement("SELECT * FROM registrationForm WHERE police_status = 'pending'");
            ResultSet resultSet = ps.executeQuery();

            while (resultSet.next()) {
                list.add(new applicationForm(
                        resultSet.getString("idregistrationForm"),
                        resultSet.getString("first_name"),
                        resultSet.getString("last_name"),
                        resultSet.getString("nic"),
                        resultSet.getString("address"),
                        resultSet.getString("nationality"),
                        resultSet.getString("dob"),
                        resultSet.getString("gender"),
                        resultSet.getString("birthCertificate_no"),
                        resultSet.getString("profession")
                ));
            }

            colAppId.setCellValueFactory(new PropertyValueFactory<>("idregistrationForm"));
            colFN.setCellValueFactory(new PropertyValueFactory<>("first_name"));
            colLN.setCellValueFactory(new PropertyValueFactory<>("last_name"));
            colNic.setCellValueFactory(new PropertyValueFactory<>("nic"));
            colAddress.setCellValueFactory(new PropertyValueFactory<>("address"));
            colNationality.setCellValueFactory(new PropertyValueFactory<>("nationality"));
            colDob.setCellValueFactory(new PropertyValueFactory<>("dob"));
            colGender.setCellValueFactory(new PropertyValueFactory<>("gender"));
            colBirthCertificate.setCellValueFactory(new PropertyValueFactory<>("birthCertificate_no"));
            colProfession.setCellValueFactory(new PropertyValueFactory<>("profession"));

            tableView.setItems(list);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void laodDataIntoAdminTable(){
        ObservableList<AdminApplicationForm> list2 = FXCollections.observableArrayList();
        c = conn.connectDb();
        try {

            PreparedStatement ps = c.prepareStatement("SELECT * FROM registrationForm WHERE police_status IN ('Good', 'Bad');");
            ResultSet rs = ps.executeQuery();



            while (rs.next()) {
                AdColAppId.setCellValueFactory(new PropertyValueFactory<AdminApplicationForm,String>("idregistrationForm"));
                AdColFn.setCellValueFactory(new PropertyValueFactory<AdminApplicationForm, String>("first_name"));
                AdColLn.setCellValueFactory(new PropertyValueFactory<AdminApplicationForm, String>("last_name"));
                AdColNic.setCellValueFactory(new PropertyValueFactory<AdminApplicationForm, String>("nic"));
                AdColAddress.setCellValueFactory(new PropertyValueFactory<AdminApplicationForm, String>("address"));
                AdColNationality.setCellValueFactory(new PropertyValueFactory<AdminApplicationForm, String>("nationality"));
                AdColDob.setCellValueFactory(new PropertyValueFactory<AdminApplicationForm, String>("dob"));
                AdColGender.setCellValueFactory(new PropertyValueFactory<AdminApplicationForm, String>("gender"));
                AdColBirthCertificateNo.setCellValueFactory(new PropertyValueFactory<AdminApplicationForm, String>("birthCertificate_no"));
                AdColProfession.setCellValueFactory(new PropertyValueFactory<AdminApplicationForm, String>("profession"));
                AdColPoliceStatus.setCellValueFactory(new PropertyValueFactory<AdminApplicationForm, String>("police_status"));



                list2.add(new AdminApplicationForm(rs.getString("idregistrationForm"),rs.getString("first_name"),rs.getString("last_name"),rs.getString("nic"),rs.getString("address"),rs.getString("nationality"),rs.getString("dob"),rs.getString("gender"),rs.getString("birthCertificate_no"),rs.getString("profession"),rs.getString("police_status")));
                AdminTableView.setItems(list2);

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
    public void loadDataIntoAdminAppointmentTable(){
        ObservableList<AdminAppointmentSchedule> list3 = FXCollections.observableArrayList();

        c= conn.connectDb();
        try {

            PreparedStatement ps1 = c.prepareStatement("SELECT * FROM registrationForm WHERE admin_status = 'Approved';");
            ResultSet rs1 = ps1.executeQuery();



            while (rs1.next()) {
                colAppointmentId.setCellValueFactory(new PropertyValueFactory<AdminAppointmentSchedule,String>("idregistrationForm"));
                colAppointmentName.setCellValueFactory(new PropertyValueFactory<AdminAppointmentSchedule,String>("first_name"));
                colAppointmentPhone.setCellValueFactory(new PropertyValueFactory<AdminAppointmentSchedule,String>("phone_no"));
                colAppointmentEmail.setCellValueFactory(new PropertyValueFactory<AdminAppointmentSchedule,String>("email"));
                colAppointmentStatus.setCellValueFactory(new PropertyValueFactory<AdminAppointmentSchedule,String>("admin_status"));
                list3.add(new AdminAppointmentSchedule(rs1.getString("idregistrationForm"),rs1.getString("first_name"),rs1.getString("phone_no"),rs1.getString("email"),rs1.getString("admin_status")));
                AppointmentTableView.setItems(list3);

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        AppointmentTimeComboBox.setItems(FXCollections.observableArrayList("9:00 AM","10:00 AM","11:00 AM","2:00 PM","3:00 PM"));
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }




    public void AdminApproveButton(ActionEvent event) {
        String id = AdminApplicationId.getText();
        admin.adminStatusApprove(id);
    }

    public void AdminRejectButton(ActionEvent event) {
        String id = AdminApplicationId.getText();
        admin.adminStatusReject(id);
    }

    public void ADAppointmentDetails(ActionEvent event) {
        loadDataIntoAdminAppointmentTable();
        AdminAppointmentDetails.toFront();
    }

    public void AdminAppointmentBackButton(ActionEvent event) {
        home.toFront();
    }



    public void AdminAppointmentItemSetButton(MouseEvent mouseEvent) {
        Integer index = AppointmentTableView.getSelectionModel().getSelectedIndex();

            if(index <= -1){
                return;
            }
        txtId.setText(colAppointmentId.getCellData(index).toString());
        txtPhone.setText(colAppointmentPhone.getCellData(index).toString());
        txtEmail.setText(colAppointmentEmail.getCellData(index).toString());
    }

EmailSender emailSender = new EmailSender();
    public void AdminAddAppointmentButton(ActionEvent event) {
        String id = txtId.getText();
        String date = String.valueOf(AppointmentDatePicker.getValue());
        String time = String.valueOf(AppointmentTimeComboBox.getValue());
        String email = txtEmail.getText();
        admin.AdminAddAppointment(id,date,time);
        emailSender.sendEmail(email,id,date,time);
    }

    public void userChangeAppointmentButton(ActionEvent event) {
        changeAppointment.toFront();
    }
}