package luis122448.model;

public class EmployeeModel {

    private Integer id;
    private String firstName;
    private String paSurname;
    private String maSurname;
    private String email;
    private Float salary;

    public EmployeeModel() {
    }

    public EmployeeModel(Integer id, String firstName, String paSurname, String maSurname, String email, Float salary) {
        this.id = id;
        this.firstName = firstName;
        this.paSurname = paSurname;
        this.maSurname = maSurname;
        this.email = email;
        this.salary = salary;
    }

    public Integer getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getPaSurname() {
        return paSurname;
    }

    public String getMaSurname() {
        return maSurname;
    }

    public String getEmail() {
        return email;
    }

    public Float getSalary() {
        return salary;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setPaSurname(String paSurname) {
        this.paSurname = paSurname;
    }

    public void setMaSurname(String maSurname) {
        this.maSurname = maSurname;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setSalary(Float salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "EmployeeModel{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", paSurname='" + paSurname + '\'' +
                ", maSurname='" + maSurname + '\'' +
                ", email='" + email + '\'' +
                ", salary=" + salary +
                '}';
    }
}
