package fr.adaming.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.dao.IGeneriqueDao;
import fr.adaming.entities.Marchandise;

@Service
@Transactional
public class MarchandiseServiceImpl implements IMarchandiseService {

	private IGeneriqueDao<Marchandise> marchDao;

	@Autowired
	public void setMarchDao(IGeneriqueDao<Marchandise> marchDao) {
		this.marchDao = marchDao;
		marchDao.setGeneric(Marchandise.class);
	}

	@Override
	public Marchandise save(Marchandise entite) {
		marchDao.save(entite);
		return entite;

	}

	@Override
	public void update(Marchandise entite) {
		marchDao.update(entite);

	}

	@Override
	public Marchandise getById(Long id) {
		return marchDao.getById(id);
	}

	@Override
	public void delete(Long id) {
		marchDao.delete(id);

	}

}
