package studio9;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import assignment7.Student;

public class UniversityDatabase {
	
	private final Map<String, Student> studMap;
	
	public UniversityDatabase() {
		studMap = new HashMap<>();
	}
	//TODO: Complete this class according to the studio instructions

	public void addStudent(String accountName, Student student) {
		studMap.put(accountName,  student);
	}

	public int getStudentCount() {
		return studMap.size();
	}

	public String lookupFullName(String accountName) {
		if (studMap.get(accountName)!= null) {
			return studMap.get(accountName).getFullName();
		}
		else
			return null;
	}

	public double getTotalBearBucks() {
		double total = 0;
		
		for (String name : studMap.keySet()) {
			total = total + studMap.get(name).getBearBucksBalance();
		}
		return total;
	}
}
