package com.example.phonebook

import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.example.phonebook.adapter.EntryAdapter
import com.example.phonebook.data.Datasource
import com.example.phonebook.data.modul.Entry
import com.example.phonebook.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        val datasource = Datasource()
        val entryList = datasource.getEntries()

        val deleteEntry = { abc: Entry ->
            deleteEntryItem(entryList, abc)
        }

        binding.entryRecycler.adapter = EntryAdapter(entryList, deleteEntry)
        Toast.makeText(this, "App started", Toast.LENGTH_SHORT)
            .show()

        binding.addEntryButton.setOnClickListener {
            val name = binding.inputNameText.text.toString()
            val number = binding.inputNumberText.text.toString()

            if(!name.isNullOrEmpty() && !number.isNullOrEmpty()){
                val newEntry = Entry(name, number, R.drawable.image_placeholder)
                entryList.add(newEntry)

                binding.inputNameText.text = null
                binding.inputNumberText.text = null
            }
        }

        when(resources.configuration.uiMode and Configuration.UI_MODE_NIGHT_MASK){
            Configuration.UI_MODE_NIGHT_YES -> {
                Log.e("mode", "NIGHT")
            }
            Configuration.UI_MODE_NIGHT_NO -> {
                Log.e("mode", "DAY")
            }
        }
    }



    fun deleteEntryItem(entryList: MutableList<Entry>, entry: Entry){
        entryList.remove(entry)
    }
}