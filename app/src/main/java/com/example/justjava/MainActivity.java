package com.example.justjava;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
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
        String priceMessage = calculatePrice() + " \n" + "Thank you!";
        String order = createOrderSummary("Kim", numberOfCoffees, priceMessage);
        TextView orderTextView = (TextView) findViewById(R.id.order_text_view);
        orderTextView.setText(order);
    }

    public void addQuantity(View view) {
        display(numberOfCoffees = numberOfCoffees + 1);
    }

    public void minusQuantity(View view) {
        numberOfCoffees = numberOfCoffees - 1;
        if (numberOfCoffees <= 0) {
            numberOfCoffees = 0;
        }
        display(numberOfCoffees);
    }

    /**
     * Order coffees with type and price included.
     *
     * @return total price
     */

    private int calculatePrice() {
        return numberOfCoffees * 5;
    }

    private void display(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_int);
        quantityTextView.setText("" + number);
    }


    private String createOrderSummary(String name, int coffees, String total) {
        boolean checked = ((CheckBox) findViewById(R.id.whipped_cream)).isChecked();
        if (checked == true) {
            return "Name:" + name + "\nQuantity:" + coffees + "\nWhipped Cream: Yes " + "\nTotal: $" + total;
        } else {
            return "Name:" + name + "\nQuantity:" + coffees + "\nWhipped Cream: No " + "\nTotal: $" + total;
        }
    }
}
