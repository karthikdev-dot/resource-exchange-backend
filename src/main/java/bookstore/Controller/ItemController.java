package bookstore.Controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import bookstore.DTOs.ItemResponseDto;
import bookstore.Entity.Item;
import bookstore.Services.ItemService;

@RestController
@RequestMapping("/api")

public class ItemController {

	
	@Autowired
	ItemService service;
	
	@PostMapping("/item")
	public Item saveItem(@RequestBody Item item) {
	    return service.saveItem(item);
	}

	@GetMapping("/get")
	public List<ItemResponseDto> getItem(@RequestParam String SearchText,
			@RequestParam Double userLat,
			@RequestParam Double userLon){
		return service.GetData(SearchText,userLat,userLon);
	}
}

