<#-- 主键 -->
<#macro priKey tablePojo ><#list tablePojo.fieldlist as field ><#if field.isKey==1>${field.fieldName}</#if></#list></#macro>
<#macro priKeyMethod tablePojo ><#list tablePojo.fieldlist as field ><#if field.isKey==1>pojo.get${field.methodName}()</#if></#list></#macro>
<#-- 其他键(排除主键) -->
<#macro otherKey tablePojo ><#list tablePojo.fieldlist as field ><#if field.isKey==0>${field.fieldName}<#if field_has_next>,</#if></#if></#list></#macro>
<#macro otherKeySign tablePojo ><#list tablePojo.fieldlist as field ><#if field.isKey==0>?<#if field_has_next>,</#if></#if></#list></#macro>
<#macro otherKeyMethod tablePojo ><#list tablePojo.fieldlist as field ><#if field.isKey==0>pojo.get${field.methodName}()<#if field_has_next>,</#if></#if></#list></#macro>
<#--其他键(排除主键)(用于更新) -->
<#macro otherKeySet tablePojo ><#list tablePojo.fieldlist as field ><#if field.isKey==0>${field.fieldName}=?<#if field_has_next>,</#if></#if></#list></#macro>
<#-- 其他键(排除自增键)(主要用于添加方法) -->
<#macro otherKeyI tablePojo ><#list tablePojo.fieldlist as field ><#if field.isIncrease==0>${field.fieldName}<#if field_has_next>,</#if></#if></#list></#macro>
<#macro otherKeyISet tablePojo ><#list tablePojo.fieldlist as field ><#if field.isIncrease==0>${field.fieldName}=?<#if field_has_next>,</#if></#if></#list></#macro>
<#macro otherKeyISign tablePojo ><#list tablePojo.fieldlist as field ><#if field.isIncrease==0>?<#if field_has_next>,</#if></#if></#list></#macro>
<#macro otherKeyIMethod tablePojo ><#list tablePojo.fieldlist as field ><#if field.isIncrease==0>pojo.get${field.methodName}()<#if field_has_next>,</#if></#if></#list></#macro>
<#-- 所有键 -->
<#macro allKey tablePojo ><#list tablePojo.fieldlist as field >${field.fieldName}<#if field_has_next>,</#if></#list></#macro>
<#macro allKeySign tablePojo ><#list tablePojo.fieldlist as field >?<#if field_has_next>,</#if></#list></#macro>
<#macro allKeyMethod tablePojo ><#list tablePojo.fieldlist as field >pojo.get${field.methodName}()<#if field_has_next>,</#if></#list></#macro>
<#-- 显示 -->
<#--
<@priKey tablePojo />

<@priKeyMethod tablePojo />

<@otherKey tablePojo />

<@otherKeyMethod tablePojo />

<@allKey tablePojo />

<@allKeyMethod tablePojo />
-->

package ${namespacePrefix}.dao.impl;

import java.text.MessageFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ${namespacePrefix}.dao.${tablePojo.className}${daoSuffix};
import ${namespacePrefix}.dao.template.DbUtilsTemplate;
import ${namespacePrefix}.pojo.${tablePojo.className}${pojoSuffix};

/**
 * @文件名：${tablePojo.className}${daoImplSuffix}.java
 * @作用：
 * @作者：张剑
 * @创建时间：${now}
 */
@Repository
public class ${tablePojo.className}${daoImplSuffix} implements ${tablePojo.className}${daoSuffix} {
	@Autowired
	protected DbUtilsTemplate dbUtilsTemplate;

	@Override
	public boolean add(${tablePojo.className}${pojoSuffix} pojo) {
		String sql = "insert into ${tablePojo.tableName}(<@otherKeyI tablePojo />) values(<@otherKeyISign tablePojo />)";
		Object[] params = {<@otherKeyIMethod tablePojo />};
		Integer count = dbUtilsTemplate.update(sql, params);
		return count > 0 ? true : false;
	}

	@Override
	public boolean update(${tablePojo.className}${pojoSuffix} pojo) {
		String sql = "update ${tablePojo.tableName} set <@otherKeySet tablePojo /> where <@priKey tablePojo />=?";
		Object[] params = {<@otherKeyMethod tablePojo />,<@priKeyMethod tablePojo />};
		Integer count = dbUtilsTemplate.update(sql, params);
		return count > 0 ? true : false;
	}

	@Override
	public boolean delById(Object id) {
		String sql = "delete from ${tablePojo.tableName} where <@priKey tablePojo />=? ";
		Object[] params = { id };
		Integer count = dbUtilsTemplate.update(sql, params);
		return count > 0 ? true : false;
	}

	@Override
	public boolean delBatch(String ids) {
		String sql = "delete from ${tablePojo.tableName} where <@priKey tablePojo /> in ("+ids+")";
		Integer count = dbUtilsTemplate.update(sql, null);
		return count > 0 ? true : false;
	}
	
	@Override
	public boolean delByWhere(String strWhere) {
		String sql = "delete from ${tablePojo.tableName} where "+strWhere;
		Integer count = dbUtilsTemplate.update(sql, null);
		return count > 0 ? true : false;
	}

	@Override
	public ${tablePojo.className}${pojoSuffix} queryPojoById(Object id) {
		String sql = "select <@allKey tablePojo /> from ${tablePojo.tableName} where <@priKey tablePojo />=?";
		Object[] params = { id };
		return dbUtilsTemplate.queryFirst(${tablePojo.className}${pojoSuffix}.class, sql, params);
	}

	@Override
	public ${tablePojo.className}${pojoSuffix} queryPojoByWhere(String strWhere) {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("select <@allKey tablePojo /> from ${tablePojo.tableName} ");
		if (null != strWhere) {
			strBuilder.append(" where " + strWhere);
		}
		return dbUtilsTemplate.queryFirst(${tablePojo.className}${pojoSuffix}.class, strBuilder.toString(), null);
	}

	@Override
	public List<${tablePojo.className}${pojoSuffix}> queryList(String strWhere, String orderBy) {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append(" select <@allKey tablePojo /> from ${tablePojo.tableName}  ");
		if (null != strWhere && !"".equals(strWhere)) {
			strBuilder.append(" where " + strWhere);
		}
		if (null == orderBy || "".equals(orderBy)) {
			strBuilder.append(" order by <@priKey tablePojo /> desc ");
		} else {
			strBuilder.append(" order by " + orderBy);
		}
		return dbUtilsTemplate.queryForList(${tablePojo.className}${pojoSuffix}.class, strBuilder.toString(), null);
	}
	
	@Override
	public Integer queryListCount(String strWhere) {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append(" select count(*) from ${tablePojo.tableName}  ");
		if (null != strWhere && !"".equals(strWhere)) {
			strBuilder.append(" where " + strWhere);
		}
		return Integer.parseInt(dbUtilsTemplate.queryForObject(strBuilder.toString(), 1).toString());
	}

	@Override
	public List<${tablePojo.className}${pojoSuffix}> queryListByPage(String strWhere, String orderBy, Integer startIndex, Integer pageSize) {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append(" select <@allKey tablePojo /> from ${tablePojo.tableName}  ");
		if (null != strWhere && !"".equals(strWhere)) {
			strBuilder.append(" where " + strWhere);
		}
		if (null == orderBy || "".equals(orderBy)) {
			strBuilder.append(" order by <@priKey tablePojo /> desc ");
		} else {
			strBuilder.append(" order by " + orderBy);
		}
		if (null == startIndex) {
			startIndex = 0;
		}
		if (null == pageSize) {
			pageSize = 10;
		}
		strBuilder.append(MessageFormat.format(" limit {0},{1} ", startIndex, pageSize));
		return dbUtilsTemplate.queryForList(${tablePojo.className}${pojoSuffix}.class, strBuilder.toString(), null);
	}
}
