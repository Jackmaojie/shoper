package shop.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import shop.mapper.CellphoneMapper;
import shop.model.Cellphone;
import shop.service.CellphoneService;

@Service
public class CellphoneServiceImpl implements CellphoneService {
	
	private CellphoneMapper cellphoneMapper;
	
	
	public CellphoneServiceImpl(CellphoneMapper cellphoneMapper) {
		this.cellphoneMapper = cellphoneMapper;
	}


	@Override
	public List<Cellphone> search(Cellphone cellphone) {

		return cellphoneMapper.search(cellphone);
	}


	@Override
	public List<Cellphone> findAll() {
		return cellphoneMapper.findAll();
	}


	@Override
	public Cellphone findOne(String id) {

		return cellphoneMapper.findOne(id);
	}

}
