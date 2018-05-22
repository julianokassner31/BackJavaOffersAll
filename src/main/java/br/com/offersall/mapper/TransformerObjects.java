package br.com.offersall.mapper;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class TransformerObjects {

	@SuppressWarnings("unchecked")
	public static <T> Object transformerInDTO(T produto, @SuppressWarnings("rawtypes") Class clazz) {
		ProdutoMapper mapper = new ProdutoMapper();
		return mapper.map(produto, clazz);
	}            
	
	public static <T> Object transformerJsonToObject(String json, T t) throws JsonParseException, JsonMappingException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		return mapper.readValue(json, (Class<T>) t);
	}
	
	public static <T> String transformerObjectToJson(Object obj) throws JsonParseException, JsonMappingException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		return mapper.writeValueAsString(obj);
	}
	
	public static JsonNode getNodeJson(String json, String node) throws JsonProcessingException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		JsonNode jsonNode = mapper.readTree(json);
		return jsonNode.get(node);
	}
}
