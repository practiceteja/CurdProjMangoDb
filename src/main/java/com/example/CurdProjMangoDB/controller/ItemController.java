package com.example.CurdProjMangoDB.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.CurdProjMangoDB.model.Item;
import com.example.CurdProjMangoDB.service.ItemService;

@RestController
@RequestMapping("/api/items")
public class ItemController {

	@Autowired
	private ItemService itemService;

	@GetMapping("/hello")
	public String getWishMessage() {
		return "Hello, I am an item wish message";
	}

	@GetMapping
	public List<Item> getAllItems() {
		return itemService.getAllItems();
	}

	@GetMapping("/{id}")
	public ResponseEntity<Item> getItemById(@PathVariable String id) {
		Item item = itemService.getItemById(id);
		if (item != null) {
			return ResponseEntity.ok(item);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@PostMapping
	public Item createItem(@RequestBody Item item) {
		return itemService.createItem(item);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Item> updateItem(@PathVariable String id, @RequestBody Item item) {
		Item updatedItem = itemService.updateItem(id, item);
		if (updatedItem != null) {
			return ResponseEntity.ok(updatedItem);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteItem(@PathVariable String id) {
		itemService.deleteItem(id);
		return ResponseEntity.noContent().build();
	}
}
