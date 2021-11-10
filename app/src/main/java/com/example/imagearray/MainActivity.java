package com.example.imagearray;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText num;
    private ImageView img;
    int[] image = {R.drawable._01,R.drawable.__02,
            R.drawable._04,R.drawable.__03,
            R.drawable._05,R.drawable._06,
            R.drawable._07,R.drawable._08,
            R.drawable._09,R.drawable._10};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        num = (EditText)findViewById(R.id.num);
        img = (ImageView)findViewById(R.id.img);
        num.addTextChangedListener(new TextWatcher() {
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                try {
                    for(int i=0;i<image.length;i++){
                        if((Integer.parseInt(num.getEditableText().toString()))==(i+1)){
                            img.setVisibility(View.VISIBLE);
                            img.setImageResource(image[i]);
                        }
                    }
                    if((Integer.parseInt(num.getEditableText().toString()))==0 || (Integer.parseInt(num.getEditableText().toString()))>10){
                        img.setVisibility(View.INVISIBLE);
                    }
                }
                catch (Exception e){
                    img.setVisibility(View.INVISIBLE);
                }
            }
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }
            @Override
            public void afterTextChanged(Editable s) {
            }
        });
    }
}