import java.util.OptionalInt;

public class Person {

    protected final String name;
    protected final String surname;
    protected int age;
    protected String address;

    public Person(String name, String surname) {
        this.name = name;
        this.surname = surname;
        this.age = -1;
    }

    public Person(String name, String surname, int age) throws IllegalArgumentException {
        this.name = name;
        this.surname = surname;
        if (age < 0) {
            throw new IllegalArgumentException();
        }
        this.age = age;
    }

    public Person(String name, String surname, int age, String city) throws IllegalArgumentException {
        this.name = name;
        this.surname = surname;
        if (age < 0) {
            throw new IllegalArgumentException();
        }
        this.age = age;
        this.address = city;
    }

    public Person(PersonBuilder personBuilder) {
        this.name = personBuilder.getName();
        this.surname = personBuilder.getSurname();
        this.age = personBuilder.getAge();
        this.address = personBuilder.getAddress();
    }

    public boolean hasAge() {
        if (age >= 0) {
            return true;
        }
        return false;
    }
    public boolean hasAddress() {
        if (address == null) {
            return false;
        }
        return true;
    }

    public String getName() {
        return this.name;
    }
    public String getSurname() {
        return this.surname;
    }
    public OptionalInt getAge() {
        if (this.age == -1) {
            return OptionalInt.empty();
        }
        return OptionalInt.of(this.age);
    }
    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    public void happyBirthday() {
        if (age >= 0) {
            this.age++;
        }
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder(name + " " + surname);
        if (this.hasAge()) {
            str.append(", " + age + " y.o.");
        }
        if (this.hasAddress()) {
            str.append(", living at " + address);
        }
        return new String(str);
    }

    @Override
    public int hashCode() {
        int ageHashCode = this.hasAge() ? age * 31 : 0;
        return name.hashCode() +
                surname.hashCode() +
                address.hashCode() +
                ageHashCode;

    }

    public PersonBuilder newChildBuilder() {
        PersonBuilder child = new PersonBuilder();
        child.setSurname(this.surname);
        child.setAge(0);
        child.setAddress(this.address);
        return child;
    }
}
