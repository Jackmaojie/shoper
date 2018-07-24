package shop.controller.form;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import shop.model.Cellphone;


public class CellphoneForm {
	@Size(min=1,message="不能为空")
	private String id;
	@Size(min=1,message="不能为空")
	private String brand;
	@Size(min=1,message="不能为空")
	private String model;
	@Size(min=1,message="不能为空")
	private String os;
	@Size(min=1,message="不能为空")
	private String cpubrand;
	private Long ram;
	private Long storage;
	private String color;
	private String description;
	@NotNull
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
		this.brand = brand;
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
		this.os = os;
	}
	public String getCpubrand() {
		return cpubrand;
	}
	public void setCpubrand(String cpubrand) {
		this.cpubrand = cpubrand;
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
	public Cellphone tocellphone() {
		Cellphone cellphone=new Cellphone();
		cellphone.setId(id);
		cellphone.setBrand(brand);
		cellphone.setModel(model);
		cellphone.setOs(os);
		cellphone.setCpubrand(cpubrand);
		cellphone.setRam(ram);
		cellphone.setStorage(storage);
		cellphone.setColor(color);
		cellphone.setDescription(description);
		cellphone.setPrice(price);
		return cellphone;
	}
	
	public static CellphoneForm fromcellphone(Cellphone cellphone) {
		CellphoneForm cellphoneForm=new CellphoneForm();
		cellphoneForm.setId(cellphone.getId());
		cellphoneForm.setBrand(cellphone.getBrand());
		cellphoneForm.setModel(cellphone.getModel());
		cellphoneForm.setOs(cellphone.getOs());
		cellphoneForm.setCpubrand(cellphone.getCpubrand());
		cellphoneForm.setRam(cellphone.getRam());
		cellphoneForm.setStorage(cellphone.getStorage());
		cellphoneForm.setColor(cellphone.getColor());
		cellphoneForm.setDescription(cellphone.getDescription());
		cellphoneForm.setPrice(cellphone.getPrice());
		return cellphoneForm;
	}
	

}
