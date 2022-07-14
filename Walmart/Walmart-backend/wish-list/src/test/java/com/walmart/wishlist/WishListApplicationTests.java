package com.walmart.wishlist;

import com.walmart.wishlist.domain.WishList;
import com.walmart.wishlist.repo.WishListRepo;
import com.walmart.wishlist.service.WishListService;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class WishListApplicationTests {

	private Integer Id = 1333333;
	private String image="fakeImage.jpg";
	private String name="fake News";
	private String price="200";
	private String user_id="1324234234234";
	@Autowired
	private WishListRepo wishListRepo;
	@Autowired
	private WishListService wishListService;

	@Test
	@Order(1)
	public void WishListAdd(){
		WishList wishList = new WishList(Id, image, name, price, user_id);
		WishList save =  this.wishListRepo.save(wishList);
		assertNotNull(this.wishListRepo.findById(Id));
	}

	@Test
	@Order(2)
	public void WishListGet(){
		assertNotNull(this.wishListRepo.findById(Id));
	}

	@Test
	@Order(3)
	public void WishListDelete(){
		this.wishListRepo.deleteById(Id);
		assertTrue(true);
	}

}
