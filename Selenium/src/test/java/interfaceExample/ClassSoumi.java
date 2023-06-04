package interfaceExample;

public class ClassSoumi implements InterfaceSoumi {

	String fatherName=null;
	String motherName=null;
	
	public ClassSoumi(String fatherName, String motherName) {
		this.fatherName = fatherName;
		this.motherName = motherName;
	}

	@Override
	public String fatherName() {
		return fatherName;

	}

	@Override
	public String motherName() {
		return motherName;

	}

}
