package com.forpus.wayfindingdop

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MapActivity : AppCompatActivity() {

    private lateinit var customMapView: CustomMapView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_map)

        customMapView = findViewById(R.id.customMapView)

        val setLocationButton: Button = findViewById(R.id.button_set_location)
        setLocationButton.setOnClickListener {
            // Aquí puedes implementar la lógica para establecer la ubicación del usuario
            // Por ejemplo, agregar un marcador en una posición específica
            customMapView.addMarker(200f, 200f)  // Coordenadas de ejemplo
        }
    }
}
