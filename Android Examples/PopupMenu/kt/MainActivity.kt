package com.example.androidexamples

import android.content.Context
import android.os.Build
import android.os.Bundle
import android.view.ContextThemeWrapper
import android.view.View
import android.widget.PopupMenu
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import com.example.androidexamples.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding
    private lateinit var context:Context
    private lateinit var view:View

    @RequiresApi(Build.VERSION_CODES.Q)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.button.setOnClickListener {
            onMenuItemClick(this)
        }
    }

    @RequiresApi(Build.VERSION_CODES.Q)
    private fun onMenuItemClick(context: Context){
        val wrapper: Context =  ContextThemeWrapper(context, R.style.CustomPopUpStyle)
        val popMenu = PopupMenu(wrapper, button)
        popMenu.menuInflater.inflate(R.menu.popup_menu, popMenu.menu)
        popMenu.show()
        popMenu.setForceShowIcon(true)

        popMenu.setOnMenuItemClickListener(PopupMenu.OnMenuItemClickListener { item ->
            when(item.itemId){
                R.id.home-> Toast.makeText(this, "home", Toast.LENGTH_SHORT).show()
                R.id.settings-> Toast.makeText(this, "settings", Toast.LENGTH_SHORT).show()
                R.id.share-> Toast.makeText(this, "share", Toast.LENGTH_SHORT).show()
            }
            true
        })
    }

}
