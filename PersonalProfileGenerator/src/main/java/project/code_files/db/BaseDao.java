package project.code_files.db;

public interface BaseDao<T> {
    /**
     * Rules for adding new records into 5 tables in cloud database
     * @param t new record t
     * @return results of adding new records，return an integer，above 0 means adding successfully.
     */
    int insert(T t);

    /**
     * Rules for retrieving records from 5 tables in cloud database
     * @return return retrieving info
     */
    T findByUserId(int userId);

}
