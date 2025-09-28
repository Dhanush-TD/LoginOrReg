import java.sql.*;
import java.util.Scanner;

public class LoginOrReg {

    private static final String dbUrl = "jdbc:mysql://localhost:3306/login_re_db";
    private static final String dbName = "root";
    // 🔐 Password is now taken from environment variable, not hardcoded
    private static final String dbPassword = System.getenv("DB_PASSWORD");

    public static void main(String[] args)throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection c = DriverManager.getConnection(dbUrl,dbName,dbPassword);

        Scanner sc = new Scanner(System.in);

        while (true){
            System.out.println("\n===== MENU =====");
            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.println("3. Update Email");
            System.out.println("4. Forget Password");
            System.out.println("5. Exit");
            System.out.print("Enter the Option: ");
            int option = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (option){
                case 1:
                    System.out.print("Enter the Name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter the Email: ");
                    String email = sc.nextLine();
                    System.out.print("Enter the Password: ");
                    String password = sc.nextLine();
                    Register(c,name,email, password);
                    break;

                case 2:
                    System.out.print("Enter the Email: ");
                    String logEmail = sc.nextLine();
                    System.out.print("Enter the Password: ");
                    String logPassword = sc.nextLine();
                    login(c,logEmail, logPassword);
                    break;

                case 3:
                    System.out.print("Enter old Email: ");
                    String oldEmail = sc.nextLine();
                    System.out.print("Enter new Email: ");
                    String newEmail = sc.nextLine();
                    updateEmail(c, oldEmail, newEmail);
                    break;

                case 4:
                    System.out.print("Enter Email: ");
                    String lEmail = sc.nextLine();
                    System.out.print("Enter New Password: ");
                    String lPassword = sc.nextLine();
                    forgetPassword(c,lEmail,lPassword);
                    break;

                case 5:
                    System.out.println("👋 Exiting program. Goodbye!");
                    sc.close();
                    c.close();
                    return;

                default:
                    System.out.println("❌ Invalid Option! Please choose again.");
            }
        }
    }

    private static final String INSERT_SQL = "INSERT INTO registered (name,email,password) VALUES(?,?,?)";
    public static void Register(Connection c,String name,String email, String password) throws SQLException {
        String checkSql = "SELECT email FROM registered WHERE email = ?";
        PreparedStatement checkPt = c.prepareStatement(checkSql);
        checkPt.setString(1, email);

        ResultSet rs = checkPt.executeQuery();
        if (rs.next()) {
            System.out.println("⚠️ Hey! Your email is already registered. Just go with Login 🙂");
        } else {
            PreparedStatement insertPt = c.prepareStatement(INSERT_SQL);
            insertPt.setString(1,name);
            insertPt.setString(2, email);
            insertPt.setString(3, password);
            insertPt.executeUpdate();
            System.out.println("✅ Registration successful!");
        }
    }

    public static void login(Connection c, String logEmail,String logPassword) throws SQLException {
        String checkSQL = "SELECT * FROM registered WHERE email = ? AND password = ?";
        PreparedStatement p = c.prepareStatement(checkSQL);
        p.setString(1, logEmail);
        p.setString(2, logPassword);

        ResultSet r = p.executeQuery();
        if (r.next()){
            System.out.println("✅ Login successful!");
        } else {
            System.out.println("❌ Invalid Email or Password. Try again or use Forget Password 🙂");
        }
    }

    public static void updateEmail(Connection c, String oldEmail, String newEmail) throws SQLException {
        String updateSQL = "UPDATE registered SET email = ? WHERE email = ?";
        PreparedStatement u = c.prepareStatement(updateSQL);
        u.setString(1, newEmail);
        u.setString(2, oldEmail);
        int rows = u.executeUpdate();

        if (rows > 0) {
            System.out.println("✅ Email updated successfully!");
        } else {
            System.out.println("❌ Old Email not found. Try again.");
        }
    }

    public static void forgetPassword(Connection c, String lEmail , String lPassword) throws SQLException {
        String updateSQL = "UPDATE registered SET password = ? WHERE email = ?";
        PreparedStatement pu = c.prepareStatement(updateSQL);
        pu.setString(1, lPassword);
        pu.setString(2, lEmail);
        int rows = pu.executeUpdate();

        if (rows > 0) {
            System.out.println("✅ Password updated successfully!");
        } else {
            System.out.println("❌ Email not found. Please Register first 🙂");
        }
    }
}
