package lms.model.service;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

import lms.controller.BookController;
import lms.controller.LoginLibrarian;
import lms.model.entity.Authors;
import lms.model.entity.Books;
import lms.model.entity.Categories;
import lms.model.entity.Libarians;
import lms.model.entity.Members;
import lms.model.entity.borrowBooks;

public class DatabaseService {

	public static Libarians checkLogin(String email) {
		// TODO Auto-generated method stub
		Libarians lib = null;
		try(Connection con = myConnection.getConnection()) {
			String query = "SELECT * FROM librarians WHERE email=?";
			PreparedStatement pstm = con.prepareStatement(query);
			pstm.setString(1,email);
			ResultSet rs = pstm.executeQuery();
			
			while(rs.next()) {
				lib = new Libarians();
				lib.setId(rs.getInt("id"));
				lib.setEmail(rs.getString("email"));
				lib.setPass(rs.getString("password"));
				lib.setNrc(rs.getString("nrc"));
				lib.setPhno(rs.getString("phno"));
				lib.setCreateDate(LocalDate.parse(rs.getString("created_at")));
				
			}
		} catch (Exception e) {
			//e.printStackTrace();
		}
		return lib;
	}

	public static List<Authors> getAllAuthors() {
		// TODO Auto-generated method stub
		List<Authors> list = new ArrayList<>();
		try (Connection con = myConnection.getConnection()){
			String query = "SELECT * FROM authors";
			PreparedStatement pstm = con.prepareStatement(query);
			ResultSet rs = pstm.executeQuery();
			
			while(rs.next()) {
				Authors obj = new Authors();
				obj.setId(rs.getInt("author_id"));
				obj.setName(rs.getString("name"));
				obj.setCountry(rs.getString("country"));
				
				list.add(obj);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	public static void addAuthor(String name, String country) {
		// TODO Auto-generated method stub
		try (Connection con = myConnection.getConnection()){
			String query = "INSERT INTO authors(name,country) VALUES (?,?)";
			PreparedStatement pstm = con.prepareStatement(query);
			pstm.setString(1, name);
			pstm.setString(2, country);
			pstm.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void editAuthor(Authors author) {
		// TODO Auto-generated method stub
		try(Connection con = myConnection.getConnection()) {
			String query = "UPDATE authors SET name =?,country=? WHERE author_id =? ";
			PreparedStatement pstm = con.prepareStatement(query);
			pstm.setString(1, author.getName());
			pstm.setString(2, author.getCountry());
			pstm.setInt(3, author.getId());
			pstm.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static List<Categories> getAllCategories() {
		// TODO Auto-generated method stub
		List<Categories> list = new ArrayList<>();
		try (Connection con = myConnection.getConnection()){
			String query = "SELECT * FROM categories";
			PreparedStatement pstm = con.prepareStatement(query);
			ResultSet rs = pstm.executeQuery();
			
			while(rs.next()) {
				Categories obj = new Categories();
				obj.setId(rs.getInt("category_id"));
				obj.setName(rs.getString("name"));
		
				list.add(obj);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public static List<Authors> FindAllAuthors(String name, String country) {
		Authors auth = null;
		List<Authors> authlist = new ArrayList<>();
		try(Connection con = myConnection.getConnection()){
			String query ="""
					SELECT * FROM authors WHERE name LIKE ? AND country LIKE ?
					""" ;
			PreparedStatement pstm = con.prepareStatement(query);
			pstm.setString(1,"%"+ name +"%");
			pstm.setString(2, "%"+ country +"%");
			ResultSet rs = pstm.executeQuery();
			while(rs.next()) {
				auth = new Authors();
				auth.setId(rs.getInt("author_id"));
				auth.setName(rs.getString("name"));
				auth.setCountry(rs.getString("country"));
				authlist.add(auth);
			}
		}
			catch(Exception e){
				e.printStackTrace();
			}
		return authlist;
	}
	

	public static void addCategory(String name) {
		// TODO Auto-generated method stub
		try (Connection con = myConnection.getConnection()){
			String query = "INSERT INTO categories(name) VALUES (?)";
			PreparedStatement pstm = con.prepareStatement(query);
			pstm.setString(1, name);
			pstm.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void editCategory(Categories cat) {
		// TODO Auto-generated method stub
		try(Connection con = myConnection.getConnection()) {
			String query = "UPDATE categories SET name =? WHERE category_id =? ";
			PreparedStatement pstm = con.prepareStatement(query);
			pstm.setString(1, cat.getName());
			pstm.setInt(2, cat.getId());
			pstm.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static List<Categories> FindAllCategories(String name) throws SQLException {
		Categories cat = null;
		List<Categories> catlist = new ArrayList<>();
		try(Connection con = myConnection.getConnection()){
			String query ="""
					SELECT * FROM categories
					""" ;
			List<Object> params = new ArrayList<>();
			if (!name.isEmpty()) {
				query += "WHERE name LIKE ?";
				params.add("%" + name + "%");
			}
			
			PreparedStatement pstm = con.prepareStatement(query);
			for (var i = 0; i < params.size(); i++) {
				pstm.setObject(i + 1, params.get(i));
			}

			ResultSet rs = pstm.executeQuery();
			while(rs.next()) {
				cat = new Categories();
				cat.setId(rs.getInt("category_id"));
				cat.setName(rs.getString("name"));
				
				catlist.add(cat);
				}
			
		return catlist;
	}
}

	public static List<Books> getAllBooks() {
		List<Books> list = new ArrayList<>();
		try(Connection con = myConnection.getConnection()) {
			String query = """
						SELECT b.*,a.name 'author_name' , c.name 'category_name' 
						FROM books b, authors a, categories c
						WHERE b.author_id = a.author_id AND 
						b.category_id = c.category_id
					""";
			PreparedStatement pstm = con.prepareStatement(query);
			ResultSet rs = pstm.executeQuery();
			while(rs.next()) {
				Books book = new Books();
				book.setCode(rs.getInt("code"));
				book.setTitle(rs.getString("title"));
				book.setIs_avaliable(rs.getInt("is_available"));
			Categories cat = new Categories();
				cat.setId(rs.getInt("category_id"));;
				cat.setName(rs.getString("category_name"));
				book.setCategory(cat);
				
				Authors author = new Authors();
				author.setId(rs.getInt("author_id"));
				author.setName(rs.getString("author_name"));
				
				book.setAuthor(author);
				list.add(book);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
		
	}

	public static boolean addBook(Books book) {
		boolean result = false;
		try(Connection con = myConnection.getConnection()){
			String query = "INSERT INTO books(code,title,is_available,author_id,category_id)VALUES(?,?,?,?,?)";
			PreparedStatement pstm = con.prepareStatement(query);
			pstm.setInt(1, book.getCode());
			pstm.setString(2, book.getTitle());
			pstm.setInt(3,1);
			pstm.setInt(4, book.getAuthor().getId());
			pstm.setInt(5,book.getCategory().getId());
			
			pstm.executeUpdate();
			result = true;
		} catch (Exception e) {
			//e.printStackTrace();
			result = false;
		}
		return result;
	}

	public static boolean EditBook(Books book) {
		
		boolean result = false;
		try (Connection con = myConnection.getConnection()){
			String query = "UPDATE books SET title =?, is_available=?,author_id=?,category_id=? where code =?";
			PreparedStatement pstm = con.prepareStatement(query);
			pstm.setString(1, book.getTitle());
			pstm.setInt(2,1);
			pstm.setInt(3, book.getAuthor().getId());
			pstm.setInt(4, book.getCategory().getId());
			pstm.setInt(5, book.getCode());
			pstm.executeUpdate();
			result = true;
		} catch (Exception e) {
			e.printStackTrace();
			result = false;
		}
		return result;
	}

	public static List<Books> findAllBooks(String avaliable, String author,String category) {
		List<Books> list = new ArrayList<>();
		try (Connection con = myConnection.getConnection()) {
			String query = """
					SELECT b.*,a.name 'author_name',c.name 'category_name'
					FROM books b, authors a, categories c
					WHERE b.author_id = a.author_id AND
					b.category_id = c.category_id
					""";
			List<Object> params = new ArrayList<>();
		
			if (!avaliable.isEmpty()) {
				query += " AND b.is_available = ?";
				params.add(avaliable);
			}
			if (!author.isEmpty()) {
				query += " AND a.name LIKE ?";
				params.add("%" + author + "%");
			}
			if (!category.isEmpty()) {
				query += " AND c.name LIKE ?";
				params.add("%" + category + "%");
			}
			PreparedStatement pstm = con.prepareStatement(query);

			for (var i = 0; i < params.size(); i++) {
				pstm.setObject(i + 1, params.get(i));
			}

			ResultSet rs = pstm.executeQuery();

			while (rs.next()) {
				Books book = new Books();

				book.setCode(rs.getInt("code"));
				book.setTitle(rs.getString("title"));
				book.setIs_avaliable(1);

				Categories cat = new Categories();
				cat.setId(rs.getInt("category_id"));
				cat.setName(rs.getString("category_name"));

				book.setCategory(cat);

				Authors auth = new Authors();
				auth.setId(rs.getInt("author_id"));
				auth.setName(rs.getString("author_name"));

				book.setAuthor(auth);
				list.add(book);
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public static List<Members> getAllMembers() {
		List<Members> list = new ArrayList<>();
		try (Connection con = myConnection.getConnection()){
			String query = "SELECT * FROM members";
			PreparedStatement pstm = con.prepareStatement(query);
			ResultSet rs = pstm.executeQuery();
			
			while(rs.next()) {
				Members obj = new Members();
				obj.setCardid(rs.getInt("card_id"));
				obj.setName(rs.getString("name"));
				obj.setRollno(rs.getString("rollno"));
				obj.setClassyear(rs.getString("class_year"));
				obj.setAcademic(rs.getString("academic_year"));
				obj.setCreate(rs.getDate("created_at").toLocalDate());
				obj.setExpire(rs.getDate("expired").toLocalDate());
				list.add(obj);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public static void addMembers(String name, String rollno, String classyr, String academicyr, LocalDate create,
			LocalDate expire) {
		try (Connection con = myConnection.getConnection()){
			String query = "INSERT INTO members(name,rollno,class_year,academic_year,created_at,expired) VALUES (?,?,?,?,?,?)";
			PreparedStatement pstm = con.prepareStatement(query);
			pstm.setString(1, name);
			pstm.setString(2, rollno);
			pstm.setString(3, classyr);
			pstm.setString(4, academicyr);
			pstm.setDate(5, Date.valueOf(create));
			pstm.setDate(6, Date.valueOf(expire));
			
			pstm.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	public static void editMembers(Members mem) {
		// TODO Auto-generated method stub
		try(Connection con = myConnection.getConnection()) {
			String query = "UPDATE members SET name =?,rollno=?,class_year=?,academic_year=?,created_at=?,expired=? WHERE card_id =? ";
			PreparedStatement pstm = con.prepareStatement(query);
			pstm.setString(1, mem.getName());
			pstm.setString(2, mem.getRollno());
			pstm.setString(3, mem.getClassyear());
			pstm.setString(4, mem.getAcademic());
			pstm.setDate(5, Date.valueOf(mem.getCreate()));
			pstm.setDate(6, Date.valueOf(mem.getExpire()));
			pstm.setInt(7, mem.getCardid());
			pstm.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static List<Members> FindAllMembers(String card, String name,LocalDate expired) throws SQLException {
		boolean result=false;
		List<Members> memlist = new ArrayList<>();
		try(Connection con = myConnection.getConnection()){
			String query ="""
					SELECT * FROM members 
					WHERE 
					""" ;
			List<Object> params = new ArrayList<>();
			
			if (!name.isEmpty()) {
				query += " name LIKE ?";
				params.add("%"+name+"%");
			
			}
			if (expired != null) {
				query += " AND expired = ?";
				params.add(expired);
			
			}
			
			PreparedStatement pstm = con.prepareStatement(query);
			for (var i = 0; i < params.size(); i++) {
				pstm.setObject(i + 1, params.get(i));
			}
			
			ResultSet rs = pstm.executeQuery();
			
			while(rs.next()) {
				Members mem = new Members();
				
				mem.setCardid(rs.getInt("card_id"));
				mem.setName(rs.getString("name"));
				mem.setRollno(rs.getString("rollno"));
				mem.setClassyear(rs.getString("class_year"));
				mem.setAcademic(rs.getString("academic_year"));
				mem.setCreate(rs.getDate("created_at").toLocalDate());
				mem.setExpire(rs.getDate("expired").toLocalDate());
				
				memlist.add(mem);
				}
			
		return memlist;
	}
}

	public static List<borrowBooks> getAllBorrowBooks() {
		List<borrowBooks> list = new ArrayList<>();
		try(Connection con = myConnection.getConnection()) {
			String query = """
						SELECT bb.*,b.title , m.name 'member_name' ,l.email
						FROM borrowbooks bb, books b, members m,librarians l
						WHERE bb.card_id = m.card_id AND 
						bb.code = b.code AND
						bb.libarian_id = l.id 
					""";
			PreparedStatement pstm = con.prepareStatement(query);
			ResultSet rs = pstm.executeQuery();
			while(rs.next()) {
				borrowBooks bbook = new borrowBooks();
				bbook.setId(rs.getInt("id"));
				bbook.setBorrow_date(Date.valueOf(rs.getString("borrow_date")).toLocalDate());
				bbook.setDue_date(Date.valueOf(rs.getString("due_date")).toLocalDate());
				String returnDate = rs.getString("return_date");
				bbook.setReturn_date(returnDate != null ? LocalDate.parse(returnDate) : null);
				bbook.setFees(rs.getInt("fees"));

				Books book = new Books();
				book.setCode(rs.getInt("code"));
				book.setTitle(rs.getString("title"));
				//book.setIs_avaliable(rs.getString("is_available"));
				
				bbook.setCode(book);
				
				Members member = new Members();
				member.setCardid(rs.getInt("card_id"));
				member.setName(rs.getString("member_name"));
				//member.setCreate(Date.valueOf(rs.getString("created_at")).toLocalDate());
				//member.setExpire(Date.valueOf(rs.getString("created_at")).toLocalDate().plusYears(1));
				bbook.setCard_id(member);
				
				Libarians lib = new Libarians();
				lib.setId(rs.getInt("id"));
				lib.setEmail(rs.getString("email"));
				bbook.setLib_id(lib);
				list.add(bbook);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
		
	}

	public static Members FindMemberByID(String member_id) {
		
		Members member = null;
		try(Connection con = myConnection.getConnection()){
			String query ="""
					SELECT * from members WHERE card_id =? 
					""" ;
			PreparedStatement pstm = con.prepareStatement(query);
			pstm.setString(1, member_id);
			ResultSet rs = pstm.executeQuery();
			
			if(rs.next()) {
			member = new Members();
			member.setCardid(rs.getInt("card_id"));
			member.setName(rs.getString("name"));
			member.setRollno(rs.getString("rollno"));
			member.setClassyear(rs.getString("class_year"));
			member.setAcademic(rs.getString("academic_year"));
			member.setCreate(Date.valueOf(rs.getString("created_at")).toLocalDate());
			member.setExpire(Date.valueOf(rs.getString("expired")).toLocalDate());
			
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
			return member;
	}

	public static Books FindBookByID(String book_code) {
		Books book = null;
		try(Connection con = myConnection.getConnection()){
			String query ="""
					SELECT b.*,c.name'cat_name',a.name 'auth_name' FROM books b,categories c,authors a
					WHERE code =? AND b.category_id = c.category_id AND b.author_id = a.author_id
					""" ;
			PreparedStatement pstm = con.prepareStatement(query);
			pstm.setString(1, book_code);
			ResultSet rs = pstm.executeQuery();
			
			if(rs.next()) {
				book = new Books();
				book.setCode(rs.getInt("code"));
				book.setTitle(rs.getString("title"));
				book.setIs_avaliable(1);
				Authors auth = new Authors();
				auth.setId(rs.getInt("author_id"));
				auth.setName(rs.getString("auth_name"));
				book.setAuthor(auth);
				
				Categories cat = new Categories();
				cat.setId(rs.getInt("category_id"));
				cat.setName(rs.getString("cat_name"));
				book.setCategory(cat);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
			return book;
	}

	public static boolean addBorrowBooks(borrowBooks borrowbook) throws SQLException {
		boolean result = false;
		Connection con = null;
		try{
			con = myConnection.getConnection();
			
			String insertBorrow = "INSERT INTO borrowbooks(card_id,code,borrow_date,due_date,libarian_id) VALUES (?,?,?,?,?)";
			String updateBookavailable = "UPDATE books SET is_available =? WHERE code =? ";
			
			con.setAutoCommit(false);
			
			//insert borrowbook
			Books book = borrowbook.getCode();
			
			Members member = borrowbook.getCard_id();
			
			//if(borrowbook.getReturn_date() != null) {
				System.out.println(borrowbook.getReturn_date());
				PreparedStatement pstm = con.prepareStatement(insertBorrow);
				pstm.setInt(1, member.getCardid());
				pstm.setInt(2, book.getCode());
				pstm.setDate(3, Date.valueOf(borrowbook.getBorrow_date()));
				pstm.setDate(4, Date.valueOf(borrowbook.getDue_date()));
				//pstm.setDate(5, Date.valueOf(return_date));
				//pstm.setInt(6, fees);
				pstm.setInt(5, LoginLibrarian.login_user.getId());
				pstm.executeUpdate();
			
			//updateBookTable->Available
			PreparedStatement pstm1 = con.prepareStatement(updateBookavailable);
			pstm1.setInt(1, 0);
			pstm1.setInt(2, book.getCode());
			pstm1.executeUpdate();
			//}
			result = true;
			con.commit();
			
		} catch (Exception e) {
			e.printStackTrace();
			con.rollback();
			result = false;
		}
		finally {
			con.close();
		}
		return result;
		
	}

	public static Books CheckBookAvailable(String book_code) {
		Books book = null;
		try(Connection con = myConnection.getConnection()){
			String query ="""
					SELECT b.*,c.name'cat_name',a.name 'auth_name' FROM books b,categories c,authors a
					WHERE code =? AND is_available=1 AND b.category_id = c.category_id AND b.author_id = a.author_id
					""" ;
			PreparedStatement pstm = con.prepareStatement(query);
			pstm.setString(1, book_code);
			ResultSet rs = pstm.executeQuery();
			
			if(rs.next()) {
				book = new Books();
				book.setCode(rs.getInt("code"));
				book.setTitle(rs.getString("title"));
				book.setIs_avaliable(1);
				Authors auth = new Authors();
				auth.setId(rs.getInt("author_id"));
				auth.setName(rs.getString("auth_name"));
				book.setAuthor(auth);
				
				Categories cat = new Categories();
				cat.setId(rs.getInt("category_id"));
				cat.setName(rs.getString("cat_name"));
				book.setCategory(cat);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
			return book;
	}

	public static boolean checkMemberReturn(String member_id) {
		
		boolean result = false;
		try(Connection con = myConnection.getConnection()) {
			String query = """
						SELECT * FROM borrowbooks WHERE card_id =? AND due_date < now() AND return_date IS null
					""";
			
			PreparedStatement pstm = con.prepareStatement(query);
			pstm.setString(1, member_id);
			ResultSet rs = pstm.executeQuery();
			
			if(rs.next()) {
				result = true;				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	public static List<borrowBooks> FindBorrowMemberByID(String memberId) {
		List<borrowBooks> booklist = new ArrayList<>();
		try(Connection con = myConnection.getConnection()){
			String query ="""
					SELECT * FROM borrowbooks WHERE card_id =? AND return_date IS null;
					""" ;
			PreparedStatement pstm = con.prepareStatement(query);
			pstm.setString(1, memberId);
			ResultSet rs = pstm.executeQuery();
			
			while(rs.next()) {
			borrowBooks book = new borrowBooks();
			book.setId(rs.getInt("id"));
			String BorrowDate = rs.getString("borrow_Date");
			book.setBorrow_date(LocalDate.parse(BorrowDate));
			String DueDate = rs.getString("due_date");
			book.setDue_date(LocalDate.parse(DueDate));
			String returnDate = rs.getString("return_date");
			book.setReturn_date(returnDate != null ? LocalDate.parse(returnDate) : null);
			book.setFees(rs.getInt("fees"));

			Books book1 = new Books();
			book1.setCode(rs.getInt("code"));
			//book1.setTitle(rs.getString("title"));
			//book.setIs_avaliable(rs.getString("is_available"));
			
			book.setCode(book1);
			
			Members member = new Members();
			member.setCardid(rs.getInt("card_id"));
			//member.setName(rs.getString("member_name"));
			book.setCard_id(member);
			booklist.add(book);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
			return booklist;
	}

	public static List<borrowBooks> getAllBorrowBooksInReturn() {
		List<borrowBooks> list = new ArrayList<>();
		try(Connection con = myConnection.getConnection()) {
			String query = """
						SELECT bb.*,b.code , m.card_id
						FROM borrowbooks bb, books b, members m
						WHERE bb.card_id = m.card_id AND 
						bb.code = b.code 
					""";
			PreparedStatement pstm = con.prepareStatement(query);
			ResultSet rs = pstm.executeQuery();
			while(rs.next()) {
				borrowBooks bbook = new borrowBooks();
				bbook.setId(rs.getInt("id"));
				bbook.setBorrow_date(Date.valueOf(rs.getString("borrow_date")).toLocalDate());
				bbook.setDue_date(Date.valueOf(rs.getString("due_date")).toLocalDate());
				String returnDate = rs.getString("return_date");
				bbook.setReturn_date(returnDate != null ? LocalDate.parse(returnDate) : null);
				bbook.setFees(rs.getInt("fees"));

				Books book = new Books();
				book.setCode(rs.getInt("code"));
				//book.setTitle(rs.getString("title"));
				//book.setIs_avaliable(rs.getString("is_available"));
				
				bbook.setCode(book);
				
				Members member = new Members();
				member.setCardid(rs.getInt("card_id"));
				//member.setName(rs.getString("member_name"));
				//member.setCreate(Date.valueOf(rs.getString("created_at")).toLocalDate());
				//member.setExpire(Date.valueOf(rs.getString("created_at")).toLocalDate().plusYears(1));
				bbook.setCard_id(member);
				
				list.add(bbook);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
		
	}

	public static boolean addReturnBooks(borrowBooks borrowbook) throws SQLException {
		boolean result = false;
		Connection con = null;
		try{
			con = myConnection.getConnection();
			
			String updateReturnDate = "UPDATE borrowbooks SET return_date =? WHERE id=?";
			String updateBookavailable = "UPDATE books SET is_available =? WHERE code =? ";
			String updateFees = "UPDATE borrowbooks SET fees=? WHERE id=?";
			
			Books book = borrowbook.getCode();
			
			con.setAutoCommit(false);
			
			//update borrowbooks Table-> returnDate
			PreparedStatement pstm = con.prepareStatement(updateReturnDate);
			pstm.setString(1, borrowbook.getReturn_date().now().toString());
			pstm.setInt(2, borrowbook.getId());
			pstm.executeUpdate();
			
			//update BookTable->Available
			PreparedStatement pstm1 = con.prepareStatement(updateBookavailable);
			pstm1.setInt(1, 1);
			pstm1.setInt(2, book.getCode());
			pstm1.executeUpdate();
			
			//update borrowbooks Table-> fees
			
			Period dateperiod = Period.between(borrowbook.getDue_date(),LocalDate.now());
			int p = dateperiod.getDays();
			int feesForOneDay = 100;
			
			if(p>0) {
			PreparedStatement pstm2 = con.prepareStatement(updateFees);
			pstm2.setInt(1, feesForOneDay*p);
			pstm2.setInt(2, borrowbook.getId());
			pstm2.executeUpdate();
			}
			result = true;
			con.commit();
			
		} catch (Exception e) {
			e.printStackTrace();
			con.rollback();
			result = false;
		}
		finally {
			con.close();
		}
		return result;
	}

	public static List<Libarians> getAllLibarians() {
		List<Libarians> list = new ArrayList<>();
		try (Connection con = myConnection.getConnection()){
			String query = "SELECT * FROM librarians";
			PreparedStatement pstm = con.prepareStatement(query);
			ResultSet rs = pstm.executeQuery();
			
			while(rs.next()) {
				Libarians obj = new Libarians();
				obj.setId(rs.getInt("id"));
				obj.setEmail(rs.getString("email"));
				obj.setPass(rs.getString("password"));
				obj.setNrc(rs.getString("nrc"));
				obj.setPhno(rs.getString("phno"));
				obj.setCreateDate(Date.valueOf(rs.getString("created_at")).toLocalDate());
				list.add(obj);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public static void addLibarian(String email, String nrc, String phno) {
		// TODO Auto-generated method stub
		try (Connection con = myConnection.getConnection()){
			String query = "INSERT INTO librarians(email,nrc,phno,created_at) VALUES (?,?,?,?)";
			PreparedStatement pstm = con.prepareStatement(query);			
			pstm.setString(1, email);
			pstm.setString(2, nrc);
			pstm.setString(3, phno);
			pstm.setString(4, LocalDate.now().toString());
			pstm.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void editLibarian(Libarians lib) {
		try(Connection con = myConnection.getConnection()) {
			String query = "UPDATE librarians SET email =?,nrc=?,phno=? WHERE id=? ";
			PreparedStatement pstm = con.prepareStatement(query);
			pstm.setString(1, lib.getEmail());
			pstm.setString(2, lib.getNrc());
			pstm.setString(3, lib.getPhno());
			pstm.setInt(4, lib.getId());
			pstm.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static List<Libarians> FindAllLibarians(String email, String nrc, String phno) {
		Libarians lib = null;
		List<Libarians> liblist = new ArrayList<>();
		try(Connection con = myConnection.getConnection()){
			String query ="""
					SELECT * FROM Librarians WHERE email LIKE ? OR nrc LIKE ? OR phno LIKE ?
					""" ;
			PreparedStatement pstm = con.prepareStatement(query);
			pstm.setString(1, "%"+ email +"%" );
			pstm.setString(2, "%"+ nrc +"%");
			pstm.setString(3, "%"+ phno +"%");
			ResultSet rs = pstm.executeQuery();
			while(rs.next()) {
				lib = new Libarians();
				lib.setId(rs.getInt("id"));
				lib.setEmail(rs.getString("email"));
				lib.setNrc(rs.getString("nrc"));
				lib.setPhno(rs.getString("phno"));
				lib.setPass(rs.getString("password"));
				lib.setCreateDate(Date.valueOf(rs.getString("created_at")).toLocalDate().now());
				liblist.add(lib);
			}
		}
			catch(Exception e){
				e.printStackTrace();
			}
		return liblist;
	}
}


