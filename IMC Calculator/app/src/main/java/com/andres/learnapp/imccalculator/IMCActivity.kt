package com.andres.learnapp.imccalculator

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import com.andres.learnapp.R
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.slider.RangeSlider
import java.text.DecimalFormat

class IMCActivity : AppCompatActivity() {

    private var isMaleSelected: Boolean = true
    private var isFemaleSelected: Boolean = false
    private var currentHeight: Int = 150
    private var currentWeight: Int = 50
    private var currentAge: Int = 25

    // Logic Variables
    private lateinit var viewMale: CardView
    private lateinit var viewFemale: CardView
    private lateinit var tvHeightText: TextView
    private lateinit var rsHeigthValue: RangeSlider
    // Weight Card
    private lateinit var tvWeightText: TextView
    private lateinit var btnSubstractWeight: FloatingActionButton
    private lateinit var btnPlusWeight: FloatingActionButton
    // Age Card
    private lateinit var tvAgeText: TextView
    private lateinit var btnSubstractAge: FloatingActionButton
    private lateinit var btnPlusAge: FloatingActionButton
    // Calculate Button
    private lateinit var btnCalcIMC: Button
    // El companion object permite que cualquier archivo externo pueda acceder a el.
    companion object {
        const val IMC_KEY = "IMC_RESULT"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_imcactivity)

        initComponents()
        initListeners()
        initUI()
    }

    private fun initComponents() {
        viewMale = findViewById(R.id.cardViewMale)
        viewFemale = findViewById(R.id.cardViewFemale)
        tvHeightText = findViewById(R.id.tvHeight)
        rsHeigthValue = findViewById(R.id.rsHeight)
        // Weight Card
        tvWeightText = findViewById(R.id.tvWeight)
        btnSubstractWeight = findViewById(R.id.btnLessWeight)
        btnPlusWeight = findViewById(R.id.btnPlusWeight)
        // Age Card
        tvAgeText = findViewById(R.id.tvAge)
        btnSubstractAge = findViewById(R.id.btnLessAge)
        btnPlusAge = findViewById(R.id.btnPlusAge)
        // Calculate Button
        btnCalcIMC = findViewById(R.id.btnCalculateIMC)
    }

    private fun initListeners() {
        viewMale.setOnClickListener {
            changeGender()
            setGenderColor()
        }
        viewFemale.setOnClickListener {
            changeGender()
            setGenderColor()
        }
        rsHeigthValue.addOnChangeListener { _, value, _ ->
            // Esto servira para cambiar el formato de los decimales.
            val df = DecimalFormat("#.##")
            currentHeight = df.format(value).toInt()
            tvHeightText.text = "$currentHeight cm"
        }
        btnSubstractWeight.setOnClickListener {
            if (currentWeight > 0 && currentWeight < 200) {
                currentWeight -= 1
                setWeight()
            }
        }
        btnPlusWeight.setOnClickListener {
            if (currentWeight > 20 && currentWeight < 200) {
                currentWeight += 1
                setWeight()
            }
        }
        btnSubstractAge.setOnClickListener {
            if (currentAge > 0 && currentAge < 120) {
                currentAge -= 1
                setAge()
            }
        }
        btnPlusAge.setOnClickListener {
            if (currentAge > 0 && currentAge < 120) {
                currentAge += 1
                setAge()
            }
        }
        btnCalcIMC.setOnClickListener {
            calculateIMC()
        }
    }

    private fun setWeight() {
        tvWeightText.text = "${currentWeight} Kg"
    }

    private fun setAge() {
        tvAgeText.text = "${currentAge} Years"
    }

    private fun calculateIMC() {
        val df = DecimalFormat("#.##")
        val IMC = df.format(currentWeight / ((currentHeight.toDouble() / 100) * (currentHeight.toDouble() / 100))).toDouble()

        navigateToResult(IMC)
    }

    private fun navigateToResult(result: Double) {
        val intent = Intent(this, IMCResultActivity::class.java)
        intent.putExtra(IMC_KEY, result)
        startActivity(intent)
    }

    private fun initUI() {
        setGenderColor()
        setWeight()
        setAge()
    }

    private fun changeGender(){
        isMaleSelected = !isMaleSelected
        isFemaleSelected = !isFemaleSelected
    }
    private fun setGenderColor() {
        viewMale.setCardBackgroundColor(getBackgroundColor(isMaleSelected))
        viewFemale.setCardBackgroundColor(getBackgroundColor(isFemaleSelected))
    }

    private fun getBackgroundColor(isSelectedComponent: Boolean) : Int {

        val colorReference = if(isSelectedComponent) {
            R.color.background_component_selected
        } else {
            R.color.background_component
        }

        return ContextCompat.getColor(this, colorReference)
    }
}