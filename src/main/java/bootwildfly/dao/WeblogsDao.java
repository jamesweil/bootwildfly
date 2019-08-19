package bootwildfly.dao;

import bootwildfly.entity.Weblogs;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

@Repository
public interface WeblogsDao extends BaseMapper<Weblogs> {
}
