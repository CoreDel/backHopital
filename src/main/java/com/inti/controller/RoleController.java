package com.inti.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.inti.entities.Role;
import com.inti.service.interfaces.IRoleService;


@RestController
@CrossOrigin 
public class RoleController {
	@Autowired
	IRoleService roleService;
	
	//findAll
	@GetMapping(value="/roles")
	public List<Role> findAll(){
		return roleService.findAll();
	}
	
	//findOne
	@GetMapping(value = "/roles/{idR}")
	public Role findOne(@PathVariable("idR") Long idRole) {
		return roleService.findOne(idRole);
	}
	
	//findBy
	@GetMapping(value = "/roles/{idR}/{libelle}")
	public Role findByIdRoleAndLibelle(@PathVariable("idR") Long idRole,@PathVariable("libelle") String libelle) {
		return roleService.findByIdRoleAndLibelle(idRole, libelle);
	}
	
	//save
	@PostMapping(value = "/roles")
	public Role saveRole(@RequestBody Role role){
		return roleService.save(role);
	}
	
	//update
	@PutMapping(value="/roles/{idR}")
	public Role updateRole(@PathVariable("idR") Long idRole, @RequestBody Role role) {
		Role currentRole=roleService.findOne(idRole); 
		currentRole.setLibelle(role.getLibelle());	
		return roleService.save(currentRole);	
	}
	
	//delete
	@DeleteMapping(value = "/roles/{idR}")
	public void deleteRole(@PathVariable("idR") Long idRole) {
		roleService.delete(idRole);
	}
}