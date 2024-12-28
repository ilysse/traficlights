package com.manager.trafflight

// MainActivity.kt
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import java.util.Calendar
import android.view.View
import java.text.SimpleDateFormat
import java.util.Locale
import android.widget.TextView
import android.view.Choreographer
import android.animation.ValueAnimator
import android.animation.ArgbEvaluator

class MainActivity : AppCompatActivity() {
    private lateinit var redLight: View
    private lateinit var yellowLight: View
    private lateinit var greenLight: View
    private lateinit var scenario1Button: Button
    private lateinit var scenario2Button: Button
    private lateinit var timeDisplay: TextView
    private val handler = Handler(Looper.getMainLooper())
    private var isScenario2Active = false
    private var isYellowOn = false

    // Cache colors
    private var redColor = 0
    private var yellowColor = 0
    private var greenColor = 0
    private var grayColor = 0

    private val timeFormat by lazy {
        SimpleDateFormat("HH:mm:ss", Locale.getDefault())
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initializeViews()
        cacheColors()
        setupClickListeners()
    }

    private fun cacheColors() {
        redColor = getColor(R.color.red)
        yellowColor = getColor(R.color.yellow)
        greenColor = getColor(R.color.green)
        grayColor = getColor(R.color.gray)
    }

    private fun initializeViews() {
        redLight = findViewById(R.id.redLight)
        yellowLight = findViewById(R.id.yellowLight)
        greenLight = findViewById(R.id.greenLight)
        scenario1Button = findViewById(R.id.scenario1Button)
        scenario2Button = findViewById(R.id.scenario2Button)
        timeDisplay = findViewById(R.id.timeDisplay)
    }

    private fun setupClickListeners() {
        scenario1Button.setOnClickListener {
            stopScenario2()
            runScenario1()
        }
        scenario2Button.setOnClickListener {
            stopScenario2()
            runScenario2()
        }
    }

    private fun animateColorChange(view: View, fromColor: Int, toColor: Int, duration: Long) {
        ValueAnimator.ofObject(ArgbEvaluator(), fromColor, toColor).apply {
            this.duration = duration
            addUpdateListener { animator ->
                view.setBackgroundColor(animator.animatedValue as Int)
            }
            start()
        }
    }

    private fun runScenario1() {
        resetLights()

        // Red light with animation
        animateColorChange(redLight, grayColor, redColor, 300)

        // After 3 seconds, yellow light
        handler.postDelayed({
            animateColorChange(redLight, redColor, grayColor, 300)
            animateColorChange(yellowLight, grayColor, yellowColor, 300)
        }, 3000)

        // After 6 seconds, green light
        handler.postDelayed({
            animateColorChange(yellowLight, yellowColor, grayColor, 300)
            animateColorChange(greenLight, grayColor, greenColor, 300)
        }, 6000)
    }

    private fun runScenario2() {
        isScenario2Active = true
        resetLights()
        blinkYellowLight()
    }

    private fun blinkYellowLight() {
        if (!isScenario2Active) return

        isYellowOn = !isYellowOn
        yellowLight.setBackgroundColor(if (isYellowOn) yellowColor else grayColor)

        // Schedule next blink after 1 second
        handler.postDelayed({ blinkYellowLight() }, 1000)
    }

    private fun stopScenario2() {
        isScenario2Active = false
        handler.removeCallbacksAndMessages(null)
    }

    private fun resetLights() {
        redLight.setBackgroundColor(grayColor)
        yellowLight.setBackgroundColor(grayColor)
        greenLight.setBackgroundColor(grayColor)
        handler.removeCallbacksAndMessages(null)
    }

    override fun onDestroy() {
        super.onDestroy()
        stopScenario2()
        handler.removeCallbacksAndMessages(null)
    }
}