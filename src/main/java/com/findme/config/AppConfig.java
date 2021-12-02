package com.findme.config;

import com.findme.controller.PostController;
import com.findme.controller.UserController;
import com.findme.dao.PostRepository;
import com.findme.dao.PostRepositoryImpl;
import com.findme.dao.UserRepository;
import com.findme.dao.UserRepositoryImpl;
import com.findme.service.PostService;
import com.findme.service.PostServiceImpl;
import com.findme.service.UserService;
import com.findme.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.*;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.PropertyResolver;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.spring5.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring5.view.ThymeleafViewResolver;

import javax.persistence.EntityManagerFactory;
import java.util.Properties;

@Configuration
@EnableWebMvc
@EnableTransactionManagement
@PropertySource("classpath:application.properties")
@ComponentScan(value = "com.findme",
        includeFilters = {
        @ComponentScan.Filter(type = FilterType.ANNOTATION, value = Controller.class)
})
public class AppConfig implements WebMvcConfigurer {
    private final ApplicationContext applicationContext;

//    @Value(value = "${url.database}")
//    private String urlDatabase;
//    @Value(value = "${user.name}")
//    private String userName;
//    @Value(value = "${user.password}")
//    private String userPassword;
//    @Value(value = "${driver.class.name}")
//    private String driverClassName;

    @Autowired
    public AppConfig(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    @Bean
    public SpringResourceTemplateResolver templateResolver() {
        SpringResourceTemplateResolver templateResolver = new SpringResourceTemplateResolver();
        templateResolver.setApplicationContext(applicationContext);
        templateResolver.setPrefix("classpath:/views/");
        templateResolver.setSuffix(".html");
        return templateResolver;
    }

    public SpringTemplateEngine templateEngine() {
        SpringTemplateEngine templateEngine = new SpringTemplateEngine();
        templateEngine.setTemplateResolver(templateResolver());
        templateEngine.setEnableSpringELCompiler(true);
        return templateEngine;
    }

    public void configureViewResolvers(ViewResolverRegistry registry) {
        ThymeleafViewResolver resolver = new ThymeleafViewResolver();
        resolver.setTemplateEngine(templateEngine());
        registry.viewResolver(resolver);
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(dataSource());
        em.setPackagesToScan(new String[]{"com"});
        JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        em.setJpaVendorAdapter(vendorAdapter);
        em.setJpaProperties(additionalProperties());
        return em;
    }

    @Bean
    public PropertiesDataBase propertiesDataBase () {
        return new PropertiesDataBase();
    }

    @Bean
    public DriverManagerDataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
        for (String bean : beanDefinitionNames) {
            System.out.println(bean);

        }
        dataSource.setDriverClassName(propertiesDataBase().getDriverClassName());
        dataSource.setUrl(propertiesDataBase().getUrlDatabase());
        dataSource.setUsername(propertiesDataBase().getUserLogin());
        dataSource.setPassword(propertiesDataBase().getUserPassword());
        return dataSource;
    }

    @Bean
    public PersistenceExceptionTranslationPostProcessor exceptionTranslation() {
        return new PersistenceExceptionTranslationPostProcessor();
    }

    @Bean
    public PlatformTransactionManager transactionManager(EntityManagerFactory emf) {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(emf);
        return transactionManager;
    }

    private Properties additionalProperties() {
        Properties properties = new Properties();
        properties.setProperty("hibernate.dialect", "org.hibernate.dialect.Oracle10gDialect");
        properties.setProperty("hibernate.show_sql", "true");
        properties.setProperty("hibernate.format_sql", "true");
        return properties;
    }

//    @Bean(name = "userRepository")
//    public UserRepository userRepository() {
//        return new UserRepositoryImpl();
//    }
//
//    @Bean(name = "postRepository")
//    public PostRepository postRepository() {
//        return new PostRepositoryImpl();
//    }
//
//    @Bean(name = "userService")
//    public UserService userService(UserRepository userRepository) {
//        return new UserServiceImpl(userRepository);
//    }
//
//    @Bean(name = "postService")
//    public PostService postService(PostRepository postRepository) {
//        return new PostServiceImpl(postRepository);
//    }
//
//    @Bean(name = "userController")
//    public UserController userController(UserService userService) {
//        return new UserController(userService);
//    }
//
//    @Bean(name = "postController")
//    public PostController postController(PostService postService) {
//        return new PostController(postService);
//    }

}
