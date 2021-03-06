package br.com.globality.gam.console.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * @author Leonardo Andrade
 *
 */
@Entity
@Table(name = "ISC_TB034_REGISTRO_DE_PARA")
@NamedQueries({ @NamedQuery(name = "RegistroDePara.findAll", query = "select t from RegistroDePara t") })
@SequenceGenerator(name = "seq_registro_de_para", sequenceName = "ISC_TB034_REGISTRO_DE_PARA_S", initialValue = 1)
public class RegistroDePara extends AbstractEntity {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3086460721512448830L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_registro_de_para")
	@Column(name = "NU_REGISTRO_DE_PARA", nullable = false, unique = true)
	private Long id;
	
	@Column(name = "IC_ATIVO", nullable = false, length = 1)
	private boolean ativo;
	
	@Column(name = "IC_IMPORTADO", nullable = false, length = 1)
	private boolean importado;
	
	@ManyToOne(optional=false, cascade=CascadeType.REFRESH)
	@JoinColumn(name = "NU_ENT_APL_DE_PARA", nullable = false)
	private EntidadeAplicacaoDePara entidadeAplicacaoDePara;
	
	@ManyToOne(optional=false, cascade=CascadeType.REFRESH)
	@JoinColumn(name = "NU_REGISTRO_DE", nullable = false)
	private Registro registroDe;
	
	@ManyToOne(optional=false, cascade=CascadeType.REFRESH)
	@JoinColumn(name = "NU_REGISTRO_PARA", nullable = false)
	private Registro registroPara;
	
	@ManyToOne(optional=false, cascade=CascadeType.REFRESH)
	@JoinColumn(name = "NU_USUARIO_INCLUSAO", nullable = false)
	private Usuario usuarioInclusao;
	
	@Column(name = "DT_INCLUSAO", nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataInclusao;
	
	@ManyToOne(optional=true, cascade=CascadeType.REFRESH)
	@JoinColumn(name = "NU_USUARIO_ALTERACAO", nullable = true)
	private Usuario usuarioAlteracao;
	
	@Column(name = "DT_ALTERACAO", nullable = true)
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataAlteracao;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public boolean isAtivo() {
		return ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}

	public boolean isImportado() {
		return importado;
	}

	public void setImportado(boolean importado) {
		this.importado = importado;
	}

	public EntidadeAplicacaoDePara getEntidadeAplicacaoDePara() {
		return entidadeAplicacaoDePara;
	}

	public void setEntidadeAplicacaoDePara(EntidadeAplicacaoDePara entidadeAplicacaoDePara) {
		this.entidadeAplicacaoDePara = entidadeAplicacaoDePara;
	}

	public Registro getRegistroDe() {
		return registroDe;
	}

	public void setRegistroDe(Registro registroDe) {
		this.registroDe = registroDe;
	}

	public Registro getRegistroPara() {
		return registroPara;
	}

	public void setRegistroPara(Registro registroPara) {
		this.registroPara = registroPara;
	}

	public Usuario getUsuarioInclusao() {
		return usuarioInclusao;
	}

	public void setUsuarioInclusao(Usuario usuarioInclusao) {
		this.usuarioInclusao = usuarioInclusao;
	}

	public Date getDataInclusao() {
		return dataInclusao;
	}

	public void setDataInclusao(Date dataInclusao) {
		this.dataInclusao = dataInclusao;
	}

	public Usuario getUsuarioAlteracao() {
		return usuarioAlteracao;
	}

	public void setUsuarioAlteracao(Usuario usuarioAlteracao) {
		this.usuarioAlteracao = usuarioAlteracao;
	}

	public Date getDataAlteracao() {
		return dataAlteracao;
	}

	public void setDataAlteracao(Date dataAlteracao) {
		this.dataAlteracao = dataAlteracao;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RegistroDePara other = (RegistroDePara) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
}
