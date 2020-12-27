package model;

public class DoctorModel {
    private long id;
    private String name;
    private boolean gender;
    private String nationality;
    private String address;
    private String phone;
    private String education;
    private String position;
    private String specialized;
    private String hospital;

    public DoctorModel(long id, String name, boolean gender, String nationality, String address, String phone, String education, String position, String specialized, String hospital) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.nationality = nationality;
        this.address = address;
        this.phone = phone;
        this.education = education;
        this.position = position;
        this.specialized = specialized;
        this.hospital = hospital;
    }

    public DoctorModel(long id, String name, String gender, String nationality, String address, String phone, String education, String position, String hospital) {
    }

    public DoctorModel() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getSpecialized() {
        return specialized;
    }

    public void setSpecialized(String specialized) {
        this.specialized = specialized;
    }

    public String getHospital() {
        return hospital;
    }

    public void setHospital(String hospital) {
        this.hospital = hospital;
    }
}
