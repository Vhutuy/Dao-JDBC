package application;

import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

public class Program2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		DepartmentDao departmentDao = DaoFactory.createDepartmentDao();

		System.out.println("=== test 1: Insert ===");
		Department dep = new Department(9, "Food");
//		departmentDao.insert(dep);
		System.out.println("Done!");

		System.out.println("=== test 2: Update ===");
		dep = new Department(6, "Games");
		departmentDao.update(dep);
		System.out.println("department Updated!");

		System.out.println("=== test 3: Delete By Id ===");
		System.out.print("Choose a department ID to be Deleted: ");
		int id = sc.nextInt();
//		departmentDao.deleteById(id);
		System.out.println("Department " + id + " has been deleted!");

		System.out.println("=== test 4: Find By Id ===");
		System.out.print("Enter a deparment ID:");
		id = sc.nextInt();
		System.out.println(departmentDao.findById(id));

		System.out.println("=== test 5: Find All ===");
		List<Department> list = departmentDao.findALl();
		list.forEach(System.out::println);
		


		sc.close();
	}

}
