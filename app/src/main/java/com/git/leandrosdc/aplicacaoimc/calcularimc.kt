package com.git.leandrosdc.aplicacaoimc

import android.icu.math.MathContext
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.git.leandrosdc.aplicacaoimc.databinding.FragmentCadastroUsuarioBinding
import com.git.leandrosdc.aplicacaoimc.databinding.FragmentCalcularimcBinding
import java.text.DecimalFormat
import kotlin.math.roundToInt
import kotlin.math.roundToLong

class calcularimc : Fragment() {

    private var binding:FragmentCalcularimcBinding? = null


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCalcularimcBinding.inflate(inflater, container, false)
        return binding?.root
    }



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var peso: Double? = arguments?.getDouble("pesoUsuario")
        var altura: Double? = arguments?.getDouble("alturaUsuario")

        var imc:Double = calcularImc(peso!!,altura!!)


        if(imc <= 18.5){
            binding?.textoDetalhe?.text = "Magreza, quando o resultado é menor que 18,5 kg/m2;"
        }else if(imc > 18.5 && imc <= 24.9){
            binding?.textoDetalhe?.text = "Normal, quando o resultado está entre 18,5 e 24,9 kg/m2;"
        }else if(imc > 24.9 && imc <= 30){
            binding?.textoDetalhe?.text = "Sobrepeso, quando o resultado está entre 24,9 e 30 kg/m2;"
        }else if(imc > 30){
            binding?.textoDetalhe?.text = "Obesidade, quando o resultado é maior que 30 kg/m2;"
        }else{
            binding?.textoDetalhe?.text = "ERRO"
        }

        binding?.textoResposta?.text = imc.toString()
        binding?.textoNome?.text = "Nome: " + arguments?.getString("nomeUsuario")
        binding?.textoAltura?.text = "Altura: " + arguments?.getDouble("alturaUsuario").toString()
        binding?.textoPeso?.text = "Peso: " + arguments?.getDouble("pesoUsuario").toString()
        binding?.textoGenero?.text = "Genero: " + arguments?.getString("generoUsuario")

    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}

fun calcularImc(peso:Double, altura:Double):Double{
    return peso/(altura * altura).roundToInt()
}