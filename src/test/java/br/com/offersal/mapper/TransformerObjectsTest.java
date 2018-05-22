package br.com.offersal.mapper;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;

import org.junit.Test;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;

import br.com.offersall.dto.ProdutoDTO;
import br.com.offersall.mapper.TransformerObjects;
import br.com.offersall.pojo.Produto;
import br.com.offersall.pojo.ProdutoEmpresa;

public class TransformerObjectsTest {
	
	@Test
	public void transformerInDTOTest() {
		Produto p = new Produto();
		p.setId(1);
		ProdutoDTO dto = (ProdutoDTO) TransformerObjects.transformerInDTO(p, ProdutoDTO.class);
		assertEquals("db5mRxeXhisEz4ZnUna44A==", dto.getId());
	}
	
	@Test
	public void transformerJsonToObjectTest() throws JsonParseException, JsonMappingException, IOException {
		String json = "{\"preco\":\"2.99\",\"produto\":{ \"nome\":\"OMO\",\"codigoBarras\":\"123456789097\"} }";
		ProdutoEmpresa produtoEmpresa = (ProdutoEmpresa) TransformerObjects.transformerJsonToObject(json, ProdutoEmpresa.class);
		assertEquals(new BigDecimal(2.99).setScale(2, RoundingMode.DOWN), produtoEmpresa.getPreco().setScale(2, RoundingMode.DOWN));
		assertEquals("OMO", produtoEmpresa.getProduto().getNome());
	}
	
	@Test
	public void transformerObjectToJsonTest() throws JsonParseException, JsonMappingException, IOException {
		ProdutoEmpresa produtoDoCliente = new ProdutoEmpresa();
		produtoDoCliente.setPreco(new BigDecimal(2.99).setScale(2, RoundingMode.DOWN));
		Produto produto = new Produto();
		produto.setNome("OMO");
		produto.setCodigoBarras(1234567890972l);
		produtoDoCliente.setProduto(produto);
		String JSON  = TransformerObjects.transformerObjectToJson(produtoDoCliente);
		assertEquals(new BigDecimal(2.99).setScale(2, RoundingMode.DOWN), produtoDoCliente.getPreco().setScale(2, RoundingMode.DOWN));
		assertEquals("{\"id\":null,\"preco\":2.99,\"precoPromocional\":null,\"ativo\":false,\"produtoNaPromocao\":false}", JSON);
	}
	
	@Test
	public void getNodeJsonTest() throws JsonParseException, JsonMappingException, IOException {
		String json = "{\"valor\":\"2.99\",\"produto\":{ \"nome\":\"OMO\",\"codigoDeBarras\":\"1234567890972\"} }";
		JsonNode node = TransformerObjects.getNodeJson(json, "valor");
		assertEquals("2.99", node.asText());
	}
}
