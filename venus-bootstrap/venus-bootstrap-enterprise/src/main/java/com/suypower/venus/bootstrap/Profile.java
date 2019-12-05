package com.suypower.venus.bootstrap;

public enum Profile {

    Dev("dev"),

    Test("test"),

    Sim("sim"),

    Prod("prod");

    private String name;

    Profile(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static Profile parse(String name){
        if(Dev.getName().equals(name)){
            return Dev;
        }
        else if(Test.getName().equals(name)){
            return Test;
        }
        else if(Prod.getName().equals(name)){
            return Prod;
        }
        else if(Sim.getName().equals(name)){
            return Sim;
        }
        return null;
    }
}
