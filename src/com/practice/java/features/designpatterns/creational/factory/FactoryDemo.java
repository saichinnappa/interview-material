package com.practice.java.features.designpatterns.creational.factory;

public class FactoryDemo {

	public static void main(String[] args) {
		Website site = WebsiteFactory.getWebsite(WebsiteType.BLOG);

//		Shop shop = new Shop();
//		shop.createWebsite();
//		System.out.println(shop.getPages());
		
		System.out.println(site.getPages());

		site = WebsiteFactory.getWebsite(WebsiteType.SHOP);

		System.out.println(site.getPages());
	}

}
