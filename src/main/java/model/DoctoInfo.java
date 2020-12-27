package model;

public class DoctoInfo extends DoctorModel {
    private String  reward ;
    private String experience;

    public DoctoInfo(long id, String name, boolean gender, String nationality, String address, String phone, String education, String position, String specialized, String hospital, String reward, String experience) {
        super(id, name, gender, nationality, address, phone, education, position, specialized, hospital);
        this.reward = reward;
        this.experience = experience;
    }

    public DoctoInfo() {

    }

    public String getReward() {
        return reward;
    }

    public void setReward(String reward) {
        this.reward = reward;
    }

    public String getExperience() {
        return experience;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }
}
