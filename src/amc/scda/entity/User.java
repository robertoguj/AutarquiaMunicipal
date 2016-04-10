package amc.scda.entity;

import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import amc.scda.entity.enums.ContaStatus;

@Entity
@NamedQueries(value = { @NamedQuery(name = "User.findByEmailSenha", query = "SELECT u FROM User u "
		+ "WHERE u.email = :email AND u.password = :password") })
@Table(name = "users")
public class User extends AbstractEntity implements UserDetails {

	private static final long serialVersionUID = 1L;

	@Transient
	public static final String FIND_BY_EMAIL_SENHA = "User.findByEmailSenha";
	
	@Transient
	public static final String FIND_BY_ID = "User.findByID";

	@Id
	@SequenceGenerator(name = "seq", sequenceName = "id_seq", allocationSize = 1)
	@GeneratedValue(generator = "seq", strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "user_username", unique = true)
	private String username;

	@Column(name = "user_password")
	private String password;

	@Column(name = "cpf")
	private String cpf;

	@Column(name = "nm_usuario")
	private String nome;

	@Column(name = "email")
	private String email;

	@Column(name = "telefone")
	private String telefone;

	@Column(name = "data_cadastro")
	@Temporal(TemporalType.DATE)
	private Date dataCadastro;

	@Column(name = "status")
	@Enumerated(EnumType.STRING)
	private ContaStatus status;

	@ManyToMany
	@JoinTable(name = "users_roles", joinColumns = { @JoinColumn(name = "user_id") }, inverseJoinColumns = { @JoinColumn(name = "role_id") })
	@LazyCollection(LazyCollectionOption.FALSE)
	private List<Role> roles;

	// 
	@Column(name = "status_conta")
	private boolean ativo;

	@Transient
	private Boolean checkboxSelecao = false;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public ContaStatus getStatus() {
		return status;
	}

	public void setStatus(ContaStatus status) {
		this.status = status;
	}

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	public boolean isAtivo() {
		return ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}

	@Override
	@Transient
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return roles;
	}

	@Override
	@Transient
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	@Transient
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	@Transient
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	@Transient
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return false;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public Date getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public Boolean getCheckboxSelecao() {
		return checkboxSelecao;
	}

	public void setCheckboxSelecao(Boolean checkboxSelecao) {
		this.checkboxSelecao = checkboxSelecao;
	}

}