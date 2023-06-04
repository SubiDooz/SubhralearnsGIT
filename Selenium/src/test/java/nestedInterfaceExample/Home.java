package nestedInterfaceExample;

public interface Home {
	
	void openMainDoor();
	
	LivingRoom accessLivingRoom();
	
	MasterBedRoom accessMasterBedRoom();
	
	interface LivingRoom{
		void sittingFurniture();
		
		void eatingFurniture();
		
	}
	
	interface MasterBedRoom{
		
		void sleepingFurniture();
		void entertainment();
		
		MasterBathRoom accessMasterBathRoom();
		
		interface MasterBathRoom{
			
			void modeOfBathing();
				
		}
		
	}
	
	

}
