/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Core;

/**
 *
 * @author ad
 */
public class Inhabitant {
    private String name;
    private String dob;
    private String married;

    //default constructor
    public Inhabitant(){}
    
    public Inhabitant(String name, String dob, String married) {
        this.name = name;
        this.dob = dob;
        this.married = married;
    }

    public String getName() {
        return name;
    }

    public String getDob() {
        return dob;
    }

    public String getMarried() {
        return married;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public void setMarried(String married) {
        this.married = married;
    }
    
    
    
}
