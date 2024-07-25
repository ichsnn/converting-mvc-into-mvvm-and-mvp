package my.id.ichsnn.mvcmvvmmvp

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.appcompat.app.AppCompatActivity
import my.id.ichsnn.mvcmvvmmvp.controllers.MainController
import my.id.ichsnn.mvcmvvmmvp.databinding.ActivityMainBinding
import my.id.ichsnn.mvcmvvmmvp.models.Celsius
import my.id.ichsnn.mvcmvvmmvp.views.MainView

class MainActivity : AppCompatActivity(), MainView {
    private lateinit var binding: ActivityMainBinding
    private lateinit var controller: MainController
    private lateinit var model: Celsius

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        controller = MainController(this)
        model = Celsius.getInstance()

        initView()
        observeModel()
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
                    controller.calculateTemperature()
                }
            })
        }
    }

    private fun observeModel() {
        model.getReaumur().observe(this) { reaumur ->
            binding.inputReaumur.setText(reaumur.toString())
        }
        model.getFahrenheit().observe(this) { fahrenheit ->
            binding.inputFahrenheit.setText(fahrenheit.toString())
        }
    }

    override fun getCelsius(): String {
        return binding.inputCelsius.text.toString()
    }
}