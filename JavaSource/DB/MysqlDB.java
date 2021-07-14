package DB;
import java.sql.*;
public class MysqlDB {
	
	static Connection con=null;
	private static String rapporteur="";
	
	static void getIntance(){
		
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/gestion_societe","root","");
			rapporteur="suces";
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			rapporteur="ClassNotFoundException";
			//e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			rapporteur="SQLException";
		}
		
	}

	/*
	 * la suivante methode est utilisée pour interroger la base de donnée en lui passant
	 * le parametre de type select
	 */
	public static ResultSet extraire_DB(String requete){
		
		ResultSet result=null;
		Statement st=null;
		if(con==null)
			getIntance();
		if(con!=null){
			try {
				
				st=con.createStatement();
				result=st.executeQuery(requete);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		return result;
	}
	
	/*
	 * La suite fonction est appellée quand on aura une requete commencant par
	 * insert, update, delete ,etc 
	 */
	public static int update_Bd(String requete){
	 	int nb=-1;
	    Statement st=null;	
	 	if(con==null)
	 		getIntance();
	 	if(con!=null)
	 	{
	 		try {
				st=con.createStatement();
				nb=st.executeUpdate(requete);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	 		
	 		
	 	}
	 	
		return nb;
	}

}

