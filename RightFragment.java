package edu.mnstate.mg0483fp.lollogin;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

public class RightFragment extends Fragment {
    private final static String TAG = "RightFragment";
    EditText username_text;
    EditText password_text;
    EditText confirm_dialog;
    MyDBHandler myDB;

    RightFragment activityCommander;
    public interface RightFragmentListener{
        public void createMeme();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_right, container, false);


        username_text = (EditText) view.findViewById(R.id.username_text);
        password_text = (EditText) view.findViewById(R.id.password_text);

        final Button forgot_button = (Button)view.findViewById(R.id.forgot_button);
        forgot_button.setOnClickListener(
                new View.OnClickListener(){
                    public void onClick(View view){
                        handleForgotButton(view);
                    }
                }
        );

        final Button submit_button = (Button)view.findViewById(R.id.sign_button);
        submit_button.setOnClickListener(
                new View.OnClickListener(){
                    public void onClick(View view){
                        buttonClicked(view);
                    }
                }
        );

        myDB = new MyDBHandler(getActivity(),null,null,1);

        return view;
    }

    public void buttonClicked(View view){
        String username;
        String password;
        boolean checkFlag = false;
        username = username_text.getText().toString();
        password = password_text.getText().toString();

        if(TextUtils.isEmpty(username)){
            username_text.setError("type username");
            return;
        }
        if(TextUtils.isEmpty(password)) {
            password_text.setError("type password");
            return;
        }
        Log.i(TAG, "##########################user name = " + username + " password = " + password);

        User user = new User(username, password);
        checkFlag = myDB.checkUser(user);

        if(checkFlag == true){
            Intent intent = new Intent(getActivity(), DashActivity.class);
            startActivity(intent);
            username_text.setText(null);
            password_text.setText(null);


        }





    }

    public void handleForgotButton(View view){
        LayoutInflater li = LayoutInflater.from(getContext());
        View getInfoView = li.inflate(R.layout.user_dialog, null);
        AlertDialog.Builder alertDlgbld = new AlertDialog.Builder(getContext());
        alertDlgbld.setView(getInfoView);

        final AlertDialog alertDialog = alertDlgbld.create();
        alertDialog.setButton(AlertDialog.BUTTON_POSITIVE, "OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        //get references to dialog
                        EditText username_dialog = (EditText) alertDialog.findViewById(R.id.username_dialog);
                        EditText password_dialog = (EditText) alertDialog.findViewById(R.id.password_dialog);
                        EditText confirm_dialog = (EditText) alertDialog.findViewById(R.id.confirm_dialog);

                        String userName = username_dialog.getText().toString();
                        String passWord = password_dialog.getText().toString();
                        String confirm = confirm_dialog.getText().toString();

                        if(TextUtils.isEmpty(userName)){
                            username_dialog.setError("type username");
                            return;
                        }
                        if(TextUtils.isEmpty(passWord)) {
                            password_dialog.setError("type password");
                            return;
                        }

                        if(confirm.equals(passWord)){
                            User user = new User(userName, passWord);
                            myDB.addUser(user);
                        }
                        else{
                            confirm_dialog.setError("password does not match!");
                            return;
                        }

                    }
        });
        alertDialog.setButton(AlertDialog.BUTTON_NEGATIVE, "CANCEL", new DialogInterface.OnClickListener(){
            @Override
            public void onClick(DialogInterface dialogInterface, int i){alertDialog.dismiss();}
        });
        alertDialog.show();

    }
}
