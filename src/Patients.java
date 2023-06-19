
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Patients extends Users {
    private String firstName;
    private String lastName;
    private String gender;
    private String doctor;
    private int age;
    private String address;
    private String description;
    JTextField ratingField;
    JTextField contactField;
    JTextField emailField;
    JTextArea prescriptionTextArea;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastname() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDoctor() {
        return doctor;
    }

    public void setDoctor(String doctor) {
        this.doctor = doctor;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
    public void setTextFields(JTextField ratingField, JTextField contactField, JTextField emailField, JTextArea prescriptionTextArea) {
    this.ratingField = ratingField;
    this.contactField = contactField;
    this.emailField = emailField;
    this.prescriptionTextArea = prescriptionTextArea;
    }
    
    public void bookAppointment () {
    try {
    String dbURL = "jdbc:ucanaccess://C:\\Users\\LENOVO\\OneDrive\\Documents\\NetBeansProjects\\Hospital-Management-System\\HMS.accdb";
    Connection connection = DriverManager.getConnection(dbURL);
    String selectQuery = "SELECT * FROM Patients WHERE Email = ?";
    PreparedStatement selectStatement = connection.prepareStatement(selectQuery);
    selectStatement.setString(1, getEmail());
    ResultSet resultSet = selectStatement.executeQuery();

    if (resultSet.next()) {
        String updateQuery = "UPDATE Patients SET FirstName = ?, LastName = ?, Gender = ?, Doctor = ?, Contact = ?, Age = ?, Address = ?, Description = ? WHERE Email = ?";
        try (PreparedStatement updateStatement = connection.prepareStatement(updateQuery)) {
            updateStatement.setString(1, getFirstName());
            updateStatement.setString(2, getLastname());
            updateStatement.setString(3, getGender());
            updateStatement.setString(4, getDoctor());
            updateStatement.setString(5, getContact());
            updateStatement.setInt(6, getAge());
            updateStatement.setString(7, getAddress());
            updateStatement.setString(8, getDescription());
            updateStatement.setString(9, getEmail());
            int rowsUpdated = updateStatement.executeUpdate();
            if (rowsUpdated > 0) {
               JOptionPane.showMessageDialog(null, "Appointment booked successfully");
               DoctorRatingJFrame DRFrame = new DoctorRatingJFrame();
               DRFrame.setName(getDoctor());
               DRFrame.setVisible(true);
            }
        }
    } 
    else {
        JOptionPane.showMessageDialog(null, "User with specified email does not exist");
    }
    resultSet.close();
    selectStatement.close();
    connection.close();
    } 
    catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Please fill all required fields");
        }
    }
    
    public void searchDoctors (String selectedDoctor) {
        
        try {
            String dbURL = "jdbc:ucanaccess://C:\\Users\\LENOVO\\OneDrive\\Documents\\NetBeansProjects\\Hospital-Management-System\\HMS.accdb";
            Connection connection = DriverManager.getConnection(dbURL);
            String query = "SELECT Ratings, Contact, Email FROM Doctors WHERE Username = ?";
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setString(1, selectedDoctor);
            ResultSet resultSet = stmt.executeQuery();
            
            while (resultSet.next()) {
                ratingField.setText(resultSet.getString("Ratings") + " /10");
                contactField.setText(resultSet.getString("Contact"));
                emailField.setText(resultSet.getString("Email"));                
            }
            
            resultSet.close();
            stmt.close();
            connection.close();
        } 
       
        catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    public void getPrescription (String diseaseComboBox, String selectedMedicine) {
        String[][] diseaseMedicineData = {
            {"Hypertension", "Lisinopril, Amlodipine, Losartan, Hydrochlorothiazide"},
            {"Diabetes", "Metformin, Insulin, Sitagliptin, Glipizide"},
            {"Influenza", "Oseltamivir, Zanamivir, Peramivir"},
            {"Asthma", "Albuterol, Fluticasone, Montelukast, Budesonide"},
            {"Arthritis", "Acetaminophen, Ibuprofen, Naproxen, Methotrexate, Adalimumab"},
            {"Depression", "Fluoxetine, Sertraline, Escitalopram, Amitriptyline, Venlafaxine"},
            {"Bacterial Infection", "Amoxicillin, Ciprofloxacin, Azithromycin, Doxycycline"},
            {"Viral Infection", "Acyclovir, Valacyclovir, Ribavirin, Ganciclovir"},
            {"Allergies", "Loratadine, Cetirizine, Fexofenadine, Diphenhydramine"},
            {"High Cholesterol", "Statins, Ezetimibe, Fenofibrate"},
            {"Migraine", "Sumatriptan, Rizatriptan, Propranolol, Topiramate"},
    };
        String selectedDisease=diseaseComboBox;
        for (String[] disease : diseaseMedicineData) {
                if (disease[0].equals(selectedDisease)) {
                    selectedMedicine = disease[1];
                    break;
                }
            }
        prescriptionTextArea.setText("Following are the medicines or chemical you can take:\nPlease consult your Doctor before taking them.\n"+selectedMedicine);
    }
    
}
