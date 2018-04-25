package br.imd.pds.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ConstraintMode;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;

@Entity
@Table(name="role")
public class Role implements GrantedAuthority {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Column(name="name")
	private String name;
	
	@ManyToMany(fetch=FetchType.LAZY, cascade=CascadeType.ALL, targetEntity=User.class)
    @JoinTable(name = "user_role",
            joinColumns=@JoinColumn(name="role_id",nullable=false,updatable=false),
            inverseJoinColumns=@JoinColumn(name="user_id",nullable=false,updatable=false),
            foreignKey=@ForeignKey(ConstraintMode.CONSTRAINT),
            inverseForeignKey=@ForeignKey(ConstraintMode.CONSTRAINT)
    )
	private List<User> users;


	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@Override
	public String getAuthority() {
		return name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	
}
