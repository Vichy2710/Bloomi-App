package com.example.bloomi;

public class uses_manage {
    //thong tin lien quan den user
    String email,phone;
    int id;
    Boolean activeFlag,deleteFlag;
    String creatDate;
    String firstName,lastName,gender,birthday,avatarUrl;
    String coverImageUrl,address,authProvider;
    public uses_manage(String email, String phone, int id, Boolean activeFlag, Boolean deleteFlag, String firstName, String lastName, String gender, String birthday, String avatarUrl, String coverImageUrl, String address, String authProvider) {
        this.email = email;
        this.phone = phone;
        this.id = id;
        this.activeFlag = activeFlag;
        this.deleteFlag = deleteFlag;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.birthday = birthday;
        this.avatarUrl = avatarUrl;
        this.coverImageUrl = coverImageUrl;
        this.address = address;
        this.authProvider = authProvider;
    }

    public uses_manage( int id, Boolean activeFlag, Boolean deleteFlag, String creatDate,String email,String phone, String firstName, String lastName, String gender, String birthday, String avatarUrl, String coverImageUrl, String address, String authProvider) {
        this.email = email;
        this.phone = phone;
        this.id = id;
        this.activeFlag = activeFlag;
        this.deleteFlag = deleteFlag;
        this.creatDate = creatDate;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.birthday = birthday;
        this.avatarUrl = avatarUrl;
        this.coverImageUrl = coverImageUrl;
        this.address = address;
        this.authProvider = authProvider;
    }

    @Override
    public String toString() {
        return "uses_manage{" +
                "email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", id=" + id +
                ", activeFlag=" + activeFlag +
                ", deleteFlag=" + deleteFlag +
                ", creatDate='" + creatDate + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", gender='" + gender + '\'' +
                ", birthday='" + birthday + '\'' +
                ", avatarUrl='" + avatarUrl + '\'' +
                ", coverImageUrl='" + coverImageUrl + '\'' +
                ", address='" + address + '\'' +
                ", authProvider='" + authProvider + '\'' +
                '}';
    }
}
