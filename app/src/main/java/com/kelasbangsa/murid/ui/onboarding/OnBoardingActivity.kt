package com.kelasbangsa.murid.ui.onboarding

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import androidx.viewpager.widget.ViewPager
import com.google.android.material.button.MaterialButton
import com.google.android.material.tabs.TabLayout
import com.kelasbangsa.murid.R
import com.kelasbangsa.murid.ui.signin.SignInActivity
import com.kelasbangsa.murid.adapter.OnBoardingViewPagerAdapter
import com.kelasbangsa.murid.data.model.OnBoardingData

class OnBoardingActivity : AppCompatActivity() {

    var onBoardingViewPagerAdapter : OnBoardingViewPagerAdapter? = null
    var tabLayout : TabLayout? = null
    var viewPager : ViewPager? = null
    var addAnimation : Animation? = null
    var btnNext : MaterialButton? = null
    var btnGetStarted : MaterialButton? = null
    var btnSkip : MaterialButton? = null
    var position = 0
    var sharedPreferences : SharedPreferences? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_on_boarding)

        //Restore preferences
        if (restorePrefData()){
            val i = Intent(applicationContext, SignInActivity::class.java)
            startActivity(i)
            finish()
        }

        //INIT VIEW
        tabLayout = findViewById(R.id.tab_indicator)
        btnNext = findViewById(R.id.btn_next)
        btnGetStarted = findViewById(R.id.btn_get_started)
        btnSkip = findViewById(R.id.btn_skip)
        addAnimation = AnimationUtils.loadAnimation(applicationContext, R.anim.button_animation)

        //Add data to out model
        val onBoardingData : MutableList<OnBoardingData> = ArrayList()
        onBoardingData.add(
            OnBoardingData(
            "Temukan Guru di Dekat Anda",
            "Menemukan guru yang anda cari dengan mudah, tanpa harus keluar rumah. Hanya dengan ponsel anda.",
                R.drawable.ilustrasi_slide_1
            )
        )

        onBoardingData.add(
            OnBoardingData(
            "Buat Janji Pertemuan",
            "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.",
                R.drawable.ilustrasi_slide_2
            )
        )

        onBoardingData.add(
            OnBoardingData(
            "Belajar dengan Gurumu",
            "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.",
                R.drawable.ilustrasi_slide_3
            )
        )

        setOnBoardingViewPagerAdapter(onBoardingData)

        position = viewPager!!.currentItem

        btnNext?.setOnClickListener{
            if (position < onBoardingData.size){
                position++
                viewPager!!.currentItem = position
            }
            if (position == onBoardingData.size - 1){
                loadLastScreen()
            }
        }

        btnGetStarted?.setOnClickListener{
            savePrefData()
            val i = Intent(applicationContext, SignInActivity::class.java)
            startActivity(i)

        }

        btnSkip?.setOnClickListener{
            finishOnBoarding()
        }

        tabLayout!!.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab?) {
                position = tab!!.position
                if (tab.position == onBoardingData.size - 1) {
                    loadLastScreen()
                }
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
            }

            override fun onTabReselected(tab: TabLayout.Tab?) {
            }
        })
    }

    private fun finishOnBoarding() {

        // Get the shared preferences
        sharedPreferences = applicationContext.getSharedPreferences("my_preferences", MODE_PRIVATE)

        // Set onboarding_complete to true
        val editor: SharedPreferences.Editor = sharedPreferences!!.edit()
        editor.putBoolean("onboarding_complete", true)
        editor.apply()

        // Launch the main Activity, called LoginActivity
        val login = Intent(this, SignInActivity::class.java)
        startActivity(login)


        // Close the OnboardingActivity
        finish()
    }

    private fun loadLastScreen() {
        btnNext?.visibility = View.INVISIBLE
        btnGetStarted?.visibility = View.VISIBLE

        //button mulai add animation

        //TODO: ADD an animation the get started button
        btnGetStarted?.animation = addAnimation
    }

    private fun setOnBoardingViewPagerAdapter(onBoardingData: List<OnBoardingData>){
        //INIT VIEW
        viewPager = findViewById(R.id.onboarding_view_pager)
        onBoardingViewPagerAdapter = OnBoardingViewPagerAdapter(this, onBoardingData)
        viewPager!!.adapter = onBoardingViewPagerAdapter

        //set indicator
        tabLayout?.setupWithViewPager(viewPager)
    }

    private fun savePrefData(){
        sharedPreferences = applicationContext.getSharedPreferences("pref", Context.MODE_PRIVATE)
        val editor:SharedPreferences.Editor = sharedPreferences!!.edit()
        editor.putBoolean("isFirstTimeRun", true)
        editor.apply()
    }

    private fun restorePrefData() : Boolean{
        sharedPreferences = applicationContext.getSharedPreferences("pref", Context.MODE_PRIVATE)
        return sharedPreferences!!.getBoolean("isFirstTimeRun", false)
    }
}