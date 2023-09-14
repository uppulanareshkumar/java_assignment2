package com.ecart;

import java.util.ArrayList;
import java.util.List;

public class Cart {

	private List<Product> items;

	public Cart() {
		super();
		items = new ArrayList<>(); 
	}
	
	//Part-2(2)
	public void addToCart(Product product){
		items.add(product);
	}

	public List<Product> getItems() {
		return items;
	}

	public void setItems(List<Product> items) {
		this.items = items;
	}
	
	public double calculateTotal(List<Product> item){
		int sum=0;
		
		return item.stream()
		    .mapToDouble(p->p.getPrice())
		    .reduce(sum,(a,b)->a+b);
		
	}
	
	public double calculateTotalParallel(List<Product> item){
		int sum=0;
		
		return item.parallelStream()
		    .mapToDouble(p->p.getPrice())
		    .reduce(sum,(a,b)->a+b);	
	}
}