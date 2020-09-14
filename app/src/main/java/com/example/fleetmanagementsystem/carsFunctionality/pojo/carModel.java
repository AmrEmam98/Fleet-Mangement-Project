package com.example.fleetmanagementsystem.carsFunctionality.pojo;

 public class carModel {

    String name;
    int model , image;

     public carModel(String name, int model, int image) {
         this.name = name;
         this.model = model;
         this.image = image;
     }


     public String getName() {
         return name;
     }

     public void setName(String name) {
         this.name = name;
     }

     public int getModel() {
         return model;
     }

     public void setModel(int model) {
         this.model = model;
     }

     public int getImage() {
         return image;
     }

     public void setImage(int image) {
         this.image = image;
     }
 }
