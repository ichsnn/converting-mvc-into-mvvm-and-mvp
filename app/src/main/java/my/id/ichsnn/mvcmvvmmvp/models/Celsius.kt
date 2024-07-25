package my.id.ichsnn.mvcmvvmmvp.models

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class Celsius {

    private var celsius: Double
    private var reaumur: MutableLiveData<Double>
    private var fahrenheit: MutableLiveData<Double>

    init {
        celsius = 0.0
        reaumur = MutableLiveData(0.0)
        fahrenheit = MutableLiveData(0.0)
    }

    fun setCelsius(celsius: Double) {
        this.celsius = celsius
    }

    fun getReaumur(): LiveData<Double> {
        return reaumur
    }

    fun getFahrenheit(): LiveData<Double> {
        return fahrenheit
    }


    fun toReaumur() {
        reaumur.value = 0.8 * celsius
    }

    fun toFahrenheit() {
        fahrenheit.value = (1.8 * celsius) + 32
    }

    companion object {
        private var instance: Celsius? = null

        fun getInstance(): Celsius {
            return instance ?: synchronized(this) {
                instance ?: Celsius().also {
                    instance = it
                }
            }
        }

    }
}