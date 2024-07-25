package my.id.ichsnn.mvcmvvmmvp.models

class Celsius {

    private var celsius: Double

    init {
        celsius = 0.0
    }

    fun setCelsius(celsius: Double) {
        this.celsius = celsius
    }

    fun toReaumur() = 0.8 * celsius


    fun toFahrenheit() = (1.8 * celsius) + 32

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