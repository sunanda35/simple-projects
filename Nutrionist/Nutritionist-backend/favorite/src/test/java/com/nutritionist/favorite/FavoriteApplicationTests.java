package com.nutritionist.favorite;

import com.nutritionist.favorite.domain.Favourite;
import com.nutritionist.favorite.repository.FavouriteRepository;
import com.nutritionist.favorite.service.DataService;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class FavoriteApplicationTests {

	@Autowired
	FavouriteRepository favouriteRepository;

	@Autowired
	DataService dataService;

	private int favId = 534358;
	private int userId=34345;

	@Test
	@Order(1)
	public void favoriteAdd(){
		int id = favId;
		String ids = ""+favId+"";
		Favourite fav = new Favourite(favId, ""+favId, ""+userId+"");
		var saveFav = favouriteRepository.save(fav);
		assertNotNull(favouriteRepository.findById(id).get());
	}

	@Test
	@Order(2)
	public void favoriteGet(){
		var favIds = "";
		var data = this.favouriteRepository.findAll();
		for (Favourite favouriteObj : data) {
			if(favIds!=""){
				favIds+=",";
			}
			favIds+=favouriteObj.getFoodIds();
		}
		var bookData = dataService.favConsumeApi("https://api.nal.usda.gov/fdc/v1/foods?fdcIds="+favIds+"&api_key=qqgiaSPX1eVDkb7mkUg3kSmptZZA1RZGphyVHQhh");
		assertTrue(!bookData.isEmpty());
	}

	@Test
	@Order(2)
	public void deleteFavorite(){
		favouriteRepository.deleteById(favId);
		var favIds = "";
		var data = this.favouriteRepository.findAll();
		for (Favourite favouriteObj : data) {
			if(favIds!=""){
				favIds+=",";
			}
			favIds+=favouriteObj.getFoodIds();
		}
		var bookData = dataService.favConsumeApi("https://api.nal.usda.gov/fdc/v1/foods?fdcIds="+favIds+"&api_key=qqgiaSPX1eVDkb7mkUg3kSmptZZA1RZGphyVHQhh");
		assertTrue(!bookData.isEmpty());
	}

}
