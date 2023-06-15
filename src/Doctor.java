class Doctor {
    private String name;
    private String appointment;

    public Doctor(String name) {
        this.name = name;
        this.appointment = "";
    }

    public String getName() {
        return name;
    }

    public String getAppointment() {
        return appointment;
    }

    public void changeAppointment(String appointment) {
        this.appointment = appointment;
    }
    public void viewAppointment(String appointment) {
        this.appointment = appointment;
    }
    public void managePrescription(String appointment) {
        this.appointment = appointment;
    }
    public void searchPatients () {
        
    }
}