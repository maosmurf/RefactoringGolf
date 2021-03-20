import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class SorterTests {

	@Test
	public void bubblesortPutsArrayInAscendingOrder() {
		int[] array = {3,1,2};
		array = SortKind.BUBBLE.sort(array);
		assertArrayEquals(new int[]{1,2,3}, array );
	}
	
	@Test
	public void quicksortPutsArrayInAscendingOrder() {
		int[] array = {3,1,2};
		array = SortKind.QUICK.sort(array);
		assertArrayEquals(new int[]{1,2,3}, array );
	}
	
	@Test
	public void insertionsortPutsArrayInAscendingOrder() {
		int[] array = {3,1,2};
		array = SortKind.INSERTION.sort(array);
		assertArrayEquals(new int[]{1,2,3}, array );
	}

}
