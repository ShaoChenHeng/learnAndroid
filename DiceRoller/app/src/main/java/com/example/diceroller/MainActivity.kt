package com.example.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollButton: Button = findViewById(R.id.button)
        rollButton.setOnClickListener {
            // val toast = Toast.makeText(this, "Dice Rolled!", Toast.LENGTH_SHORT)
            // toast.show()
            // as same as: Toast.makeText(this, "Dice Rolled!", Toast.LENGTH_SHORT).show()

            // val resultTextView: TextView = findViewById(R.id.textView)
            // resultTextView.text = "6"
            rollDice()
        }
        // Do a dice roll when the app starts
        rollDice()
    }

    private fun rollDice() {
        val dice = Dice(6)
        val diceRoll = dice.roll()

        // random number
        val resultTextView: TextView = findViewById(R.id.textView)
        resultTextView.text = diceRoll.toString()

        // random pic
        // Find the ImageView in the layout
        val diceImage: ImageView = findViewById(R.id.imageView)

        /*when (diceRoll) {
            1 -> diceImage.setImageResource(R.drawable.pic1)
            2 -> diceImage.setImageResource(R.drawable.pic2)
            3 -> diceImage.setImageResource(R.drawable.pic3)
            4 -> diceImage.setImageResource(R.drawable.pic4)
            5 -> diceImage.setImageResource(R.drawable.pic5)
            6 -> diceImage.setImageResource(R.drawable.pic6)
        }*/

        // Determine which drawable resource ID to use based on the dice roll
        val drawableResource = when (diceRoll) {
            1 -> R.drawable.pic1
            2 -> R.drawable.pic2
            3 -> R.drawable.pic3
            4 -> R.drawable.pic4
            5 -> R.drawable.pic5
            else -> R.drawable.pic6
        }

        // Update the ImageView with the correct drawable resource ID
        diceImage.setImageResource(drawableResource)
        // Update the content description
        diceImage.contentDescription = diceRoll.toString()
    }

    class Dice(val numSides: Int) {
        fun roll(): Int {
            return (1..numSides).random()
        }
    }
}
