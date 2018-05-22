//package br.com.offersall.apiRest.cosmos;
//
//import java.net.URISyntaxException;
//
//import org.apache.http.client.methods.HttpGet;
//import org.apache.http.client.utils.URIBuilder;
//
//import br.com.offersall.pojo.Credencial;
//
//public class CosmosBeans {
//	
//	public HttpGet buscaProdutoPorCodigoDeBarra(String url, Credencial credencial, String codigoBarras) throws URISyntaxException {
//
//		URIBuilder builder = getBuilderUrl(url, CosmosPort.SERVICE_GET_GTINS, codigoBarras);
//		return builderRequest(new HttpGet(builder.toString()));
//	}
//	
//	public static URIBuilder getBuilderUrl(String url, String service, String codigoBarras)
//			throws URISyntaxException {
//
//		String urlService = url + service;
//		urlService = url + service.replace(":id", codigoBarras);
//
//		return new URIBuilder(urlService);
//	}
//	
//	private static Request builderRequest(Request request, String token) {
//		request.addHeader("X-Cosmos-Token" , token);
//		return request.version(HttpVersion.HTTP_1_1).connectTimeout(60000);
//	}
//
//}
