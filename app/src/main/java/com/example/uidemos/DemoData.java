package com.example.uidemos;

public class DemoData {
    private String name;
    private String action;
    private int requestCode;

    public DemoData(String name, String action, int requestCode){
        this.name = name;
        this.action = action;
        this.requestCode = requestCode;
    }

    @Override
    public String toString(){
        return name;
    }

    public String getAction(){
        return action;
    }

    public int getRequestCode() {return requestCode;}
}
