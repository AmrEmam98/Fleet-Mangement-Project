package com.example.fleetmanagementsystem.loginFunctionality.viewModels;

import androidx.lifecycle.ViewModel;

import com.google.firebase.auth.FirebaseAuth;

import io.reactivex.subjects.BehaviorSubject;

import static com.example.fleetmanagementsystem.loginFunctionality.ResponseConstants.LoginObserverResponse.*;
import static com.example.fleetmanagementsystem.loginFunctionality.ResponseConstants.LoginObserverResponse.SUCCESS_RESPONSE;


public class LoginViewModel extends ViewModel {
    public BehaviorSubject<String>loginSubject=BehaviorSubject.create();
    public void doLogin(String email,String password){
        FirebaseAuth firebaseAuth=FirebaseAuth.getInstance();
        firebaseAuth.signInWithEmailAndPassword(email,password)
                .addOnSuccessListener(authResult->{
                    loginSubject.onNext(SUCCESS_RESPONSE);
                })
                .addOnFailureListener(e->{
                    loginSubject.onNext(e.getMessage());
                });
    }
}
