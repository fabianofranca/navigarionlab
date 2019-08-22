package com.fabianofranca.navigationlab

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.TaskStackBuilder
import androidx.navigation.NavController
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

            val key = "android-support-nav:controller:deepLinkIds"

            val ids = intArrayOf(R.id.fragmentOne, R.id.fragmentTwo/*, R.id.fragmentThree*/)
//
//            val intent = Intent(this, MainActivity::class.java).apply {
//                putExtra(key, ids)
//            }
//            startActivity(Intent(intent))

            controller.createDeepLink().setDestination(R.id.fragmentThree).createTaskStackBuilder().run {
                editIntentAt(0)?.putExtra(key, ids)
                startActivities()
            }

            //controller.navigate(R.id.action_global_fragmentThree)
        }
    }

    override fun onBackPressed() {
        super.onBackPressed()
        index -= 1
    }


}
