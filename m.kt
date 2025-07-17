package com.hfad.myfirstapp

import android.os.Bundle
import android.widget.Button
import android.widget.Spinner
import android.widget.TextView
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.hfad.myfirstapp.ui.theme.MyFirstAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_layout)

        val button = findViewById<Button>(R.id.Button)

        button.setOnClickListener {
            val companyName = findViewById<Spinner>(R.id.Spinner).selectedItem.toString()

            val domainList = getDomains(companyName)

            val domains = domainList.reduce { str, item -> str + '\n' + item }

            val result = findViewById<TextView>(R.id.Result)

            result.text = domains
        }

    }

    fun getDomains(company:String) : List<String> {
        return when(company) {
            "Google" -> listOf("google.com","youtube.com","gmail.com")
            "Meta" -> listOf("facebook.com","instagram.com", "whatsapp.com")
            "Microsoft" -> listOf("office.com", "azure.com", "microsoft365.com")

            else -> listOf("Unknown Company")
        }
    }
}

