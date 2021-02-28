package com.example.final_hack;

public class userhelper {

    public userhelper()
    {}

    public userhelper(String name, String id, String hash, String dob,String i) {
        this.name = name;
        this.id = id;
        this.hash = hash;
        this.dob = dob;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    /*public userhelper(String name, String device,String imgname,String uri,String gender,String age) {
        this.name = name;
        this.device = device;
        if(imgname.trim().equals(""))
        {
            imgname= "No name";
        }

        this.imgname=imgname;
        this.uri=uri;
        this.gender=gender;
        this.age=age;
    }*/

    String name,id,hash,dob;
    String i;


}
