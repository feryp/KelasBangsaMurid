package com.kelasbangsa.murid.ui.pesanKelas

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.constraintlayout.widget.ConstraintLayout
import com.google.android.material.appbar.MaterialToolbar
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText
import com.kelasbangsa.murid.R
import com.kelasbangsa.murid.ui.tingkatan.TingkatPendidikanActivity
import com.kelasbangsa.murid.ui.guru.GuruActivity
import com.kelasbangsa.murid.ui.lokasi.PilihLokasiActivity
import com.kelasbangsa.murid.ui.pembayaran.PembayaranActivity
import java.lang.reflect.Method

class PesanKelasActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var toolbar : MaterialToolbar
    private lateinit var spKategori : Spinner
    private lateinit var spBidangStudi : Spinner
    private lateinit var spTingPendidikan : Spinner
    private lateinit var spTingKelas : Spinner
//    private lateinit var pilihTingkatan : ConstraintLayout
    private lateinit var btnPilihGuru : MaterialButton
    private lateinit var etLokasi : TextView
    private lateinit var btnPesan : MaterialButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pesan_kelas)

        //INIT VIEW
        toolbar = findViewById(R.id.toolbar_pesan_kelas)
        spKategori = findViewById(R.id.sp_kategori)
        spBidangStudi = findViewById(R.id.sp_bidang_studi)
        spTingPendidikan = findViewById(R.id.sp_ting_pendidikan)
        spTingKelas = findViewById(R.id.sp_ting_kelas)
//        pilihTingkatan = findViewById(R.id.container_pilih_tingkatan)
        btnPilihGuru = findViewById(R.id.btn_pilih_guru)
        etLokasi = findViewById(R.id.et_lokasi)
        btnPesan = findViewById(R.id.btn_pesan_kelas)

        //Spinner kategori
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

        //Spinner bidang studi
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

        //Spinner tingkat pendidikan
        val opTingPendidikan = arrayOf(
            "Pilih Tingkat Pendidikan",
            "TK-PAUD",
            "Sekolah Dasar (SD)",
            "Sekolah Menengah Pertama (SMP)",
            "Sekolah Menengah Akhir (SMA)",
            "Universitas",
            "Umum")
        spTingPendidikan.adapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,opTingPendidikan)

        spTingPendidikan.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(adapterView: AdapterView<*>?, view: View?, position: Int, id: Long) {
                Toast.makeText(this@PesanKelasActivity, "Anda Pilih Bidang Studi ${adapterView?.getItemAtPosition(position).toString()}",
                    Toast.LENGTH_SHORT).show()
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {

            }

        }

        //Spinner tingkat kelas
        val opTingKelas = arrayOf(
            "Pilih Tingkat Kelas",
            "Kelas 10",
            "Kelas 11",
            "Kelas 12")
        spTingKelas.adapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,opTingKelas)

        spTingKelas.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(adapterView: AdapterView<*>?, view: View?, position: Int, id: Long) {
                Toast.makeText(this@PesanKelasActivity, "Anda Pilih Bidang Studi ${adapterView?.getItemAtPosition(position).toString()}",
                    Toast.LENGTH_SHORT).show()
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {

            }

        }


        //Set OnClick Listener
        btnPilihGuru.setOnClickListener(this)
        etLokasi.setOnClickListener(this)
        btnPesan.setOnClickListener(this)


        //Set NavigationOnClick Listener
        toolbar.setNavigationOnClickListener{
            finish()
        }
    }
//
//    @SuppressLint("ObsoleteSdkInt")
//    fun EditText.shouldShowInputOnFocus(show: Boolean){
//        when{
//            Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP -> {
//                this.showSoftInputOnFocus = show
//            }
//
//            Build.VERSION.SDK_INT == Build.VERSION_CODES.ICE_CREAM_SANDWICH_MR1 -> {
//                val method : Method = TextInputEditText::class.java.getMethod(
//                    "setSoftInputShowOnFocus",
//                    *arrayOf<Class<*>?>(Boolean::class.javaPrimitiveType)
//                )
//                method.isAccessible = true
//                method.invoke(this, show)
//            }
//            else -> {
//                val method : Method = TextInputEditText::class.java.getMethod(
//                    "setShowSoftInputOnFocus",
//                    *arrayOf<Class<*>?>(Boolean::class.javaPrimitiveType)
//                )
//                method.isAccessible = true
//                method.invoke(this, show)
//            }
//        }
//    }

    override fun onClick(v: View) {
        when(v.id){
            R.id.btn_pilih_guru -> {
                val pilihGuru = Intent(this, GuruActivity::class.java)
                startActivity(pilihGuru)
            }

            R.id.et_lokasi -> {
                val pilihLokasi = Intent(this, PilihLokasiActivity::class.java)
                startActivity(pilihLokasi)
            }
            R.id.btn_pesan_kelas -> {
                val pesanKelas = Intent(this, PembayaranActivity::class.java)
                startActivity(pesanKelas)
            }
        }
    }
}