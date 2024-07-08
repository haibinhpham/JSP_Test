/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Core;

import java.util.ArrayList;

/**
 *
 * @author ad
 */
public class City {

    //declare variables, cityname, list<InhabitantImp> listInhabitants
    private String cityName;
    private ArrayList<Inhabitant> listInhabitants;
    
    //default constructor
    public City(){
    }
    
    //constructor
    public City(String cityName, ArrayList<Inhabitant> listInhabitants){
        this.cityName = cityName;
        this.listInhabitants = listInhabitants;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public void setListInhabitants(ArrayList<Inhabitant> listInhabitants) {
        this.listInhabitants = listInhabitants;
    }
    
    

    //override searchLocal throws remote exception -type InhabitantImp
    public Inhabitant searchLocal(String name){
        for (Inhabitant local : listInhabitants) {
            if (local.getName().equals(name)) {
                return local;
            }
        }
        return null;
    }

    public Inhabitant addInhabitant(String name, String dob, String married){
        Inhabitant local = new Inhabitant(name, dob, married);
        if (local != null && !listInhabitants.contains(local)) {
            listInhabitants.add(local);
        }
        return null;
    }

    public String getCityName() {
        return cityName;
    }

    public ArrayList<Inhabitant> getListInhabitants() {
        return listInhabitants;
    }

    //override searchMaritial(name)
    public String searchMaritial(String name) {
        for (Inhabitant local : listInhabitants) {
            if (local.getName().equals(name)) {
                return name + "'s maritial status is: " + local.getMarried();
            }
        }
        return "person not found";
    }

    //  getAllDob
    public ArrayList<String> getAllDob()  {
        ArrayList<String> listdob = new ArrayList<>();
        for (Inhabitant local : listInhabitants) {
            listdob.add(local.getDob());
        }
        return listdob;
    }
    // getAllName
    public ArrayList<String> getAllName(){
        ArrayList<String> listname = new ArrayList<>();
        for(Inhabitant local : listInhabitants){
            listname.add(local.getName());
        }
        return listname;
    }
    //override getall status
    public ArrayList<String> getAllMaritial() {
        ArrayList<String> listmarried = new ArrayList<>();
        for(Inhabitant local : listInhabitants){
            listmarried.add(local.getMarried());
        }
        return listmarried;
    }
}
