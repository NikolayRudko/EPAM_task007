package com.epam.task.seven.repository;

import com.epam.task.seven.empty.Ellipse;
import com.epam.task.seven.repository.specification.Specification;

import java.util.ArrayList;
import java.util.List;

public class CustomEllipseRepository implements EllipseRepository {

    private List<Ellipse> ellipseList = new ArrayList<>();

    @Override
    public void addEllipse(Ellipse ellipse) throws RepositoryException {
        if (ellipseList.contains(ellipse)){
            throw new RepositoryException("List of ellipse has this ellipse" + ellipse);
        }
            ellipseList.add(ellipse);
    }

    @Override
    public void removeEllipse(Ellipse ellipse) throws RepositoryException {
        if (!ellipseList.contains(ellipse)){
            throw new RepositoryException("List of ellipse has not this ellipse" + ellipse);
        }
        ellipseList.remove(ellipse);
    }

    @Override
    public void updateEllipse(Ellipse ellipse) {

    }

    @Override
    public List<Ellipse> query(Specification specification) {
        List<Ellipse> resultList = new ArrayList<>();
        for (Ellipse ellipse: ellipseList){
            if (specification.specified(ellipse)){
                resultList.add(ellipse);
            }
        }
        return resultList;
    }
}
