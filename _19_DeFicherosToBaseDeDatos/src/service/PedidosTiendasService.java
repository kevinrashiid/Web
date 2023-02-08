package service;

import java.util.List;

import model.pedidos;

public interface PedidosTiendasService {
	
	List<pedidos> pedidosTienda(String dirFichero);
	void guardarPedido(pedidos pedido);
	void guardarPedidos(List<pedidos> pedidos);
	int totalDeUnidades();
	String productoUltimoProducto();
	
}