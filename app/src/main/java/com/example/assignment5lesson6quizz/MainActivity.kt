package com.example.assignment5lesson6quizz

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_main.*
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.time.format.FormatStyle
import java.util.*

class MainActivity : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        reset.setOnClickListener{
            Google.isChecked = false
            JetBrains.isChecked = false
            Microsoft.isChecked = false
            Range.isChecked = false
            SealedClass.isChecked = false
            ElvisOperator.isChecked = false
        }

        getResults.setOnClickListener {
            val current = LocalDateTime.now()

            val formatter = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM)
            val formatted = current.format(formatter)

            var results = 0
            if(JetBrains.isChecked){
                results+= 50
            }

            if(ElvisOperator.isChecked && !SealedClass.isChecked && !Range.isChecked){
                results += 50
            }

            val builder = AlertDialog.Builder(this@MainActivity)
            builder.setTitle("Score")
            if(results < 50){
                builder.setMessage("You took the test on $formatted, Your Score is 0.You have failed, please try again")
            } else {
                builder.setMessage("Congratulations, You have passeed, Your score is $results")
            }
            builder.setNegativeButton("Close Window"){dialogInterface, which ->
                dialogInterface.dismiss()
            }

            val dialog: AlertDialog = builder.create()
            dialog.show()
        }
    }

}