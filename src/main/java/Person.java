class Person {

    private String firstName = null;
    private String middleName = null;
    private String lastName = null;

    Person(String firstName, String middleName, String lastName) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
    }

    String getFirstName() {
        return firstName;
    }

    String getMiddleName() {
        return middleName;
    }

    String getLastName() {
        return lastName;
    }
}
