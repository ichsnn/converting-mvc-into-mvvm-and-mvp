package my.id.ichsnn.mvcmvvmmvp.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import my.id.ichsnn.mvcmvvmmvp.models.Celsius

class MainViewModel : ViewModel() {
    private var _celsius: MutableLiveData<Celsius> = MutableLiveData()

    fun getCelsius(): LiveData<Celsius> = _celsius

    fun setCelsius(celsius: String) {
        var celsiusTemp = celsius
        if (celsiusTemp.isEmpty()) {
            celsiusTemp = "0"
        }
        val parsedCelsius = celsiusTemp.toDouble()

        val celsiusModel = Celsius.getInstance()
        celsiusModel.setCelsius(parsedCelsius)

        this._celsius.value = celsiusModel
    }
}