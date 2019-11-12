package test.course;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import test.course.cats.Cat;


@Repository
public class CatDAO {
	
	List <Cat> cats = new ArrayList<Cat>();
	
	public List<Cat> getCats() {
		return cats;
	}

	public void setCats(List<Cat> cats) {
		this.cats = cats;
	}

	public void addCat(Cat cat) {
		cats.add(cat);
		System.out.println("Dziękuję, dodałem kota do kolekcji!");
	}
	
	public Cat getCatById(Integer id) {
		if (id<cats.size()) {
			return cats.get(id);
		} else {
			return null;
		}
	}

}
