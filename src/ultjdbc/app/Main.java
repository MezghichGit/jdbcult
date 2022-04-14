package ultjdbc.app;
import java.sql.*;
import java.util.Scanner;
public class Main {

	public static void main(String[] args) throws SQLException {
		//System.out.println("Hello JDBC from Java");
		// STEP 1: on �tablit une connexion avec la base de donn�es mysql
	    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ultjdbc","root","");
	    //System.out.println(con);
	    
	    //Lecture des param�tres � partir du clavier
	    /*
	    Scanner sc = new Scanner(System.in);
	    System.out.println("Donner un nom");
	    String nom = sc.nextLine();
	    
	    System.out.println("Donner la classe");
	    String classe = sc.nextLine();*/
	    
	    
	   // STEP 2: Cr�ation d'un objet statement pour �crire les commandes SQL
	 	Statement stmt = con.createStatement();
	    //int result = stmt.executeUpdate("insert into etudiant(nom,classe) values('"+nom+"', '"+classe+"')");
	    //System.out.println(result);  // ici j'affiche le nombre d'�lement ins�rer
	    
	    
	    //Code de l'update (Mise � jour)
	 	//String newNom = "Omar Moutari";
	 	//int result = stmt.executeUpdate("update etudiant set nom='"+ newNom+"' where id ='1'");
	 	
	 	//Code delete(suppression)
	 	int result = stmt.executeUpdate("delete from etudiant where id ='4'");
	 	
	 	// STEP 3: Cr�ation objet ResultSET(table en m�moire) dont le r�le est de stocker le r�sultat d'une requete select
	 		ResultSet rs = stmt.executeQuery("select id, nom, classe from etudiant");
	 		
	 		// STEP 4: On fait le parcours du ResultSet et on affiche son contenu
	 		
	 		while(rs.next()) {
	 			
	 		int id = rs.getInt("id");
	 		String nom = rs.getString("nom");
	 		String classe = rs.getString("classe");
	 		System.out.println(id+ " "+nom +" "+classe);
	 		}
	    System.out.println("Fin du programme");

	}

}
