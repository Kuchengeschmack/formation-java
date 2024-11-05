package fr.adaming.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.dao.IMarchandiseDao;
import fr.adaming.entities.Cargaison;
import fr.adaming.entities.Marchandise;

@Service
@Transactional
public class MarchandiseServiceImpl implements IMarchandiseService {

	private IMarchandiseDao marchDao;

	@Autowired
	public void setMarchDao(IMarchandiseDao marchDao) {
		this.marchDao = marchDao;
		marchDao.setGeneric(Marchandise.class);
	}

	@Override
	public Marchandise save(Marchandise entite) {
		marchDao.save(entite);
		return entite;

	}

	@Override
	public Marchandise update(Marchandise entite) {
		return marchDao.update(entite);

	}

	@Override
	public Marchandise getById(Long id) {
		return marchDao.getById(id);
	}

	@Override
	public int delete(Long id) {
		return marchDao.delete(id);

	}

	@Override
	public List<Marchandise> list() {

		return marchDao.list();
	}

	@Override
	public List<Marchandise> rechercheMarchandise(Cargaison cargIn) {

		return marchDao.rechercheMarchandise(cargIn);
	}

	@Override
	public List<Marchandise> rechercheMarchandise(String motClef) {

		return marchDao.rechercheMarchandise(motClef);
	}

}
