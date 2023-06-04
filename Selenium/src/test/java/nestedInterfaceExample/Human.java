package nestedInterfaceExample;

public class Human implements Home{

	@Override
	public void openMainDoor() {
		System.out.println("Door opened");
		
	}

	@Override
	public LivingRoom accessLivingRoom() {
		// TODO Auto-generated method stub
		return new LivingRoomClass();
	}

	@Override
	public MasterBedRoom accessMasterBedRoom() {
		// TODO Auto-generated method stub
		return new MasterBedRoomClass();
	}
	
	public static void main(String[] args) {
		Human human = new Human();
		human.openMainDoor();
		human.accessLivingRoom().eatingFurniture();
		human.accessLivingRoom().sittingFurniture();
		human.accessMasterBedRoom().sleepingFurniture();
		human.accessMasterBedRoom().entertainment();
		human.accessMasterBedRoom().accessMasterBathRoom().modeOfBathing();
	}

}
