package com.inti.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inti.entities.Role;
import com.inti.repositories.RoleRepository;
import com.inti.service.interfaces.IRoleService;

@Service
public class RoleService implements IRoleService{
	@Autowired
	RoleRepository roleRepository;
	
	//findAll
	@Override
	public List<Role> findAll() {
		return roleRepository.findAll();
	}

	//findOne
	@Override
	public Role findOne(Long idRole) {
		return roleRepository.findById(idRole).get();
	}
	
	//save
	@Override
	public Role save(Role role) {
		return roleRepository.save(role);
	}

	//delete
	@Override
	public void delete(Long idRole) {
		roleRepository.deleteById(idRole);
	}

	//findBy
	@Override
	public Role findByIdRoleAndLibelle(Long idRole, String libelle) {
		return roleRepository.findByIdRoleAndLibelle(idRole, libelle);
	}

}