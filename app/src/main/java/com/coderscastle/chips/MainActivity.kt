package com.coderscastle.chips

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.graphics.drawable.toDrawable
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.chip.Chip
import com.google.android.material.chip.ChipGroup

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val chipGroup: ChipGroup = findViewById(R.id.chipGroup)

        val cities = listOf("Dhaka", "Rajshahi", "Chottogram", "Rangpur", "Barisal", "Khulna", "Sylhet")

        for (city in cities) {
            val chip = Chip(chipGroup.context)
            chip.text = city
            chip.isClickable = true
            chip.isCheckable = true

            chip.setOnCheckedChangeListener { buttonView, isChecked ->
                if (isChecked) Toast.makeText(this, buttonView.text, Toast.LENGTH_SHORT).show()
            }

            chipGroup.addView(chip)
        }
    }
}