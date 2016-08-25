package com.ctfo.upp.baseservice.dao;

import com.ctfo.base.dao.beans.UPParam;
import com.ctfo.base.dao.beans.UPParamExample;
import com.ctfo.base.dao.beans.UPParamExampleExtended;
import java.util.List;

public interface UPParamDAO {

	/**
	 * This method was generated by Abator for iBATIS. This method corresponds to the database table UPP.TB_UPP_PARAM
	 * @abatorgenerated  Tue Nov 04 13:25:26 CST 2014
	 */
	void insert(UPParam record);

	/**
	 * This method was generated by Abator for iBATIS. This method corresponds to the database table UPP.TB_UPP_PARAM
	 * @abatorgenerated  Tue Nov 04 13:25:26 CST 2014
	 */
	int updateByPrimaryKey(UPParam record);

	/**
	 * This method was generated by Abator for iBATIS. This method corresponds to the database table UPP.TB_UPP_PARAM
	 * @abatorgenerated  Tue Nov 04 13:25:26 CST 2014
	 */
	int updateByPrimaryKeySelective(UPParam record);

	/**
	 * This method was generated by Abator for iBATIS. This method corresponds to the database table UPP.TB_UPP_PARAM
	 * @abatorgenerated  Tue Nov 04 13:25:26 CST 2014
	 */
	List selectByExample(UPParamExample example);

	/**
	 * This method was generated by Abator for iBATIS. This method corresponds to the database table UPP.TB_UPP_PARAM
	 * @abatorgenerated  Tue Nov 04 13:25:26 CST 2014
	 */
	UPParam selectByPrimaryKey(String id);

	/**
	 * This method was generated by Abator for iBATIS. This method corresponds to the database table UPP.TB_UPP_PARAM
	 * @abatorgenerated  Tue Nov 04 13:25:26 CST 2014
	 */
	int deleteByExample(UPParamExample example);

	/**
	 * This method was generated by Abator for iBATIS. This method corresponds to the database table UPP.TB_UPP_PARAM
	 * @abatorgenerated  Tue Nov 04 13:25:26 CST 2014
	 */
	int deleteByPrimaryKey(String id);

	/**
	 * This method was generated by Abator for iBATIS. This method corresponds to the database table UPP.TB_UPP_PARAM
	 * @abatorgenerated  Tue Nov 04 13:25:26 CST 2014
	 */
	int countByExample(UPParamExample example);

	/**
	 * This method was generated by Abator for iBATIS. This method corresponds to the database table UPP.TB_UPP_PARAM
	 * @abatorgenerated  Tue Nov 04 13:25:26 CST 2014
	 */
	int updateByExampleSelective(UPParam record, UPParamExample example);

	/**
	 * This method was generated by Abator for iBATIS. This method corresponds to the database table UPP.TB_UPP_PARAM
	 * @abatorgenerated  Tue Nov 04 13:25:26 CST 2014
	 */
	int updateByExample(UPParam record, UPParamExample example);

	/**
	 * This method was generated by Abator for iBATIS. This method corresponds to the database table UPP.TB_UPP_PARAM
	 * @abatorgenerated  Tue Nov 04 13:25:26 CST 2014
	 */
	List selectByExampleWithPage(UPParamExample example);

	/**
	 * This method was generated by Abator for iBATIS. This method corresponds to the database table UPP.TB_UPP_PARAM
	 * @abatorgenerated  Tue Nov 04 13:25:26 CST 2014
	 */
	List selectByExampleWithPage(UPParamExampleExtended exampleExtended);

	/**
	 * This method was generated by Abator for iBATIS. This method corresponds to the database table UPP.TB_UPP_PARAM
	 * @abatorgenerated  Tue Nov 04 13:25:26 CST 2014
	 */
	List getKeyBy(UPParamExample example);

	/**
	 * This method was generated by Abator for iBATIS. This method corresponds to the database table UPP.TB_UPP_PARAM
	 * @abatorgenerated  Tue Nov 04 13:25:26 CST 2014
	 */
	String getNameSpace();

	/**
	 * This method was generated by Abator for iBATIS. This method corresponds to the database table UPP.TB_UPP_PARAM
	 * @abatorgenerated  Tue Nov 04 13:25:26 CST 2014
	 */
	List getKeyBy(UPParamExampleExtended example);

	/**
	 * This method was generated by Abator for iBATIS. This method corresponds to the database table UPP.TB_UPP_PARAM
	 * @abatorgenerated  Tue Nov 04 13:25:26 CST 2014
	 */
	int countByExample(UPParamExampleExtended example);
}