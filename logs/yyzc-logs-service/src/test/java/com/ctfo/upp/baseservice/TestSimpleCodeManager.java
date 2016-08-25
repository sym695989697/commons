package com.ctfo.upp.baseservice;

import java.math.BigDecimal;
import java.util.List; 

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.util.Assert;

import com.ctfo.base.dao.beans.SimpleCode;
import com.ctfo.base.dao.beans.SimpleCodeExampleExtended;
import com.ctfo.base.intf.internal.ISimpleCodeManager;
import com.ctfo.upp.exception.UPPException;
import com.ctfo.upp.models.PaginationResult;
import com.ctfo.upp.unit.TestBase_2;

/**
 * 请牢记！
 * 1. 一条 JUnit 最佳实践：测试任何可能的错误。
 * 2. 单元测试不是用来证明您是对的，而是为了证明您没有错。
 * 
 * @author malongqing
 * @date 2014-03-04
 */
//@RunWith(Parameterized.class)
public class TestSimpleCodeManager extends TestBase_2 { //implements ISimpleCodeManager{

	private String uuid = "812e5b30-9f10-4aff-af31-afba830feb6a";
	
	ISimpleCodeManager manager =null;

	@Before
	public void setUp() throws Exception {
		super.setUp();		
		//manager = (ISimpleCodeManager)ServiceFactory.getFactory().getService(ISimpleCodeManager.class);
	}

	@After
	public void destroy() throws Exception{

		//this.initData();

	}


	@Test(expected=UPPException.class)//, timeout=1000)  
	public void addSimpleCode() throws UPPException{

			String id  = manager.addSimpleCode(this.getSimpleCode());
			
			//下面两种方式断言,都可以,选择其中 一种断言即可
			Assert.notNull(id, "uuid is not null");	    	 
			Assert.isInstanceOf(String.class, id, "uuid is String type");

			org.junit.Assert.assertNotNull("uuid is not null", id);
		
	}

	@Test(expected=UPPException.class)//, timeout=1000)    
	public void getSimpleCodeById() throws UPPException{

		SimpleCode usc = manager.getSimpleCodeById(uuid);

		Assert.notNull(usc);			
		Assert.isTrue(uuid.equals(usc.getId()));
		Assert.isAssignable(SimpleCode.class, usc.getClass());


	}


	@Test(expected=UPPException.class)//, timeout=1000)  
	public void getSimpleCodesByExampleExtended() throws UPPException{

		SimpleCodeExampleExtended uscee = new SimpleCodeExampleExtended();			
		List<?> list = manager.getSimpleCodeByExampleExtended(uscee);
		Assert.notNull(list);
		Assert.isTrue(list.size()>0);

	}

	@Test(expected=UPPException.class)//, timeout=1000)  
	public void getSimpleCodesPageByExampleExtended() throws UPPException{

		SimpleCodeExampleExtended uscee = new SimpleCodeExampleExtended();
		uscee.setSkipNum(1);
		uscee.setLimitNum(30);
		uscee.setEndNum(30);				
		PaginationResult<SimpleCode> pg = manager.getSimpleCodePageByExampleExtended(uscee);

		Assert.notNull(pg);
		Assert.isTrue(pg.getTotal()>0);



	}

	@Test(expected=UPPException.class)//, timeout=1000)
	public void countSimpleCodesByExampleExtended() throws UPPException{
		
		SimpleCodeExampleExtended uscee = new SimpleCodeExampleExtended();
		int count = manager.countSimpleCodeByExampleExtended(uscee);

		Assert.notNull(count);


	}


	@Test(expected=UPPException.class)//, timeout=1000)    
	public void modifySimpleCode() throws UPPException{

		SimpleCode bean = new SimpleCode();
		bean.setId(uuid);
		bean.setTypeCode("root");
		bean.setTypeName("测试信息");
		bean.setCode("1001");
		bean.setName("测试修改名称00000000");			
		manager.modifySimpleCode(bean);

	}



	//@org.junit.runner.RunWith("要使用的测试运行器")
	//@Ignore("db is down")
	@Test(expected=UPPException.class)//, timeout=1000)
	public void removeSimpleCode() throws UPPException{
		
		SimpleCodeExampleExtended see = new SimpleCodeExampleExtended();
		see.createCriteria().andCodeEqualTo("3333").andTypeCodeEqualTo("root");
		List<SimpleCode> list = manager.getSimpleCodeByExampleExtended(see);
		for(SimpleCode usc : list){
			usc.setStatus("0");
			manager.modifySimpleCode(usc);
			manager.removeSimpleCode(usc.getId());
		}
		
	}


	private SimpleCode getSimpleCode(){

		SimpleCode usc = new SimpleCode();
		usc.setName("测试信息22");
		usc.setCode("3333");
		usc.setTypeCode("root");
		usc.setPid("0");		    	
		usc.setStatus("1");//是否启用	    	
		usc.setSort(new BigDecimal(1));
		usc.setTypeName("测试信息");
		usc.setDescription("22222222");

		return usc;
	}



	//	private String expected; 
	//    
	//    private String target; 
	//
	//    @Parameters 
	//    public static Collection querywords(){ 
	//        return Arrays.asList(new Object[][]{ 
	//            {"employee_info", "employeeInfo"},      // 测试一般的处理情况
	//            {null, null},                           // 测试 null 时的处理情况
	//            {"", ""},                               // 测试空字符串时的处理情况
	//            {"employee_info", "EmployeeInfo"},      // 测试当首字母大写时的情况
	//            {"employee_info_a", "employeeInfoA"},   // 测试当尾字母为大写时的情况
	//            {"employee_a_info", "employeeAInfo"}    // 测试多个相连字母大写时的情况
	//        }); 
	//    } 
	//
	//     /** 
	//     * 参数化测试必须的构造函数
	//     * @param expected     期望的测试结果，对应参数集中的第一个参数
	//     * @param target     测试数据，对应参数集中的第二个参数
	//     */ 
	//    public TestSimpleCodeManagerImpl(String expected , String target){ 
	//        this.expected = expected; 
	//        this.target = target; 
	//    } 

}