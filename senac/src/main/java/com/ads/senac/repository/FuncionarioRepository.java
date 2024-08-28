package com.ads.senac.repository;

import com.ads.senac.model.Funcionario;
import com.ads.senac.model.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {

    boolean existsByPessoa(Pessoa pessoa);
}
