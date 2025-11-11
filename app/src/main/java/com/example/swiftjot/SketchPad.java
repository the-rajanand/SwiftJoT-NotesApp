package com.example.swiftjot;

import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import static com.example.swiftjot.SketchView.colorList;
import static com.example.swiftjot.SketchView.currentBrush;
import static com.example.swiftjot.SketchView.pathList;

import androidx.appcompat.app.AppCompatActivity;

public class SketchPad extends AppCompatActivity {

    private SketchView sketchView;

    public static Path path = new Path();
    public static Paint paintBrush = new Paint();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sketch_pad);
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }


        ImageButton redBtn = findViewById(R.id.redColor);
        ImageButton blueBtn = findViewById(R.id.blueColor);
        ImageButton blackBtn = findViewById(R.id.blackColor);
        ImageButton eraser = findViewById(R.id.whiteColor);

        redBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(SketchPad.this, "Red Pen", Toast.LENGTH_SHORT).show();
                paintBrush.setColor(Color.RED);
                currentColor(paintBrush.getColor());
            }
        });

        blueBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(SketchPad.this, "Blue Pen", Toast.LENGTH_SHORT).show();
                paintBrush.setColor(Color.BLUE);
                currentColor(paintBrush.getColor());
            }
        });

        blackBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(SketchPad.this, "Black Pen", Toast.LENGTH_SHORT).show();
                paintBrush.setColor(Color.BLACK);
                currentColor(paintBrush.getColor());
            }
        });

        eraser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(SketchPad.this, "All Clear", Toast.LENGTH_SHORT).show();
                pathList.clear();
                colorList.clear();
                path.reset();
            }
        });
    }
    public void currentColor(int color) {
        currentBrush = color;
        path = new Path();
    }
}