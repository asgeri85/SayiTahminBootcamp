package com.example.sayitahminbootcamp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.sayitahminbootcamp.databinding.ActivitySonBinding

class SonActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySonBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivitySonBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val gelen=intent.getBooleanExtra("durum",false)

        if (gelen){
            binding.imageView2.setImageResource(R.drawable.ic_baseline_emoji_emotions_24)
            binding.textViewSon.text="Kazandınız"
        }else{
            binding.imageView2.setImageResource(R.drawable.ic_baseline_mood_bad_24)
            binding.textViewSon.text="Kaybettiniz"
        }
    }
}