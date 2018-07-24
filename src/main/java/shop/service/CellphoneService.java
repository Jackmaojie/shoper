package shop.service;

import java.util.List;

import shop.model.Cellphone;

public interface CellphoneService {
	
	List<Cellphone> search(Cellphone cellphone);

	List<Cellphone> findAll();

	Cellphone findOne(String id);
	
	
}
