class Patient {
    private String name;
    private String appointment;

    public Patient(String name) {
        this.name = name;
        this.appointment = "";
    }

    public String getName() {
        return name;
    }

    public String bookAppointment() {
        return appointment;
    }

    public void getPrescription(String appointment) {
        this.appointment = appointment;
    }
    public void seeReviews () {
        
    }
    public void searchDoctors () {
        
    }
    public void feedback () {
        
    }
}
