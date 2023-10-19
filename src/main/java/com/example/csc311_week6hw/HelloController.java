package com.example.csc311_week6hw;

import com.example.csc311_week6hw.db.ConnDbOps;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;
import java.io.File;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;


public class HelloController implements Initializable {

    private final ObservableList<Person> data = FXCollections.observableArrayList(
    );

    // ALl the variables for the javafx
    @FXML
    TextField name, email, phone,address,salary,password;
    @FXML
    private TableView<Person> tv;
    @FXML
    private TableColumn<Person, Integer> tv_id;
    @FXML
    private TableColumn<Person, String> tv_name, tv_email, tv_phone, tv_address,tv_salary,tv_password;

    @FXML
    ImageView img_view;



    // initialize the tableview with the data from database
    public void initialize(URL url, ResourceBundle resourceBundle) {
        tv_id.setCellValueFactory(new PropertyValueFactory<>("id"));
        tv_name.setCellValueFactory(new PropertyValueFactory<>("name"));
        tv_email.setCellValueFactory(new PropertyValueFactory<>("email"));
        tv_phone.setCellValueFactory(new PropertyValueFactory<>("phone"));
        tv_address.setCellValueFactory(new PropertyValueFactory<>("address"));
        tv_salary.setCellValueFactory(new PropertyValueFactory<>("salary"));
        tv_password.setCellValueFactory(new PropertyValueFactory<>("password"));

        // get the data from database
        ObservableList<Person> databaseData = null;
        try {
            ConnDbOps dbOps = new ConnDbOps();
            databaseData = dbOps.getAllUsersFromDatabase();
            tv.setItems(databaseData);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        tv.setItems(databaseData);
    }


  // Method that adds record to the database
    @FXML
    protected void addNewRecord() {
        String nameValue = name.getText();
        String emailValue = email.getText();
        String phoneValue = phone.getText();
        String addressValue = address.getText();
        String salaryValue = salary.getText();
        String passwordValue = password.getText();

        try {
            int salaryInt = Integer.parseInt(salaryValue);
            Person p = new Person(nameValue, emailValue, phoneValue, addressValue, salaryInt, passwordValue);

            ConnDbOps dbOps = new ConnDbOps();
            dbOps.insertUser(p);

            loadTableData();
            data.add(p);

        } catch (NumberFormatException e) {
            System.out.println("Invalid salary value.");
        }
        loadTableData();
        clearForm();
    }

    //deletes the record from the database
    @FXML
    protected void deleteRecord() {
        Person selectedPerson = tv.getSelectionModel().getSelectedItem();

        if (selectedPerson != null) {
            // Delete from the database using ConnDbOps
            ConnDbOps dbOps = new ConnDbOps();
            dbOps.deleteUser(selectedPerson.getEmail());
            loadTableData();
            // Remove the selected item from the TableView
            data.remove(selectedPerson);
        }

    }

    //clears the text-field
    //uses in the delete and add method to clear the field after you click to add or delete
    @FXML
    protected void clearForm() {
        name.clear();
        email.clear();
        phone.clear();
        address.clear();
        salary.clear();
        password.clear();
    }

    //edits the data from the database
    @FXML
    protected void editRecord() {
        Person  p = tv.getSelectionModel().getSelectedItem();
        int c = data.indexOf(p);
        Person p2 = new Person();
        p2.setId(c+1);
        p2.setName(name.getText());
        p2.setEmail(email.getText());
        p2.setPhone(phone.getText());
        p2.setAddress(address.getText());
        p2.setSalary(Integer.parseInt(salary.getText()));
        p2.setPassword(password.getText());
        data.remove(c);
        data.add(c,p2);
        tv.getSelectionModel().select(c);
    }

    //shows the image in the javafx
    @FXML
    protected void showImage(){
        File file = (new FileChooser()).showOpenDialog(img_view.getScene().getWindow());
        if(file != null){
            img_view.setImage(new Image(file.toURI().toString()));
        }
    }

    //it selects the clicked item in the tableview
    @FXML
    protected void selectedItemTV(MouseEvent mouseEvent){
        Person v = tv.getSelectionModel().getSelectedItem();
        name.setText(v.getName());
        email.setText(v.getEmail());
        phone.setText(v.getPhone());
        address.setText(v.getAddress());
        salary.setText(Integer.toString(v.getSalary()));
        password.setText(v.getPassword());
    }

    // tried to load the data to the tableview after adding and deleting
   @FXML
    protected void loadTableData() {
        try {
            ConnDbOps dbOps = new ConnDbOps();
            ObservableList<Person> databaseData = dbOps.getAllUsersFromDatabase();
            data.addAll(databaseData);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}