package inner_classes;

public class Ex_16_anonyousCycleFactoryMore {

	
	static CycleAnonymous fabrica (CycleFactoryAnonymous cf) {
		return cf.getCycle();
	}
	
	public static void main(String[] args) {

		//	hahahahahah I think it is not correct but it's work
		Ex_16_anonyousCycleFactoryMore.fabrica(new CycleFactoryAnonymous() {

			@Override
			public CycleAnonymous getCycle() {
				return new CycleAnonymous() {
					
					int wheels = 2;

					@Override
					public CycleAnonymous move() {
						System.out.println("Bicycle move");	
						return this;
					}
					
					public CycleAnonymous getWheeals () {
						System.out.println("There are " + wheels + " wheels");
						return this;
					}
					
				};
			}
		}
		).move().getWheeals();
		
	}

}

interface CycleAnonymous {
	CycleAnonymous move();
	CycleAnonymous getWheeals();		//		we can't cast to anonymous class so need initialize in interface
}

interface CycleFactoryAnonymous {
	CycleAnonymous getCycle();
}


