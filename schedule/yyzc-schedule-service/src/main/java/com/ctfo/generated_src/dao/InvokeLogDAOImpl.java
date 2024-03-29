package com.ctfo.generated_src.dao;

import java.util.List;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.ctfo.generated_src.bean.InvokeLog;
import com.ctfo.generated_src.bean.InvokeLogExample;
import com.ctfo.generated_src.bean.InvokeLogExampleExtended;

public class InvokeLogDAOImpl extends SqlMapClientDaoSupport implements InvokeLogDAO {

	/**
	 * This method was generated by Abator for iBATIS. This method corresponds to the database table QUARTZ.QRTZ_INVOKE_LOG
	 * @abatorgenerated  Tue Mar 03 16:40:13 CST 2015
	 */
	public InvokeLogDAOImpl() {
		super();
	}

	/**
	 * This method was generated by Abator for iBATIS. This method corresponds to the database table QUARTZ.QRTZ_INVOKE_LOG
	 * @abatorgenerated  Tue Mar 03 16:40:13 CST 2015
	 */
	public void insert(InvokeLog record) {
		getSqlMapClientTemplate().insert(
				"QRTZ_INVOKE_LOG.abatorgenerated_insert", record);
	}

	/**
	 * This method was generated by Abator for iBATIS. This method corresponds to the database table QUARTZ.QRTZ_INVOKE_LOG
	 * @abatorgenerated  Tue Mar 03 16:40:13 CST 2015
	 */
	public int updateByPrimaryKey(InvokeLog record) {
		int rows = getSqlMapClientTemplate().update(
				"QRTZ_INVOKE_LOG.abatorgenerated_updateByPrimaryKey", record);
		return rows;
	}

	/**
	 * This method was generated by Abator for iBATIS. This method corresponds to the database table QUARTZ.QRTZ_INVOKE_LOG
	 * @abatorgenerated  Tue Mar 03 16:40:13 CST 2015
	 */
	public int updateByPrimaryKeySelective(InvokeLog record) {
		int rows = getSqlMapClientTemplate().update(
				"QRTZ_INVOKE_LOG.abatorgenerated_updateByPrimaryKeySelective",
				record);
		return rows;
	}

	/**
	 * This method was generated by Abator for iBATIS. This method corresponds to the database table QUARTZ.QRTZ_INVOKE_LOG
	 * @abatorgenerated  Tue Mar 03 16:40:13 CST 2015
	 */
	public List selectByExample(InvokeLogExample example) {
		List list = getSqlMapClientTemplate().queryForList(
				"QRTZ_INVOKE_LOG.abatorgenerated_selectByExample", example);
		return list;
	}

	/**
	 * This method was generated by Abator for iBATIS. This method corresponds to the database table QUARTZ.QRTZ_INVOKE_LOG
	 * @abatorgenerated  Tue Mar 03 16:40:13 CST 2015
	 */
	public InvokeLog selectByPrimaryKey(String id) {
		InvokeLog key = new InvokeLog() {
		};
		key.setId(id);
		InvokeLog record = (InvokeLog) getSqlMapClientTemplate()
				.queryForObject(
						"QRTZ_INVOKE_LOG.abatorgenerated_selectByPrimaryKey",
						key);
		return record;
	}

	/**
	 * This method was generated by Abator for iBATIS. This method corresponds to the database table QUARTZ.QRTZ_INVOKE_LOG
	 * @abatorgenerated  Tue Mar 03 16:40:13 CST 2015
	 */
	public int deleteByExample(InvokeLogExample example) {
		int rows = getSqlMapClientTemplate().delete(
				"QRTZ_INVOKE_LOG.abatorgenerated_deleteByExample", example);
		return rows;
	}

	/**
	 * This method was generated by Abator for iBATIS. This method corresponds to the database table QUARTZ.QRTZ_INVOKE_LOG
	 * @abatorgenerated  Tue Mar 03 16:40:13 CST 2015
	 */
	public int deleteByPrimaryKey(String id) {
		InvokeLog key = new InvokeLog() {
		};
		key.setId(id);
		int rows = getSqlMapClientTemplate().delete(
				"QRTZ_INVOKE_LOG.abatorgenerated_deleteByPrimaryKey", key);
		return rows;
	}

	/**
	 * This method was generated by Abator for iBATIS. This method corresponds to the database table QUARTZ.QRTZ_INVOKE_LOG
	 * @abatorgenerated  Tue Mar 03 16:40:13 CST 2015
	 */
	public int countByExample(InvokeLogExample example) {
		Integer count = (Integer) getSqlMapClientTemplate().queryForObject(
				"QRTZ_INVOKE_LOG.abatorgenerated_countByExample", example);
		return count.intValue();
	}

	/**
	 * This method was generated by Abator for iBATIS. This method corresponds to the database table QUARTZ.QRTZ_INVOKE_LOG
	 * @abatorgenerated  Tue Mar 03 16:40:13 CST 2015
	 */
	public int updateByExampleSelective(InvokeLog record,
			InvokeLogExample example) {
		UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
		int rows = getSqlMapClientTemplate().update(
				"QRTZ_INVOKE_LOG.abatorgenerated_updateByExampleSelective",
				parms);
		return rows;
	}

	/**
	 * This method was generated by Abator for iBATIS. This method corresponds to the database table QUARTZ.QRTZ_INVOKE_LOG
	 * @abatorgenerated  Tue Mar 03 16:40:13 CST 2015
	 */
	public int updateByExample(InvokeLog record, InvokeLogExample example) {
		UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
		int rows = getSqlMapClientTemplate().update(
				"QRTZ_INVOKE_LOG.abatorgenerated_updateByExample", parms);
		return rows;
	}

	/**
	 * This method was generated by Abator for iBATIS. This method corresponds to the database table QUARTZ.QRTZ_INVOKE_LOG
	 * @abatorgenerated  Tue Mar 03 16:40:13 CST 2015
	 */
	public List selectByExampleWithPage(InvokeLogExample example) {
		List list = getSqlMapClientTemplate().queryForList(
				"QRTZ_INVOKE_LOG.abatorgenerated_selectByExamplePage", example);
		return list;
	}

	/**
	 * This method was generated by Abator for iBATIS. This method corresponds to the database table QUARTZ.QRTZ_INVOKE_LOG
	 * @abatorgenerated  Tue Mar 03 16:40:13 CST 2015
	 */
	public List selectByExampleWithPage(InvokeLogExampleExtended exampleExtended) {
		List list = getSqlMapClientTemplate().queryForList(
				"QRTZ_INVOKE_LOG.abatorgenerated_selectByExampleExtendedPage",
				exampleExtended);
		return list;
	}

	/**
	 * This method was generated by Abator for iBATIS. This method corresponds to the database table QUARTZ.QRTZ_INVOKE_LOG
	 * @abatorgenerated  Tue Mar 03 16:40:13 CST 2015
	 */
	public List getKeyBy(InvokeLogExample example) {
		List list = getSqlMapClientTemplate().queryForList(
				"QRTZ_INVOKE_LOG.abatorgenerated_selectKeyBy", example);
		return list;
	}

	/**
	 * This method was generated by Abator for iBATIS. This method corresponds to the database table QUARTZ.QRTZ_INVOKE_LOG
	 * @abatorgenerated  Tue Mar 03 16:40:13 CST 2015
	 */
	public String getNameSpace() {
		return "QRTZ_INVOKE_LOG";
	}

	/**
	 * This method was generated by Abator for iBATIS. This method corresponds to the database table QUARTZ.QRTZ_INVOKE_LOG
	 * @abatorgenerated  Tue Mar 03 16:40:13 CST 2015
	 */
	public List getKeyBy(InvokeLogExampleExtended example) {
		List list = getSqlMapClientTemplate().queryForList(
				"QRTZ_INVOKE_LOG.abatorgenerated_selectKeyByExtended", example);
		return list;
	}

	/**
	 * This method was generated by Abator for iBATIS. This method corresponds to the database table QUARTZ.QRTZ_INVOKE_LOG
	 * @abatorgenerated  Tue Mar 03 16:40:13 CST 2015
	 */
	public int countByExample(InvokeLogExampleExtended example) {
		Integer count = (Integer) getSqlMapClientTemplate().queryForObject(
				"QRTZ_INVOKE_LOG.abatorgenerated_countByExampleExtended",
				example);
		return count.intValue();
	}

	/**
	 * This class was generated by Abator for iBATIS. This class corresponds to the database table QUARTZ.QRTZ_INVOKE_LOG
	 * @abatorgenerated  Tue Mar 03 16:40:13 CST 2015
	 */
	private static class UpdateByExampleParms extends InvokeLogExample {
		private Object record;

		public UpdateByExampleParms(Object record, InvokeLogExample example) {
			super(example);
			this.record = record;
		}

		public Object getRecord() {
			return record;
		}
	}
}