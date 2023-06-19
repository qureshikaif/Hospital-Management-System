import java.awt.Dimension;
import java.awt.Toolkit;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;
public class BookAppointmentJFrame extends javax.swing.JFrame {
    
    public BookAppointmentJFrame() {
        initComponents();
        centerFrame();

    try {
        String dbURL = "jdbc:ucanaccess://C:\\Users\\LENOVO\\OneDrive\\Documents\\NetBeansProjects\\Hospital-Management-System\\HMS.accdb";
        Connection connection = DriverManager.getConnection(dbURL);
        Statement statement = null;
        ResultSet resultSet = null;
        statement = connection.createStatement();   
        String query = "SELECT Username FROM Doctors";
        resultSet = statement.executeQuery(query);
        ArrayList<String> doctorNames = new ArrayList<>();
        
        while (resultSet.next()) {
            String doctorName = resultSet.getString("Username");
            doctorNames.add(doctorName);
        }

        for (String name : doctorNames) {
            doctorField.addItem(name);
        }
    } 
    
    catch (SQLException e) {
        e.printStackTrace();
    } 
    
 }
    private void centerFrame() {
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    int screenWidth = screenSize.width;
    int screenHeight = screenSize.height;
    int frameWidth = getWidth();
    int frameHeight = getHeight();
    int x = (screenWidth - frameWidth) / 2;
    int y = (screenHeight - frameHeight) / 2;
    setLocation(x, y);
    }
    
    String name;
    public void setName (String username) {
        this.name=username;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel6 = new javax.swing.JLabel();
        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel2 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        maleButton = new javax.swing.JRadioButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        ageField = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        diseaseField = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        addressField = new javax.swing.JTextArea();
        jLabel10 = new javax.swing.JLabel();
        doctorField = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        contactField = new javax.swing.JTextField();
        firstName = new javax.swing.JTextField();
        lastName = new javax.swing.JTextField();
        femaleButton = new javax.swing.JRadioButton();
        jLabel4 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        emailField = new javax.swing.JTextField();
        timingField = new javax.swing.JComboBox<>();
        jLabel12 = new javax.swing.JLabel();

        jLabel6.setBackground(new java.awt.Color(255, 255, 255));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setIcon(new javax.swing.ImageIcon("C:\\Users\\LENOVO\\Downloads\\hospital-management-software-main-banner-1.jpg")); // NOI18N

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(0, 102, 204));
        jPanel2.setForeground(new java.awt.Color(255, 255, 255));

        jLabel8.setFont(new java.awt.Font("Segoe UI Black", 1, 36)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Book An Appointment");

        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("First Name: ");

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Last Name: ");

        buttonGroup1.add(maleButton);
        maleButton.setForeground(new java.awt.Color(255, 255, 255));
        maleButton.setText("Male");

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Gender: ");

        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Age: ");

        ageField.setBackground(new java.awt.Color(255, 255, 255));
        ageField.setForeground(new java.awt.Color(0, 102, 204));

        diseaseField.setBackground(new java.awt.Color(255, 255, 255));
        diseaseField.setColumns(20);
        diseaseField.setForeground(new java.awt.Color(0, 102, 204));
        diseaseField.setRows(5);
        diseaseField.setText("Description");
        diseaseField.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                diseaseFieldMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                diseaseFieldMouseExited(evt);
            }
        });
        jScrollPane1.setViewportView(diseaseField);

        addressField.setBackground(new java.awt.Color(255, 255, 255));
        addressField.setColumns(20);
        addressField.setForeground(new java.awt.Color(0, 102, 204));
        addressField.setRows(5);
        addressField.setText("Address");
        addressField.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                addressFieldMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                addressFieldMouseExited(evt);
            }
        });
        jScrollPane2.setViewportView(addressField);

        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Doctor: ");

        doctorField.setBackground(new java.awt.Color(255, 255, 255));
        doctorField.setForeground(new java.awt.Color(0, 102, 204));
        doctorField.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                doctorFieldMouseClicked(evt);
            }
        });
        doctorField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                doctorFieldActionPerformed(evt);
            }
        });

        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Contact: ");

        contactField.setBackground(new java.awt.Color(255, 255, 255));
        contactField.setForeground(new java.awt.Color(0, 102, 204));

        firstName.setBackground(new java.awt.Color(255, 255, 255));
        firstName.setForeground(new java.awt.Color(0, 102, 204));
        firstName.setToolTipText("");

        lastName.setBackground(new java.awt.Color(255, 255, 255));
        lastName.setForeground(new java.awt.Color(0, 102, 204));

        buttonGroup1.add(femaleButton);
        femaleButton.setForeground(new java.awt.Color(255, 255, 255));
        femaleButton.setText("Female");
        femaleButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                femaleButtonActionPerformed(evt);
            }
        });

        jLabel4.setBackground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setIcon(new javax.swing.ImageIcon("C:\\Users\\LENOVO\\OneDrive\\Documents\\NetBeansProjects\\Hospital-Management-System\\Images\\background.png")); // NOI18N

        jButton1.setBackground(new java.awt.Color(0, 153, 255));
        jButton1.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Book");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(0, 153, 255));
        jButton2.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Back");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Email: ");

        emailField.setBackground(new java.awt.Color(255, 255, 255));
        emailField.setForeground(new java.awt.Color(0, 102, 204));

        timingField.setBackground(new java.awt.Color(255, 255, 255));
        timingField.setForeground(new java.awt.Color(0, 102, 204));

        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Timings: ");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 419, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 93, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel8)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addComponent(jLabel1)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(firstName, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addComponent(jLabel2)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(lastName))
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(37, 37, 37)
                                    .addComponent(emailField)))
                            .addGap(75, 75, 75)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel11)
                                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(19, 19, 19)
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(ageField, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(doctorField, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(contactField, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addComponent(jLabel12)
                                    .addGap(18, 18, 18)
                                    .addComponent(timingField, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addGap(18, 18, 18)
                        .addComponent(jButton2))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 432, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                            .addComponent(jLabel3)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(maleButton)
                            .addGap(18, 18, 18)
                            .addComponent(femaleButton, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 432, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(81, 81, 81))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(jLabel8)
                .addGap(50, 50, 50)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(firstName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)
                    .addComponent(doctorField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(lastName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12)
                    .addComponent(timingField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(emailField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11)
                    .addComponent(contactField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(maleButton)
                    .addComponent(femaleButton)
                    .addComponent(jLabel3)
                    .addComponent(jLabel5)
                    .addComponent(ageField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void femaleButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_femaleButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_femaleButtonActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String selectedGender=null;
        if(maleButton.isSelected()) {
            selectedGender="Male";
        }
        else if(femaleButton.isSelected()) {
            selectedGender="Female";
        }
        Patients patient = new Patients();
        patient.setFirstName(firstName.getText());
        patient.setLastName(lastName.getText()); 
        patient.setGender(selectedGender);
        patient.setDoctor((String) doctorField.getSelectedItem());
        patient.setContact(contactField.getText()); 
        patient.setAge(Integer.parseInt(ageField.getText())); 
        patient.setAddress(addressField.getText());
        patient.setDescription(diseaseField.getText());
        patient.setEmail(emailField.getText());
        patient.bookAppointment();
    
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
         PatientJFrame PFrame = new PatientJFrame();
         this.dispose();
         PFrame.setName(name);
         PFrame.setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void addressFieldMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addressFieldMouseClicked
       addressField.setText("");
    }//GEN-LAST:event_addressFieldMouseClicked

    private void diseaseFieldMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_diseaseFieldMouseClicked
        diseaseField.setText("");
    }//GEN-LAST:event_diseaseFieldMouseClicked

    private void addressFieldMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addressFieldMouseExited

    }//GEN-LAST:event_addressFieldMouseExited

    private void diseaseFieldMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_diseaseFieldMouseExited
     
    }//GEN-LAST:event_diseaseFieldMouseExited

    private void doctorFieldMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_doctorFieldMouseClicked
        String selectedDoctor = (String) doctorField.getSelectedItem();
        try {
            String dbURL = "jdbc:ucanaccess://C:\\Users\\LENOVO\\OneDrive\\Documents\\NetBeansProjects\\Hospital-Management-System\\HMS.accdb";
            Connection connection = DriverManager.getConnection(dbURL);
            String sql = "SELECT Timings FROM Doctors WHERE Username = ?";
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, selectedDoctor);
            ResultSet rs = stmt.executeQuery();
            
            while (rs.next()) {
                timingField.addItem(rs.getString("Timings"));
            }
            
            rs.close();
            stmt.close();
            connection.close();
        } 
        catch (SQLException ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_doctorFieldMouseClicked

    private void doctorFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_doctorFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_doctorFieldActionPerformed

public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(BookAppointmentJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BookAppointmentJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BookAppointmentJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BookAppointmentJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BookAppointmentJFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea addressField;
    private javax.swing.JTextField ageField;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JTextField contactField;
    private javax.swing.JTextArea diseaseField;
    private javax.swing.JComboBox<String> doctorField;
    private javax.swing.JTextField emailField;
    private javax.swing.JRadioButton femaleButton;
    private javax.swing.JTextField firstName;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField lastName;
    private javax.swing.JRadioButton maleButton;
    private javax.swing.JComboBox<String> timingField;
    // End of variables declaration//GEN-END:variables
}
