public class PersonBuilder {

    private String name;
    private String surname;
    private int age;
    private String address;

    public PersonBuilder setName(String name) {
        this.name = name;
        return this;
    }
    public PersonBuilder setSurname(String surname) {
        this.surname = surname;
        return this;
    }
    public PersonBuilder setAge(int age) {
        this.age = age;
        return this;
    }
    public PersonBuilder setAddress(String address) {
        this.address = address;
        return this;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public int getAge() {
        return age;
    }

    public String getAddress() {
        return address;
    }

    public Person build() throws IllegalArgumentException, IllegalStateException {
        if (this.age < 0) {
            throw new IllegalArgumentException("Illegal age!");
        }
        if (this.name == null) {
            throw new IllegalStateException("Person without name!");
        }
        if (this.surname == null) {
            throw new IllegalStateException("Person without surname!");
        }
        return new Person(this);
    }
}
