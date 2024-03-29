package com.miniProject.subway.member.model.dto;

public class MemberDTO implements  java.io.Serializable {

    private String id;
    private String pwd;
    private String name;
    private String email;
    private String phone;
    private int point;

    public MemberDTO (){
        // 기본생성자
    }

    public MemberDTO (String id, String pwd, String name, String email, String phone){
        this.id = id;
        this.pwd = pwd;
        this.name = name;
        this.email = email;
        this.phone = phone;
    }

    public String getid() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    public void getString(){
        System.out.println("id : " + this.id + "\n" +
                "pwd : " + this.pwd + "\n" +
                "name : " + this.name + "\n" +
                "email : " + this.email + "\n" +
                "phone : " + this.phone + "\n" +
                "point : " + this.point);
    }

    @Override
    public String toString() {
        return "id='" + id + '\'' +
                "| 비밀번호='" + pwd + '\'' +
                "| 이름='" + name + '\'' +
                "| email='" + email + '\'' +
                "| 연락처='" + phone + '\'' +
                "| 현재 보유중인 포인트=" + point;
    }
}
