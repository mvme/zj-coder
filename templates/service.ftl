package ${namespacePrefix}.service;

import java.util.List;
import ${namespacePrefix}.pojo.${tablePojo.className}${pojoSuffix};

/**
 * @文件名：${tablePojo.className}${serviceSuffix}.java
 * @作用：
 * @作者：张剑
 * @创建时间：${now}
 */
public interface ${tablePojo.className}${serviceSuffix} {
	/**
	 * 添加
	 * @param pojo
	 * @return
	 */
	boolean add(${tablePojo.className}${pojoSuffix} pojo);

	/**
	 * 修改
	 * @param pojo
	 * @return
	 */
	boolean update(${tablePojo.className}${pojoSuffix} pojo);

	/**
	 * 刪除单条(通过ID)
	 * @param id
	 * @return
	 */
	boolean delById(Object id);

	/**
	 * 删除多条
	 * @param ids
	 * @return
	 */
	boolean delBatch(String ids);
	
	/**
	 * 刪除(通过条件)
	 * @param id
	 * @return
	 */
	boolean delByWhere(String strWhere);
	
	/**
	 * 获取对象(通过ID)
	 * @param id
	 * @return
	 */
	${tablePojo.className}${pojoSuffix} queryPojoById(Object id);

	/**
	 * 获取对象
	 * @param id
	 * @return
	 */
	${tablePojo.className}${pojoSuffix} queryPojoByWhere(String strWhere);

	/**
	 * 获取对象列表(不分页)
	 * @param strWhere
	 * @param orderBy
	 * @return
	 */
	List<${tablePojo.className}${pojoSuffix}> queryList(String strWhere, String orderBy);
	
	/**
	 * 获取对象列表数据条数
	 * @param strWhere
	 * @param orderBy
	 * @return
	 */
	Integer queryListCount(String strWhere);

	/**
	 * 获取对象列表(分页)
	 * @param strWhere
	 * @param orderBy
	 * @param startIndex
	 * @param pageNum
	 * @return
	 */
	List<${tablePojo.className}${pojoSuffix}> queryListByPage(String strWhere, String orderBy, Integer startIndex, Integer pageSize);

}
