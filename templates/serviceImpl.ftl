package ${namespacePrefix}.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ${namespacePrefix}.dao.${tablePojo.className}${daoSuffix};
import ${namespacePrefix}.pojo.${tablePojo.className}${pojoSuffix};
import ${namespacePrefix}.service.${tablePojo.className}${serviceSuffix};

/**
 * @文件名：${tablePojo.className}${serviceImplSuffix}.java
 * @作用：
 * @作者：张剑
 * @创建时间：${now}
 */
@Service
public class ${tablePojo.className}${serviceImplSuffix} implements ${tablePojo.className}${serviceSuffix} {
	@Autowired
	private ${tablePojo.className}${daoSuffix} ${tablePojo.objectsName}${daoSuffix};

	@Override
	public boolean add(${tablePojo.className}${pojoSuffix} pojo) {
		return ${tablePojo.objectsName}${daoSuffix}.add(pojo);
	}

	@Override
	public boolean update(${tablePojo.className}${pojoSuffix} pojo) {
		return ${tablePojo.objectsName}${daoSuffix}.update(pojo);
	}

	@Override
	public boolean delById(Object id) {
		return ${tablePojo.objectsName}${daoSuffix}.delById(id);
	}

	@Override
	public boolean delBatch(String ids) {
		return ${tablePojo.objectsName}${daoSuffix}.delBatch(ids);
	}
	
	@Override
	public boolean delByWhere(String strWhere) {
		return ${tablePojo.objectsName}${daoSuffix}.delByWhere(strWhere);
	}

	@Override
	public ${tablePojo.className}${pojoSuffix} queryPojoById(Object id) {
		return ${tablePojo.objectsName}${daoSuffix}.queryPojoById(id);
	}

	@Override
	public ${tablePojo.className}${pojoSuffix} queryPojoByWhere(String strWhere) {
		return ${tablePojo.objectsName}${daoSuffix}.queryPojoByWhere(strWhere);
	}

	@Override
	public List<${tablePojo.className}${pojoSuffix}> queryList(String strWhere, String orderBy) {
		return ${tablePojo.objectsName}${daoSuffix}.queryList(strWhere, orderBy);
	}
	
	@Override
	public Integer queryListCount(String strWhere) {
		return ${tablePojo.objectsName}${daoSuffix}.queryListCount(strWhere);
	}

	@Override
	public List<${tablePojo.className}${pojoSuffix}> queryListByPage(String strWhere, String orderBy, Integer startIndex, Integer pageSize) {
		return ${tablePojo.objectsName}${daoSuffix}.queryListByPage(strWhere, orderBy, startIndex, pageSize);
	}

}
