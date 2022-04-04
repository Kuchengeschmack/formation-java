package fr.adaming.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.dao.IGeneriqueDao;
import fr.adaming.entities.Cargaison;

@Service
@Transactional
public class CargaisonServiceImpl implements ICargaisonService {

	private IGeneriqueDao<Cargaison> cargDao;

	@Autowired
	public void setCargDao(IGeneriqueDao<Cargaison> cargDao) {
		this.cargDao = cargDao;
		cargDao.setGeneric(Cargaison.class);
	}

	@Override
	public Cargaison save(Cargaison entite) {
		cargDao.save(entite);
		return entite;

	}

	@Override
	public Cargaison update(Cargaison entite) {
		return cargDao.update(entite);

	}

	@Override
	public int delete(Long id) {
		return cargDao.delete(id);

	}

	@Override
	public Cargaison getById(Long id) {
		return cargDao.getById(id);
	}

	@Override
	public List<Cargaison> list() {

		return cargDao.list();
	}

}
