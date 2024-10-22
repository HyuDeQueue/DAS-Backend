package com.project.DASBackend.dto;

import java.io.Serializable;

/*
This class is required for storing the username and password we recieve from the client.
* */
public class JwtRequest implements Serializable {

    private static final long serialVersionUID = 5926468583005150707L;

    private String uid;


    //need default constructor for JSON Parsing
    public JwtRequest()
    {

    }

    public JwtRequest(String uid) {
        this.setUid(uid);

    }

    public String getUid() {
        return this.uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }


}
