package com.example.examen2ev_pdmd_raresciuchina

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.examen2ev_pdmd_raresciuchina.databinding.ActivityMovieDisplayBinding

class MovieDisplayActivity : AppCompatActivity() {

    private var listaid = mutableListOf<Int>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMovieDisplayBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var pelicula = intent.getSerializableExtra("pelicula") as Movie


        listaid.add(pelicula.IdPelicula)

        binding.Buscar.setOnClickListener {
            if (listaid.contains(binding.editTextTextPersonName.text.toString().toInt())){

                binding.DuracionMinutos.text = pelicula.duracionMinutos.toString()
                binding.NombredelDirector.text = pelicula.nombreDirector.toString()
                binding.TituloPelicula.text = pelicula.tituloPelicula
                binding.anyoLanzamiento.text = pelicula.anyoLanzamiento.toString()
            }else Toast.makeText(this, "El ID de la pelicula buscada no existe", Toast.LENGTH_SHORT).show()

        }


        binding.BorrarPelicula.setOnClickListener {
            listaid.remove(binding.editTextTextPersonName.text.toString().toInt())

            binding.DuracionMinutos.text = "0"
            binding.NombredelDirector.text = ""
            binding.TituloPelicula.text = ""
            binding.anyoLanzamiento.text = "0"

            Toast.makeText(this, "La pelicula seleccionada se ha borrado correctamente", Toast.LENGTH_SHORT).show()
            binding.BorrarPelicula.isEnabled =false
            binding.Buscar.isEnabled = false
        }



        binding.button.setOnClickListener {
            val intent = Intent(this,MovieTitleActivity::class.java)
            startActivity(intent)
        }





    }
}