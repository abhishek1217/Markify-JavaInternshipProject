package markify.entities;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import markify.constants.BookGenre;
import markify.managers.BookmarkManager;

class BookTest {

	@Test
	void test() {

		// Test 1:BookGenre = "Philosophy", return false
		Book book = BookmarkManager.getinstance().createBook(4000, "Walden", 1854, "Wilder Publications",
				new String[] { "Henry", "David", "Thoreau" }, BookGenre.PHILOSOPHY, 4.3);

		boolean isKidFriendlyEligible = book.isKidFriendlyEligible();

		assertFalse(isKidFriendlyEligible, "BookGenre = 'Philosophy' - isKidFriendlyEligible() must return false");

		// Test 2: BookGenre = "Self Help", return false
		book = BookmarkManager.getinstance().createBook(4000, "Walden", 1854, "Wilder Publications",
				new String[] { "Henry", "David", "Thoreau" }, BookGenre.SELF_HELP, 4.3);

		isKidFriendlyEligible = book.isKidFriendlyEligible();

		assertFalse(isKidFriendlyEligible, "BookGenre = 'SelfHelp' - isKidFriendlyEligible() must return false");
	}

}
