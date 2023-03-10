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
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "projeto")
public class Projeto implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "gerador1", sequenceName = "projeto_codigo_seq", allocationSize = 1)
	@GeneratedValue(generator = "gerador1", strategy = GenerationType.SEQUENCE)
	private Long codigo;
	
	@Column(name = "nome")
	@NotBlank(message = "O nome é obrigatório")
	private String nome;
	
	@Column(name = "descricao")
	@NotBlank(message = "A descrição é obrigatória")
	private String descricao;
	
	@Column(name = "status")
	@Enumerated(EnumType.STRING)
	private Status status = Status.ATIVO;
	
	@Column(name = "area")
	@Enumerated(EnumType.STRING)
	private Areas area = Areas.ENSINO;

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

	public Areas getArea() {
		return area;
	}

	public void setArea(Areas area) {
		this.area = area;
	}

	@Override
	public int hashCode() {
		return Objects.hash(area, codigo, descricao, nome, status);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Projeto other = (Projeto) obj;
		return area == other.area && Objects.equals(codigo, other.codigo) && Objects.equals(descricao, other.descricao)
				&& Objects.equals(nome, other.nome) && status == other.status;
	}

	@Override
	public String toString() {
		return "Projeto [codigo=" + codigo + ", nome=" + nome + ", descricao=" + descricao + ", status=" + status
				+ ", area=" + area + "]";
	}
}
