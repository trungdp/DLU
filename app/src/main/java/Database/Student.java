package Database;


public class Student {
    private String id;
    private String name;
    private String email;
    private String address;
    private int years;
    private String password;

    public Student(){ }

    public Student(String id, String name, String email, String address, int years, String password) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.address = address;
        this.years = years;
        this.password = password;
    }

    public Student(String name, String email, String address, int years) {
        this.name = name;
        this.email = email;
        this.address = address;
        this.years = years;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setYears(int years) {
        this.years = years;
    }

    public void setPassword(String password) { this.password = password; }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getAddress() {
        return address;
    }

    public int getYears() {
        return years;
    }

    public String getPassword() { return password; }
}