package com.codingdojo.pokebook.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingdojo.pokebook.models.Pokebook;
import com.codingdojo.pokebook.repositories.ExpenseRepository;

@Service
public class ExpenseService {
	@Autowired
	private ExpenseRepository expenseRepository;
	
	public ExpenseService(ExpenseRepository expenseRepository) {
		this.expenseRepository = expenseRepository;
	}
	
	// Create expense
	public Pokebook createExpense(Pokebook expense) {
		return expenseRepository.save(expense);
	}
	
	// Retrieve all expenses
	public List<Pokebook> allExpenses() {
		return expenseRepository.findAll();
	}
	
	// Retrieve one expense
	public Pokebook findExpense(Long id) {
		Optional<Pokebook> optionalExpense = expenseRepository.findById(id);
		if(optionalExpense.isPresent()) {
			return optionalExpense.get();
		} else {
			return null;
		}
	}
	
	// Update
	public Pokebook updateExpense(Long id, Pokebook expense) {
		if(expenseRepository.findById(id).isPresent()) {
			Pokebook ex = expenseRepository.findById(id).get();
			
			ex.setAmount(expense.getAmount());
			ex.setExpense(expense.getExpense());
			ex.setVendor(expense.getVendor());
			ex.setDescription(expense.getDescription());
			
			return expenseRepository.save(ex);
		}
		return null;
	}
	
	// Delete
	public void deleteExpense(Long id) {
		expenseRepository.deleteById(id);
	}
}
