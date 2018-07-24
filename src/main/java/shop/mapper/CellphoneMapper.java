package shop.mapper;

import java.util.List;

import shop.model.Cellphone;

public interface CellphoneMapper {

	List<Cellphone> search(Cellphone cellphone);

	List<Cellphone> findAll();

	Cellphone findOne(String id);
	
	
}
