package bilgeadam.bean;

import java.util.Date;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import bilgeadam.dao.BookDAOImpl;
import bilgeadam.dao.MemberDAOImpl;
import bilgeadam.dao.RentedBooksDAOImpl;
import bilgeadam.model.Book;
import bilgeadam.model.Member;

@ManagedBean
@RequestScoped
public class KayitEkleBean {
    private String kitapAdi;
    private String uyeAdiSoyadi;
    private Date kayitTarihi;
    private Date sonKayitTarihi;
	public KayitEkleBean() {
		super();
	}
	public String getKitapAdi() {
		return kitapAdi;
	}
	public void setKitapAdi(String kitapAdi) {
		this.kitapAdi = kitapAdi;
	}
	public String getUyeAdiSoyadi() {
		return uyeAdiSoyadi;
	}
	public void setUyeAdiSoyadi(String uyeAdiSoyadi) {
		this.uyeAdiSoyadi = uyeAdiSoyadi;
	}
	public Date getKayitTarihi() {
		return kayitTarihi;
	}
	public void setKayitTarihi(Date kayitTarihi) {
		this.kayitTarihi = kayitTarihi;
	}
	public Date getSonKayitTarihi() {
		return sonKayitTarihi;
	}
	public void setSonKayitTarihi(Date sonKayitTarihi) {
		this.sonKayitTarihi = sonKayitTarihi;
	}
	public void kaydet()
	{
		RentedBooksDAOImpl rbdi = new RentedBooksDAOImpl();
		MemberDAOImpl mdi = new MemberDAOImpl();
		Member member = mdi.find(uyeAdiSoyadi);
		BookDAOImpl bdi = new BookDAOImpl();
		Book book = bdi.kitabiBul(kitapAdi);
		if(book!=null&&member!=null)
		{
			rbdi.saveRentedBook(member, book, kayitTarihi, sonKayitTarihi);
			addMessage("islem basarili","kayit eklendi");
		}else {
			errorMessage("islem basarisiz","lutfen kontrol ediniz");
		}
		
	}
	public void addMessage(String summary,String detail)
	{
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO,summary,detail);
		FacesContext.getCurrentInstance().addMessage(null, message);
	}
	public void errorMessage(String summary,String detail)
	{
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR,summary,detail);
		FacesContext.getCurrentInstance().addMessage(null, message);
	}
}
