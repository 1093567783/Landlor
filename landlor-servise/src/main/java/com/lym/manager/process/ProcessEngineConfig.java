package com.lym.manager.process;

import com.alibaba.druid.pool.DruidDataSource;
import org.activiti.engine.*;
import org.activiti.engine.impl.cfg.StandaloneProcessEngineConfiguration;
import org.activiti.engine.impl.history.HistoryLevel;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

/**
 * @Author LYM
 * @Description 流程引擎配置
 * @Date 2021/2/4
 * @Version v1.0.0
 **/
@Component
public class ProcessEngineConfig {
    /**
     * 数据源
     * @return
     */
    @ConfigurationProperties(prefix = "spring.datasource")
    @Bean
    public DataSource dataSource(){
        return new DruidDataSource();
    }
    /**
     * 工作流流程引擎配置文件
     * @param dataSource
     * @return
     */
    @Bean
    public ProcessEngineConfiguration processEngineConfiguration(DataSource dataSource){
        StandaloneProcessEngineConfiguration standaloneProcessEngineConfiguration = new StandaloneProcessEngineConfiguration();
        standaloneProcessEngineConfiguration.setDataSource(dataSource);
        //自动更新表结构，数据库表不存在时会自动创建表
        standaloneProcessEngineConfiguration.setDatabaseSchemaUpdate("true");
        //保存历史数据级别设置为full最高级别，便于历史数据的追溯
        standaloneProcessEngineConfiguration.setHistoryLevel(HistoryLevel.FULL);
        //关闭activiti自动部署（使用流程设计器部署，不使用具体文件访问方式）
        standaloneProcessEngineConfiguration.setDbHistoryUsed(true);
        return standaloneProcessEngineConfiguration;
    }

    /**
     * 工作流流程引擎
     * @param processEngineConfiguration
     * @return
     */
    @Bean
    public ProcessEngine processEngine(ProcessEngineConfiguration processEngineConfiguration){
        return processEngineConfiguration.buildProcessEngine();
    }

    /**
     * RuntimeService
     * @param processEngine
     * @return
     */
    @Bean
    public RuntimeService runtimeService(ProcessEngine processEngine){
        return processEngine.getRuntimeService();
    }

    /**
     * TaskService
     * @param processEngine
     * @return
     */
    @Bean
    public TaskService taskService(ProcessEngine processEngine){
        return processEngine.getTaskService();
    }

    /**
     * RepositoryService
     * @param processEngine
     * @return
     */
    @Bean
    public RepositoryService repositoryService(ProcessEngine processEngine){
        return processEngine.getRepositoryService();
    }

    /**
     * HistoryService
     * @param processEngine
     * @return
     */
    @Bean
    public HistoryService historyService(ProcessEngine processEngine) {
        return processEngine.getHistoryService();
    }
}
