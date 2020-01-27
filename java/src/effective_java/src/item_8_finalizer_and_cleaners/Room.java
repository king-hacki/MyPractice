
//	Java 9 need
//package item_8_finalizer_and_cleaners;
//
////An autocloseable class using a cleaner as a safety net
//public class Room implements AutoCloseable {
//
//	private static final Cleaner cleaner = Cleaner.create();
//	
//	// Resource that requires cleaning. Must not refer to Room!
//	private static class State implements Runnable {
//
//		int numJunksPiles;	// Number of junk piles in this room
//		
//		State (int numJunksPiles) {
//			this.numJunksPiles = numJunksPiles;
//		}
//		
//		// Invoked by close method or cleaner
//		@Override
//		public void run() {
//			// TODO Auto-generated method stub
//			System.out.println("Cleaning room");
//			numJunksPiles = 0;
//		}
//		
//	}
//	
//	// The state of this room, shared with our cleanable
//    private final State state;
//    
//    // Our cleanable. Cleans the room when it’s eligible for gc
//    private final Cleaner.Cleanable cleanable;
//    
//    public Room (int numJunksPiles) {
//    	state = new State(numJunksPiles); 
//    	cleanable = cleaner.register(this, state);
//    }
//	
//	@Override
//	public void close() throws Exception {
//		// TODO Auto-generated method stub
//		cleanable.clean();
//	}
//
//}
//
//
//public class Adult {
//	public static void main(String[] args) {
//		try (Room myRoom = new Room(7)) { 
//			System.out.println("Goodbye");
//    	} 
//    }
//}