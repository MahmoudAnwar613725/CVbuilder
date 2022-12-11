package com.course.cvbuilder.ui.main.work

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.course.cvbuilder.R
import edu.miu.CVBuilderApp.data.Work
import edu.miu.walmartlogin.adapter.WorkAdapter


/**
 * A simple [Fragment] subclass.
 * Use the [WorkFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class WorkFragment : Fragment(R.layout.fragment_work),AddworkListner {
    private var workList = mutableListOf<Work>()
    private lateinit var adapter: WorkAdapter
    private lateinit var recyclerView: RecyclerView
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        recyclerView = view.findViewById(R.id.recycler_view)
        if (context != null) {
            workList = mutableListOf(
                Work(
                    "Verizon",
                    "Android Developer",
                    "2022 - Present",
                    R.drawable.verizon
                ),
                Work(
                    "MIU",
                    "Backend-developer student",
                    "2021-2022",
                    R.drawable.miu
                ),
                Work(
                    "Ultimate Solutions",
                    "Android Developer",
                    "2017 - 2021",
                    R.drawable.ultimate
                ),
                Work(
                    "Trust Training Academy",
                    ".NET developer and instructor",
                    "2014 - 2017",
                    R.drawable.trust
                ),
            )
            setupRecyclerView()
        }

        val fab: View = view.findViewById(R.id.fab)
        fab.setOnClickListener { showWorkDialog() }
    }

    private fun setupRecyclerView() {
        if (::recyclerView.isInitialized) {
            recyclerView.layoutManager = LinearLayoutManager(context)
            adapter = WorkAdapter(requireContext(), workList)
            recyclerView.adapter = adapter
        }
    }

    private fun showWorkDialog() {
           val dialog = WorkDialog()
        dialog.setWorlListner(this)
            dialog.show(parentFragmentManager, WorkDialog::class.java.name)
    }

    @SuppressLint("NotifyDataSetChanged")
    override fun onAddWOrk(work: Work) {
        workList.add(work)
        if (::adapter.isInitialized) {
            adapter.notifyDataSetChanged()
        } else {
            setupRecyclerView()
        }
    }
}