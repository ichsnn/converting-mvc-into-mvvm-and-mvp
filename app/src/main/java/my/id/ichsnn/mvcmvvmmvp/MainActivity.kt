package my.id.ichsnn.mvcmvvmmvp

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import my.id.ichsnn.mvcmvvmmvp.databinding.ActivityMainBinding
import my.id.ichsnn.mvcmvvmmvp.viewmodels.MainViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initViewModel()
        initView()
        observeTemperature()
    }

    private fun initViewModel() {
        viewModel = ViewModelProvider(this)[MainViewModel::class.java]
    }

    private fun initView() {
        binding.apply {
            inputCelsius.addTextChangedListener(object : TextWatcher {
                override fun beforeTextChanged(
                    s: CharSequence?,
                    start: Int,
                    count: Int,
                    after: Int
                ) {
                }

                override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}

                override fun afterTextChanged(s: Editable?) {
                    viewModel.setCelsius(s.toString())
                }
            })
        }
    }

    private fun observeTemperature() {
        viewModel.getCelsius().observe(this) { celsius ->
            binding.apply {
                inputReaumur.setText(celsius.toReaumur().toString())
                inputFahrenheit.setText(celsius.toFahrenheit().toString())
            }
        }
    }

}