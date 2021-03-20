import org.junit.jupiter.api.Test;

import java.util.function.Function;

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


	@Test
	void name() {
		int result = add(1, 2);

		int isThreeA = add(1, 2);
		int isThreeB = adder(1).add(2);
		int is1002 = adder(1000).add(2);

		Adder add1000 = adder(1000);

		add1000.add(2);
		add1000.add(10);

		Adder add1002 = add1000.plus(2);
		int is1012 = add1002.add(10);
	}

	private int add(int a, int b) {
		return a+b;
	}

	private int addOne(int b) {
		return add(1, b);
	}

	private int addTwo(int b) {
		return add(2, b);
	}

	private interface Adder {
		int add(int b);

		default Adder plus(int c) {
			return b -> c + add(b);
		}
	}

	private Adder adder(int a) {
		return b -> a + b;
	}
}
