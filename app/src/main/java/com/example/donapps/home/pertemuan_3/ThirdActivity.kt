package com.example.donapps.home.pertemuan_3

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.donapps.R
import com.example.donapps.databinding.ActivityThirdBinding

class ThirdActivity : AppCompatActivity() {
    private lateinit var binding: ActivityThirdBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityThirdBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)
        supportActionBar?.apply {
            title = "Third Activity"
            setDisplayHomeAsUpEnabled(true)
            setDisplayShowHomeEnabled(true)
            setHomeAsUpIndicator(R.drawable.ic_arrow_back)
        }

        binding.btnKirim.setOnClickListener {
            val nama = binding.inputNoTujuan.text
            Log.e("Klik btnSubmit", "Tombol berhasil di tekan. Isi dari inputNama = $nama")
            Toast.makeText(this, "Pesan telah berhasil dikirim ke = $nama", Toast.LENGTH_SHORT).show()

            val intent = Intent(this, ThirdResultActivity::class.java)
            startActivity(intent)
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
