package com.zpx.cadastroservicos.services;

import com.zpx.cadastroservicos.entities.Servico;
import com.zpx.cadastroservicos.repositories.ServicoRepository;
import jakarta.persistence.Entity;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServicoService {

    @Autowired
    private ServicoRepository servicoRepository;


    public List<Servico> findAll () {
        return servicoRepository.findAll();
    }

    public List<Servico> findAllPaymentsPendents(){
        return servicoRepository.findAllPaymentsPendents();
    }

    public List<Servico> findAllPaymentsCanceleds(){
        return servicoRepository.findAllPaymentsCanceleds();
    }

    public Optional<Servico> findById (Long id) {
        return servicoRepository.findById(id);
    }

    @Transactional
    public Servico create (Servico objServico) {
        if (objServico.getValorPago() == null || objServico.getValorPago() == 0 || objServico.getDataPagamento() == null) {
            objServico.setStatus("pendente");
        }
        else {
            objServico.setStatus("realizado");
        }
        return servicoRepository.save(objServico);
    }

    @Transactional
    public Servico update (Servico objServico) {
        if (objServico.getValorPago() != null && objServico.getValorPago() > 0 && objServico.getDataPagamento() != null) {
            objServico.setStatus("realizado");
        }
        return servicoRepository.save(objServico);
    }

    @Transactional
    public void delete (Long id) {
       Optional<Servico> newObj = servicoRepository.findById(id);
       servicoRepository.delete(newObj.get());
    }

    @Transactional
    public void cancelServico (Long id) {
        Servico newObj = servicoRepository.findById(id).get();
        newObj.setStatus("cancelado");
        servicoRepository.save(newObj);
    }
}
