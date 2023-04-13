package assignment7;

//TODO: Copy a working Student class from Assignment 7 over this file.
public class Student {

	private String firstName;
	private String lastName;
	private int idNumber;
	private int attemptedCredits;
	private int passingCredits;
	private double totalGradeQualityPoints;
	private double bearBucksBalance;
	
	/**
	 * 
	 * @param first: first name
	 * @param last: last name
	 * @param n: student ID number
	 */
	public Student(String first, String last, int id) {	
		firstName = first;
		lastName = last;
		idNumber = id;
	}
	
	/**
	 * @param no parameters
	 * @return student's full name
	 */
	public String getFullName() {
		return firstName + " " + lastName;
	}
	
	/**
	 * @param no parameters
	 * @return idNumber
	 */
	public int getId() {
		return idNumber;
	}
	
	/**
	 * @param no parameters
	 * @return attemptedCredits
	 */
	public int getTotalAttemptedCredits() {
		return attemptedCredits; 
	}
	
	/**
	 * @param no parameters
	 * @return totalPassingCredits
	 */
	public int getTotalPassingCredits() {
		return passingCredits;
	}
	
	/**
	 * @param no parameters
	 * @return GPA
	 */
	public double calculateGradePointAverage() {
		return totalGradeQualityPoints/attemptedCredits;
	}
	
	/**
	 * 
	 * @param grade
	 * @param credits
	 */
	public void submitGrade(double grade, int credits) {
		attemptedCredits = attemptedCredits + credits;
		totalGradeQualityPoints = totalGradeQualityPoints+(grade*credits);
		if (grade >= 1.7) {
			passingCredits+=credits;
		}
	}
	
	/**
	 * @param no parameters
	 * @return class standing
	 */
	public String getClassStanding() {
		if (getTotalPassingCredits()<30) {
			return "First Year";
		}
		else if (getTotalPassingCredits()>=30 && getTotalPassingCredits()<60) {
			return "Sophomore";
		}
		else if (getTotalPassingCredits()>=60 && getTotalPassingCredits()<90) {
			return "Junior";
		}
		else
			return "Senior";
	}
	
	/**
	 * @param no parameters
	 * @return eligibility for Phi Beta Kappa
	 */
	public boolean isEligibleForPhiBetaKappa() {
		if (getTotalAttemptedCredits()>=75 && calculateGradePointAverage()>=3.80) {
			return true;
		}
		else if (getTotalAttemptedCredits()>=98 && calculateGradePointAverage()>=3.60) {
			return true;
		}
		else
			return false;
	}
	
	/**
	 * @param amount
	 */
	public void depositBearBucks(double amount) {
		bearBucksBalance += amount;
	}
	
	/**
	 * 
	 * @param amount
	 */
	public void deductBearBucks(double amount) {
		bearBucksBalance -= amount;
	}
	
	/**
	 * @param no parameters
	 * @return bear bucks balance
	 */
	public double getBearBucksBalance() {
		return bearBucksBalance;
	}
	
	/**
	 * @param no parameters
	 * @return amount cashed out
	 */
	public double cashOutBearBucks() {
		if (bearBucksBalance < 10) {
			bearBucksBalance = 0;
			return 0;
		}
		else {
			double bal = bearBucksBalance;
			bearBucksBalance = 0;
			return bal-10;
		}
	}
	
	/**
	 * 
	 * @param firstName
	 * @param otherParent
	 * @param isHyphenated
	 * @param id
	 * @return
	 */
	public Student createLegacy(String firstName, Student otherParent, boolean
			isHyphenated, int id) {
		if (isHyphenated == true) {
			Student legacyStudent = new Student(firstName, this.lastName+"-"+otherParent.getLastName(),id);
			legacyStudent.bearBucksBalance = this.cashOutBearBucks() + otherParent.cashOutBearBucks();
			return legacyStudent;
		}
		else {
			Student legacyStudent = new Student(firstName, this.lastName, id);
			legacyStudent.bearBucksBalance = this.cashOutBearBucks() + otherParent.cashOutBearBucks();
			return legacyStudent;
		}
	}
	
	/**
	 * @param no parameters
	 * @return
	 */
	public String getLastName() {
		return lastName;
	}
	
	/**
	 * @param no parameters
	 * @param return full name and id number as a string
	 */
	public String toString() {
		return getFullName() + " " + idNumber;
	}
}
