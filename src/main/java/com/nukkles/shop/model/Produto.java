package com.nukkles.shop.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name= "tb_produto")
public class Produto {
		
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		public Long id;
		
		@NotNull
		@Size(min = 10, max = 100, message="O campo deve ter no mínimo 10 caracteres, e no máximo 100 caracteres")
		private String titulo;
		
		@NotNull
		@Column(precision = 6, scale = 2)
		public BigDecimal valor;
		
		@ManyToOne
		@JsonIgnoreProperties("categoria")
		private Categoria categoria;
		
		@ManyToOne
		@JsonIgnoreProperties("usuario")
		private Usuario usuario;

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getTitulo() {
			return titulo;
		}

		public void setNome(String titulo) {
			this.titulo = titulo;
		}

		public BigDecimal getValor() {
			return valor;
		}

		public void setValor(BigDecimal valor) {
			this.valor = valor;
		}

		public Categoria getCategoria() {
			return categoria;
		}

		public void setCategoria(Categoria categoria) {
			this.categoria = categoria;
		}

		public Usuario getUsuario() {
			return usuario;
		}

		public void setUsuario(Usuario usuario) {
			this.usuario = usuario;
		}		
}