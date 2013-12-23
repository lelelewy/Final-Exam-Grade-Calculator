import java.util.*;

public class GradeTest {
	public static void main(String[] args) {
		Scanner scan = new Scanner (System.in);
		System.out.println("How many grade categories are there in the class? (excluding the final exam)");
		int catNum = scan.nextInt();
		double[] grades = new double[catNum];
		double[] gradePercents = new double[catNum];
		for(int i = 0; i < catNum; i++) {
			System.out.println("What grade did you get in the category?");
			grades[i] = scan.nextDouble();
			System.out.println("What percentage was that category worth? (in decimal format)");
			gradePercents[i] = scan.nextDouble();
		}
		System.out.println("How much is the final exam worth? (in decimal format)");
		double finalExamPercent = scan.nextDouble();
		System.out.println("Would you like to see your final class grade if you got a certain score on the final? (yes or no)");
		String answer = scan.next();
		while (answer.equals("yes")){
			System.out.println("What grade do you expect to get on the final?");
			double finalExamGrade = scan.nextDouble();
			double result = calculateClassGrade(grades, gradePercents, finalExamGrade, finalExamPercent);
			System.out.println("You will get a " + result + " in the class.");
			System.out.println("Would you like to see your final class grade if you got a certain score on the final? (yes or no)");
			answer = scan.next();
		}	
		//else {
			System.out.println("Would you like to see what you need on the final exam in order to get a certain grade in the class?(yes or no)");
			answer = scan.next();
			while (answer.equals("yes")){
				System.out.println("What grade do you want in the class?");
				double finalClassGrade = scan.nextDouble();
				double result = calculateExamGrade(grades, gradePercents, finalClassGrade, finalExamPercent);
				System.out.println("You need to get a " + result + " to get a " + finalClassGrade + " in the class.");
				System.out.println("Would you like to see what you need in order to get a certain grade in the class? (yes or no)");
				answer = scan.next();
			}
		//}	
	}
	public static double calculateExamGrade(double[] a, double[] b, double classGrade, double examPercentage) {
		double temp=0;
		for(int i = 0; i < a.length; i++) {
				temp+=a[i]*b[i];
		}
		return (classGrade - temp)/examPercentage;
	}

	public static double calculateClassGrade(double[]a, double[] b, double examGrade, double examPercentage){
		double temp=0;
		for(int i = 0; i < a.length; i++) {
				temp+=a[i]*b[i];
		}
		return temp + (examGrade * examPercentage);
	}

}

