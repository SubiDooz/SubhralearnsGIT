package interfaceExample;

public class ClassSubhra implements InterfaceSubhra{

	@Override
	public String fatherName() {
		return "Suhrid";
	}

	@Override
	public String address() {
		return "Balurghat";
	}

	@Override
	public InterfaceSoumi soumiDetails() {
		InterfaceSoumi iSoumi = new ClassSoumi("Satyen", "Swapna");
		return iSoumi;
	}
	
	public static void main(String[] args) {
		ClassSubhra cs = new ClassSubhra();
		System.out.println(cs.fatherName());
		System.out.println(cs.address());
		System.out.println(cs.soumiDetails().fatherName());
		System.out.println(cs.soumiDetails().motherName());

	}

}
