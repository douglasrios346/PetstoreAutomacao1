package dataFactory;

import pojo.CadastroPedidoPojo;

public class CadastroPedidoDataFactory {
    static CadastroPedidoPojo pedido = new CadastroPedidoPojo();
    public static CadastroPedidoPojo setBody(){
        pedido.setId(1);
        pedido.setPetId(1);
        pedido.setQuantity(1);
        pedido.setShipDate("2024-03-08T23:07");
        pedido.setStatus("placed");
        pedido.setComplete(true);
        return pedido;
    }
}
