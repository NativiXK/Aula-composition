package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Department;
import entities.HourContract;
import entities.Worker;
import entities.enums.WorkerLevel;

public class Program {

	public static void main(String[] args) throws ParseException {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		// sets the formatting pattern
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yy");

		Worker worker = new Worker();

		System.out.print("Enter department's name: ");
		worker.setDepartment(new Department(sc.nextLine()));
		System.out.println("Enter worker data: ");
		System.out.print("Name: ");
		worker.setName(sc.nextLine());
		System.out.print("Level: ");
		// convert the String's insertion to the value mapped on WorkerLevel
		String level = sc.nextLine();
		worker.setLevel(WorkerLevel.valueOf(level.toUpperCase()));
		System.out.print("Base salary: ");
		worker.setBaseSalary(sc.nextDouble());
		System.out.print("How many contracts to this worker? ");
		int amount = sc.nextInt();

		// creating the contracts accordingly with the user's insertion
		for (int i = 0; i < amount; i++) {
			System.out.println("Enter contract #" + (i + 1) + " data: ");
			System.out.print("Date (DD/MM/YYYY): ");
			Date date = sdf.parse(sc.next());
			System.out.print("Value per hour: ");
			double valuePerHour = sc.nextDouble();
			System.out.print("Duration (Hours): ");
			int duration = sc.nextInt();
			System.out.println();
			worker.addContract(new HourContract(date, valuePerHour, duration));
		}

		System.out.println();
		System.out.print("Enter month and year to calculate income (MM/YYYY): ");
		String dateSearch = sc.next();
		//breaking the string and converting to integer the year and month
		int c_month = Integer.parseInt(dateSearch.substring(0, 2));
		int c_year  = Integer.parseInt(dateSearch.substring(3));

		System.out.println("Name: " + worker.getName());
		System.out.println("Department: " + worker.getDepartment().getName());
		System.out.print("Income for " + dateSearch + ": ");
		System.out.println(worker.income(c_year, c_month));
		sc.close();
	}

}
