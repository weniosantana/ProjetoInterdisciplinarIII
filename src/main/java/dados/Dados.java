package dados;

public class Dados {
	private String codItem;
	private String nomItem;
	private String marcItem;
	private float valorItem;
	
	
	
	
	public Dados() {
		
	}
	
	public Dados(String codItem, String nomItem, String marcItem, float valorItem) {
		super();
		this.codItem = codItem;
		this.nomItem = nomItem;
		this.marcItem = marcItem;
		this.valorItem = valorItem;
	}
	public String getCodItem() {
		return codItem;
	}
	public void setCodItem(String codItem) {
		this.codItem = codItem;
	}
	public String getNomItem() {
		return nomItem;
	}
	public void setNomItem(String nomItem) {
		this.nomItem = nomItem;
	}
	public String getMarcItem() {
		return marcItem;
	}
	public void setMarcItem(String marcItem) {
		this.marcItem = marcItem;
	}
	public float getValorItem() {
		return valorItem;
	}
	public void setValorItem(float valorItem) {
		this.valorItem = valorItem;
	}
	
	
	
	
	
	
	
	
}
