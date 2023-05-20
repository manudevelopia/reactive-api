package info.developia.reactive.api.mapper;

import info.developia.reactive.api.model.User;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UserMapper {
    @Select("""
            select u_name name
            from menus.users
            """)
    List<User> getAll();
}
