package umerlab.com.higherorlower;

// A project developed by Dr. Faheem Chishti
// on 28Feb. 2019

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    // This gives a random integer between 1 (inclusive) and 20 (exclusive)
    int min = 1;
    int max = 20;
    int randomNumber = new Random().nextInt((max - min) + 1) + min;

    public void OnClickGuess(View vW) {

        EditText enteredNumber = (EditText) findViewById(R.id.edtNumber);
        if(enteredNumber.getText().toString().isEmpty()){
            Toast.makeText(this, "Please enter a number!", Toast.LENGTH_LONG).show();
        }else{
            // Now convert it into a string
            String enteredNumberInString = enteredNumber.getText().toString();
            // Now convert it into an int variable type
            int enteredNumberInInt = Integer.parseInt(enteredNumberInString);

            if (enteredNumberInInt == randomNumber) {
                // Now show the Result in a TextView field
                TextView resultView = (TextView) findViewById(R.id.txtResult);
                resultView.setText("Wel done! You guessed right.");
            } else if (enteredNumberInInt < randomNumber) {
                TextView resultView = (TextView) findViewById(R.id.txtResult);
                resultView.setText("You are a bit below, go higher.");
            } else {
                TextView resultView = (TextView) findViewById(R.id.txtResult);
                resultView.setText("You are a bit above, go lower.");
            }
        }

    }

    public void onClickReset(View Vw) {
        randomNumber = new Random().nextInt((max - min) + 1) + min;
        TextView resultView = (TextView) findViewById(R.id.txtResult);
        resultView.setText("");
        EditText enteredNumber = (EditText) findViewById(R.id.edtNumber);
        enteredNumber.setText(null);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
