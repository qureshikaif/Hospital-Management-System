
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Doctors extends Users {
    private String doctorId;
    private String timings;
    private String ratings;
    JTextField firstName;
    JTextField lastName;
    JTextField ageField;
    JTextField contactField;
    JTextField emailField;
    JTextField genderField;
    JTextArea diseaseField;

    public String getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(String doctorId) {
        this.doctorId = doctorId;
    }

    public String getTimings() {
        return timings;
    }

    public void setTimings(String timings) {
        this.timings = timings;
    }

    public String getRatings() {
        return ratings;
    }

    public void setRatings(String ratings) {
        this.ratings = ratings;
    }
    
    public void setTextFields(JTextField firstName, JTextField lastName, JTextField ageField, JTextField contactField, JTextField emailField, JTextField genderField, JTextArea diseaseField) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.ageField = ageField;
    this.contactField = contactField;
    this.emailField = emailField;
    this.genderField = genderField;
    this.diseaseField = diseaseField;
    
    }
    public void setAppointmentTimings () {
        try {
           String dbURL = "jdbc:ucanaccess://C:\\Users\\LENOVO\\OneDrive\\Documents\\NetBeansProjects\\Hospital-Management-System\\HMS.accdb";
           Connection connection = DriverManager.getConnection(dbURL);
            PreparedStatement checkEmailStmt = connection.prepareStatement("SELECT * FROM Doctors WHERE Email = ?");
            checkEmailStmt.setString(1, getEmail());
            ResultSet resultSet = checkEmailStmt.executeQuery();

            if (resultSet.next()) {
                PreparedStatement updateTimingStmt = connection.prepareStatement("UPDATE Doctors SET Timings = ? WHERE Email = ?");
                updateTimingStmt.setString(1,getTimings());
                updateTimingStmt.setString(2, getEmail());
                updateTimingStmt.executeUpdate();
                JOptionPane.showMessageDialog(null, "Timings updated successfully.");
            } 
            else {
                JOptionPane.showMessageDialog(null, "Email not found in the database.");
            }
            resultSet.close();
            checkEmailStmt.close();
            connection.close();
        } 
        catch ( SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void searchPatients (String selectedPatient) {
        try {
            
            String dbURL = "jdbc:ucanaccess://C:\\Users\\LENOVO\\OneDrive\\Documents\\NetBeansProjects\\Hospital-Management-System\\HMS.accdb";
            Connection connection = DriverManager.getConnection(dbURL);
            String query = "SELECT firstname, lastname, age, contact, email, address, gender, description FROM Patients WHERE Username = ?";
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setString(1, selectedPatient);
            ResultSet resultSet = stmt.executeQuery();
            
            while (resultSet.next()) {
                firstName.setText(resultSet.getString("FirstName"));
                lastName.setText(resultSet.getString("LastName"));
                ageField.setText(resultSet.getString("Age"));
                contactField.setText(resultSet.getString("Contact"));
                emailField.setText(resultSet.getString("Email"));
                genderField.setText(resultSet.getString("Gender"));
                diseaseField.setText(resultSet.getString("Description"));
            }

            resultSet.close();
            stmt.close();
            connection.close();
        } 
        catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}