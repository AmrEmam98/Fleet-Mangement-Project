package com.example.fleetmanagementsystem.carsFunctionality.pojo;
import com.google.firebase.firestore.DocumentSnapshot;
public class CarModel {

    public String name,imageUrl,model2;
    int model , image;

    public CarModel() {
    }

    public  CarModel(DocumentSnapshot documentSnapshot)
    {
        this.name=documentSnapshot.get("name").toString();
        this.model2=documentSnapshot.get("model").toString();
        this.imageUrl=documentSnapshot.get("image").toString();

    }
     public CarModel(String name, int model, int image) {
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
