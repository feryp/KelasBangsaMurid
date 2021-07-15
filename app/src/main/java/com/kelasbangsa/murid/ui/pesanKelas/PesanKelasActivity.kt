package com.kelasbangsa.murid.ui.pesanKelas

import android.annotation.SuppressLint
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import com.google.android.material.appbar.MaterialToolbar
import com.google.android.material.textfield.TextInputEditText
import com.kelasbangsa.murid.R
import java.lang.reflect.Method

class PesanKelasActivity : AppCompatActivity() {

    private lateinit var toolbar : MaterialToolbar
    private lateinit var spKategori : Spinner
    private lateinit var spBidangStudi : Spinner
    private lateinit var etLokasi : EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pesan_kelas)

        //INIT VIEW
        toolbar = findViewById(R.id.toolbar)
        spKategori = findViewById(R.id.sp_kategori)
        spBidangStudi = findViewById(R.id.sp_bidang_studi)
        etLokasi = findViewById(R.id.et_lokasi)

        val opCategory =  arrayOf("Akademik","Bahasa","Agama","Keterampilan","Teknologi","Olahraga","Musik")
        spKategori.adapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,opCategory)

        spKategori.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(adapterView: AdapterView<*>?, view: View?, position: Int, id: Long) {
                Toast.makeText(this@PesanKelasActivity, "Anda Pilih Kategori ${adapterView?.getItemAtPosition(position).toString()}",
                    Toast.LENGTH_SHORT).show()
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {

            }

        }

        val opBS = arrayOf("Ekonomi","Geografi","Kimia","Biologi","Fisika","Matematika","Ujian Nasional")
        spBidangStudi.adapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,opBS)

        spBidangStudi.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(adapterView: AdapterView<*>?, view: View?, position: Int, id: Long) {
                Toast.makeText(this@PesanKelasActivity, "Anda Pilih Bidang Studi ${adapterView?.getItemAtPosition(position).toString()}",
                    Toast.LENGTH_SHORT).show()
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {

            }

        }

        //Untuk menghilangkan keyboard
        etLokasi.shouldShowInputOnFocus(false)


        //Set NavigationOnClick Listener
        toolbar.setNavigationOnClickListener{
            finish()
        }
    }

    @SuppressLint("ObsoleteSdkInt")
    fun EditText.shouldShowInputOnFocus(show: Boolean){
        when{
            Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP -> {
                this.showSoftInputOnFocus = show
            }

            Build.VERSION.SDK_INT == Build.VERSION_CODES.ICE_CREAM_SANDWICH_MR1 -> {
                val method : Method = TextInputEditText::class.java.getMethod(
                    "setSoftInputShowOnFocus",
                    *arrayOf<Class<*>?>(Boolean::class.javaPrimitiveType)
                )
                method.isAccessible = true
                method.invoke(this, show)
            }
            else -> {
                val method : Method = TextInputEditText::class.java.getMethod(
                    "setShowSoftInputOnFocus",
                    *arrayOf<Class<*>?>(Boolean::class.javaPrimitiveType)
                )
                method.isAccessible = true
                method.invoke(this, show)
            }
        }
    }
}