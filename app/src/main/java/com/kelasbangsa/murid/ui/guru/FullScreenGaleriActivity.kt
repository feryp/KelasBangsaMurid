package com.kelasbangsa.murid.ui.guru

import android.content.Intent
import android.os.Bundle
import android.view.Window
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import com.github.chrisbanes.photoview.PhotoView
import com.google.android.material.appbar.MaterialToolbar
import com.kelasbangsa.murid.R
import com.kelasbangsa.murid.data.model.Galeri


class FullScreenGaleriActivity : AppCompatActivity() {

    private lateinit var toolbar : MaterialToolbar
    private lateinit var photoView : PhotoView
    private lateinit var galeri : MutableList<Galeri>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.requestFeature(Window.FEATURE_NO_TITLE)
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )
        setContentView(R.layout.activity_full_screen_galeri)

        //INIT VIEW
        toolbar = findViewById(R.id.toolbar_fullscreen)
        photoView =  findViewById(R.id.full_img)

        toolbar.setNavigationOnClickListener {
            finish()
        }

        val intent = intent
        val pos = intent.getIntExtra("Foto", 0)
        photoView.setImageResource(pos)
    }


}