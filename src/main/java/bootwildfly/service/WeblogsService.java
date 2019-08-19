package bootwildfly.service;

import bootwildfly.entity.Weblogs;

import java.util.List;

public interface WeblogsService {
    List<Weblogs> findAll();
    Weblogs findById(String id);
    boolean add(Weblogs weblogs);
    boolean update(Weblogs weblogs);
    boolean delete(String id);
}
