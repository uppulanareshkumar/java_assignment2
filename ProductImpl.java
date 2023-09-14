package com.ecart;

import java.util.Comparator;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ProductImpl {

	public static void main(String args[]){
	//Part-1(1)
		List<Product> products = Stream.of(
				new Product(1, "Apple iPhone 13", 799.99, 4.5),
				new Product(2, "Samsung Galaxy S22", 749.99, 4.6),
				new Product(3, "Google Pixel 6", 699.99, 4.7),
				new Product(4, "Sony WH-1000XM4", 349.99, 4.8),
				new Product(5, "Apple MacBook Pro", 1299.99, 4.9),
				new Product(6, "Dell XPS 13", 1199.99, 4.4),
				new Product(7, "Amazon Echo Dot", 49.99, 4.2),
				new Product(8, "Apple Watch Series 7", 399.99, 4.6),
				new Product(9, "Bose QuietComfort 35 II", 299.99, 4.7),
				new Product(10, "GoPro HERO10 Black", 499.99, 4.5))
				.collect(Collectors.toList());
		
		products.stream()
		//Part-1(2)
		      .filter(product->product.getPrice()<500.0) //filter products with price >500.0
		      .filter(p->p.getRating()>4.5) //filter products with rating>4.5
		      .sorted(Comparator.comparingDouble(p->p.getPrice())) //sorting products using price
		      //.sorted(Comparator.comparingDouble(p->p.getRating())) //sorting products using rating
		      .forEach(System.out::println);
		
		//Part-1(3)
		List<String> names = products.stream()
				                     .map(p->p.getName()) //transform list of products to list of names
				                     .collect(Collectors.toList());
		System.out.println(names);
		
		//Part-2(1)
		DoubleSummaryStatistics stat = products.stream()
				                               .collect(Collectors.summarizingDouble(Product::getPrice));
		System.out.println("Count :"+stat.getCount()); //get the count of products
		System.out.println("Sum :"+stat.getSum()); //get the sum of prices of products
		System.out.println("Min :"+stat.getMin()); //get the min of prices of products
		System.out.println("Max :"+stat.getMax()); //get the max of prices of products
		System.out.println("Average :"+stat.getAverage()); //get the average of prices of products
		
		//Part-2(3)
		Map<Double,List<Product>> productsByRating = products.stream()
				                  .collect(Collectors.groupingBy(Product::getRating)); //grouping the products using their ratings
		productsByRating.forEach((key,value)->{
			System.out.println("Rating: "+key+", List of Products: "+value);
		});
		
		Map<Boolean,List<Product>> productsPartByPrice = products.stream()
				                   .collect(Collectors.partitioningBy(p->p.getPrice()>799.0)); //partitioning the products using their price
		productsPartByPrice.forEach((key,value)->{
			System.out.println(">799.0: "+key+", Products: "+value);
		});
	}

}