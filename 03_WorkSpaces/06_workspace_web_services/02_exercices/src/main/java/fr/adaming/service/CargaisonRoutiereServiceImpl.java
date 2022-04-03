package fr.adaming.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.dao.IGeneriqueDao;
import fr.adaming.entities.CargaisonRoutiere;

@Service
@Transactional
public class CargaisonRoutiereServiceImpl implements ICargaisonRoutiereService {

	private IGeneriqueDao<CargaisonRoutiere> cargRoutDao;

	@Autowired
	public void setCargRoutDao(IGeneriqueDao<CargaisonRoutiere> cargRoutDao) {
		this.cargRoutDao = cargRoutDao;
		cargRoutDao.setGeneric(CargaisonRoutiere.class);
	}

	@Override
	public CargaisonRoutiere save(CargaisonRoutiere entite) {
		cargRoutDao.save(entite);
		return entite;

	}

	@Override
	public void update(CargaisonRoutiere entite) {
		cargRoutDao.update(entite);

	}

	@Override
	public int delete(Long id) {
		return cargRoutDao.delete(id);

	}

	@Override
	public CargaisonRoutiere getById(Long id) {
		return cargRoutDao.getById(id);
	}

	@Override
	public List<CargaisonRoutiere> list() {

		return cargRoutDao.list();
	}

}
