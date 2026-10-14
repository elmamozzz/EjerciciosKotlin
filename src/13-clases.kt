import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

// Kotlin ofrece cuatro modificadores de visibilidad:

// public. Permite que la declaración sea accesible en todas partes.
// private. Permite que se pueda acceder a la declaración en la misma clase o archivo de origen.
// protected. Hace que la declaración sea accesible en subclases. 
// internal. Permite que se pueda acceder a la declaración en el mismo módulo.El modificador interno es
// similar al privado, pero puedes acceder a propiedades y métodos internos desde fuera de la clase,
// siempre y cuando lo hagas en el mismo módulo.

// open significa que la clase puede ser extendida por otras clases
// SmartDevice es la superclase
open class SmartDevice(val name: String, val category: String) {

    // Para definir los atributos se utiliza var y val según sean mutables o inmutables
    var deviceStatus = "online"
        protected set

    open val deviceType = "unknown"

    // Definición de métodos de la clase
    // Con open el metodo puede ser sobrescrito por el método turnOn() otra subclase
    open fun turnOn() {
        deviceStatus = "on"
    }

    open fun turnOff() {
        deviceStatus = "off"
    }
}

// Relacion SmartTvDevice IS-A SmartDevice
class SmartTvDevice(deviceName: String, deviceCategory: String) :
    SmartDevice(name = deviceName, category = deviceCategory) {

    override val deviceType = "Smart TV"

    private var speakerVolume by RangeRegulator(initialValue = 2, minValue = 0, maxValue = 100)

    private var channelNumber by RangeRegulator(initialValue = 1, minValue = 0, maxValue = 200)

    fun increaseSpeakerVolume() {
        speakerVolume++
        println("Speaker volume increased to $speakerVolume.")
    }

    fun nextChannel() {
        channelNumber++
        println("Channel number increased to $channelNumber.")
    }
    
    // override significa que el metodo turnOn() sobrescribe el método de la superclase
    // ejecuta el código TurnOn() de la superclase y el println adicional
    override fun turnOn() {
        super.turnOn()
        println(
            "$name is turned on. Speaker volume is set to $speakerVolume and channel number is " +
                "set to $channelNumber."
        )
    }

    override fun turnOff() {
        super.turnOff()
        println("$name turned off")
    }
}

// Relacion SmartLightDevice IS-A SmartDevice
class SmartLightDevice(deviceName: String, deviceCategory: String) :
    SmartDevice(name = deviceName, category = deviceCategory) {

    override val deviceType = "Smart Light"

    private var brightnessLevel by RangeRegulator(initialValue = 0, minValue = 0, maxValue = 100)

    fun increaseBrightness() {
        brightnessLevel++
        println("Brightness increased to $brightnessLevel.")
    }

    // override significa que el metodo turnOn() sobrescribe el método de la superclase
    override fun turnOn() {
        super.turnOn()
        brightnessLevel = 2
        println("$name turned on. The brightness level is $brightnessLevel.")
    }

    override fun turnOff() {
        super.turnOff()
        brightnessLevel = 0
        println("Smart Light turned off")
    }
}

// La clase SmartHome es una relacion HAS-A con las clases SmartTvDevice y SmartLightDevice
class SmartHome(
    val smartTvDevice: SmartTvDevice,
    val smartLightDevice: SmartLightDevice
) {

    var deviceTurnOnCount = 0
        private set

    fun turnOnTv() {
        deviceTurnOnCount++
        smartTvDevice.turnOn()
    }

    fun turnOffTv() {
        deviceTurnOnCount--
        smartTvDevice.turnOff()
    }

    fun increaseTvVolume() {
        smartTvDevice.increaseSpeakerVolume()
    }

    fun changeTvChannelToNext() {
        smartTvDevice.nextChannel()
    }

    fun turnOnLight() {
        deviceTurnOnCount++
        smartLightDevice.turnOn()
    }

    fun turnOffLight() {
        deviceTurnOnCount--
        smartLightDevice.turnOff()
    }

    fun increaseLightBrightness() {
        smartLightDevice.increaseBrightness()
    }

    fun turnOffAllDevices() {
        turnOffTv()
        turnOffLight()
    }
}

// RangeRegulator es un interfaz de la clase ReadWriteProperty
class RangeRegulator(
    initialValue: Int,
    private val minValue: Int,
    private val maxValue: Int
) : ReadWriteProperty<Any?, Int> {

    var fieldData = initialValue

    override fun getValue(thisRef: Any?, property: KProperty<*>): Int {
        return fieldData
    }

    override fun setValue(thisRef: Any?, property: KProperty<*>, value: Int) {
        if (value in minValue..maxValue) {
            fieldData = value
        }
    }
}

fun main() {

    // En main se instancian objetos de clases definidas mediante relaciones IS-A con la superclase SmartDevice
    // El constructor implícito toma los parametros para inicializar los atributos de la clase
    var smartDevice: SmartDevice = SmartTvDevice("Android TV", "Entertainment")
    
    // Llamada al metodo de la clase
    smartDevice.turnOn()

    smartDevice = SmartLightDevice("Google Light", "Utility")
    smartDevice.turnOn()
}

