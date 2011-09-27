/**
 * Copyright (c) 2000-2011 Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.portal.model.impl;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ResourceCode;
import com.liferay.portal.model.ResourceCodeModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;
import com.liferay.portlet.expando.util.ExpandoBridgeFactoryUtil;

import java.io.Serializable;

import java.sql.Types;

/**
 * The base model implementation for the ResourceCode service. Represents a row in the &quot;ResourceCode&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link com.liferay.portal.model.ResourceCodeModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link ResourceCodeImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ResourceCodeImpl
 * @see com.liferay.portal.model.ResourceCode
 * @see com.liferay.portal.model.ResourceCodeModel
 * @generated
 */
public class ResourceCodeModelImpl extends BaseModelImpl<ResourceCode>
	implements ResourceCodeModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a resource code model instance should use the {@link com.liferay.portal.model.ResourceCode} interface instead.
	 */
	public static final String TABLE_NAME = "ResourceCode";
	public static final Object[][] TABLE_COLUMNS = {
			{ "codeId", Types.BIGINT },
			{ "companyId", Types.BIGINT },
			{ "name", Types.VARCHAR },
			{ "scope", Types.INTEGER }
		};
	public static final String TABLE_SQL_CREATE = "create table ResourceCode (codeId LONG not null primary key,companyId LONG,name VARCHAR(255) null,scope INTEGER)";
	public static final String TABLE_SQL_DROP = "drop table ResourceCode";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.portal.util.PropsUtil.get(
				"value.object.entity.cache.enabled.com.liferay.portal.model.ResourceCode"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.portal.util.PropsUtil.get(
				"value.object.finder.cache.enabled.com.liferay.portal.model.ResourceCode"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.portal.util.PropsUtil.get(
				"value.object.column.bitmask.enabled.com.liferay.portal.model.ResourceCode"),
			true);
	public static long COMPANYID_COLUMN_BITMASK = 1L;
	public static long SCOPE_COLUMN_BITMASK = 2L;
	public static long NAME_COLUMN_BITMASK = 4L;
	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.portal.util.PropsUtil.get(
				"lock.expiration.time.com.liferay.portal.model.ResourceCode"));

	public ResourceCodeModelImpl() {
	}

	public long getPrimaryKey() {
		return _codeId;
	}

	public void setPrimaryKey(long primaryKey) {
		setCodeId(primaryKey);
	}

	public Serializable getPrimaryKeyObj() {
		return new Long(_codeId);
	}

	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	public Class<?> getModelClass() {
		return ResourceCode.class;
	}

	public String getModelClassName() {
		return ResourceCode.class.getName();
	}

	public long getCodeId() {
		return _codeId;
	}

	public void setCodeId(long codeId) {
		_codeId = codeId;
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_columnBitmask |= COMPANYID_COLUMN_BITMASK;

		if (!_setOriginalCompanyId) {
			_setOriginalCompanyId = true;

			_originalCompanyId = _companyId;
		}

		_companyId = companyId;
	}

	public long getOriginalCompanyId() {
		return _originalCompanyId;
	}

	public String getName() {
		if (_name == null) {
			return StringPool.BLANK;
		}
		else {
			return _name;
		}
	}

	public void setName(String name) {
		_columnBitmask |= NAME_COLUMN_BITMASK;

		if (_originalName == null) {
			_originalName = _name;
		}

		_name = name;
	}

	public String getOriginalName() {
		return GetterUtil.getString(_originalName);
	}

	public int getScope() {
		return _scope;
	}

	public void setScope(int scope) {
		_columnBitmask |= SCOPE_COLUMN_BITMASK;

		if (!_setOriginalScope) {
			_setOriginalScope = true;

			_originalScope = _scope;
		}

		_scope = scope;
	}

	public int getOriginalScope() {
		return _originalScope;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ResourceCode toEscapedModel() {
		if (isEscapedModel()) {
			return (ResourceCode)this;
		}
		else {
			if (_escapedModelProxy == null) {
				_escapedModelProxy = (ResourceCode)ProxyUtil.newProxyInstance(_classLoader,
						_escapedModelProxyInterfaces,
						new AutoEscapeBeanHandler(this));
			}

			return _escapedModelProxy;
		}
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		if (_expandoBridge == null) {
			_expandoBridge = ExpandoBridgeFactoryUtil.getExpandoBridge(getCompanyId(),
					ResourceCode.class.getName(), getPrimaryKey());
		}

		return _expandoBridge;
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		getExpandoBridge().setAttributes(serviceContext);
	}

	@Override
	public Object clone() {
		ResourceCodeImpl resourceCodeImpl = new ResourceCodeImpl();

		resourceCodeImpl.setCodeId(getCodeId());
		resourceCodeImpl.setCompanyId(getCompanyId());
		resourceCodeImpl.setName(getName());
		resourceCodeImpl.setScope(getScope());

		resourceCodeImpl.resetOriginalValues();

		return resourceCodeImpl;
	}

	public int compareTo(ResourceCode resourceCode) {
		long primaryKey = resourceCode.getPrimaryKey();

		if (getPrimaryKey() < primaryKey) {
			return -1;
		}
		else if (getPrimaryKey() > primaryKey) {
			return 1;
		}
		else {
			return 0;
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}

		ResourceCode resourceCode = null;

		try {
			resourceCode = (ResourceCode)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		long primaryKey = resourceCode.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public void resetOriginalValues() {
		ResourceCodeModelImpl resourceCodeModelImpl = this;

		resourceCodeModelImpl._originalCompanyId = resourceCodeModelImpl._companyId;

		resourceCodeModelImpl._setOriginalCompanyId = false;

		resourceCodeModelImpl._originalName = resourceCodeModelImpl._name;

		resourceCodeModelImpl._originalScope = resourceCodeModelImpl._scope;

		resourceCodeModelImpl._setOriginalScope = false;

		_columnBitmask = 0;
	}

	@Override
	public CacheModel<ResourceCode> toCacheModel() {
		ResourceCodeCacheModel resourceCodeCacheModel = new ResourceCodeCacheModel();

		resourceCodeCacheModel.codeId = getCodeId();

		resourceCodeCacheModel.companyId = getCompanyId();

		resourceCodeCacheModel.name = getName();

		String name = resourceCodeCacheModel.name;

		if ((name != null) && (name.length() == 0)) {
			resourceCodeCacheModel.name = null;
		}

		resourceCodeCacheModel.scope = getScope();

		return resourceCodeCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(9);

		sb.append("{codeId=");
		sb.append(getCodeId());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", name=");
		sb.append(getName());
		sb.append(", scope=");
		sb.append(getScope());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(16);

		sb.append("<model><model-name>");
		sb.append("com.liferay.portal.model.ResourceCode");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>codeId</column-name><column-value><![CDATA[");
		sb.append(getCodeId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>companyId</column-name><column-value><![CDATA[");
		sb.append(getCompanyId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>name</column-name><column-value><![CDATA[");
		sb.append(getName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>scope</column-name><column-value><![CDATA[");
		sb.append(getScope());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static ClassLoader _classLoader = ResourceCode.class.getClassLoader();
	private static Class<?>[] _escapedModelProxyInterfaces = new Class[] {
			ResourceCode.class
		};
	private long _codeId;
	private long _companyId;
	private long _originalCompanyId;
	private boolean _setOriginalCompanyId;
	private String _name;
	private String _originalName;
	private int _scope;
	private int _originalScope;
	private boolean _setOriginalScope;
	private transient ExpandoBridge _expandoBridge;
	private long _columnBitmask;
	private ResourceCode _escapedModelProxy;
}