package com.ecart;

public class CartImpl {

	public static void main(String[] args) {
		//Part-2(2)
		Product p1 = new Product(1, "Apple iPhone 13", 799.99, 4.5);
		Product p2 = new Product(2, "Samsung Galaxy S22", 749.99, 4.6);
		Product p3 = new Product(3, "Google Pixel 6", 699.99, 4.7);
		
		Cart user = new Cart();
		
		user.addToCart(p1); //add products to the user's cart
		user.addToCart(p2);
		user.addToCart(p3);
		
		System.out.println(user.getItems()); //print the items in cart
		long startSeq = System.nanoTime();
		double cartTotalPrice = user.calculateTotal(user.getItems()); //calculate total cart price
		System.out.println("Cart Total Price :"+cartTotalPrice);
		long endSeq = System.nanoTime();
		long durationSeq = (endSeq-startSeq)/1000000 ; //duration in ms
		System.out.println("Sequential Search duration: "+durationSeq);
		
		//Part-3(2)
		long startPar = System.nanoTime();
		double cartTotalPriceParallel = user.calculateTotalParallel(user.getItems()); //calculate total cart price using parallel stream
		System.out.println("Cart Total Price :"+cartTotalPriceParallel);
		long endPar = System.nanoTime();
		long durationPar = (endPar-startPar)/1000000 ; //duration in ms
		System.out.println("Parallel Search Duration: "+durationPar);
	}

}