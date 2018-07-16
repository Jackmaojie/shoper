package shop.config;


import javax.sql.DataSource;

import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;


@Configuration
@ComponentScan("shop")
@EnableWebMvc
@MapperScan("shop.mapper")
@PropertySource("classpath:shop/jdbc.properties")
public class ShopAppConfig extends WebMvcConfigurerAdapter {
	@Override
	public void configureViewResolvers(ViewResolverRegistry registry) {
		// author-list -> /WEB-INF/jsp/author-list.jsp
				// 对于控制器方法返回的字符串，会用以下规则解析成jsp路径，然后forward
				// 前缀 + 返回字符串 + 后缀 = jsp路径
				//            前缀                                      后缀
		System.out.println("Appconfig");
		registry.jsp("/WEB-INF/jsp/", ".jsp");
	}
	/**
	 * 数据源依赖环境
	 * 配置jdbc
	 * @param env
	 * @return
	 */
	@Bean
	public DataSource dataSource(Environment env) { 
		DriverManagerDataSource ds = new DriverManagerDataSource(
				env.getProperty("jdbc.url"),
				env.getProperty("jdbc.username"),
				env.getProperty("jdbc.password"));
		ds.setDriverClassName(env.getProperty("jdbc.driverClassName"));
		return ds;
	}
	
	/**
	 * 定义Mybatis的会话工厂
	 * @param dataSource
	 * @return
	 */
	@Bean // 定义Mybatis的会话工厂
	public SqlSessionFactoryBean sqlSessionFactory(DataSource dataSource) {
		SqlSessionFactoryBean sf = new SqlSessionFactoryBean();
		sf.setConfigLocation(new ClassPathResource("shop/shop-config.xml"));
		sf.setDataSource(dataSource);
		return sf;
	}
	/**
	 * 编码
	 * @return
	 */
	@Bean
	public PasswordEncoder passwordEncoder() {
	    return new BCryptPasswordEncoder();
	}
	// spring事务需要事务管理器组件（开事务、提交或回滚事务）  
	/**
	 * spring事务需要事务管理器组件（开事务、提交或回滚事务）
	 * @author admin
	 */
	@Bean
	public PlatformTransactionManager transactionManager(DataSource dataSource){
		
		return new DataSourceTransactionManager(dataSource);
		
	}
	
	
}

