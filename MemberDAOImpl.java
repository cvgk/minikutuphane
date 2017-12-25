package bilgeadam.dao;

import java.util.List;

import org.hibernate.Session;

import bilgeadam.hibernateutil.HibernateUtil;
import bilgeadam.model.Member;

public class MemberDAOImpl {
      public void save(Member member)
      {
    	  Session session = HibernateUtil.getSession();
    	  session.beginTransaction();
    	  session.save(member);
    	  session.getTransaction().commit();
    	  session.close();
      }
      public Member find(String name)
      {
    	  Session session = HibernateUtil.getSession();
    	  session.beginTransaction();
    	  @SuppressWarnings("unchecked")
		  List<Member> list = session.createQuery("from Member").getResultList();
    	  for(int i=0;i<list.size();i++)
    	  {
    		  Member member = list.get(i);
    		  if(name.equalsIgnoreCase(member.getName()))
    		  {
    			  return member;
    		  }
    	  }
    	  return null;
      }
}

