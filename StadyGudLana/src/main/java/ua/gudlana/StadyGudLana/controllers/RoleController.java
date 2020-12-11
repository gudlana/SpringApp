package ua.gudlana.StadyGudLana.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ua.gudlana.StadyGudLana.data.domain.Role;
import ua.gudlana.StadyGudLana.service.RoleService;

@Controller
public class RoleController {

    @Autowired
    private RoleService roleService;

    @GetMapping("/roles")
    public String getAllRoles(Model model){
        model.addAttribute("roles", roleService.findAll());
        return "sprRoleList";
    }

    @GetMapping("/addRole")
    public String getRoleForm() {
        return "role_form";

    }

    @PostMapping("/addRole")
    public String createRole(@ModelAttribute("addRole") Role request, Model model){
        roleService.createRole(request);
        model.addAttribute("roles", roleService.findAll());
        return "role_form";
    }

    @GetMapping("/editRole")
    public String editRole(@PathVariable("id") String roleId, Model model){
        model.addAttribute("editRole", roleService.findRoleById(roleId));
        return "role_edit_form";
    }

    @PostMapping("/editRole")
    public String updateRole(@ModelAttribute("editRole") Role role, Model model){
        roleService.updateRole(role);
        model.addAttribute("roles", roleService.findAll());
        return "roles_list";
    }


}
