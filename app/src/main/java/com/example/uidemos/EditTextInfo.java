package com.example.uidemos;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.widget.EditText;

import java.io.Serializable;

/**
 * Created by frederik290 on 20/04/2017.
 * This class will hold info from the editText views from activity_edit_text
 */

public class EditTextInfo implements Serializable {
    private String plainText;
    private String password;
    private String email;
    private int number;


    public EditTextInfo(Activity activity){
        EditText editPlain = (EditText) activity.findViewById(R.id.edit_plainText);
        EditText editPassword = (EditText) activity.findViewById(R.id.edit_password);
        EditText editEmail = (EditText) activity.findViewById(R.id.edit_email);
        EditText editNumber = (EditText) activity.findViewById(R.id.edit_number);

        plainText = editPlain.getText().toString();
        password = editPassword.getText().toString();
        email = editEmail.getText().toString();

        try{
            number = Integer.parseInt(editNumber.getText().toString());
        }catch (Exception e){
            // handle it...
            e.printStackTrace();
        }
    }

    @Override
    public String toString(){
        return "Plain-Text: " + plainText + "\n" +
                "Password: " +  getPassRepresentation() + "\n" +
                "Email: " + email + "\n" +
                "Number: " + number;
    }

    private String getPassRepresentation(){
        if(password != ""){
            int length = password.length();
            String rep = password.substring(0,1);
            return rep += String.format("%0" + (length-1) + "d", 0).replace("0","*");
        } else {
            return password;
        }
    }

    public String getPlainText(){
        return plainText;
    }

    public String getPassword(){
        return password;
    }

    public String getEmail(){
        return email;
    }

    public int getNumber(){
        return number;
    }

}
