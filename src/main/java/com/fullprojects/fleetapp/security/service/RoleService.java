package com.fullprojects.fleetapp.security.service;

import com.fullprojects.fleetapp.models.User;
import com.fullprojects.fleetapp.repositories.UserRepository;
import com.fullprojects.fleetapp.security.model.Role;
import com.fullprojects.fleetapp.security.repositories.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class RoleService {
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private UserRepository userRepository;

    //Return List of countries
    public List<Role> getRoles(){
        return roleRepository.findAll();
    };

    //add/save Countries to database
    public void save(Role role){
        roleRepository.save(role);
    }

    //get by id
    public Role findById(int id) {
        return roleRepository.findById(id).orElse(null);
    }


    public void delete(Integer id) {
        roleRepository.deleteById(id);
    }

    public void assignUserRole(Integer userId, Integer roleId ){
        User user = userRepository.findById(userId).orElse(null);
        Role role = roleRepository.findById(roleId).orElse(null);

        Set<Role> useRoles = user.getRoles();
        useRoles.add(role);
        user.setRoles(useRoles);
        userRepository.save(user);

    }
    public void unassignUserRole(Integer userId, Integer roleId){
        User user = userRepository.findById(userId).orElse(null);

        Set<Role> useRoles = user.getRoles();
        useRoles.removeIf(x-> x.getId() == roleId);
        userRepository.save(user);
    }
    public Set<Role> getUserRoles(User user){
        return user.getRoles();
    }
    public Set<Role> getUserNotRoles(User user){
        return roleRepository.getUserNotRoles(user.getId());
    }
}
