public class Student {
    private String name;
    private int age;
    private int gender;
    private String address;
    private Double grade;
    private String code;
    static int count = 0;

    // Constructor
    public Student (String code, String name, int age, int gender, String address, Double grade) {
        this.code = code;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.address = address;
        this.grade = grade;
        count ++;
    }



    // Getters and Setters
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return this.age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getGender() {
        return this.gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Double getGrade() {
        return this.grade;
    }

    public void setGrade(Double grade) {
        this.grade = grade;
    }

    public String getCode() {
        return this.code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    // Method to convert student details to a string

    public String toString() {
        return String.format(
                "\nStudent code: %s\nStudent name: %s\nStudent age: %d\nStudent gender: %s\nStudent address: %s\nStudent grade: %.2f\n",
                this.code, this.name, this.age, this.gender, this.address, this.grade);
    }
}
