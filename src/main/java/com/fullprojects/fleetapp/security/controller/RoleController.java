package com.fullprojects.fleetapp.security.controller;


import com.fullprojects.fleetapp.models.User;
import com.fullprojects.fleetapp.security.model.Role;
import com.fullprojects.fleetapp.security.service.RoleService;
import com.fullprojects.fleetapp.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class RoleController {
    @Autowired
    private RoleService roleService;

    @Autowired
    private UserService userService;


    @GetMapping("/roles")
    public String getRoles(Model model){

        List<Role> roleList  = roleService.getRoles();
        model.addAttribute("roles", roleList);

        return "role";
    }

    @GetMapping("/user/Edit/{id}")
    public String editUser(@PathVariable int id, Model model){
        User user = userService.findById(id);
        model.addAttribute("user", user);
        model.addAttribute("userRoles", roleService.getUserRoles(user));
        model.addAttribute("userNotRoles", roleService.getUserNotRoles(user));
        return "/userEdit";
    }


    @PostMapping("/roles/addNew")
    public String addNew(Role role){
        roleService.save(role);
        return "redirect:/roles";
    }

    @RequestMapping(value = "/roles/findById")
    @ResponseBody
    public Role findById(int id) {
        return roleService.findById(id);
    }

    @RequestMapping(value="/roles/update", method= {RequestMethod.PUT, RequestMethod.GET})
    public String update(Role role) {
        roleService.save(role);
        return "redirect:/roles";
    }

    @RequestMapping(value="/roles/delete", method= {RequestMethod.DELETE, RequestMethod.GET})
    public String delete(Integer id) {
        roleService.delete(id);
        return "redirect:/roles";
    }

    @RequestMapping("/roles/assign/{userId}/{roleId}")
    public String assignRole(@PathVariable Integer userId,
                             @PathVariable Integer roleId){
        roleService.assignUserRole(userId, roleId);
        return "redirect:/user/Edit/"+userId;
    }


    @RequestMapping("/roles/unassign/{userId}/{roleId}")
    public String unassignRole(@PathVariable Integer userId,
                               @PathVariable Integer roleId){
        roleService.unassignUserRole(userId, roleId);
        return "redirect:/user/Edit/"+userId;
    }

}
