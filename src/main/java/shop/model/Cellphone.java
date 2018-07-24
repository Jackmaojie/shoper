package shop.model;

public class Cellphone {
	private String id;
	private String brand;
	private String model;
	private String os;
	private String cpubrand;
	private Long ram;
	private Long storage;
	private String color;
	private String description;
	private Long price;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		//过滤空或者空字符串
        if (brand != null && !brand.trim().isEmpty()) {
            this.brand = brand;
        }
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getOs() {
		return os;
	}
	public void setOs(String os) {
        if (os != null && !os.trim().isEmpty()) {
            this.os = os;
        }
	}
	public String getCpubrand() {
		return cpubrand;
	}
	public void setCpubrand(String cpubrand) {
        if (cpubrand != null && !cpubrand.trim().isEmpty()) {
            this.cpubrand = cpubrand;
        }
	}
	public Long getRam() {
		return ram;
	}
	public void setRam(Long ram) {
		this.ram = ram;
	}
	public Long getStorage() {
		return storage;
	}
	public void setStorage(Long storage) {
		this.storage = storage;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Long getPrice() {
		return price;
	}
	public void setPrice(Long price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "Cellphone [id=" + id + ", brand=" + brand + ", model=" + model
				+ ", os=" + os + ", cpubrand=" + cpubrand + ", ram=" + ram
				+ ", storage=" + storage + ", color=" + color
				+ ", description=" + description + ", price=" + price + "]";
	}
	
	
	
	
	

}
