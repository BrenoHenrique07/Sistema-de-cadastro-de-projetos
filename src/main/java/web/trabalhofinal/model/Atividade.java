package web.trabalhofinal.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="atividade")
public class Atividade implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "gerador", sequenceName = "atividade_codigo_seq", allocationSize = 1)
	@GeneratedValue(generator = "gerador", strategy = GenerationType.SEQUENCE)
	private Long codigo;
	
	@Column(name = "nome")
	@NotBlank(message = "O nome é obrigatório")
	private String nome;
	
	@Column(name = "descricao")
	@NotBlank(message = "A descrição é obrigatória")
	private String descricao;
	
	@Enumerated(EnumType.STRING)
	private Status status = Status.ATIVO;
	
	@ManyToOne
	@JoinColumn(name = "codigo_projeto")
	@NotNull
	private Projeto projeto;

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Projeto getProjeto() {
		return projeto;
	}

	public void setProjeto(Projeto projeto) {
		this.projeto = projeto;
	}

	@Override
	public int hashCode() {
		return Objects.hash(codigo, descricao, nome, projeto, status);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Atividade other = (Atividade) obj;
		return Objects.equals(codigo, other.codigo) && Objects.equals(descricao, other.descricao)
				&& Objects.equals(nome, other.nome) && Objects.equals(projeto, other.projeto) && status == other.status;
	}

	@Override
	public String toString() {
		return "Atividade [codigo=" + codigo + ", nome=" + nome + ", descricao=" + descricao + ", status=" + status
				+ ", projeto=" + projeto + "]";
	}
}
