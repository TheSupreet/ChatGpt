//package com.example.chatgpt
//
//import android.content.Intent
//import android.net.Uri
//import android.os.Bundle
//import android.widget.TextView
//import androidx.appcompat.app.AppCompatActivity
//import com.example.chatgpt.databinding.ActivityMainBinding
//
//class MainActivity : AppCompatActivity() {
//    private lateinit var binding : ActivityMainBinding
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        binding = ActivityMainBinding.inflate(layoutInflater)
//        setContentView(binding.root)
////        val textView: TextView = findViewById<TextView>(R.id.textView6)
////        textView.movementMethod = LinkMovementMethod.getInstance()
//        val ldn1: TextView = findViewById(R.id.textView6)
//        ldn1.setOnClickListener {
//            gotoUrl("https://www.linkedin.com/in/supreet-kurdekar-82b3ba242")
//            val ldn2: TextView = findViewById(R.id.textView7)
//        ldn2.setOnClickListener {
//            gotoUrl("https://www.linkedin.com/in/shivananda-m-n-79024020a")
//
//        binding.generateImage.setOnClickListener{
//            startActivity(Intent(this,ImageGenerateActivity::class.java))
//        }
//
//        binding.chatWithBot.setOnClickListener{
//            startActivity(Intent(this,ChatActivity::class.java))
//        }
//
//    }
//}
//
//    private fun gotoUrl(url: String) {
//        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
//        startActivity(intent)
//    }
//}
//    private fun gotoUrl(url: String) {
//        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
//        startActivity(intent)
//    }
//}
package com.example.chatgpt

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.chatgpt.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val ldn1: TextView = findViewById(R.id.textView7)
        ldn1.setOnClickListener {
            gotoUrl("https://www.linkedin.com/in/supreet-kurdekar-82b3ba242")
        }

        val ldn2: TextView = findViewById(R.id.textView6)
        ldn2.setOnClickListener {
            gotoUrl("https://www.linkedin.com/in/shivananda-m-n-79024020a")
        }

        binding.generateImage.setOnClickListener{
            startActivity(Intent(this,ImageGenerateActivity::class.java))
        }

        binding.chatWithBot.setOnClickListener{
            startActivity(Intent(this,ChatActivity::class.java))
        }
    }

    private fun gotoUrl(url: String) {
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
        startActivity(intent)
    }
}

