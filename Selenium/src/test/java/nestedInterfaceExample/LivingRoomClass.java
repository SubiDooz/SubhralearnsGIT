package nestedInterfaceExample;

import nestedInterfaceExample.Home.LivingRoom;

public class LivingRoomClass implements LivingRoom {

	@Override
	public void sittingFurniture() {
		System.out.println("Sofa");
	}

	@Override
	public void eatingFurniture() {
		// TODO Auto-generated method stub
		System.out.println("Dining Table");;
	}

}
