<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zh-cn">

<head>
	<%@ include file="../../static/head.jsp"%>
	<!-- font-awesome -->
	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/font-awesome.min.css">
</head>
<style>
        .openBox {}

        .openBox .openBG {
            position: fixed;
            width: 100vw;
            height: 100vh;
            background: rgba(0, 0, 0, .3);
            top: 0;
            left: 0;
            z-index: 19;
        }

        .openBox .openView {
            position: fixed;
            width: 80vw;
            height: 60vh;
            background: #fff;
            top: 20vh;
            left: 10vw;
            z-index: 20;
            padding: 20px;
            box-sizing: border-box;
            border-radius: 10px;
            display: flex;
            align-items: center;
            justify-content: center;
        }
</style>
<body>
	<div id="main-container">
		<!-- Top Navigation -->
		<%@ include file="../../static/topNav.jsp"%>
				
		<!-- Menu -->
		<div id="menu-container" class="navbar">
			<ul class="navbar-nav navbar-horizontal" id="navUl">
				
			</ul>
		</div>
		<!-- /Menu -->

		<!-- Breadcrumb -->
		<div id="breadcrumb-container">
			<h3 class="breadcrumb-title">录取信息管理</h3>
			<ol class="breadcrumb-list">
				<li class="breadcrumb-item-home">
					<a href="#">
						<span class="ti-home"></span>
					</a>
				</li>
				<li class="breadcrumb-item-one"><span>录取信息管理</span></li>
				<li class="breadcrumb-item-two"><span>录取信息列表</span></li>
			</ol>
		</div>
		<!-- /Breadcrumb -->
				
		<!-- Main Content -->
		<div id="center-container">

			<div class="center-form">
				<div class="form-item">
					<label>高校名称</label>
					<input type="text" id="gaoxiaomingchengSearch" class="form-control form-control-sm" placeholder="请输入高校名称" aria-controls="tableId">
				</div>
				<div class="form-item">
					<label>标题</label>
					<input type="text" id="biaotiSearch" class="form-control form-control-sm" placeholder="请输入标题" aria-controls="tableId">
				</div>
				<div class="form-item">
					<label>专业名称</label>
					<select name="zhuanyemingcheng" id="zhuanyemingchengSelect" class="form-control form-control-sm" aria-controls="tableId">
					</select>
				</div>
				<div class="form-item">
					<label>录取分数</label>
					<select name="luqufenshu" id="luqufenshuSelect" class="form-control form-control-sm" aria-controls="tableId">
					</select>
				</div>
				<button onclick="search()" type="button" class="btn btn-search btn-primary">查询</button>
			</div>
			
			<div class="btns">
				<button onclick="add()" type="button" class="btn btn-success btn-add 新增"><i class="fa fa-plus"></i><span>添加</span></button>
				<button onclick="deleteMore()" type="button" class="btn btn-danger btn-del 删除"><i class="fa fa-remove"></i><span>批量删除</span></button>
				<button onclick="chartDialog1()" type="button" class="btn btn-info btn-statis" v-if="crossBtnControl('高校录取人数统计')"><i class="fa fa-database"></i><span>高校录取人数统计</span></button>
				<button onclick="chartDialog2()" type="button" class="btn btn-info btn-statis" v-if="crossBtnControl('高校分数统计')"><i class="fa fa-database"></i><span>高校分数统计</span></button>
			</div>

			<table id="tableId" class="table table-bordered">
				<thead>
					<tr>
						<th class="no-sort" style="min-width: 35px;">
							<div class="custom-control custom-checkbox">
								<input class="custom-control-input" type="checkbox" id="select-all" onclick="chooseAll()">
								<label class="custom-control-label" for="select-all"></label>
							</div>
						</th>
						<th onclick="sort('gaoxiaomingcheng')">高校名称<i id="gaoxiaomingchengIcon" class="fa fa-sort"></i></th>
						<th onclick="sort('biaoti')">标题<i id="biaotiIcon" class="fa fa-sort"></i></th>
						<th>封面</th>
						<th onclick="sort('gaoxiaodizhi')">高校地址<i id="gaoxiaodizhiIcon" class="fa fa-sort"></i></th>
						<th onclick="sort('zhuanyemingcheng')">专业名称<i id="zhuanyemingchengIcon" class="fa fa-sort"></i></th>
						<th onclick="sort('luqufenshu')">录取分数<i id="luqufenshuIcon" class="fa fa-sort"></i></th>
						<th onclick="sort('luqurenshu')">录取人数<i id="luqurenshuIcon" class="fa fa-sort"></i></th>
						<th onclick="sort('fabushijian')">发布时间<i id="fabushijianIcon" class="fa fa-sort"></i></th>
						<th>操作</th>
					</tr>
				</thead>
				<tbody></tbody>
			</table>
			

			<div id="pagination">
				<div class="dataTables_length" id="tableId_length">
					<select name="tableId_length" aria-controls="tableId" id="selectPageSize" onchange="changePageSize()">
						<option value="10">10</option>
						<option value="25">25</option>
						<option value="50">50</option>
						<option value="100">100</option>
					</select> 
					<span class="text">条每页</span>
				</div>
				<ul class="pagination">
					<li class="page-item" id="tableId_previous" onclick="pageNumChange('pre')">
						<a class="page-link" href="#" tabindex="-1">上一页</a>
					</li>
					<li class="page-item" id="tableId_next" onclick="pageNumChange('next')">
						<a class="page-link" href="#">下一页</a>
					</li>
				</ul>
			</div>
            <div class="openBox" v-if="showType1">
                <div class="openBG" @click="showClick1"></div>
                <div class="openView">
                    <div id="luqurenshuMain1" class="graph" style="width: 70vw;height:50vh;"></div>
                </div>
            </div>
            <div class="openBox" v-if="showType2">
                <div class="openBG" @click="showClick2"></div>
                <div class="openView">
                    <div id="luqufenshuMain2" class="graph" style="width: 70vw;height:50vh;"></div>
                </div>
            </div>
		</div>
		

	<!-- Back to Top -->
	<a id="back-to-top" href="#" class="back-to-top">Top</a>
	<!-- /Back to Top -->
	
	<%@ include file="../../static/foot.jsp"%>
    <script src="${pageContext.request.contextPath}/resources/js/vue.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/js/echarts.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/js/echarts/theme/fresh-cut.js"></script>
	<script language="javascript" type="text/javascript" src="${pageContext.request.contextPath}/resources/My97DatePicker/WdatePicker.js"></script>

	<script>
		<%@ include file="../../utils/menu.jsp"%>
		<%@ include file="../../static/setMenu.js"%>
		<%@ include file="../../utils/baseUrl.jsp"%>
		<%@ include file="../../static/getRoleButtons.js"%>
		<%@ include file="../../static/crossBtnControl.js"%>
		var tableName = "luquxinxi";
		var pageType = "list";
	  	var searchForm = { key: ""};
		var pageIndex = 1;
		var pageSize = 10;
		var totalPage = 0;
		var dataList = [];
		var sortColumn = '';
		var sortOrder= '';
		var ids = [];
		var checkAll = false;
        var vm = new Vue({
            el: '#center-container',
            data: {
                showType1: false,
                showType2: false,
            },
            beforeCreate: function() {

            },
            created: function() {},
            methods: {
                showClick1() {
                    vm.showType1 = !vm.showType1
                },
                showClick2() {
                    vm.showType2 = !vm.showType2
                },
            },
        })


		var zhuanyemingchengOptions = [];
		var luqufenshuOptions = [];

		function init() {
			// 满足条件渲染提醒接口
		}
		// 改变每页记录条数
		function changePageSize() {
		    var selection = document.getElementById('selectPageSize');
		    var index = selection.selectedIndex;
			pageSize = selection.options[index].value;
			getDataList();
        }		
		//排序
		function sort(columnName){
			var iconId = '#'+columnName+'Icon'
			$('th i').attr('class','fa fa-sort');
			if(sortColumn == '' || sortColumn != columnName){
				sortColumn = columnName;
				sortOrder = 'asc';
				$(iconId).attr('class','fa fa-sort-asc');
			}
			if(sortColumn == columnName){
				if(sortOrder == 'asc'){
					sortOrder = 'desc';
					$(iconId).attr('class','fa fa-sort-desc');
				}else{
					sortOrder = 'asc';
					$(iconId).attr('class','fa fa-sort-asc');
				}
			}
			pageIndex = 1;
			getDataList();
		}		
		

		// 查询
		function search(){
			searchForm = { key: ""};
			if($('#gaoxiaomingchengSearch').val() != null && $('#gaoxiaomingchengSearch').val() != ''){
				searchForm.gaoxiaomingcheng ="%" +  $('#gaoxiaomingchengSearch').val() + "%";
			}
			
			if($('#biaotiSearch').val() != null && $('#biaotiSearch').val() != ''){
				searchForm.biaoti ="%" +  $('#biaotiSearch').val() + "%";
			}
			
			var zhuanyemingchengIndex = document.getElementById("zhuanyemingchengSelect").selectedIndex;
			var zhuanyemingchengOptions = document.getElementById("zhuanyemingchengSelect").options;
			var zhuanyemingchengSelectedOption = zhuanyemingchengOptions[zhuanyemingchengIndex]
			if(zhuanyemingchengSelectedOption.text != null && zhuanyemingchengSelectedOption.text != ''){
				searchForm.zhuanyemingcheng = zhuanyemingchengSelectedOption.text;
			}
			var luqufenshuIndex = document.getElementById("luqufenshuSelect").selectedIndex;
			var luqufenshuOptions = document.getElementById("luqufenshuSelect").options;
			var luqufenshuSelectedOption = luqufenshuOptions[luqufenshuIndex]
			if(luqufenshuSelectedOption.text != null && luqufenshuSelectedOption.text != ''){
				searchForm.luqufenshu = luqufenshuSelectedOption.text;
			}
			getDataList();
		}		
		// 获取数据列表
        function getDataList() {
			http("luquxinxi/page","GET",{
				page: pageIndex,
				limit: pageSize,
				sort: sortColumn,
				order: sortOrder,
				gaoxiaomingcheng : searchForm.gaoxiaomingcheng,	
				biaoti : searchForm.biaoti,	
				zhuanyemingcheng : searchForm.zhuanyemingcheng,	
				luqufenshu : searchForm.luqufenshu,	
			},(res)=>{
				if(res.code == 0){
					clear();
					dataList = res.data.list;
					totalPage = res.data.totalPage;
					//var tbody = document.getElementById('tbMain');
					for(var i = 0;i < dataList.length; i++){ //遍历一下表格数据  
						var trow = setDataRow(dataList[i],i); //定义一个方法,返回tr数据 
						$('tbody').append(trow); 
					}
					pagination(); //渲染翻页组件
					getRoleButtons();// 权限按钮控制
				}
			});
        }		
		// 渲染表格数据
		function setDataRow(item,number){
			//创建行 
			var row = document.createElement('tr'); 
			row.setAttribute('class','useOnce');
			//创建勾选框
			var checkbox = document.createElement('td');
			var checkboxDiv = document.createElement('div');
			checkboxDiv.setAttribute("class","custom-control custom-checkbox");
			var checkboxInput = document.createElement('input');
			checkboxInput.setAttribute("class","custom-control-input");
			checkboxInput.setAttribute("type","checkbox");
			checkboxInput.setAttribute('name','chk');
			checkboxInput.setAttribute('value',item.id);
			checkboxInput.setAttribute("id",number);
			checkboxDiv.appendChild(checkboxInput);
			var checkboxLabel = document.createElement('label');
			checkboxLabel.setAttribute("class","custom-control-label");
			checkboxLabel.setAttribute("for",number);
			checkboxDiv.appendChild(checkboxLabel);
			checkbox.appendChild(checkboxDiv);
			row.appendChild(checkbox)

			var gaoxiaomingchengCell  = document.createElement('td');

						 gaoxiaomingchengCell.innerHTML = item.gaoxiaomingcheng;

			row.appendChild(gaoxiaomingchengCell);
			var biaotiCell  = document.createElement('td');

						 biaotiCell.innerHTML = item.biaoti;

			row.appendChild(biaotiCell);
			var fengmianCell  = document.createElement('td');

			            var fengmianImg = document.createElement('img');
            fengmianImg.setAttribute('src',item.fengmian?(baseUrl+item.fengmian.split(",")[0]):'');
			fengmianImg.setAttribute('height',100);
			fengmianImg.setAttribute('width',100);
			fengmianCell.appendChild(fengmianImg);


			row.appendChild(fengmianCell);
			var gaoxiaodizhiCell  = document.createElement('td');

						 gaoxiaodizhiCell.innerHTML = item.gaoxiaodizhi;

			row.appendChild(gaoxiaodizhiCell);
			var zhuanyemingchengCell  = document.createElement('td');

						 zhuanyemingchengCell.innerHTML = item.zhuanyemingcheng;

			row.appendChild(zhuanyemingchengCell);
			var luqufenshuCell  = document.createElement('td');

						 luqufenshuCell.innerHTML = item.luqufenshu;

			row.appendChild(luqufenshuCell);
			var luqurenshuCell  = document.createElement('td');

						 luqurenshuCell.innerHTML = item.luqurenshu;

			row.appendChild(luqurenshuCell);
			var luquneirongCell  = document.createElement('td');

			
			var fabushijianCell  = document.createElement('td');

						  fabushijianCell.innerHTML = item.fabushijian;


			row.appendChild(fabushijianCell);

			//每行按钮
			var btnGroup = document.createElement('td');


			//详情按钮
			var detailBtn = document.createElement('button');
			var detailAttr = "detail(" + item.id + ')';
			detailBtn.setAttribute("type","button");
			detailBtn.setAttribute("class","btn btn-info btn-sm 查看");
			detailBtn.setAttribute("onclick",detailAttr);
			detailBtn.innerHTML = "查看"
			btnGroup.appendChild(detailBtn)
			//修改按钮
			var editBtn = document.createElement('button');
			var editAttr = 'edit(' +  item.id + ')';
			editBtn.setAttribute("type","button");
			editBtn.setAttribute("class","btn btn-warning btn-sm 修改");
			editBtn.setAttribute("onclick",editAttr);
			editBtn.innerHTML = "修改"
			btnGroup.appendChild(editBtn)

                        //查看评论按钮
                        var discussListBtn = document.createElement('button');
                        var discussListAttr = 'discussList(' +  item.id + ')';
                        discussListBtn.setAttribute("type","button");
                        discussListBtn.setAttribute("class","btn btn-warning btn-sm 查看评论");
                        discussListBtn.setAttribute("onclick",discussListAttr);
                        discussListBtn.innerHTML = "查看评论"
                        btnGroup.appendChild(discussListBtn)
			//删除按钮
			var deleteBtn = document.createElement('button');
			var deleteAttr = 'remove(' +  item.id + ')';
			deleteBtn.setAttribute("type","button");
			deleteBtn.setAttribute("class","btn btn-danger btn-sm 删除");
			deleteBtn.setAttribute("onclick",deleteAttr);
			deleteBtn.innerHTML = "删除"
			btnGroup.appendChild(deleteBtn)


			row.appendChild(btnGroup)
			return row;
		}		


		// 翻页
        function pageNumChange(val) {
            if(val == 'pre') {
                pageIndex--;
            }else if(val == 'next'){
                pageIndex++;
            }else{
                pageIndex = val;
            }
			getDataList();
        }		
		// 下载
		function download(url){
			window.open(url);
		}
		// 打开新窗口播放媒体
		function mediaPlay(url){
			window.open(url);
		}		
		// 渲染翻页组件
		function pagination() {
			var beginIndex = pageIndex;
			var endIndex = pageIndex;
			var point = 4;
			//计算页码
			for(var i=0;i<3;i++){
				if(endIndex==totalPage){ break;}
				endIndex++;
				point--;
			}
			for(var i=0;i<3;i++){
				if(beginIndex==1){break;}
				beginIndex--;
				point--;
			}
			if(point>0){
				while (point>0){
					if(endIndex==totalPage){ break;}
					endIndex++;
					point--;
				}
				while (point>0){
					if(beginIndex==1){ break;}
					beginIndex--;
					point--
				}
			}
			// 是否显示 前一页 按钮
			if(pageIndex>1){
				$('#tableId_previous').show();
			}else{
				$('#tableId_previous').hide();
			}
			// 渲染页码按钮
			for(var i=beginIndex;i<=endIndex;i++){
				var pageNum = document.createElement('li');
				pageNum.setAttribute('onclick',"pageNumChange("+i+")");
				if(pageIndex == i){
					pageNum.setAttribute('class','paginate_button page-item active useOnce');
				}else{
					pageNum.setAttribute('class','paginate_button page-item useOnce');
				}								
				var pageHref = document.createElement('a');
				pageHref.setAttribute('class','page-link');
				pageHref.setAttribute('href','#');
				pageHref.setAttribute('aria-controls','tableId');
				pageHref.setAttribute('data-dt-idx',i);
				pageHref.setAttribute('tabindex',0);
				pageHref.innerHTML = i;
				pageNum.appendChild(pageHref);
				$('#tableId_next').before(pageNum);
			}
			// 是否显示 下一页 按钮
			if(pageIndex < totalPage){
				$('#tableId_next').show();
				$('#tableId_next a').attr('data-dt-idx',endIndex+1);
			}else{
				$('#tableId_next').hide();
			}
			var pageNumInfo = "当前第 "+ pageIndex + " 页，共 "+ totalPage + " 页";
			$('#tableId_info').html(pageNumInfo);
		}		
		// 跳转到指定页
		function toThatPage(){
			//var index = document.getElementById('pageIndexInput').value;
			if(index<0 || index>totalPage){
				alert('请输入正确的页码');
			}else {
				pageNumChange(index);
			}
		}		
		// 全选/全不选
		function chooseAll(){
			checkAll = !checkAll;
			var boxs = document.getElementsByName("chk");
			for(var i=0;i<boxs.length;i++){
				boxs[i].checked= checkAll;
			}
		}		
	
		// 批量删除
		function deleteMore(){
			ids = []
			var boxs = document.getElementsByName("chk");
			for(var i=0;i<boxs.length;i++){
				if(boxs[i].checked){
					ids.push(boxs[i].value)
				}
			}
			if(ids.length == 0){
				alert('请勾选要删除的记录');
			}else{
				remove(ids);
			}
		}	
		// 删除
        function remove(id) { 
            var mymessage = confirm("真的要删除吗？");
            if (mymessage == true) {
				var paramArray = [];
				if (id == ids){
					paramArray = id;
				}else{
					paramArray.push(id);
				}             
				httpJson("luquxinxi/delete","POST",paramArray,(res)=>{
					if(res.code == 0){
						getDataList();		
						alert('删除成功');
					}
				});         
            }
            else {
                alert("已取消操作");
            }
        }			
		// 用户登出
        <%@ include file="../../static/logout.jsp"%>

		//修改
        function edit(id) {
            window.sessionStorage.setItem('id', id)
            window.location.href = "add-or-update.jsp"
        }
	//评论列表
	function discussList(id) {
            window.sessionStorage.setItem('refid', id)
            window.location.href = "../discussluquxinxi/list.jsp"
        }
		//清除会重复渲染的节点
        function clear(){
        	var elements = document.getElementsByClassName('useOnce');
        	for(var i = elements.length - 1; i >= 0; i--) { 
        	  elements[i].parentNode.removeChild(elements[i]); 
        	}
        }
	//添加
	function add(){
		window.location.href = "add-or-update.jsp"
	}
	//单列求和
	function getSum(colName){
		http("luquxinxi"+colName,"GET",{
			tableName: "luquxinxi",
			columnName: colName
		},(res)=>{
			if(res.code == 0){
				return res.data.sum;
			}
		});
	}		
	// 查看详情
	function detail(id){
		window.sessionStorage.setItem("id", id);
		//window.sessionStorage.setItem("ifView", true);
		window.location.href = "info.jsp";
	}

	function zhuanyemingchengSelect(){
		//填充下拉框选项
		http("option/zhuanyemingcheng/zhuanyemingcheng","GET",{},(res)=>{
			if(res.code == 0){
				zhuanyemingchengOptions = res.data;
				var nullOption = document.createElement('option');
				var zhuanyemingchengSelect = document.getElementById('zhuanyemingchengSelect');
				zhuanyemingchengSelect.appendChild(nullOption);
				for(var i=0;i<zhuanyemingchengOptions.length;i++){
					var zhuanyemingchengOption = document.createElement('option');
					zhuanyemingchengOption.setAttribute('name','zhuanyemingchengOption');
					zhuanyemingchengOption.setAttribute('value',zhuanyemingchengOptions[i]);
					zhuanyemingchengOption.innerHTML = zhuanyemingchengOptions[i];
					zhuanyemingchengSelect.appendChild(zhuanyemingchengOption);
				}
			}
		});
	}
	function luqufenshuSelect(){
		//填充下拉框选项
		http("option/luqufenshu/luqufenshu","GET",{},(res)=>{
			if(res.code == 0){
				luqufenshuOptions = res.data;
				var nullOption = document.createElement('option');
				var luqufenshuSelect = document.getElementById('luqufenshuSelect');
				luqufenshuSelect.appendChild(nullOption);
				for(var i=0;i<luqufenshuOptions.length;i++){
					var luqufenshuOption = document.createElement('option');
					luqufenshuOption.setAttribute('name','luqufenshuOption');
					luqufenshuOption.setAttribute('value',luqufenshuOptions[i]);
					luqufenshuOption.innerHTML = luqufenshuOptions[i];
					luqufenshuSelect.appendChild(luqufenshuOption);
				}
			}
		});
	}
	//跨表
	function crossTable(obj,crossTableName,crossOptAudit,statusColumnName,tips,statusColumnValue){
		window.sessionStorage.setItem('crossTableId',obj.id);
		window.sessionStorage.setItem('crossObj', JSON.stringify(obj));
		window.sessionStorage.setItem('crossTableName',"luquxinxi");
		window.sessionStorage.setItem('statusColumnName',statusColumnName);
		window.sessionStorage.setItem('statusColumnValue',statusColumnValue);
		window.sessionStorage.setItem('tips',tips);
		if(statusColumnName!=''&&!statusColumnName.startsWith("[")) {
			for (var o in obj){
				if(o==statusColumnName && obj[o]==statusColumnValue){
                    alert(tips);
					return
				}
			}
		}
		var url = "../"+crossTableName+"/add-or-update.jsp?cross=true";
		window.location.href = url;
	}



                function chartDialog1(){
                    vm.showType1 = true

                    $.ajax({
                        type: "GET",
                        url: baseUrl+`luquxinxi/value/gaoxiaomingcheng/luqurenshu`,
                        beforeSend: function(xhr) {
                            xhr.setRequestHeader("token", window.sessionStorage.getItem('token'));
                        },
                        success: function(data){
                            if(data.code == 0){
                                if(data.data != null){
                                    let res = data.data;
                                    let xAxis = [];
                                    let yAxis = [];
                                    let pArray = []
                                    for(let i=0;i<res.length;i++){
                                        xAxis.push(res[i].gaoxiaomingcheng);
                                        yAxis.push(parseFloat((res[i].total)));
                                        pArray.push({
                                            value: parseFloat((res[i].total)),
                                            name: res[i].gaoxiaomingcheng
                                        })
                                    }

                                    var myChart = echarts.init(document.getElementById('luqurenshuMain1'),'fresh-cut');
                                    var option = {};
                                    option = {
                                        title: {
                                            text: '高校录取人数统计',
                                            left: 'center'
                                        },
                                        tooltip: {
                                          trigger: 'item',
                                          formatter: '{b} : {c}'
                                        },
                                        xAxis: {
                                            type: 'category',
                                            data: xAxis
                                        },
                                        yAxis: {
                                            type: 'value'
                                        },
                                        series: [{
                                            data: yAxis,
                                            type: 'bar'
                                        }]
                                    };

                                    // 使用刚指定的配置项和数据显示图表。
                                    myChart.setOption(option);
                                }
                            }else if(data.code == 401){
                                <%@ include file="../../static/toLogin.jsp"%>
                            }else{
                                alert(data.msg);
                            }
                        },
                    });
                }

                function chartDialog2(){
                    vm.showType2 = true

                    $.ajax({
                        type: "GET",
                        url: baseUrl+"luquxinxi/group/luqufenshu",
                        beforeSend: function(xhr) {
                            xhr.setRequestHeader("token", window.sessionStorage.getItem('token'));
                        },
                        success: function(data){
                            if(data.code == 0){
                                if(data.data != null){
                                    let res = data.data;
                                    let xAxis = [];
                                    let yAxis = [];
                                    let pArray = []
                                    for(let i=0;i<res.length;i++){
                                        xAxis.push(res[i].luqufenshu);
                                        yAxis.push(parseFloat((res[i].total)));
                                        pArray.push({
                                            value: parseFloat((res[i].total)),
                                            name: res[i].luqufenshu
                                        })
                                    }

                                    var myChart = echarts.init(document.getElementById('luqufenshuMain2'),'fresh-cut');
                                    var option = {};
                                        option = {
                                                title: {
                                                    text: '高校分数统计',
                                                    left: 'center'
                                                },
                                                legend: {
                                                  orient: 'vertical',
                                                  left: 'left'
                                                },
                                                tooltip: {
                                                  trigger: 'item',
                                                  formatter: '{b} : {c} ({d}%)'
                                                },
                                                series: [
                                                    {
                                                        type: 'pie',
                                                        radius: ['25%', '55%'],
                                                        center: ['50%', '60%'],
                                                        data: pArray,
                                                        emphasis: {
                                                            itemStyle: {
                                                                shadowBlur: 10,
                                                                shadowOffsetX: 0,
                                                                shadowColor: 'rgba(0, 0, 0, 0.5)'
                                                            }
                                                        }
                                                    }
                                                ]
                                        };

                                    // 使用刚指定的配置项和数据显示图表。
                                    myChart.setOption(option);
                                }
                            }else if(data.code == 401){
                                <%@ include file="../../static/toLogin.jsp"%>
                            }else{
                                alert(data.msg);
                            }
                        },
                    });
                }






		$(document).ready(function() { 
			//激活翻页按钮
			$('#tableId_previous').attr('class','paginate_button page-item previous')
			$('#tableId_next').attr('class','paginate_button page-item next')
			//隐藏原生搜索框
			$('#tableId_filter').hide()
			//设置右上角用户名
			$('.dropdown-menu h5').html(window.sessionStorage.getItem('username')+'('+window.sessionStorage.getItem('role')+')')
			//设置项目名
			$('.sidebar-header h3 a').html(projectName)
			setMenu();			
			init();
			getDataList();
			<%@ include file="../../static/myInfo.js"%>
			zhuanyemingchengSelect();
			luqufenshuSelect();
		});
	</script>
</body>

</html>
