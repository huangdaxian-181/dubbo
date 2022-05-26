package pattern;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * mybatis单例模式
 *
 * @author 搬砖的码农
 * @date 2022/05/21
 * @email
 **/
public class SingleMybatisPattern {

    /**
     * 实例化类
     */
    private static final SingleMybatisPattern singleMybatisPattern = new SingleMybatisPattern();


    /**
     * 私有构造方法 禁止调用
     */
    private SingleMybatisPattern() {
    }

    /**
     * 外部调用此类
     */
    public static SingleMybatisPattern getInstance() {
        return singleMybatisPattern;
    }

    /**
     * 返回读取连接
     */
    public SqlSession getSingle(){

        try{
            InputStream is = Resources.getResourceAsStream("mybatis-config.xml");

            SqlSessionFactory ssf = new SqlSessionFactoryBuilder().build(is);

            SqlSession ss = ssf.openSession();

            return ss;
        }
        catch (IOException e){
            e.printStackTrace();

            return null;
        }

    }
}
