package luis122448.repository;

import java.sql.SQLException;
import java.util.List;

public interface EmployeeRepository<T, Q> {

    List<T> findAll() throws SQLException;
    T findById(Q q) throws SQLException;
    void save(T t) throws SQLException;
    void update(T t) throws SQLException;
    void delete(Q q) throws SQLException;

}
