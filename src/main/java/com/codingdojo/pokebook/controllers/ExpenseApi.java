//package com.codingdojo.pokebook.controllers;
//
//import java.util.List;
//
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.codingdojo.pokebook.models.Pokebook;
//import com.codingdojo.pokebook.services.ExpenseService;
//
//@RestController
//public class ExpenseApi {
//	private final ExpenseService expenseService;
//	
//	public ExpenseApi(ExpenseService expenseService ) {
//		this.expenseService = expenseService;
//	}
//	
//	@RequestMapping("/api/expenses")
//	public List<Pokebook> index() {
//		return expenseService.allExpenses();
//	}
//	
//	@RequestMapping(value="/api/expenses", method=RequestMethod.POST)
//	public Pokebook create(@RequestParam(value="expense") String expense, @RequestParam(value="vendor") String vendor, @RequestParam(value="amount") Double amount, @RequestParam(value="description") String description) {
////		System.out.println(id);
//		System.out.println("----------------");
//		Pokebook expenses = new Pokebook(expense, vendor, amount, description);
//		return expenseService.createExpense(expenses);
//	}
//}
