package com.spring.es.springes;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends ElasticsearchRepository<Student, String> {

    List<Student> findByName(String name);
    Page<Student> findByName(String name, Pageable pageable);
    List<Student> findByAge(int age);

}
