package com.example.phonebook.data

import com.example.phonebook.R
import com.example.phonebook.data.modul.Entry

class Datasource {

    fun getEntries(): MutableList<Entry>{
        return mutableListOf(
            Entry("Andrew Glowberman", "+12692116949", R.drawable.andrew),
            Entry("Nick Birch", "+13272343976", R.drawable.nick),
            Entry("Missy Foreman-Greenwald", "+12392309009", R.drawable.missy),
            Entry("Jessi Glaser", "+11982346649", R.drawable.jessi),
            Entry("Jay Bilzerian", "+19882536977", R.drawable.jay),
            Entry("Matthew MacDell", "+115155320878", R.drawable.matt),
            Entry("Maury", "+13972333289", R.drawable.maury),
            Entry("Connie", "+11292345024", R.drawable.connie),
            Entry("Shame Wizard", "+1456726888", R.drawable.wizard)
        )
    }
}