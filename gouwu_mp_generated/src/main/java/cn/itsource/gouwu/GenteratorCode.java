package cn.itsource.gouwu;

import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.converts.MySqlTypeConvert;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.DbType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

import java.util.*;

public class GenteratorCode {

    public static void main(String[] args) throws InterruptedException {
        //用来获取Mybatis-Plus.properties文件的配置信息
        //获取classpath下的文件
        final ResourceBundle rb = ResourceBundle.getBundle("gen");
        AutoGenerator mpg = new AutoGenerator();
        // 全局配置
        GlobalConfig gc = new GlobalConfig();
        // F:\\idea\\mybatisplus_parent\\mp_code_generate\\src\\main\\java
        gc.setOutputDir(rb.getString("OutputDir"));
        gc.setFileOverride(true);
        gc.setActiveRecord(true);// 开启 activeRecord 模式
        gc.setEnableCache(false);// XML 二级缓存
        gc.setBaseResultMap(true);// XML ResultMap
        gc.setBaseColumnList(true);// XML columList
        gc.setOpen(false);// 是否打开磁盘目录
        gc.setAuthor(rb.getString("author"));// wbtest
        mpg.setGlobalConfig(gc);
        // 数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
        // 你的是什么数据:
        dsc.setDbType(DbType.MYSQL);
        dsc.setTypeConvert(new MySqlTypeConvert());
        dsc.setDriverName(rb.getString("jdbc.driver"));
        // rb.getString("jdbc.user")
        dsc.setUsername(rb.getString("jdbc.user"));
        dsc.setPassword(rb.getString("jdbc.pwd"));
        dsc.setUrl(rb.getString("jdbc.url"));
        mpg.setDataSource(dsc);


        // 策略配置
        StrategyConfig strategy = new StrategyConfig();
        strategy.setTablePrefix(new String[] { "t_" });// 此处可以修改为您的表前缀
        strategy.setNaming(NamingStrategy.underline_to_camel);// 表名生成策略
        strategy.setInclude(new String[]{"t_specification"}); // 需要生成的表
        mpg.setStrategy(strategy);


        // 包配置
        PackageConfig pc = new PackageConfig();
        pc.setParent(rb.getString("parent"));
        pc.setController("controller");
        pc.setService("service");
        pc.setServiceImpl("service.impl");
        pc.setEntity("domain");
        pc.setMapper("mapper");
        mpg.setPackageInfo(pc);

        // 注入自定义配置，可以在 VM 中使用 cfg.abc 【可无】
        InjectionConfig cfg = new InjectionConfig() {
            @Override
            public void initMap() {
                Map<String, Object> map = new HashMap<String, Object>();
                map.put("abc", this.getConfig().getGlobalConfig().getAuthor() + "-rb");
                this.setMap(map);
            }
        };

        List<FileOutConfig> focList = new ArrayList<FileOutConfig>();

        // 调整 domain 生成目录演示
        focList.add(new FileOutConfig("/templates/entity.java.vm") {
            @Override
            public String outputFile(TableInfo tableInfo) {
                //F:\\idea\\mybatisplus_parent\\mp_code_generate\\src\\main\\java
                return rb.getString("OutputDirBase")+ "/cn/itsource/gouwu/domain/" + tableInfo.getEntityName() + ".java";
            }
        });

        // 调整 xml 生成目录演示
        focList.add(new FileOutConfig("/templates/mapper.xml.vm") {
            @Override
            public String outputFile(TableInfo tableInfo) {
                return rb.getString("OutputDirXml")+ "/cn/itsource/gouwu/mapper/" + tableInfo.getEntityName() + "Mapper.xml";
            }
        });

        //跳转controller的生成目录:
        focList.add(new FileOutConfig("/templates/controller.java.vm") {
            @Override
            public String outputFile(TableInfo tableInfo) {
                return rb.getString("OutputDir")+ "/cn/itsource/gouwu/controller/" + tableInfo.getEntityName() + "Controller.java";
            }
        });

        //跳转query的生成目录:
        focList.add(new FileOutConfig("/templates/query.java.vm") {
            @Override
            public String outputFile(TableInfo tableInfo) {
                return rb.getString("OutputDirBase")+ "/cn/itsource/gouwu/query/" + tableInfo.getEntityName() + "Query.java";
            }
        });


        cfg.setFileOutConfigList(focList);
        mpg.setCfg(cfg);

        // 自定义模板配置，可以 copy 源码 mybatis-plus/src/main/resources/templates 下面内容修改，
        // 放置自己项目的 src/main/resources/templates 目录下, 默认名称一下可以不配置，也可以自定义模板名称
        TemplateConfig tc = new TemplateConfig();
        tc.setService("/templates/service.java.vm");
        tc.setServiceImpl("/templates/serviceImpl.java.vm");
        tc.setEntity(null);
        tc.setMapper("/templates/mapper.java.vm");
        tc.setController(null);
        tc.setXml(null);
        // 如上任何一个模块如果设置 空 OR Null 将不生成该模块。
        mpg.setTemplate(tc);

        // 执行生成
        mpg.execute();
    }

}