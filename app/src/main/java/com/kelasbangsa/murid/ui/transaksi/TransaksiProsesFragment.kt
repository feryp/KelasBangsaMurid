package com.kelasbangsa.murid.ui.transaksi

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.kelasbangsa.murid.R
import com.kelasbangsa.murid.`interface`.OnItemClickListener
import com.kelasbangsa.murid.adapter.TransaksiProsesAdapter
import com.kelasbangsa.murid.data.model.Transaksi

class TransaksiProsesFragment : Fragment(), OnItemClickListener {

    private lateinit var rvTransaksi : RecyclerView
    private lateinit var adapterTransaksi : TransaksiProsesAdapter
    private lateinit var transaksi : MutableList<Transaksi>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_transaksi_proses, container, false)

        //INIT VIEW
        rvTransaksi = view.findViewById(R.id.rv_transaksi_proses)

        //List transaksi
        transaksi = ArrayList()
        transaksi.add(Transaksi("#KB30804030","6 November 2021","Rp 60.300","Menunggu Pembayaran"))
        transaksi.add(Transaksi("#KB10204020","6 November 2021","Rp 100.300","Butuh Konfirmasi"))
        transaksi.add(Transaksi("#KB30804030","6 November 2021","Rp 60.300","Menunggu Pembayaran"))
        transaksi.add(Transaksi("#KB10204020","6 November 2021","Rp 100.300","Butuh Konfirmasi"))
        transaksi.add(Transaksi("#KB30804030","6 November 2021","Rp 60.300","Menunggu Pembayaran"))
        transaksi.add(Transaksi("#KB10204020","6 November 2021","Rp 100.300","Butuh Konfirmasi"))
        transaksi.add(Transaksi("#KB30804030","6 November 2021","Rp 60.300","Menunggu Pembayaran"))
        transaksi.add(Transaksi("#KB10204020","6 November 2021","Rp 100.300","Butuh Konfirmasi"))
        transaksi.add(Transaksi("#KB30804030","6 November 2021","Rp 60.300","Menunggu Pembayaran"))
        transaksi.add(Transaksi("#KB10204020","6 November 2021","Rp 100.300","Butuh Konfirmasi"))
        transaksi.add(Transaksi("#KB30804030","6 November 2021","Rp 60.300","Menunggu Pembayaran"))
        transaksi.add(Transaksi("#KB10204020","6 November 2021","Rp 100.300","Butuh Konfirmasi"))

        //set adapter slider paket belajar
        val layoutManagerPaket = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        adapterTransaksi = TransaksiProsesAdapter(transaksi, this)
        rvTransaksi.layoutManager = layoutManagerPaket
        rvTransaksi.setHasFixedSize(true)
        rvTransaksi.adapter = adapterTransaksi




        return view
    }

    override fun onItemClick(position: Int) {
        Toast.makeText(context, transaksi[position].kodeTransaksi, Toast.LENGTH_SHORT).show()
    }
}