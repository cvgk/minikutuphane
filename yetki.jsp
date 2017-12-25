<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="bilgeadam.dao.LibrarianDAOImpl,java.util.*,bilgeadam.model.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>yetki sayfasi</title>
</head>
<body>
      <%
        
        	 Librarian librarian = (Librarian)request.getAttribute("librarian");
        	 if(librarian.getYetkiSeviyesi()==1)
        	 {
        		 out.println("<h2>Yetkileriniz</h2>");
        		 out.println("<ol><li><a href='yenikayit.xhtml'>Yeni Kayit Ekle</a></li></ol>");
        	 }else if(librarian.getYetkiSeviyesi()==2)
        	 {
        		 out.println("<h2>Yetkileriniz</h2>");
        		 out.println("<ol><li><a href='yenikayit.xhtml'>Yeni Kayit Ekle</a></li>"+
        		 "<li><a href='butunkitaplar.xhtml'>Butun kitaplari gor</a></li></ol>");
        	 }else if(librarian.getYetkiSeviyesi()==3)
        	 {
        		 out.println("<h2>Yetkileriniz</h2>");
        		 out.println("<ol><li><a href='yenikayit.xhtml'>Yeni Kayit Ekle</a></li>"+
        		 "<li><a href='butunkitaplar.xhtml'>Butun kitaplari gor</a></li>");
        		 out.println("<li><a href='kiralanmiskitaplar.xhtml'>Kiralanmis kitaplari gor</a></li>"+
        		 "<li><a href='odunckitap1.jsp'>Kitap odunc ver</a></li></ol>");
        		 
        	 }
         
      %>
</body>
</html>