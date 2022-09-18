package com.ekinma99.my_wordle

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val input = findViewById<EditText>(R.id.editText)
        val result = findViewById<Button>(R.id.button)
        val reset = findViewById<Button>(R.id.resetBtn)
        var counter = 0
        var inputDisplay1 = findViewById<TextView>(R.id.guessValue1)
        var inputDisplay2 = findViewById<TextView>(R.id.guessValue2)
        var inputDisplay3 = findViewById<TextView>(R.id.guessValue3)
        val guessOne = findViewById<TextView>(R.id.guess1)
        val guessTwo = findViewById<TextView>(R.id.guess2)
        val guessThree = findViewById<TextView>(R.id.guess3)
        val guessCheckOne = findViewById<TextView>(R.id.guessCheck1)
        val guessCheckTwo = findViewById<TextView>(R.id.guessCheck2)
        val guessCheckThree = findViewById<TextView>(R.id.guessCheck3)
        var correct_answer = findViewById<TextView>(R.id.answer)
        var checkedValue1 = findViewById<TextView>(R.id.guessCheckValue1)
        var checkedValue2 = findViewById<TextView>(R.id.guessCheckValue2)
        var checkedValue3 = findViewById<TextView>(R.id.guessCheckValue3)

        var wordleWord = FourLetterWordList.getRandomFourLetterWord()
        fun checkGuess(guess: String, wordToGuess: String): String {
            var result = ""
            for (i in 0..3) {
                if (guess[i] == wordToGuess[i]) {
                    result += "O"
                } else if (guess[i] in wordToGuess) {
                    result += "+"
                } else {
                    result += "X"
                }
            }
            return result
        }
        fun clearData(){

        }
            result.setOnClickListener {
                counter++
                if (counter == 1) {
                    guessOne.visibility = View.VISIBLE // guess # 1
                    guessOne.text
                    inputDisplay1.visibility = View.VISIBLE
                    inputDisplay1.text = input.getText().toString() // user guess
                    guessCheckOne.visibility = View.VISIBLE
                    guessCheckOne.text
                    val guessChecked = checkGuess(input.toString().uppercase(), wordleWord)
                    checkedValue1.visibility = View.VISIBLE
                    checkedValue1.text = guessChecked
                } else if (counter == 2) {
                    guessTwo.visibility = View.VISIBLE // guess # 2
                    guessTwo.text
                    inputDisplay2.visibility = View.VISIBLE
                    inputDisplay2.text = input.getText().toString() // user guess
                    guessCheckTwo.visibility = View.VISIBLE
                    guessCheckTwo.text
                    val guessChecked = checkGuess(input.toString().uppercase(), wordleWord)
                    checkedValue2.visibility = View.VISIBLE
                    checkedValue2.text = guessChecked
                } else {
                    guessThree.visibility = View.VISIBLE // guess # 3
                    guessThree.text
                    inputDisplay3.visibility = View.VISIBLE
                    inputDisplay3.text = input.getText().toString() // user guess
                    guessCheckThree.visibility = View.VISIBLE
                    guessCheckThree.text
                    val guessChecked = checkGuess(input.toString().uppercase(), wordleWord)
                    checkedValue3.visibility = View.VISIBLE
                    checkedValue3.text = guessChecked
                    correct_answer.visibility = View.VISIBLE
                    correct_answer.text = wordleWord
                    result.visibility = View.INVISIBLE
                    reset.visibility = View.VISIBLE
                }
            }
        reset.setOnClickListener{
            inputDisplay1.visibility = View.INVISIBLE
            inputDisplay2.visibility = View.INVISIBLE
            inputDisplay3.visibility = View.INVISIBLE
            guessOne.visibility = View.INVISIBLE
            guessTwo.visibility = View.INVISIBLE
            guessThree.visibility = View.INVISIBLE
            guessCheckOne.visibility = View.INVISIBLE
            guessCheckTwo.visibility = View.INVISIBLE
            guessCheckThree.visibility = View.INVISIBLE
            checkedValue1.visibility = View.INVISIBLE
            checkedValue2.visibility = View.INVISIBLE
            checkedValue3.visibility = View.INVISIBLE
            correct_answer.visibility = View.INVISIBLE
            reset.visibility = View.INVISIBLE
            result.visibility = View.VISIBLE
            counter = 0
        }
        }
    }
