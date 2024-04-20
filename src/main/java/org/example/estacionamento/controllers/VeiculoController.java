package org.example.estacionamento.controllers;


import org.example.estacionamento.model.Veiculo;
import org.example.estacionamento.repository.VeiculoRepository;
import org.example.estacionamento.service.VeiculoService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/veiculo")
public class VeiculoController {

    private final VeiculoService service;

    public VeiculoController(VeiculoService service) {
        this.service = service;
    }


    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public void createVeiculo(@RequestBody Veiculo veiculo) {

        service.novoVeiculo(veiculo);
    }

    @GetMapping("/list")
    @ResponseStatus(HttpStatus.OK)
    public Iterable<Veiculo> listVeiculos() {
        return service.listarVeiculos();
    }


    @DeleteMapping("/delete")
    @ResponseStatus(HttpStatus.OK)
    public void deleteVeiculo(@RequestParam String placa) {

        service.deletarVeiculo(placa);
    }
}
