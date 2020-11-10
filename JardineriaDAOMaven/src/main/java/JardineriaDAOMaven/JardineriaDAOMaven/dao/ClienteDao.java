package JardineriaDAOMaven.JardineriaDAOMaven.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import JardineriaDAOMaven.JardineriaDAOMaven.model.Cliente;

public class ClienteDao implements Dao<Cliente>{
	
	private static List<Cliente> clientes = new ArrayList<Cliente>();

	public ClienteDao() {		
	}

	public Optional<Cliente> get(long id) {
		return Optional.ofNullable(clientes.get((int) id));
	}

	public List<Cliente> getAll() {
		return clientes;
	}

	public void save(Cliente cliente) {
		clientes.add(cliente);
	}

	public void update(Cliente cliente) {
		clientes.get(cliente.getCodigo_cliente()).setNombre_cliente(cliente.getNombre_cliente());
		clientes.get(cliente.getCodigo_cliente()).setNombre_contacto(cliente.getNombre_contacto());
		clientes.get(cliente.getCodigo_cliente()).setApellido_contacto(cliente.getApellido_contacto());
		clientes.get(cliente.getCodigo_cliente()).setTelefono(cliente.getTelefono());
		clientes.get(cliente.getCodigo_cliente()).setFax(cliente.getFax());
		clientes.get(cliente.getCodigo_cliente()).setLinea_direccion1(cliente.getLinea_direccion1());
		clientes.get(cliente.getCodigo_cliente()).setLinea_direccion2(cliente.getLinea_direccion2());
		clientes.get(cliente.getCodigo_cliente()).setCiudad(cliente.getCiudad());
		clientes.get(cliente.getCodigo_cliente()).setRegion(cliente.getRegion());
		clientes.get(cliente.getCodigo_cliente()).setPais(cliente.getPais());
		clientes.get(cliente.getCodigo_cliente()).setCodigo_postal(cliente.getCodigo_postal());
		clientes.get(cliente.getCodigo_cliente()).setCodigo_empleado_rep_ventas(cliente.getCodigo_empleado_rep_ventas());
		clientes.get(cliente.getCodigo_cliente()).setLimite_credito(cliente.getLimite_credito());
		
		//clientes.add(cliente);
	}

	public void delete(Cliente cliente) {
		clientes.remove(cliente);
	}

	
}
