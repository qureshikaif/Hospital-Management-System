
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Feedbacks {
    private String firstName;
    private String lastName;
    private String email;
    private String contact;
    private String feedback;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }
    
    public void provideFeedback () {
        try {
           String dbURL = "jdbc:ucanaccess://C:\\Users\\LENOVO\\OneDrive\\Documents\\NetBeansProjects\\Hospital-Management-System\\HMS.accdb";
           Connection connection = DriverManager.getConnection(dbURL);
           PreparedStatement statement = connection.prepareStatement("INSERT INTO Feedbacks (FirstName, LastName, Email, Contact, Feedback)  VALUES (?, ?, ?, ?, ?)");
           statement.setString(1, getFirstName());
           statement.setString(2,getLastName());
           statement.setString(3, getEmail());
           statement.setString(4, getContact());
           statement.setString(5, getFeedback());
           
            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                JOptionPane.showMessageDialog(null, "Thank you for your feedback!");
                PatientJFrame PFrame = new PatientJFrame();
                PFrame.setVisible(true);
            } 
            else {
                JOptionPane.showMessageDialog(null, "An error occured");
            }
        }    
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
