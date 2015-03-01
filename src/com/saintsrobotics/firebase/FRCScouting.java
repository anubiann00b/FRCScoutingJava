package com.saintsrobotics.firebase;

import com.firebase.client.AuthData;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.Firebase.AuthResultHandler;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;
import org.json.JSONObject;

public class FRCScouting {

    public static void main(String[] args) throws InterruptedException {
        Firebase root = new Firebase("https://frc-scouting.firebaseio.com/");
        
        root.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot ds) {
                Log.d("Data recieved.");
                JSONObject obj = new JSONObject(ds.toString().substring(13).replace('=', ':')).getJSONObject("value");
                Log.d(obj.toString(2));
            }

            @Override
            public void onCancelled(FirebaseError fe) {
                Log.e(fe.toString());
            }
        });
        root.authAnonymously(new AuthResultHandler() {
            @Override
            public void onAuthenticated(AuthData authData) {
                Log.d(authData.toString());
            }

            @Override
            public void onAuthenticationError(FirebaseError error) {
                Log.e(error.toString());
            }
        });
        while(true) Thread.sleep(5000);
    }
}

class Log {
    
    public static void d(String str) {
        System.out.println(str);
    }
    
    public static void e(String str) {
        System.out.println(str);
    }
}