package br.com.webservice.model.model;



public class Reserva {
	private Long id;
	private String data;
	private int idMesa;
	private Usuario cliente;
	
	public Reserva() {
	}
	
	
	public Reserva(Long id, String data, int idMesa, Usuario cliente) {
		this.id = id;
		this.data = data;
		this.idMesa = idMesa;
		this.cliente = cliente;
	}


	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public Usuario getCliente() {
		return cliente;
	}
	public void setCliente(Usuario cliente) {
		this.cliente = cliente;
	}
	


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}
	public int getIdMesa() {
		return idMesa;
	}


	public void setIdMesa(int idMesa) {
		this.idMesa = idMesa;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Reserva other = (Reserva) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
