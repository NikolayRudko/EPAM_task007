package com.epam.task.seven.repository;

import com.epam.task.seven.empty.Ellipse;
import com.epam.task.seven.repository.specification.Specification;

import java.util.List;

public interface EllipseRepository {

    void addEllipse(Ellipse ellipse) throws RepositoryException;

    void removeEllipse(Ellipse ellipse) throws RepositoryException;

    void updateEllipse(Ellipse ellipse);

    List<Ellipse> query(Specification specification);
}
