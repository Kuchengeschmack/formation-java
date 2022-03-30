package fr.adaming.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.adaming.dao.AdminProduitDaoImpl;
import fr.adaming.dao.IAdminCategorieDao;
import fr.adaming.entities.Admin;
import fr.adaming.entities.Categorie;
import fr.adaming.entities.Client;

@Service
public class AdminCategorieServiceImpl extends AdminProduitDaoImpl implements IAdminCategorieService {

	@Autowired
	IAdminCategorieDao catDao;

	@Override
	public boolean addCategory(Categorie catIn) {

		return catDao.addCategory(catIn);
	}

	@Override
	public boolean updateCategory(Categorie catIn) {

		return catDao.updateCategory(catIn);
	}

	@Override
	public Categorie getCategoryById(Categorie catIn) {

		return catDao.getCategoryById(catIn);
	}

	@Override
	public boolean deleteCategory(Categorie catIn) {

		return catDao.deleteCategory(catIn);
	}

	@Override
	public boolean addClient(Client client) {

		return catDao.addClient(client);
	}

	@Override
	public boolean updateClient(Client client) {

		return catDao.updateClient(client);
	}

	@Override
	public boolean addAdminProduct(Admin admin) {

		return catDao.addAdminProduct(admin);
	}

	@Override
	public boolean updateAdminProduct(Admin admin) {

		return catDao.updateAdminProduct(admin);
	}

	@Override
	public boolean addAdminCategory(Admin admin) {

		return catDao.addAdminCategory(admin);
	}

	@Override
	public boolean updateAdminCategory(Admin admin) {

		return catDao.updateAdminCategory(admin);
	}

}
