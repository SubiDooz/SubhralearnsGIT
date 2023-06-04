package nestedInterfaceExample;

import nestedInterfaceExample.Home.MasterBedRoom;

public class MasterBedRoomClass implements MasterBedRoom {

	@Override
	public void sleepingFurniture() {
		System.out.println("Wooden Bed");

	}

	@Override
	public void entertainment() {
		System.out.println("TV");

	}

	@Override
	public MasterBathRoom accessMasterBathRoom() {
		// TODO Auto-generated method stub
		return new MasterBathRoomClass();
	}

}
