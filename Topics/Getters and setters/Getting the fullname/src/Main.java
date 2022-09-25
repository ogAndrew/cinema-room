class User {
    private String firstName;
    private String lastName;

    public User() {
        this.firstName = "";
        this.lastName = "";
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setFirstName(String firstName) {
        if (firstName != null && !firstName.isEmpty()) {
            this.firstName = firstName;
        }
    }

    public void setLastName(String lastName) {
        if (lastName != null && !lastName.isEmpty()) {
            this.lastName = lastName;
        }
    }

    public String getFullName() {
        if (!this.isValid(this.firstName) && !this.isValid(this.lastName)) return "Unknown";
        if (this.isValid(this.firstName) && !this.isValid(this.lastName)) return this.firstName;
        if (this.isValid(this.lastName) && !this.isValid(this.firstName)) return this.lastName;

        return String.format("%s %s", this.firstName, this.lastName);
    }

    private boolean isValid(String str) {
        if (str == null || str.isEmpty()) {
            return false;
        }
        return true;
    }
}