import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Admin {
    private static final String NAME = "admin";
    private static final String PASSWORD = "admin123";

    public static String getNAME() {
        return NAME;
    }

    public static String getPASSWORD() {
        return PASSWORD;
    }
    public void addDoctor (String doctorId,String doctorName) {

        try {
            String dbURL = "jdbc:ucanaccess://C:\\Users\\LENOVO\\OneDrive\\Documents\\NetBeansProjects\\Hospital-Management-System\\HMS.accdb";
            Connection connection = DriverManager.getConnection(dbURL);
            String sql = "INSERT INTO Admin (DoctorId, DoctorName) VALUES (?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, doctorId);
            statement.setString(2, doctorName);
            statement.executeUpdate();
            statement.close();
            connection.close();
            JOptionPane.showMessageDialog(null,"Doctor added successfully!");
        } 
        catch (SQLException e) {   
            e.printStackTrace();
        }
    }
    public void removeDoctor (String doctorId) {
         try {
            String dbURL = "jdbc:ucanaccess://C:\\Users\\LENOVO\\OneDrive\\Documents\\NetBeansProjects\\Hospital-Management-System\\HMS.accdb";
            Connection connection = DriverManager.getConnection(dbURL);
            String sql = "DELETE FROM Admin WHERE DoctorId = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, doctorId);
            int rowsAffected = statement.executeUpdate();
            statement.close();
            connection.close();
            
            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(null,"Doctor deleted successfully!");
            } 
            else {
                JOptionPane.showMessageDialog(null,"Doctor with ID " + doctorId + " not found.");
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
}
