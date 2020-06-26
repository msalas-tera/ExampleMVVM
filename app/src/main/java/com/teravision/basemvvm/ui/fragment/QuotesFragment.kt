package com.teravision.basemvvm.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.teravision.basemvvm.R
import com.teravision.basemvvm.ui.viewmodel.QuotesViewModel
import kotlinx.android.synthetic.main.fragment_quotes.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class QuotesFragment : Fragment() {

    private val quotesViewModel: QuotesViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? =
        inflater.inflate(R.layout.fragment_quotes, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observeViewModel()
        floatingActionButton?.setOnClickListener {
            quotesViewModel.getQuotes()
        }
    }

    private fun observeViewModel() {
        quotesViewModel.run {
            onSuccess.observe(viewLifecycleOwner, Observer {
                tv_quote.text = it.quote
            })
            onError.observe(viewLifecycleOwner, Observer {
                Toast.makeText(context, it, Toast.LENGTH_SHORT).show()
            })
            loadingState.observe(viewLifecycleOwner, Observer {
                progress_circular?.visibility = if (it) View.VISIBLE else View.GONE
                tv_quote?.visibility = if (it) View.GONE else View.VISIBLE
            })
        }
    }
}