package ua.gudlana.StadyGudLana.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.gudlana.StadyGudLana.data.domain.Group;
import ua.gudlana.StadyGudLana.data.repository.GroupRepository;
import ua.gudlana.StadyGudLana.data.repository.PostRepository;
import ua.gudlana.StadyGudLana.data.repository.UserRepository;
import ua.gudlana.StadyGudLana.model.UserDto;

import java.util.List;

@Service
public class GroupService {

    @Autowired
    private GroupRepository groupRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PostRepository postRepository;
    private List<Group> groupList;

    public List<Group> getAllGroup(){
       return groupList = groupRepository.findAll();
    }

    public void save(Group group){
        groupRepository.save(group);
    }

    public void delete(String id){
        groupRepository.delete(id);
    }

    public List<Group> getGroupList() {
        return groupList;
    }

    public void setGroupList(List<Group> groupList) {
        this.groupList = groupList;
    }
}
