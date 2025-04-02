package za.ac.mealplan

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        // Initializing UI elements
        val edtTime = findViewById<EditText>(R.id.edtTime)
        val txtResults = findViewById<TextView>(R.id.txtResults)
        val btnSuggest = findViewById<Button>(R.id.btnSuggest)
        val btnClear = findViewById<Button>(R.id.btnClear)


// Set onClickListener for the Suggest button
        btnSuggest.setOnClickListener {
            val timeOfDay = edtTime.text.toString().trim().lowercase() // Get user input, trim spaces, and convert to lowercase
            val mealSuggestion = getMealSuggestion(timeOfDay) // Get meal suggestion based on input


            // Display meal suggestion or error message
            txtResults.text = if (mealSuggestion != null) {
                "Suggested Meal: $mealSuggestion"
            } else {
                "Invalid input! Please enter a valid time of day."
            }
        }

// Set onClickListener for the Clear button
        btnClear.setOnClickListener {
            edtTime.text.clear() // Clear input field
            txtResults.text = "" // Clear results
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }


    // Function to return meal suggestions based on the time of day
    private fun getMealSuggestion(timeOfDay: String): String? { if (timeOfDay == "morning") {
            return "Eggs"
        } else if (timeOfDay == "mid-morning") {
            return "Fruit Salad"
        } else if (timeOfDay == "afternoon") {
            return "Sandwich and Juice"
        } else if (timeOfDay == "afternoon snack") {
            return "Granola Bar"
        } else if (timeOfDay == "dinner") {
            return "Grilled Chicken with Vegetables"
        } else if (timeOfDay == "after dinner") {
            return "Ice Cream or Cake"
        } else {
            return null // Return null if input is invalid
        }
    }
}