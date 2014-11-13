package ${namespacePrefix}.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import ${namespacePrefix}.pojo.${tablePojo.className}${pojoSuffix};
import ${namespacePrefix}.service.${tablePojo.className}${serviceSuffix};

/**
 * @文件名：${tablePojo.className}${controllerSuffix}.java
 * @作用：
 * @作者：张剑
 * @创建时间：${now}
 */
@Controller
@RequestMapping("/${tablePojo.objectsName}")
public class ${tablePojo.className}${controllerSuffix} {
	@Autowired
	private ${tablePojo.className}${serviceSuffix} ${tablePojo.objectsName}${serviceSuffix};

}
