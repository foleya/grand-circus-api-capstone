package co.grandcircus.apicapstone;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import co.grandcircus.apicapstone.dao.FavoriteDao;
import co.grandcircus.apicapstone.entity.Favorite;
import co.grandcircus.apicapstone.model.EventResults;

@Controller
public class ApiController {
	
	@Autowired
	private FavoriteDao favoriteDao;
	
	private HashMap<String, String> categoryIdMap = new HashMap<String, String>();

	@RequestMapping("/")
    public ModelAndView getEventResults(@RequestParam(value="keyword", required=false) String keyword,
    									@RequestParam(value="category", required=false) String category,
    									@RequestParam(value="city", required=false) String city) {
		
		categoryIdMap.put("Music", "KZFzniwnSyZfZ7v7nJ");
		categoryIdMap.put("Arts & Theater", "KZFzniwnSyZfZ7v7na");
		categoryIdMap.put("Sports", "KZFzniwnSyZfZ7v7nE");
		categoryIdMap.put("Miscellaneous", "KZFzniwnSyZfZ7v7n1");

        ModelAndView mav = new ModelAndView("index");

        RestTemplate restTemplate = new RestTemplate();
        
        String url = "https://app.ticketmaster.com/discovery/v2/events.json?apikey=Y6rrlpSla8nKQVOyEemmAD2brKh8OlOG";
        
        if (city!=null && !city.isEmpty()) {
        	String cityParam = "&city=" + city;
        	url += cityParam;
        	
        }
        
        if (category!=null && !category.isEmpty()) {
        	String categoryParam = "&classificationId=" + categoryIdMap.get(category);
        	url += categoryParam;
        	
        }
        
        if (keyword!=null && !keyword.isEmpty()) {
        	String keywordParam = "&keyword=" + keyword;
        	url += keywordParam;
          	
        }
        
        EventResults results = restTemplate.getForObject(url, EventResults.class);
        
        if (results.getEventsShell()!=null) {   
	        mav.addObject("results", results.getEventsShell().getEvents());
        }
        
        mav.addObject("categories", categoryIdMap.keySet());

        return mav;

    }
	
	@RequestMapping("details/{eventId}")
	public ModelAndView showEventDetails(@PathVariable("eventId") String eventId) {
		
		ModelAndView mav = new ModelAndView("/details");

        RestTemplate restTemplate = new RestTemplate();
        
        String url = "https://app.ticketmaster.com/discovery/v2/events.json?" +
        		  "apikey=Y6rrlpSla8nKQVOyEemmAD2brKh8OlOG" +
        		  "&id=" + eventId;
        
        EventResults results = restTemplate.getForObject(url, EventResults.class);
        
        mav.addObject("results", results.getEventsShell().getEvents());
        
        return mav;
		
	}
	
	@RequestMapping("add-favorite")
	public ModelAndView addFavorite(@RequestParam("name") String name,
									@RequestParam("category") String category,
									@RequestParam("url") String url,
									@RequestParam("city") String city,
									@RequestParam("state") String state,
									@RequestParam("date") String date,
									@RequestParam("eventId") String eventId,
									RedirectAttributes redir) {
		
		Favorite favorite = new Favorite();
		
		favorite.setName(name);
		favorite.setCategory(category);
		favorite.setUrl(url);
		favorite.setCity(city);
		favorite.setState(state);
		favorite.setDate(date);
		favorite.setEventId(eventId);
		
		favoriteDao.save(favorite);

		redir.addFlashAttribute("message", "Added to favorites!");
		ModelAndView mav = new ModelAndView("redirect:/");
		
		return mav;
		
	}
	
	@RequestMapping("/favorites")
	public ModelAndView showFavorites () {
		return new ModelAndView("favorites", "results", favoriteDao.findAll());
	}
	
	@RequestMapping("/delete-favorite")
	public ModelAndView deleteFavorite(@RequestParam("id") Long id,
									   RedirectAttributes redir) {
		favoriteDao.deleteById(id);
		redir.addFlashAttribute("message", "Deleted from favorites.");
		ModelAndView mav = new ModelAndView("redirect:/favorites");
		return mav;
	}
	
}
