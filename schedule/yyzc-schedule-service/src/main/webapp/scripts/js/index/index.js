function jumpToJsp(url){
	$('#iframe').attr('src', url);
}

//$(function() {
//	$("#my_menu").wijmenu();
//});


var Index=function(){
	   this.tab=null;	
	};

	Index.prototype = {
		//页面初始化操作
		init:function(){
			var that=this;
			 //布局
	        $("#layout1").ligerLayout({leftWidth:190, height:'100%', heightDiff:-34, space:4, onHeightChanged: that.f_heightChanged });
	        var height = $(".l-layout-center").height();
	        //Tab
	        $("#framecenter").ligerTab({ height: height, dragToMove :true});
	        that.tab = $("#framecenter").ligerGetTabManager();        
	        //面板
	        $("#accordion1").ligerAccordion({ height: height - 24, speed: null });
	        that.accordion = $("#accordion1").ligerGetAccordionManager();
	        
	        $(".l-link").hover(function (){
	            $(this).addClass("l-link-over");
	        }, function (){
	            $(this).removeClass("l-link-over");
	        });        
	        
	        $("#pageloading").hide();
		},
		resize:function(){
			var width=$(window).width();
			//把滚动条的宽度计算在内，防止右侧多余空白
			if (document.documentElement.clientWidth < document.documentElement.offsetWidth-4){
				width+=document.documentElement.offsetWidth-document.documentElement.clientWidth;
			}
			//最小分辨率（1224*768）设置
			if(width<1224){
				$(document.body).css({width:'1224px'});
			}else{
				$(document.body).css({width:'100%'});
			}
		},
		//高度改变
		f_heightChanged : function(options){
			var that=this;
	        if(that.tab){
	          that.tab.addHeight(options.diff);	
	        }
	        if (that.accordion && options.middleHeight - 24 > 0){
	          that.accordion.setHeight(options.middleHeight - 24);	
	        }  
	    },
		//增加Tab
	    f_addTab : function(id,text,url){
			//添加tab
	    	this.tab.addTabItem({tabid : id, text: text, url: url});
	    },
	    f_closeTab:function(tabid){
	    	this.tab.removeTabItem(tabid);
	    }
	};

	$(function(){
		$("#my_menu").wijmenu();
		var indexPage=new Index();
		window.indexPage=indexPage;  
		indexPage.resize();//设置页面初始化大小
		indexPage.init();//初始化页面基本结构
			 
		$(window).resize(function() {
			indexPage.resize();
		});
	});