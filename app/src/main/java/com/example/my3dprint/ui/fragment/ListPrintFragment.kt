package com.example.my3dprint.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.example.my3dprint.R
import com.example.my3dprint.database.dao.AppDatabase
import com.example.my3dprint.database.dao.PrintDAO
import com.example.my3dprint.di.modules.daoModule
import com.example.my3dprint.model.Print
import com.example.my3dprint.ui.recyclerview.adapter.PrintListAdapter
import com.example.my3dprint.ui.viewmodel.PrintListViewModel
import kotlinx.android.synthetic.main.list_print.*
import org.koin.android.ext.android.inject
import org.koin.android.viewmodel.ext.android.viewModel
import java.lang.Appendable

class ListPrintFragment : Fragment() {

    private val viewModel: PrintListViewModel by viewModel()
    private val adapter: PrintListAdapter by inject()
    private val controller by lazy {
        findNavController()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        //getPrints()
    }

    private fun getPrints() {
        viewModel.getAllPrints().observe(
            this,
            Observer { printsFound ->
                printsFound?.let {
                    adapter.update(it)
                }
            })
    }

    private fun setUpRecyclerView() {
        adapter.whenClicked = { _ ->
            //Go to details of item selected
        }
        recyclerView.adapter = adapter
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(
            R.layout.list_print,
            container,
            false
        )
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //setUpRecyclerView()
    }
}