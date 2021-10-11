package com.example.sayitahminbootcamp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.sayitahminbootcamp.databinding.ActivityGameBinding
import kotlin.random.Random

class GameActivity : AppCompatActivity() {
    private lateinit var binding: ActivityGameBinding
    private  var hak=5
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityGameBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val random=Random.nextInt(0,100)
        binding.buttonTahmin.setOnClickListener {
            tahmin(random)
            Log.e("random",random.toString())
        }

    }

    fun tahmin(random: Int){
        val sayi=binding.editTextNumber.text.toString()
        if (sayi.isNullOrEmpty()){
           Toast.makeText(applicationContext,"Sayı giriniz",Toast.LENGTH_SHORT).show()
            return
        }
        val reqem=sayi.toInt()
        if (hak==1){
            val intent=Intent(this@GameActivity,SonActivity::class.java)
            intent.putExtra("durum",false)
            startActivity(intent)
            finish()
        }else{
            when {
                reqem==random -> {
                    val intent=Intent(this@GameActivity,SonActivity::class.java)
                    intent.putExtra("durum",true)
                    startActivity(intent)
                    finish()
                }
                reqem>random -> {
                    binding.textViewYardim.text="Azaltın"
                    hak--
                    binding.textViewHak.text="Kalan hak:$hak"
                    binding.editTextNumber.setText("")
                }
                reqem<random -> {
                    binding.textViewYardim.text="Artırın"
                    hak--
                    binding.textViewHak.text="Kalan hak:$hak"
                    binding.editTextNumber.setText("")
                }
            }
        }
    }
}