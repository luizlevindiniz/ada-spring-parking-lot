package org.example.estacionamento.service;

import org.example.estacionamento.model.Veiculo;
import org.example.estacionamento.repository.VeiculoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VeiculoService {

    private final VeiculoRepository repository;


    public VeiculoService(VeiculoRepository repository) {
        this.repository = repository;
    }

    public Veiculo novoVeiculo(Veiculo veiculo){
        // verificar se ja existe
        boolean veiculoJaExiste = repository.existsById(veiculo.getPlaca());

        if(veiculoJaExiste){
            throw new RuntimeException();
        }

        // salvar se Ok
        return repository.save(veiculo);
    }

    public Veiculo alterarVeiculo(Veiculo veiculo){
        // verificar se ja existe
        boolean veiculoJaExiste = repository.existsById(veiculo.getPlaca());

        if(!veiculoJaExiste){
            throw new RuntimeException();
        }

        // salvar se Ok
        return repository.save(veiculo);
    }

    public List<Veiculo> listarVeiculos(){
        return repository.findAll();
    }

    public void deletarVeiculo(String placa){
       repository.deleteById(placa);
    }

}
