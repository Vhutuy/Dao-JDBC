package application;

import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		SellerDao sellerDao = DaoFactory.createSellerDao();

		System.out.println("=== Teste 1: seller FindBy id ===");
		Seller seller = sellerDao.findById(3);
		System.out.println(seller);

		System.out.println("\n=== Teste 2: seller FindBy Department ===");
		Department department = new Department(2, null);
		List<Seller> list = sellerDao.findByDepartment(department);
		list.forEach(System.out::println);

		System.out.println("\n=== Teste 3: seller Find all ===");
		list = sellerDao.findALl();
		list.forEach(System.out::println);

		System.out.println("\n=== Teste 4: Insert ===");
//		Seller seller2 = new Seller(null, "Maria", "Maria@gmail.com", new Date(), 5000.0, department);
//		sellerDao.insert(seller2);
//		System.out.println("Inserted: " + seller2.getId());

		System.out.println("\n=== Teste 5: seller Update ===");
		seller = sellerDao.findById(1);
		seller.setName("Wender Ribeiro");
		sellerDao.update(seller);
		System.out.println("Done!");

		System.out.println("\n=== Teste 6: seller Delete ===");
		System.out.print("Enter a Seller ID to be deleted: ");
		int id = sc.nextInt();
		sellerDao.deleteById(id);
		System.out.println("Seller " + id + " has been deleted!");
		sc.close();

	}
}
