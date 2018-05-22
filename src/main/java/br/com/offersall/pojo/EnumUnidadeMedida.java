package br.com.offersall.pojo;

public enum EnumUnidadeMedida {
	
	KILOGRAMA(0, "Kg","Kilograma"),
	GRAMA(1, "Gr", "Grama"),
	MILIGRAMA(2, "Mg", "Milígrama"),
	LITRO(3, "Lt", "Litro"),
	MILILITRO(4, "Ml", "Milí­litro"),
	METRO_QUADRADO(5,"M²", "Metro Quadrado"),
	METRO_CUBICO(6, "M³", "Metro Cúbico"),
	METRO(7, "M", "Metro"),
	CENTIMETRO(8, "Cm", "Centí­metro"),
	MILIMETRO(9, "Mm", "Milímetro"),
	CAIXA(10, "Cx", "Caixa"),
	DUZIA(11, "Dz", "Dúzia"),
	MILHEIRO(12, "Mil", "Milheiro"),
	UNIDADE(13, "Und", "Unidade"),
	PAR(14, "Par", "Par"),
	KILATE(15, "K", "Quilate"),
	MIL_LITROS(16, "Mil L", "Mil Litros"),
	TONELADA(17, "Ton", "Tonelada"),
	MIL_METROS(18, "Mil M", "Mil Metros"),
	MIL_METROS_CUBICOS(19, "Mil M³", "Mil Metros Cúbicos"),
	MIL_METROS_QUADRADOS(20, "Mil M²", "Mil Metros Quadrados"),
	MILHAO(21, "Milhão", "Milhão"),
	HORA(22, "Hr", "Hora"),
	MINUTO(23, "Min", "Minuto"),
	SEGUNDO(24, "Seg", "Segundos");
	
	private int id;
	private String cod;
	private String unidadeMedida;
	
	private EnumUnidadeMedida(int id, String cod, String unidadeMedida) {
		this.id = id;
		this.cod = cod;
		this.unidadeMedida = unidadeMedida;
	}

	public String getCodUnidadeMedida(String cod) throws Exception{
		
		for(EnumUnidadeMedida e : EnumUnidadeMedida.values()){
			if(e.getCod().equals(cod))
				return e.getCod();
		}
		
		throw new Exception("Cod informado não existe");
	}
	
	public int getById(int id) throws Exception{
		
		for(EnumUnidadeMedida e : EnumUnidadeMedida.values()){
			if(e.getId() == id)
				return e.getId();
		}
		
		throw new Exception("Id informado não existe");
	}

	public String getUnidadeMedida(String unidadeMedida) throws Exception{
		
		for(EnumUnidadeMedida e : EnumUnidadeMedida.values()){
			if(e.getUnidadeMedida().equals(unidadeMedida))
				return e.getUnidadeMedida();
		}
		
		throw new Exception("Unidade de medida informado não existe");
	}
	
	public String getCod() {
		return cod;
	}

	public String getUnidadeMedida() {
		return unidadeMedida;
	}

	public int getId() {
		return id;
	}
	
}
