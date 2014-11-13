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
	private static String database = "";
	private static String selectTableName = "";
	private static String namespace = "";
	private static String fileSuffix = "";
	private static String templateName = "";
	private static String outputPath = "";

	private static void reset() {
		database = ZJ_ConfigUtils.getProperty("database");
		selectTableName = ZJ_ConfigUtils.getProperty("selectTableName");
		namespace = ZJ_ConfigUtils.getProperty("namespace");
		fileSuffix = ZJ_ConfigUtils.getProperty("fileSuffix");
		templateName = ZJ_ConfigUtils.getProperty("templateName");
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
		tempData.put("namespace", namespace);
		tempData.put("fileSuffix", fileSuffix);
		tempData.put("templateName", templateName);
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

	private static void fileCreator() throws IOException, TemplateException, ClassNotFoundException, SQLException {
		String path = outputPath + "/" + database + "/" + namespace.replaceAll("[.]", "/") + "/";
		creator(templateName, path, fileSuffix);
	}

	public static void mainCreator() throws IOException, TemplateException, ClassNotFoundException, SQLException {
		reset();
		// 如果文件夹已存在就删除
		File outFolder = new File(outputPath);
		if (outFolder.exists()) {
			outFolder.delete();
		}
		fileCreator();
		System.out.println("*****************************文件生成完毕****************************");

	}
}
