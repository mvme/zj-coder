package cn.psvmc;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cn.psvmc.utils.ZJ_CodeGeneratorUtils;
import cn.psvmc.utils.ZJ_ConfigUtils;
import cn.psvmc.vo.TablePojo;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

public class CodeCreater {
	private static String database = null;
	private static String selectTableName = null;
	private static String namespacePrefix = null;
	private static String pojoSuffix = null;
	private static String daoSuffix = null;
	private static String daoImplSuffix = null;
	private static String serviceSuffix = null;
	private static String serviceImplSuffix = null;
	private static String controllerSuffix = null;
	private static String outputPath = null;

	private static void reset() {
		database = ZJ_ConfigUtils.getProperty("database");
		selectTableName = ZJ_ConfigUtils.getProperty("selectTableName");
		namespacePrefix = ZJ_ConfigUtils.getProperty("namespacePrefix");
		pojoSuffix = ZJ_ConfigUtils.getProperty("pojoSuffix");
		daoSuffix = ZJ_ConfigUtils.getProperty("daoSuffix");
		daoImplSuffix = ZJ_ConfigUtils.getProperty("daoImplSuffix");
		serviceSuffix = ZJ_ConfigUtils.getProperty("serviceSuffix");
		serviceImplSuffix = ZJ_ConfigUtils.getProperty("serviceImplSuffix");
		controllerSuffix = ZJ_ConfigUtils.getProperty("controllerSuffix");
		outputPath = ZJ_ConfigUtils.getProperty("outputPath");
	}

	private static void creator(String tempName, String path, String suffix) throws IOException, TemplateException, ClassNotFoundException, SQLException {
		// 找目录
		Configuration cfg = new Configuration();
		cfg.setDefaultEncoding("UTF-8");
		cfg.setDirectoryForTemplateLoading(new File("templates"));
		// 设模板
		Template temp1 = cfg.getTemplate(tempName);
		temp1.setEncoding("UTF-8");
		// 加数据
		List<TablePojo> tableList = ZJ_CodeGeneratorUtils.getTableList();
		Map<String, Object> tempData = new HashMap<String, Object>();
		tempData.put("now", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
		tempData.put("namespacePrefix", namespacePrefix);
		tempData.put("pojoSuffix", pojoSuffix);
		tempData.put("daoSuffix", daoSuffix);
		tempData.put("daoImplSuffix", daoImplSuffix);
		tempData.put("serviceSuffix", serviceSuffix);
		tempData.put("serviceImplSuffix", serviceImplSuffix);
		tempData.put("controllerSuffix", controllerSuffix);
		Writer out = null;
		for (TablePojo tablePojo : tableList) {
			if (tablePojo.getTableName().contains(selectTableName)) {
				tempData.put("tablePojo", tablePojo);
				// 去输出
				File outFolder = new File(path);
				outFolder.mkdirs();
				File outFile = new File(path + tablePojo.getClassName() + suffix + ".java");

				FileOutputStream fos = new FileOutputStream(outFile);
				OutputStreamWriter oWriter = new OutputStreamWriter(fos, "UTF-8");// 这个地方对流的编码不可或缺，
				out = new BufferedWriter(oWriter);
				temp1.process(tempData, out);
				out.flush();
				out.close();
				System.out.println(path + tablePojo.getClassName() + suffix + ".java生成了");
			}
		}
	}

	private static void pojoCreator() throws IOException, TemplateException, ClassNotFoundException, SQLException {
		String path = outputPath + "/" + database + "/" + namespacePrefix.replaceAll("[.]", "/") + "/pojo/";
		creator("pojo.ftl", path, pojoSuffix);
	}

	private static void daoCreator() throws IOException, TemplateException, ClassNotFoundException, SQLException {
		String path = outputPath + "/" + database + "/" + namespacePrefix.replaceAll("[.]", "/") + "/dao/";
		creator("dao.ftl", path, daoSuffix);
	}

	private static void daoImplCreator() throws IOException, TemplateException, ClassNotFoundException, SQLException {
		String path = outputPath + "/" + database + "/" + namespacePrefix.replaceAll("[.]", "/") + "/dao/impl/";
		creator("daoImpl.ftl", path, daoImplSuffix);
	}

	private static void serviceCreator() throws IOException, TemplateException, ClassNotFoundException, SQLException {
		String path = outputPath + "/" + database + "/" + namespacePrefix.replaceAll("[.]", "/") + "/service/";
		creator("service.ftl", path, serviceSuffix);
	}

	private static void serviceImplCreator() throws IOException, TemplateException, ClassNotFoundException, SQLException {
		String path = outputPath + "/" + database + "/" + namespacePrefix.replaceAll("[.]", "/") + "/service/impl/";
		creator("serviceImpl.ftl", path, serviceImplSuffix);
	}

	private static void controllerCreator() throws IOException, TemplateException, ClassNotFoundException, SQLException {
		String path = outputPath + "/" + database + "/" + namespacePrefix.replaceAll("[.]", "/") + "/controller/";
		creator("controller.ftl", path, controllerSuffix);
	}

	public static void mainCreator() throws IOException, TemplateException, ClassNotFoundException, SQLException {
		reset();
		// 如果文件夹已存在就删除
		File outFolder = new File(outputPath);
		if (outFolder.exists()) {
			outFolder.delete();
		}
		pojoCreator();
		System.out.println("****************************************************************");
		daoCreator();
		System.out.println("****************************************************************");
		daoImplCreator();
		System.out.println("****************************************************************");
		serviceCreator();
		System.out.println("****************************************************************");
		serviceImplCreator();
		System.out.println("****************************************************************");
		controllerCreator();
	}
}
