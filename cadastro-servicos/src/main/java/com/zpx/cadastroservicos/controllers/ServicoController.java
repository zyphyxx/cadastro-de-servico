package com.zpx.cadastroservicos.controllers;

import com.zpx.cadastroservicos.entities.Servico;
import com.zpx.cadastroservicos.services.ServicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/servico")
public class ServicoController {

    @Autowired
    public ServicoService servicoService;

    @GetMapping("/")
    @CrossOrigin("http://localhost:3000")
    public List<Servico> findAll () {
        return servicoService.findAll();
    }

    @GetMapping("/pagamentoPendente")
    @CrossOrigin("http://localhost:3000")
    public List<Servico> findAllPaymentsPendents(){
        return servicoService.findAllPaymentsPendents();
    }

    @GetMapping("/cancelados")
    @CrossOrigin("http://localhost:3000")
    public List<Servico> findAllPaymentsCanceleds(){
        return servicoService.findAllPaymentsCanceleds();
    }

    @PostMapping("/")
    @CrossOrigin("http://localhost:3000")
    public Servico create (@RequestBody Servico objServico) {
        return servicoService.create(objServico);
    }

    @PutMapping("/")
    @CrossOrigin("http://localhost:3000")
    public Servico update (@RequestBody Servico objServico) {
        return servicoService.update(objServico);
    }

    @DeleteMapping("/{id}")
    @CrossOrigin("http://localhost:3000")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
        servicoService.delete(id);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/{id}")
    @CrossOrigin("http://localhost:3000")
    public ResponseEntity<Void> cancelServico (@PathVariable Long id) {
        servicoService.cancelServico(id);
        return ResponseEntity.ok().build();
    }


    }
