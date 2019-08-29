package com.fabianofranca.navigationlab


import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

class FragmentThree : Fragment() {

    init {
        println("===> Init - ${this::class.java.simpleName}")
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)

        println("===> Attach - ${this::class.java.simpleName}")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        println("===> Create - ${this::class.java.simpleName}")
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        println("===> CreateView - ${this::class.java.simpleName}")
        return inflater.inflate(R.layout.fragment_fragment_three, container, false)
    }

}
