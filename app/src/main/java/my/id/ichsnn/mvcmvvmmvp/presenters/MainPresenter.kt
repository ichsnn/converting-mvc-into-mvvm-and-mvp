package my.id.ichsnn.mvcmvvmmvp.presenters

import my.id.ichsnn.mvcmvvmmvp.models.Celsius
import my.id.ichsnn.mvcmvvmmvp.views.MainView

class MainPresenter(private var view: MainView) {
    fun calculateTemperature(celsius: String) {
        var celsiusTemp = celsius
        if (celsiusTemp.isEmpty()) {
            celsiusTemp = "0"
        }
        val parsedCelsius = celsiusTemp.toDouble()

        val model = Celsius.getInstance()
        model.setCelsius(parsedCelsius)

        val fahrenheit = model.toFahrenheit().toString()
        val reaumur = model.toReaumur().toString()

        view.showReaumur(reaumur)
        view.showFahrenheit(fahrenheit)
    }
}