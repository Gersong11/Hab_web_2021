package com.ufps.web.examen.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the connectiontoken database table.
 * 
 */
@Entity
@NamedQuery(name="Connectiontoken.findAll", query="SELECT c FROM Connectiontoken c")
public class Connectiontoken implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private String db;

	private String host;

	private String pass;

	private int port;

	private String state;

	private String token;

	private String userdb;
	
	public Connectiontoken(String db, String host, String pass, short port, String token, String userdb,
			Typedb typedb) {
		super();
		this.db = db;
		this.host = host;
		this.pass = pass;
		this.port = port;
		this.token = token;
		this.userdb = userdb;
		this.typedb = typedb;
	}

	//bi-directional many-to-one association to Typedb
	@ManyToOne
	@JoinColumn(name="type")
	private Typedb typedb;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="user")
	private Usuario usuario;

	//bi-directional many-to-one association to Reporte
	@OneToMany(mappedBy="connectiontoken")
	private List<Reporte> reportes;

	public Connectiontoken() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDb() {
		return this.db;
	}

	public void setDb(String db) {
		this.db = db;
	}

	public String getHost() {
		return this.host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public String getPass() {
		return this.pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public int getPort() {
		return this.port;
	}

	public void setPort(int port) {
		this.port = port;
	}

	public String getState() {
		return this.state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getToken() {
		return this.token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getUserdb() {
		return this.userdb;
	}

	public void setUserdb(String userdb) {
		this.userdb = userdb;
	}

	public Typedb getTypedb() {
		return this.typedb;
	}

	public void setTypedb(Typedb typedb) {
		this.typedb = typedb;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List<Reporte> getReportes() {
		return this.reportes;
	}

	public void setReportes(List<Reporte> reportes) {
		this.reportes = reportes;
	}

	public Reporte addReporte(Reporte reporte) {
		getReportes().add(reporte);
		reporte.setConnectiontoken(this);

		return reporte;
	}

	public Reporte removeReporte(Reporte reporte) {
		getReportes().remove(reporte);
		reporte.setConnectiontoken(null);

		return reporte;
	}

}