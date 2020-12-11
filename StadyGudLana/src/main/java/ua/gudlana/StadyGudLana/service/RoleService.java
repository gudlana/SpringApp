package ua.gudlana.StadyGudLana.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import ua.gudlana.StadyGudLana.data.domain.Role;
import ua.gudlana.StadyGudLana.data.repository.RoleRepository;

import java.util.Date;
import java.util.List;

@Service
public class RoleService {

    @Autowired
    private RoleRepository roleRepository;

    public List<Role> findAll() {
        return roleRepository.findAll();
    }


    public void createRole(Role role){
        Role userRole = roleRepository.findByRole(role.role);
        if(userRole == null) {
            Role newRole = new Role();
            newRole.role = role.role;
            newRole.description = role.description;
            newRole.dtCreate = new Date();
            roleRepository.save(newRole);
        }
    }

    public Role findRoleById(String roleId) {
        return roleRepository.findById(roleId).orElse(null);
    }

    public void updateRole(Role role) {
        Role updRole = roleRepository.findById(role.id).orElse(null);
        updRole.role = role.role;
        updRole.description = role.description;
        updRole.dtCreate = new Date();
        roleRepository.save(updRole);
    }


//    public RoleResponseDto createRole(RoleRequestDto request) {
//
//        Role role = new Role();
//        role.role = request.role;
//        role.description = request.description;
//        role.dtCreate = new Date();
//
//        roleRepository.save(role);
//
//        return mappingToRoleResponseDto(role);
//    }

//    public RoleResponseDto mappingToRoleResponseDto(Role role) {
//
//        RoleResponseDto roleDto = new RoleResponseDto();
//
//        roleDto.role = role.role;
//        roleDto.description = role.description;
//        roleDto.dtCreate = role.dtCreate;
//
//        return roleDto;
//    }

}
