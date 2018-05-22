package br.com.offersall.apiRest.cosmos;

public class CosmosPort {
	
	public static final String URL = "https://api.cosmos.bluesoft.com.br";
	
	public static final String SERVICE_GET_GTINS = "/gtins/:id"; //Recupera detalhes do produto atráves do GTIN/EAN informado.
	public static final String SERVICE_GET_GPCS = "/gpcs/:id"; //Recupera detalhes do GPC e Produtos vínculados a ele, atráves do código informado.
	public static final String SERVICE_GET_NCMS_PRODUCTS = "/ncms/:id/products"; //Recupera detalhes do NCM e Produtos vínculados a ele, atráves do código informado.
	public static final String SERVICE_GET_PRODUCTS = "/products?query=:id"; //Recupera lista de produtos paginados atráves da descrição ou GTIN.
	
	
}
