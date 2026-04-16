package com.example.donapps.pertemuan_2

import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.donapps.R
import com.example.donapps.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySecondBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)
        supportActionBar?.apply {
            title = "Second Activity"
            setDisplayHomeAsUpEnabled(true)
            setDisplayShowHomeEnabled(true)
            setHomeAsUpIndicator(R.drawable.ic_arrow_back)
        }

        binding.btnSubmit.setOnClickListener {
            val nama = binding.inputNama.text
            Log.e("Klik btnSubmit", "Tombol berhasil di tekan. Isi dari inputNama = $nama")
            Toast.makeText(this, "Pesan telah terkirim = $nama", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            android.R.id.home -> {
                onBackPressedDispatcher.onBackPressed()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}
