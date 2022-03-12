package com.example.financecal

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.financecal.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        // Envia dados para a próxima activity
        binding.btnCalc.setOnClickListener {
            if(binding.etValor.text.isNotEmpty() && binding.etQnt.text.isNotEmpty() && binding.etJuros.text.isNotEmpty()){
                val intent = Intent(this, RespActivity::class.java).apply {
                    putExtra(
                        "mode",
                        if (binding.rdbOptSimples.isChecked) "simples"
                        else "composto"
                    )
                    putExtra("valor", binding.etValor.text.toString())
                    putExtra("qnt", binding.etQnt.text.toString())
                    putExtra("juros", binding.etJuros.text.toString())
                }
                startActivity(intent)
            }
            else{
                Toast.makeText(this, R.string.err_vazio, Toast.LENGTH_LONG).show()
            }
        }

        // Limpa dados do EditText
        binding.btnClear.setOnClickListener {
            binding.etValor.setText("")
            binding.etQnt.setText("")
            binding.etJuros.setText("")
            binding.rdbOptSimples.isChecked = true
        }


    }
}