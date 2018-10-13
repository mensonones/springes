package com.spring.es.springes;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AlunoRepository extends ElasticsearchRepository<Aluno, String> {

    List<Aluno> findByNome(String nome);
    Page<Aluno> findByNome(String nome, Pageable pageable);
    List<Aluno> findByIdade(int idade);

}
