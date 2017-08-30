/**
Member javaScript
*/
var app=(function(){
	var init=function(ctx){
		session.init(ctx);
		onCreate();
	};
	var onCreate=function(){
		setContentView();
		location.href=ctx()+"/home.do";
	};
	var setContentView=function(){
	};
	var ctx=function(){
		return session.getPath('ctx');
	};
	var js=function(){
		return session.getPath('js');
	};
	var img=function(){
		return session.getPath('img');
	};
	var css=function(){
		return session.getPath('css');
	};
	return {
		init : init,
		ctx : ctx,
		js : js,
		img : img,
		css : css
	};
})();
var session=(function(){
	var init=function(ctx){
		sessionStorage.setItem('ctx',ctx);
		sessionStorage.setItem('js',ctx+'/resources/js');
		sessionStorage.setItem('img',ctx+'/resources/img');
		sessionStorage.setItem('css',ctx+'/resources/css');
	};
	var getPath=function(x){
		return sessionStorage.getItem(x);
	};
	return {
		init : init,
		getPath : getPath
	}
})();
var main=(function(){
	var init=function(){
		onCreate();
	};
	var onCreate=function(){
		setContentView();
	};
	var setContentView=function(){
		var $u1=$("#main_ul_stu");
		var $u2=$("#main_ul_grade");
		var $u3=$("#main_ul_board");
		$u1.addClass("list-group");
		$u2.addClass("list-group");
		$u3.addClass("list-group");
		$('.list-group').children().addClass("list-group-item");
		$('.list-group-item a').eq( 0 ).on('click',function(){
			alert('0');
			controller.moveTo('member','member_add');
		});
		$('.list-group-item a').eq( 1 ).on('click',function(){
			alert('1');
		});
	};
	return {
		init:init
	};
})();
var home=(function(){
	var init=function(){
		onCreate();
	};
	var onCreate=function(){
		setContentView();
		$('#loginBtn').on('click',function(){
			if($('#input_id').val()===""){
				alert('ID 를 입력해 주세요');
				return false;
			}
			if($('#input_pass').val()===""){
				alert('PASS 를 입력해 주세요');
				return false;
			}
			$('#login_box').attr('action',app.ctx()+"/common.do");
			$('#login_box').attr('method','post');
			return true;
		});
	};
	var setContentView=function(){};
	return {
		init : init
	};
})();
var navbar=(function(){
	var init=function(){
		onCreate();
	};
	var onCreate=function(){
		setContentView();
	};
	var setContentView=function(){
		var $u1=$("#navbar_ul_stu");
		var $u2=$("#navbar_ul_grade");
		var $u3=$("#navbar_ul_board");
		$u1.addClass("dropdown-menu");
		$u2.addClass("dropdown-menu");
		$u3.addClass("dropdown-menu");
		$('.dropdown-menu a').eq( 0 ).on('click',function(){
			alert('0 ');
			controller.moveTo('member','member_add');
		});
		$('.dropdown-menu a').eq( 1 ).on('click',function(){
			alert('1');
		});
		/*u1c[0].setAttribute("onclick","moveTo('member','member_add')");
		u1c[1].setAttribute("onclick","list('member','member_list','1')");
		u1c[2].setAttribute("onclick","moveTo('member','member_detail')");
		u1c[3].setAttribute("role", "separator");
		u1c[3].setAttribute("class", "divider");
		u1c[4].setAttribute("onclick","deleteTarget('학생 ')");
		u2c[0].setAttribute("onclick","moveTo('grade','grade_add')");
		u2c[1].setAttribute("onclick","list('grade','grade_list','1')");
		u2c[2].setAttribute("onclick","moveTo('grade','grade_detail')");
		u2c[3].setAttribute("role", "separator");
		u2c[3].setAttribute("class", "divider");
		u2c[4].setAttribute("onclick","deleteTarget('성적 ')");
		u3c[0].setAttribute("onclick","moveTo('board','board_add')");
		u3c[1].setAttribute("onclick","list('board','board_list','1')");
		u3c[2].setAttribute("onclick","moveTo('board','board_detail')");
		u3c[3].setAttribute("role", "separator");
		u3c[3].setAttribute("class", "divider");
		u3c[4].setAttribute("onclick","deleteTarget('게시글 ')");
		var logout=document.getElementById("logout");
		logout.setAttribute("style","color:white");
		logout.setAttribute("onclick","logout('common','home')");*/
	};
	return {init:init};
})();
var controller=(function(){
	var init=function(){
		moveTo();
	};
	var moveTo=function(dir,page){
		location.href=app.ctx()+'/'+dir+".do?action=move&page="+page;
	};
	return {
		init:init,
		moveTo:moveTo
	};
})();













