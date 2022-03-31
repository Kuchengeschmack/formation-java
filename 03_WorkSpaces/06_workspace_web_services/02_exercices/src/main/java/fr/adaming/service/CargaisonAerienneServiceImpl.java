package fr.adaming.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.dao.IGeneriqueDao;
import fr.adaming.entities.CargaisonAerienne;

@Service
@Transactional
public class CargaisonAerienneServiceImpl implements ICargaisonAerienneService {

	private IGeneriqueDao<CargaisonAerienne> cargAerDao;

	@Autowired
	public void setCargAerDao(IGeneriqueDao<CargaisonAerienne> cargAerDao) {
		this.cargAerDao = cargAerDao;
		cargAerDao.setGeneric(CargaisonAerienne.class);
	}

	@Override
	public CargaisonAerienne save(CargaisonAerienne entite) {
		cargAerDao.save(entite);
		return entite;

	}

	@Override
	public void update(CargaisonAerienne entite) {
		cargAerDao.update(entite);

	}

	@Override
	public void delete(Long id) {
		cargAerDao.delete(id);

	}

	@Override
	public CargaisonAerienne getById(Long id) {
		return cargAerDao.getById(id);
	}

}
