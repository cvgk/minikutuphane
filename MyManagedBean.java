package bilgeadam.bean;

import java.io.Serializable;
import java.util.Date;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import bilgeadam.dao.MemberDAOImpl;
import bilgeadam.model.Member;

@ManagedBean
@ViewScoped
public class MyManagedBean implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name;
    private String telephone;
    private Date dateOfBirth;
    private Date kayitTarihi;
    public Date getKayitTarihi() {
		return kayitTarihi;
	}
	public void setKayitTarihi(Date kayitTarihi) {
		this.kayitTarihi = kayitTarihi;
	}
	public String getName() {
    	return name;
    }
    public void setName(String name) {
    	this.name = name;
    }
    public String getTelephone() {
    	return telephone;
    }
    public void setTelephone(String telephone)
    {
    	this.telephone = telephone;
    }
    public Date getDateOfBirth() {
    	return dateOfBirth;
    }
    public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public void save()
	{
		Member member = new Member(name,telephone,dateOfBirth,kayitTarihi);
		MemberDAOImpl impl = new MemberDAOImpl();
		impl.save(member);	
		addMessage("islem basarili","yeni kayit eklendi");
	}
	public void addMessage(String summary,String detail)
	{
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO,summary,detail);
		FacesContext.getCurrentInstance().addMessage(null, message);
	}
}
