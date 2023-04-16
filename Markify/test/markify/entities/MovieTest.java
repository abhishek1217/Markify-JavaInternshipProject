package markify.entities;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import markify.constants.MovieGenre;
import markify.managers.BookmarkManager;

class MovieTest {

	@Test
	void test() {
		
		// Test 1: MovieGenre = "Horror", return false
		Movie movie = BookmarkManager.getinstance().createMovie(3000,"Citizen Kane","",1941,new String[] {"Orson Welles","Joseph Cotten"},new String[] {"Orson Welles"},MovieGenre.HORROR,8.5);
		
		boolean isKidFriendlyEligible = movie.isKidFriendlyEligible();
		
		assertFalse(isKidFriendlyEligible, "MovieGenre = 'Horror', isKidFriendlyEligible() must return false");
		
		
		// Test 2: MovieGenre = "Thriller", return false
		movie = BookmarkManager.getinstance().createMovie(3000,"Citizen Kane","",1941,new String[] {"Orson Welles","Joseph Cotten"},new String[] {"Orson Welles"},MovieGenre.THRILLERS,8.5);
		
		isKidFriendlyEligible = movie.isKidFriendlyEligible();
		
		assertFalse(isKidFriendlyEligible, "MovieGenre = 'Thrillers', isKidFriendlyEligible() must return false");
		
		
		// Test 3: MovieGenre = "Foreign Thriller", return false
		movie = BookmarkManager.getinstance().createMovie(3000,"Citizen Kane","",1941,new String[] {"Orson Welles","Joseph Cotten"},new String[] {"Orson Welles"},MovieGenre.FOREIGN_THRILLERS
				,8.5);
		
		isKidFriendlyEligible = movie.isKidFriendlyEligible();
		
		assertFalse(isKidFriendlyEligible, "MovieGenre = 'Foreign Thrillers', isKidFriendlyEligible() must return false");
		
	}

}
