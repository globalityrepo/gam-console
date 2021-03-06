package br.com.globality.gam.console.model;

import java.util.Date;
import java.util.List;

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
import javax.persistence.Transient;

/**
 * @author Leonardo Andrade
 *
 */
@Entity
@Table(name = "ISC_TB031_ENTIDADE_APLICACAO")
@NamedQueries({ @NamedQuery(name = "EntidadeAplicacao.findAll", query = "select t from EntidadeAplicacao t") })
@SequenceGenerator(name = "seq_entidade_aplicacao", sequenceName = "ISC_TB031_ENTIDADE_APLICACAO_S", initialValue = 1)
public class EntidadeAplicacao extends AbstractEntity {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3216641697994272177L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_entidade_aplicacao")
	@Column(name = "NU_ENTIDADE_APLICACAO", nullable = false, unique = true)
	private Long id;
	
	@Column(name = "IC_ATIVO", nullable = false, length = 1)
	private boolean ativo;
	
	@Column(name = "IC_ACESSO_LIBERADO", nullable = false, length = 1)
	private Boolean liberarAcesso;
	
	@ManyToOne(optional=false, cascade=CascadeType.REFRESH)
	@JoinColumn(name = "NU_ENTIDADE", nullable = false)
	private Entidade entidade;
	
	@ManyToOne(optional=false, cascade=CascadeType.REFRESH)
	@JoinColumn(name = "NU_APLICACAO", nullable = false)
	private Aplicacao aplicacao;
	
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
	
	@Transient
	private List<Registro> registros;
	
	@Transient
	private List<AcessoDelegado> acessosDelegados;
		
	@Transient
	private boolean configurado;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public boolean getAtivo() {
		return ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}

	public Boolean getLiberarAcesso() {
		return liberarAcesso;
	}

	public void setLiberarAcesso(Boolean liberarAcesso) {
		this.liberarAcesso = liberarAcesso;
	}

	public Entidade getEntidade() {
		return entidade;
	}

	public void setEntidade(Entidade entidade) {
		this.entidade = entidade;
	}

	public Aplicacao getAplicacao() {
		return aplicacao;
	}

	public void setAplicacao(Aplicacao aplicacao) {
		this.aplicacao = aplicacao;
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

	public List<Registro> getRegistros() {
		return registros;
	}

	public void setRegistros(List<Registro> registros) {
		this.registros = registros;
	}

	public List<AcessoDelegado> getAcessosDelegados() {
		return acessosDelegados;
	}

	public void setAcessosDelegados(List<AcessoDelegado> acessosDelegados) {
		this.acessosDelegados = acessosDelegados;
	}

	public boolean isConfigurado() {
		return configurado;
	}

	public void setConfigurado(boolean configurado) {
		this.configurado = configurado;
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
		EntidadeAplicacao other = (EntidadeAplicacao) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
}
