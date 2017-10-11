package UserData.LoginSampleAssignment.DAO;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LoginDAOImpl implements LoginDAO{
     
	   @Autowired	 
       private SessionFactory sessionFactory;

       public boolean checkLogin(String userName, String userPassword){
			
			Session session = sessionFactory.openSession();
			boolean userFound = false;
			
			String SQL_QUERY ="select * from assignment.user";
			org.hibernate.Query query = session.createSQLQuery(SQL_QUERY);
			List list = query.list();

			if ((list != null) && (list.size() > 0)) {
				userFound= true;
			}

			session.close();
			return userFound;              
       }
}