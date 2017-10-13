package com.example.justjava;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

// This app display an order form for coffee.
public class MainActivity extends AppCompatActivity {
    int numberOfCoffees = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    /**
     * This method is called when the order button is clicked.
     */

    public void submitOrder(View view) {
        String priceMessage = "Total: $" + (numberOfCoffees * 5);
        displayMessage(priceMessage);
        display(numberOfCoffees);
    }

    public void addQuantity(View view){
        display(numberOfCoffees = numberOfCoffees + 1);
    }

    public void minusQuantity(View view){
        numberOfCoffees = numberOfCoffees - 1;
        if (numberOfCoffees <= 0) {
            numberOfCoffees = 0;
        }
        display(numberOfCoffees);
    }


    /**
     * This method displays the given quantity value on the screen.
     */

    private void display(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_int);
        quantityTextView.setText("" + number);
    }

    private void displayMessage( String priceMessage) {
        TextView priceTextView = (TextView) findViewById(R.id.price_text_view);
        priceTextView.setText(priceMessage);
    }
}

