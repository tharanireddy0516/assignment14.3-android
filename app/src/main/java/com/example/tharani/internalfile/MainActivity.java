package com.example.tharani.internalfile;
/*import is libraries imported for writing the code
* AppCompatActivity is base class for activities
* Bundle handles the orientation of the activity
*/
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
/*onCreate is the first method in the life cycle of an activity
     savedInstance passes data to super class,data is pull to store state of application
   * setContentView is used to set layout for the activity
   *R is a resource and it is auto generate file
   * activity_main assign an integer value*/
public class MainActivity extends AppCompatActivity {
    //declaring variables
    EditText editText;
    Button save_button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText= findViewById(R.id.editText);
        save_button= findViewById(R.id.save_file);
        //setting the save button
        save_button.setOnClickListener(new View.OnClickListener() {//here we are creating the onclick method
            @Override
            public void onClick(View view) {
                try {//The try block contains set of statements where an exception can occur,A try block is always followed by a catch block
                    //creating the object of file out put stream
                    //for writing the file
                    /* taking FileOutputStream
                   *FileOutputStream used to create a file and write data into it */
                    FileOutputStream fileOutputStream=openFileOutput("myFile.txt",MODE_PRIVATE);
                    //creating object OutputStreamWriter
                    OutputStreamWriter outputStreamWriter=new OutputStreamWriter(fileOutputStream);
                    //using get method giving reference to editText getting the data as a string
                    outputStreamWriter.write(editText.getText().toString());
                    //closing the outputStreamWriter
                    outputStreamWriter.close();
                    //display file saved message
                    Toast.makeText(getBaseContext(), "File saved successfully!",
                            Toast.LENGTH_LONG).show();
                     /*A toast is a view containing a quick little message for the user.
                * LENGTH_LONG  display toast message in long period of time*/
                } catch (java.io.IOException e) {//catches the IOException which is compile time exception
                    e.printStackTrace();//printStackTrace used to print the description of exception
                }
            }
        });
        //setting the check button
        Button check_button=findViewById(R.id.check_file);
        check_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //finding the path of the file,gets Files directory using get method
                String path =getFilesDir().getAbsolutePath()+"/myFile.txt";
                //creating the object of the file using new
                File file=new File(path);
                //Applying condition to check the file is exist or not
                if (file.exists()){//if statement decides whether file exists or not
                    // Toast File is exists
                    Toast.makeText(getBaseContext(), "File Exist!!",
                            Toast.LENGTH_LONG).show();
                    /*A toast is a view containing a quick little message for the user.
                * LENGTH_LONG  display toast message in long period of time*/
                }
                else {//else is used when the statement in if statement is false
                    // Toast File is not exists
                    Toast.makeText(MainActivity.this, "File not exist !!", Toast.LENGTH_LONG).show();
                   /*A toast is a view containing a quick little message for the user.
                * LENGTH_LONG display toast message in long period of time*/
                }
            }
        });

    }
}

