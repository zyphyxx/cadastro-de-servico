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
    public List<Servico> findAll () {
        return servicoService.findAll();
    }

    @GetMapping("/pagamentoPendente")
    public List<Servico> findAllPaymentsPendents(){
        return servicoService.findAllPaymentsPendents();
    }

    @GetMapping("/cancelados")
    public List<Servico> findAllPaymentsCanceleds(){
        return servicoService.findAllPaymentsCanceleds();
    }

    @PostMapping("/")
    public Servico create (@RequestBody Servico objServico) {
        return servicoService.create(objServico);
    }

    @PutMapping("/")
    public Servico update (@RequestBody Servico objServico) {
        return servicoService.update(objServico);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
        servicoService.delete(id);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/{id}")
    public ResponseEntity<Void> cancelServico (@PathVariable Long id) {
        servicoService.cancelServico(id);
        return ResponseEntity.ok().build();
    }


    }
