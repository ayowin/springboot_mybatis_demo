package com.wz.springboot.mybatis.generator;

import java.io.File;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;

public class Generator {
    
    public static void main(String[] args) throws Exception {
	System.out.println("-------------MybatisGenerator--------------");
	
	// 生成POJO类、Mapper、Mapper.xml  
	generator();    
    }

    // 生成POJO类、Mapper、Mapper.xml
    private static void generator() {

	try {
	    List<String> warnings = new ArrayList<String>();
	    boolean overwrite = true;
	    
	    // mybatis-generator配置文件路径
	    URI fileNameURI = MyBatisGenerator.class.getResource("/mybatis-generator-config.xml").toURI();
	    
	    File configFile = new File(fileNameURI);
	    
	    ConfigurationParser cp = new ConfigurationParser(warnings);
	    
	    Configuration config = cp.parseConfiguration(configFile);
	    
	    DefaultShellCallback callback = new DefaultShellCallback(overwrite);
	    
	    MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
	    myBatisGenerator.generate(null);
	
	    System.out.println("mybatis-generator generate POJO,Mapper,Mapper.xml success.");	

	} catch (Exception e) {
	    System.out.println("mybatis-generator generate POJO,Mapper,Mapper.xml failed.");
	    e.printStackTrace();
	}
    }
}
