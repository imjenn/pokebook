package com.codingdojo.pokebook.controllers;

//import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.codingdojo.pokebook.models.Pokebook;
import com.codingdojo.pokebook.services.ExpenseService;

@Controller
public class ExpenseController {
	public ExpenseController(ExpenseService expenseService) {
		this.serv = expenseService;
	}
	
	@Autowired
	private ExpenseService serv;
	
	// Retrieve all expenses
	@GetMapping("/expenses")
	public String index(@ModelAttribute("ex") Pokebook expense, Model model) {
		model.addAttribute("expenses", serv.allExpenses());
		return "index.jsp";
	}
	
	// Retrieve one expense
	@GetMapping("/expenses/{id}")
	public String show(Model model, @PathVariable("id") Long id) {
		Pokebook expense = serv.findExpense(id);
		model.addAttribute("expense", expense);
		return "show.jsp";
	}
	
	// Create
	@PostMapping("/expenses")
	public String create(@Valid @ModelAttribute("ex") Pokebook expense, BindingResult result, Model model) {
		if (result.hasErrors()) {
			model.addAttribute("expenses", serv.allExpenses());
			return "index.jsp";
		} else {
			serv.createExpense(expense);
			return "redirect:/expenses";
		}
	}
	
	// Update 
	@RequestMapping("/expenses/{id}/edit")
	public String edit(@PathVariable("id") Long id, Model model) {
		Pokebook expense = serv.findExpense(id);
		model.addAttribute("expense", expense);
		return "edit.jsp";
	}
	
	@RequestMapping(value="/expenses/{id}", method=RequestMethod.POST)
	public String update(@Valid @PathVariable("id") Long id, @ModelAttribute("ex") Pokebook expense, BindingResult result) {
		if (result.hasErrors()) {
			return "edit.jsp";
		} else {
			serv.updateExpense(id, expense);
			return "redirect:/expenses";
		}
	}
	
	// Delete
	@DeleteMapping(value="/expenses/{id}/delete")
	public String destroy(@PathVariable("id") Long id) {
		System.out.println("deleting...");
		serv.deleteExpense(id);
		return "redirect:/expenses";
	}
}
