package info.developia.reactive.api.repository.mapper;

import info.developia.reactive.api.model.User;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UserMapper {
    @Select("""
            select u_id id, u_name name
            from menus.users
            """)
    List<User> getAll();

    @Select("""
            select u_id id, u_name name
            from menus.users
            where u_id = ${id}
            """)
    User getById(long id);
}
