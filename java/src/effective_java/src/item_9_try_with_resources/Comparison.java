package item_9_try_with_resources;

public class Comparison {

	public static void main(String[] args) {

		TryFinally.compare();
		
	}

}


class TryFinally {
	static void compare () {
		try {
			System.out.println(Math.sqrt(-2));
		} finally {
			System.out.println(2 / 0);
		}
	}
}

class TryWithResources implements AutoCloseable {
	static void compare () { 
		System.out.println(Math.sqrt(-2));
	}

	@Override
	public void close() throws Exception {
		System.out.println("closed");
	}
}

