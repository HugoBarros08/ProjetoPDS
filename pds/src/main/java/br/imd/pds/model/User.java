package br.imd.pds.model;

import java.util.Collection;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.br.CPF;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * Classe responsável por moldar Usuários
*/
@Entity
public class User implements UserDetails {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "user_id")
	private long id;
	
	@CPF
	@NotNull
	@Column(name = "cpf")
	private String cpf;
	
	@NotNull
	@Size(max = 100)
	@Column(name = "name")
	private String name;
	
	@NotNull
	@Column(name = "username")
	private String username;
	
	@NotEmpty
	@Length(min = 8, message = "*Sua senha deve conter no mínimo 8 caracteres")
	@Column(name = "password")
	private String password;
	
	@NotNull
	@Size(max = 100)
	@Column(name = "email")
	private String email;
	
	@ManyToOne
	@JoinColumn(name = "sector_id")
	private Sector sector;
	
	@Column(name = "flag_user")
	private boolean flag;
	
	@ManyToMany(fetch = FetchType.LAZY, cascade=CascadeType.ALL, mappedBy="users")
	private List<Role> roles;

	public User() {
		
	}
	
	public User(String cpf, String name, String username, String password, String email, Sector sector, List<Role> roles) {
		super();
		this.cpf = cpf;
		this.name = name;
		this.username = username;
		this.password = password;
		this.email = email;
		this.sector = sector;
		this.flag = true;
		this.roles = roles;
	}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
	public void setCpf(String cpf)
	{
		this.cpf = cpf;
	}

	public String getCpf()
	{
		return cpf;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getName()
	{
		return name;
	}

	public void setEmail(String email)
	{
		this.email = email;
	}

	public String getEmail()
	{
		return email;
	}
	
	public boolean getFlag() {
		return flag;
	}

	public void setFlag(boolean flag) {
		this.flag = flag;
	}
	
	

	@Override
	public String toString() {
		return "User [id=" + id + ", cpf=" + cpf + ", name=" + name + ", email=" + email + "]";
	}

	public Sector getSector() {
		return sector;
	}

	public void setSector(Sector sector) {
		this.sector = sector;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return this.roles;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return this.flag;
	}

}
