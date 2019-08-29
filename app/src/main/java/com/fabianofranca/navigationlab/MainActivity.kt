package com.fabianofranca.navigationlab

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var index = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val controller = Navigation.findNavController(this, R.id.nav_host_fragment).apply {
            setGraph(R.navigation.main_nav_graph, intent.extras)
        }

        navigateButton.setOnClickListener {
            when (index) {
                1 -> {
                    controller.navigate(R.id.action_fragmentOne_to_fragmentTwo)
                    index += 1
                }
                2 -> {
                    controller.navigate(R.id.action_fragmentTwo_to_fragmentThree)
                    index += 1
                }
            }
        }

        threeButton.setOnClickListener {
            controller.navigate(R.id.action_fragmentOne_to_fragmentTwo)
            controller.navigate(R.id.action_fragmentTwo_to_fragmentThree)
        }
    }

    override fun onBackPressed() {
        super.onBackPressed()
        index -= 1
    }


}
