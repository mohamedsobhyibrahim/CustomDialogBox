package com.mohamedsobhy.customdialogbox;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button button1;
    private Button button2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                customDialog("Dialog Box 1 " , "This is Dialog Box 1" , "cancelMethod1" , "okMethod1");
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                customDialog("Dialog Box 2 " , "This is Dialog Box 2" , "cancelMethod2" , "okMethod2");

            }
        });
    }

    private void cancelMethod1(){
        toastMessage("Cancel method 1");
    }

    private void cancelMethod2(){
        toastMessage("Cancel method 2");
    }

    private void okMethod1(){
        toastMessage("OK method 1");
    }

    private void okMethod2(){
        toastMessage("OK method 2");
    }

    private void toastMessage(String message){
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    public void customDialog(String title , String message , final String cancelMethod , final String okMethod){

        final AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setIcon(R.mipmap.ic_launcher);
        builder.setTitle(title);
        builder.setMessage(message);

        builder.setNegativeButton(
                "Cancel",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        if (cancelMethod.equals("cancelMethod1")){
                            cancelMethod1();
                        }

                        else if (cancelMethod.equals("cancelMethod2")){
                            cancelMethod2();
                        }
                    }
                });

        builder.setPositiveButton(
                "Ok",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        if (okMethod.equals("okMethod1")){
                            okMethod1();
                        }

                        else if (okMethod.equals("okMethod2")){
                            okMethod2();
                        }
                    }
                });

        builder.show();
    }
}