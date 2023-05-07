package com.andres.learnapp.imccalculator

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.core.content.ContextCompat
import com.andres.learnapp.R
import com.andres.learnapp.imccalculator.IMCActivity.Companion.IMC_KEY

class IMCResultActivity : AppCompatActivity() {

    // UI variables
    private lateinit var tvResult : TextView
    private lateinit var tvResultValue : TextView
    private lateinit var tvResultInformation : TextView
    private lateinit var btnRecalculate : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_imcresult)

        val result = intent.extras?.getDouble(IMC_KEY) ?: -1.0

        initComponent()
        initUI(result)
    }

    private fun initComponent() {
        tvResult = findViewById(R.id.tvResult)
        tvResultValue = findViewById(R.id.tvResultValue)
        tvResultInformation = findViewById(R.id.tvResultInformation)
        btnRecalculate = findViewById(R.id.btnRecalculateIMC)
    }

    private fun initUI(result : Double) {

        tvResultValue.text = result.toString()

        when(result) {
            in 0.00 .. 18.50 -> { // Peso Bajo
                tvResult.text = getString(R.string.peso_bajo)
                tvResult.setTextColor(ContextCompat.getColor(this, R.color.peso_bajo_color))
                tvResultInformation.text = getString(R.string.peso_bajo_information)
            }
            in 18.51 .. 24.99 -> { // Peso Normal
                tvResult.text = getString(R.string.peso_normal)
                tvResult.setTextColor(ContextCompat.getColor(this, R.color.peso_normal_color))
                tvResultInformation.text = getString(R.string.peso_normal_information)
            }
            in 25.00 .. 29.99 -> { // Sobre Peso
                tvResult.text = getString(R.string.sobre_peso)
                tvResult.setTextColor(ContextCompat.getColor(this, R.color.sobre_peso_color))
                tvResultInformation.text = getString(R.string.sobre_peso_information)
            }
            in 30.00 .. 99.00 -> { // Obesidad
                tvResult.text = getString(R.string.obesidad)
                tvResult.setTextColor(ContextCompat.getColor(this, R.color.obesidad_color))
                tvResultInformation.text = getString(R.string.obesidad_information)
            }
            else -> { // Valio Verga
                tvResult.text = getString(R.string.error_information)
                tvResultValue.text = getString(R.string.error_information)
                tvResultInformation.text = getString(R.string.error_information)
            }
        }

        btnRecalculate.setOnClickListener {
            val intent = Intent(this, IMCActivity::class.java)
            startActivity(intent)
        }

    }
}