package com.codingdojo.pokebook.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.pokebook.models.Pokebook;

@Repository
public interface ExpenseRepository extends CrudRepository<Pokebook, Long> {
	List<Pokebook> findAll();
}
