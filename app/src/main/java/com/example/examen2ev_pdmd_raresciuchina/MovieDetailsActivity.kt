package com.example.examen2ev_pdmd_raresciuchina

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.examen2ev_pdmd_raresciuchina.databinding.ActivityMovieDetailsBinding

class MovieDetailsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMovieDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var pelicula = intent.getSerializableExtra("pelicula")as Movie

        binding.atras.setOnClickListener {
            val intent = Intent(this,MovieTitleActivity::class.java)
            startActivity(intent)
        }
        
        binding.continuar.setOnClickListener { 
            
            if (binding.NombreDirector.text.isNotEmpty() &&
                binding.AnyoPelicula.text.isNotEmpty() &&
                binding.AnyoPelicula.text.toString().toInt() > 0){

                pelicula.nombreDirector = binding.NombreDirector.text.toString()
                pelicula.anyoLanzamiento = binding.AnyoPelicula.text.toString().toInt()

                val intent = Intent(this,MovieDisplayActivity::class.java)
                intent.putExtra("pelicula",pelicula)

                startActivity(intent)
            }else
                Toast.makeText(this, "Rellena correctamente los campos", Toast.LENGTH_SHORT).show()
            
            
        }

    }
}