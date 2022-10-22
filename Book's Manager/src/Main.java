import java.util.Scanner;
import java.util.Vector;

public class Main {

	Scanner scan = new Scanner(System.in);
	Vector <Books> book = new Vector<>();
	
	public Main() {
		// TODO Auto-generated constructor stub
		menu();
	}

	public void clearScreen() {
		for (int i = 0; i < 15; i++) {
			System.out.println();
		}
	}
	
	public void menu() {
		int input = 0;
		Boolean valid;
		
		do {
			try {
				valid = true;
				
				clearScreen();
				System.out.println("Book's Manager");
				System.out.println("1. View Books");
				System.out.println("2. Insert Book");
				System.out.println("3. Delete Book");
				System.out.println("4. Exit");
				System.out.print(">> ");
				input = scan.nextInt();
				scan.nextLine();
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("Input must be numeric!");
				System.out.print("Press enter to continue...");
				scan.nextLine();
				scan.nextLine();
				valid = false;
				continue;
			}
			
			switch (input) {
				case 1:
					clearScreen();
					if(book.isEmpty()) {
						System.out.println("There is no book yet.");
					}
					else {
						viewBooks();
					}
					System.out.print("Press enter to continue...");
					scan.nextLine();
					break;
				case 2:
					clearScreen();
					insertBook();
					break;
				case 3:
					clearScreen();
					if(book.isEmpty()) {
						System.out.println("There is no book yet.");
					}
					else {
						viewBooks();
						deleteBook();
						clearScreen();
						if(book.isEmpty()) {
							System.out.println("There is no book yet.");
						}
						else {
							viewBooks();	
						}
					}
					System.out.print("Press enter to continue...");
					scan.nextLine();
					break;
				default:
					break;
			}
		} while (input != 4 || valid == false);
	}
	
	public void viewBooks() {
		System.out.println("|===================================================================|");
		System.out.println("| No   | Id    | Title      | Type  | Price      | Total Chapter(s) |");
		System.out.println("|===================================================================|");
		for (int i = 0; i < book.size(); i++) {
			System.out.printf("| %-4d | %s | %-10s | %-5s | %-10d | %-16d |", i+1, book.get(i).getBooksID(), book.get(i).getBooksTitle(), book.get(i).getBooksType(), book.get(i).getBooksPrice(), book.get(i).getBooksChapter());
			System.out.println();
		}
		System.out.println("|===================================================================|");
	}
	
	public void insertBook() {
		String title;
		String type;
		int chapter = 0;
		int price = 0;
		String id;
		Boolean valid;
		
		do {
			valid = true;
			
			System.out.print("Input title [5 - 10 Characters]: ");
			title = scan.nextLine();
			if(title.length() < 5 || title.length() > 10) {
				valid = false;
			}
		} while (valid == false);
		
		do {
			valid = true;
			
			System.out.print("Input type [Novel | Comic Case sensitive]: ");
			type = scan.nextLine();
			if(!(type.equals("Novel") || type.equals("Comic"))) {
				valid = false;
			}
		} while (valid == false);
		
		do {
			valid = true;
			
			System.out.print("Input number of chapter(s) [1-10]: ");
			chapter = scan.nextInt();
			scan.nextLine();			
			if(chapter < 1 || chapter > 10) {
				valid = false;
			}
		} while (valid == false);
		
		if(type.equals("Novel")) {
			price = 100000 + chapter * 1000;
		}
		else if(type.equals("Comic")) {
			price = 50000 + chapter * 1000;
		}
		
		id = "BK" + (int)(0 + Math.random()*10) + (int)(0 + Math.random()*10) + (int)(0 + Math.random()*10);
		
		book.add(new Books(title, type, chapter, price, id));
		
		System.out.println();
		System.out.println("Book created!");
		System.out.print("Press enter to continue...");
		scan.nextLine();
	}
	
	public void deleteBook() {
		int index;
		Boolean valid;
		
		do {
			valid = true;
			
			System.out.println();
			if(book.size() == 1) {
				System.out.print("Choose index to be delete [1]: ");
			}
			else {
				System.out.print("Choose index to be delete [1.." + book.size() + "]: ");
			}
			index = scan.nextInt();
			scan.nextLine();
			if(index < 1 || index > book.size()) {
				valid = false;
			}
		} while (valid == false);
		
		book.remove(index-1);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Main();
	}

}
