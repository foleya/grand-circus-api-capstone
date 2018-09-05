package co.grandcircus.apicapstone.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import co.grandcircus.apicapstone.entity.Favorite;


public interface FavoriteDao extends JpaRepository<Favorite, Long> {

//	//FOR JSP
//	@Query("SELECT DISTINCT city FROM Hotel")
//	List<String> findDistinctCities();
//	
//	@Query("SELECT DISTINCT pricePerNight FROM Hotel ORDER BY pricePerNight")
//	List<Integer> findDistinctPricesPerNight();
//	
//	List<Hotel> findByCityOrderByPricePerNight(String city);
//	
//	List<Hotel> findByCityAndPricePerNightLessThanEqualOrderByPricePerNight(String city, Integer price);
//	
//	//FOR API
//	List<Hotel> findAllByOrderByPricePerNight();
//	
//	Hotel findById(Integer id);
//	
//	List<Hotel> findByCityContaining(String city);
}
