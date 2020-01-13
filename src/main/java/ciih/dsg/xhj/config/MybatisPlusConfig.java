package ciih.dsg.xhj.config;

import com.baomidou.mybatisplus.core.MybatisConfiguration;
import com.baomidou.mybatisplus.core.MybatisXMLLanguageDriver;
import com.baomidou.mybatisplus.core.parser.ISqlParser;
import com.baomidou.mybatisplus.core.parser.ISqlParserFilter;
import com.baomidou.mybatisplus.core.parser.SqlParserHelper;
import com.baomidou.mybatisplus.extension.MybatisMapWrapperFactory;
import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import com.baomidou.mybatisplus.extension.plugins.tenant.TenantHandler;
import com.baomidou.mybatisplus.extension.plugins.tenant.TenantSqlParser;
import com.baomidou.mybatisplus.extension.spring.MybatisSqlSessionFactoryBean;
import net.sf.jsqlparser.expression.Expression;
import net.sf.jsqlparser.expression.LongValue;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.type.JdbcType;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.util.ArrayList;

@Configuration
@MapperScan("ciih.dsg.xhj.mapper")
public class MybatisPlusConfig {

//    @Bean("mybatisSqlSession")
//    public SqlSessionFactory sqlSessionFactory(@Qualifier("dataSource") DataSource dataSource) throws Exception {
//        MybatisSqlSessionFactoryBean sqlSessionFactory = new MybatisSqlSessionFactoryBean();
//        MybatisConfiguration configuration = new MybatisConfiguration();
//        configuration.setDefaultScriptingLanguage(MybatisXMLLanguageDriver.class);
//        configuration.setJdbcTypeForNull(JdbcType.NULL);
//        configuration.setCallSettersOnNulls(true);
//
//        //注册Map下划线转驼峰   此为方法一，也可在配置文件中配置
//        configuration.setObjectWrapperFactory(new MybatisMapWrapperFactory());
//
//        sqlSessionFactory.setDataSource(dataSource);
//        sqlSessionFactory.setConfiguration(configuration);
//
////        PaginationInterceptor paginationInterceptor = new PaginationInterceptor();
////        ArrayList<ISqlParser> iSqlParsers = new ArrayList<>();
////        TenantSqlParser tenantSqlParser = new TenantSqlParser();
////        tenantSqlParser.setTenantHandler(new TenantHandler() {
////            @Override
////            public Expression getTenantId(boolean where) {
////                return new LongValue(4546545455L);
////            }
////
////            @Override
////            public String getTenantIdColumn() {
////                return "manager_id";
////            }
////
////            @Override
////            public boolean doTableFilter(String tableName) {
////                if (tableName.equals("admin_info")){
////                    return true;
////                }
////                return false;
////            }
////        });
////        iSqlParsers.add(tenantSqlParser);
////        paginationInterceptor.setSqlParserList(iSqlParsers);
////        paginationInterceptor.setSqlParserFilter(new ISqlParserFilter() {
////            @Override
////            public boolean doFilter(MetaObject metaObject) {
////                MappedStatement mappedStatement = SqlParserHelper.getMappedStatement(metaObject);
////                if ("ciih.dsg.xhj.mapper.ClassInfoMapper.insert".equals(mappedStatement.getId())){
////                    return true;
////                }
////                return false;
////            }
////        });
//
////        sqlSessionFactory.setPlugins(paginationInterceptor);
//
//        return sqlSessionFactory.getObject();
//    }

    @Bean
    public PaginationInterceptor paginationInterceptor() {
        PaginationInterceptor paginationInterceptor = new PaginationInterceptor();
        return paginationInterceptor;
    }
}
