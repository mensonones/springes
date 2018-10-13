package com.spring.es.springes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
public class AlunoController {

    @Autowired
    private AlunoRepository alunoRepository;

    @RequestMapping("/")
    public String welcomeES() {
        return "Welcome to Spring Boot Elastic Search Example";
    }

    @GetMapping("/getAll")
    public List<Aluno> getAllAlunos() {
        List<Aluno> alunos = new ArrayList<>();
        for (Aluno aluno : this.alunoRepository.findAll()) {
            alunos.add(aluno);
        }
        return alunos;
    }

    @PostMapping("/save")
    public String saveAllAlunos() {
        alunoRepository.saveAll(Arrays.asList(
                new Aluno("1", "Aluno1","aluno1@mail.com", 20),
                new Aluno("2", "Aluno2","aluno2@mail.com", 19),
                new Aluno("3", "Aluno3","aluno3@mail.com", 18),
                new Aluno("4", "Aluno4","aluno4@mail.com", 17)));
        return "alunos salvos...";

}

    @DeleteMapping("/delete")
    public String deleteAllAlunos() {
        try {
            alunoRepository.deleteAll();
            return "alunos deletedos com sucesso!";
        }catch (Exception e){
            return "Falha ao deletar alunos";
        }
    }
}
