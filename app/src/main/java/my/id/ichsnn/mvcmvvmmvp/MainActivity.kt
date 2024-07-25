package my.id.ichsnn.mvcmvvmmvp

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.appcompat.app.AppCompatActivity
import my.id.ichsnn.mvcmvvmmvp.databinding.ActivityMainBinding
import my.id.ichsnn.mvcmvvmmvp.presenters.MainPresenter
import my.id.ichsnn.mvcmvvmmvp.views.MainView

class MainActivity : AppCompatActivity(), MainView {
    private lateinit var binding: ActivityMainBinding
    private lateinit var presenter: MainPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        presenter = MainPresenter(this)
        initView()
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
                    presenter.calculateTemperature(s.toString())
                }
            })
        }
    }

    override fun showReaumur(reaumur: String) {
        binding.inputReaumur.setText(reaumur)
    }

    override fun showFahrenheit(fahrenheit: String) {
        binding.inputFahrenheit.setText(fahrenheit)
    }
}