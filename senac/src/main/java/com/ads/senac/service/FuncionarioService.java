package com.ads.senac.service;

import com.ads.senac.model.Funcionario;
import com.ads.senac.model.Pessoa;
import com.ads.senac.repository.FuncionarioRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FuncionarioService {

    @Autowired
    private FuncionarioRepository repository;

    public List<Funcionario> findAll() {
        return repository.findAll();
    }

    public Optional<Funcionario> findById(Long id) {
        return repository.findById(id);
    }

    public Funcionario save(Funcionario funcionario) {
        return repository.save(funcionario);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    public boolean existsByPessoa(Pessoa pessoa) {
        return repository.existsByPessoa(pessoa);
    }
}
