package com.example.kalkulatorsederhana

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    companion object {
        private const val TAG = "DetektifBug"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val etAngkaPertama = findViewById<EditText>(R.id.etAngkaPertama)
        val etAngkaKedua = findViewById<EditText>(R.id.etAngkaKedua)
        val btnBagi = findViewById<Button>(R.id.btnBagi)
        val tvHasil = findViewById<TextView>(R.id.tvHasil)

        Log.d(TAG, "Aplikasi berhasil dijalankan dan masuk ke onCreate")

        btnBagi.setOnClickListener {
            val input1 = etAngkaPertama.text.toString()
            val input2 = etAngkaKedua.text.toString()

            Log.d(TAG, "Tombol ditekan. Input1: $input1, Input2: $input2")

            if (input1.isNotEmpty() && input2.isNotEmpty()) {
                try {
                    val angka1 = input1.toDouble()
                    val angka2 = input2.toDouble()

                    if (angka2 == 0.0) {
                        Log.e(TAG, "Terjadi Kesalahan: Percobaan pembagian dengan angka NOL!")
                        Toast.makeText(this, "Angka pembagi tidak boleh 0!", Toast.LENGTH_SHORT).show()
                        tvHasil.text = getString(R.string.label_hasil, "Error")
                    } else {
                        val hasilBagi = angka1 / angka2
                        Log.i(TAG, "Perhitungan berhasil dikerjakan. Hasil: $hasilBagi")
                        tvHasil.text = getString(R.string.label_hasil, hasilBagi.toString())
                    }
                } catch (e: NumberFormatException) {
                    Toast.makeText(this, "Input tidak valid!", Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(this, "Masukkan angka terlebih dahulu!", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
