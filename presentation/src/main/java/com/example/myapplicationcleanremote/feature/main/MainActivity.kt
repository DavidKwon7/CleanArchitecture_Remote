package com.example.myapplicationcleanremote.feature.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import com.example.myapplicationcleanremote.R
import com.example.myapplicationcleanremote.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        initRecyclerView()
        initLiveData()
        clickBtn()
    }

    private fun initRecyclerView() {
        binding.recyclerView.adapter = MainAdapter()
    }

    private fun initLiveData() {
        viewModel.githubList.observe(this) {
            (binding.recyclerView.adapter as MainAdapter).setItems(it)
        }
    }

    private fun clickBtn() {
        binding.submitBtn.setOnClickListener {
            val owner = binding.ownerEditText.text.toString()
            viewModel.getGithubRepositories(owner)
        }
    }
}