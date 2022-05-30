package com.waysterdemelo.pptool.services;

import com.waysterdemelo.pptool.domain.Project;
import com.waysterdemelo.pptool.exceptions.ProjectIdException;
import com.waysterdemelo.pptool.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    public Project saveOrUpdateProject(Project project){
        try {
            project.setProjectIdentifier(project.getProjectIdentifier().toUpperCase());
            return projectRepository.save(project);
        }catch (Exception e){
            throw new ProjectIdException("Project ID '" + project.getProjectIdentifier().toUpperCase()+ "' already exists");
        }

    }

    public Project findByProjectIdentifier(String projectId){
            Project project = projectRepository.findByProjectIdentifier(projectId.toUpperCase());

            if (project == null){
                throw new ProjectIdException("Project ID'"+projectId+"'does not exists");
            }
            return project;
    }

    public Iterable<Project> findAllProjects(){
        return projectRepository.findAll();
    }

    public void deleteProjectByIdentifier(String projectId){
        Project project = projectRepository.findByProjectIdentifier(projectId.toUpperCase());

        if (project == null){
            throw new ProjectIdException("Cannot delete project with ID '" + projectId + "'. this project does not exist");
        }

        projectRepository.delete(project);
    }
}
