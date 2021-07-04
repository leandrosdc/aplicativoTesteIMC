package com.git.leandrosdc.aplicacaoimc

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.git.leandrosdc.aplicacaoimc.databinding.FragmentCadastroUsuarioBinding

class cadastroUsuario : Fragment() {

    private var binding: FragmentCadastroUsuarioBinding? = null


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentCadastroUsuarioBinding.inflate(inflater, container, false)
        return binding?.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var genero:String? = null


        binding?.buttonCalcular?.setOnClickListener(){

            if(binding?.radioButton1?.isChecked == true) {
                genero = binding?.radioButton1?.text.toString()
            }else{
                genero = binding?.radioButton2?.text.toString()
            }

            val bundle = Bundle().apply {
                putString("nomeUsuario", binding?.txtNomeEscrito?.text.toString())
                putDouble("alturaUsuario", binding?.txtAlturaEscrito?.text.toString().toDouble())
                putDouble("pesoUsuario", binding?.txtPesoEscrito?.text.toString().toDouble())
                putString("generoUsuario", genero.toString())
            }
            findNavController().navigate(R.id.action_cadastroUsuario_to_calcularimc,bundle)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

}