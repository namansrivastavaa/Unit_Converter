package com.naman.unitconverter;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import org.w3c.dom.Text;

import java.util.Timer;
import java.util.TimerTask;

public class MainScreen extends AppCompatActivity {
    EditText dollarValue;
    TextView result;
    Button getResultButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main_screen);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        dollarValue = findViewById(R.id.UnitDollar); // Should be an EditText
        result = findViewById(R.id.ConvertedValueText);
        getResultButton = findViewById(R.id.resultButton);

        getResultButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    String input = dollarValue.getText().toString().trim();
                    if (input.isEmpty()) {
                        result.setText("Please enter a valid number!");
                        return;
                    }
                    double dollar = Double.parseDouble(input); // Allow decimal values
                    result.setText("Converted Value is: " + String.format("%.2f", 87.34 * dollar));
                } catch (NumberFormatException e) {
                    result.setText("Invalid input! Please enter a number.");
                }
            }
        });
    }
}