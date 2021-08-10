package com.kelasbangsa.murid.ui.filter

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.kelasbangsa.murid.R
import com.kelasbangsa.murid.`interface`.OnItemClickListener
import com.kelasbangsa.murid.adapter.BidangStudiBotSheetAdapter
import com.kelasbangsa.murid.adapter.KategoriBotSheetAdapter
import com.kelasbangsa.murid.data.model.BidangStudi

class BotsheetFilterBSFragment : BottomSheetDialogFragment(), OnItemClickListener {

    private lateinit var rvBidangStudi : RecyclerView
    private lateinit var btnClose : ImageButton
    private lateinit var bidangStudi : MutableList<BidangStudi>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_botsheet_filter_b_s, container, false)

        //INIT VIEW
        rvBidangStudi = view.findViewById(R.id.rv_bidang_studi_botsheet)
        btnClose = view.findViewById(R.id.btn_close)

        //List bidang studi
        bidangStudi = ArrayList()
        bidangStudi.add(BidangStudi(0,"Ekonomi"))
        bidangStudi.add(BidangStudi(0,"Geografi"))
        bidangStudi.add(BidangStudi(0,"Kimia"))
        bidangStudi.add(BidangStudi(0,"Biologi"))
        bidangStudi.add(BidangStudi(0,"Fisika"))
        bidangStudi.add(BidangStudi(0,"Matematika"))
        bidangStudi.add(BidangStudi(0,"Ujian Nasional"))

        //set adapter
        val layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        val adapter = BidangStudiBotSheetAdapter(bidangStudi, this)
        rvBidangStudi.layoutManager = layoutManager
        rvBidangStudi.adapter = adapter
        rvBidangStudi.setHasFixedSize(true)

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btnClose.setOnClickListener {
            dismiss()
        }

    }


    override fun getTheme(): Int = R.style.BottomSheetDialogTheme

    override fun onItemClick(position: Int) {
        Toast.makeText(context, "Pilih "+bidangStudi[position].namaMapel, Toast.LENGTH_SHORT).show()
    }

}