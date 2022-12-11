package com.course.cvbuilder.ui.main.aboutme

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.course.cvbuilder.R


/**
 * A simple [Fragment] subclass.
 * Use the [AboutmeFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class AboutmeFragment : Fragment() {
    // TODO: Rename and change types of parameters

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_aboutme, container, false)
    }


}