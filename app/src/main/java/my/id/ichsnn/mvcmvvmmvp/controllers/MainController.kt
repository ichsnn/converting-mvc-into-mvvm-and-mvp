package my.id.ichsnn.mvcmvvmmvp.controllers

import my.id.ichsnn.mvcmvvmmvp.models.Celsius
import my.id.ichsnn.mvcmvvmmvp.views.MainView

class MainController(private var view: MainView) {
    private var model: Celsius = Celsius.getInstance()

    fun calculateTemperature() {
        var celsius = view.getCelsius()
        if (celsius.isEmpty()) {
            celsius = "0"
        }
        val parsedCelsius = celsius.toDouble()
        model.setCelsius(parsedCelsius)

        model.toReaumur()
        model.toFahrenheit()
    }
}