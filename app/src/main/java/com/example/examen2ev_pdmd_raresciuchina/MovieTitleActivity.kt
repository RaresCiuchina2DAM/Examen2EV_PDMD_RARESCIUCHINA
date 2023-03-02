package com.example.examen2ev_pdmd_raresciuchina

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.examen2ev_pdmd_raresciuchina.databinding.ActivityMovieTitleBinding

class MovieTitleActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMovieTitleBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var pelicula = Movie()


        binding.continuar.setOnClickListener {
            if (binding.TituloPelicula.text.isNotEmpty() &&
                binding.duracionMinutos.text.isNotEmpty() &&
                binding.duracionMinutos.text.toString().toInt() > 0
                && binding.idPelicula.text.isNotEmpty()
            ){
                val intent = Intent(this, MovieDetailsActivity::class.java)
                pelicula.duracionMinutos = binding.duracionMinutos.text.toString().toInt()
                pelicula.tituloPelicula = binding.TituloPelicula.text.toString()
                pelicula.IdPelicula = binding.idPelicula.text.toString().toInt()
                intent.putExtra("pelicula",pelicula)
                startActivity(intent)
            }else Toast.makeText(this, "Rellene correctamente todos los campos", Toast.LENGTH_SHORT).show()
        }


    }
}