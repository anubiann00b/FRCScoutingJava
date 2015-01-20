package com.saintsrobotics.firebase;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;

public class FRCScouting {

    public static void main(String[] args) throws InterruptedException {
        Firebase myFirebaseRef = new Firebase("https://frc-scouting.firebaseio.com/");

        myFirebaseRef.child("message").setValue("ayyyyyyy");
        myFirebaseRef.child("message").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot snapshot) {
                System.out.println(snapshot.getValue());
                System.exit(0);
            }

            @Override
            public void onCancelled(FirebaseError error) {
            }
        });
        Thread.sleep(10000);
    }
}
