package com.example.baitaprecycleview

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.baitaprecycleview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        XuLy()
    }

    private fun XuLy() {
        val ds = mutableListOf<OutData>()
        binding.btnAdd.setOnClickListener {
            val ten = binding.edtTen.text.toString()
            val mssv = binding.edtMssv.text.toString()
            if(ten.isNotEmpty() && mssv.isNotEmpty()){
                val item = OutData(ten, mssv)
                ds.add(item)
                binding.rvView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
                val adapter = RvAdapter(ds)
                binding.rvView.adapter = adapter
//                binding.rvView.adapter?.notifyItemInserted(ds.size - 1)
                binding.edtTen.text.clear()
                binding.edtMssv.text.clear()
            }
        }

    }
}