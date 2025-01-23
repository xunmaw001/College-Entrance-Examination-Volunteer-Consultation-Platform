<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isELIgnored="true" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
		<title>注册</title>
		<!-- bootstrap样式，地图插件使用 -->
		<link rel="stylesheet" href="../../css/bootstrap.min.css" />
		<link rel="stylesheet" href="../../layui/css/layui.css">
		<!-- 样式 -->
		<link rel="stylesheet" href="../../css/style.css" />
		<!-- 主题（主要颜色设置） -->
		<link rel="stylesheet" href="../../css/theme.css" />
		<!-- 通用的css -->
		<link rel="stylesheet" href="../../css/common.css" />
	</head>
	<style>
		.layui-form.add .layui-form-item .layui-form-select .layui-input {
						padding: 0 30px 0 10px;
						margin: 0;
						color: #333;
						font-size: 14px;
						border-color: #d2e5fd;
						line-height: 40px;
						border-radius: 4px;
						outline: none;
						background: #fff;
						width: 360px;
						border-width: 1px;
						border-style: solid;
						height: 40px;
					}
	</style>
	<body>
		<div id="app">
			<!-- 轮播图 -->
			<div id="layui-carousel" class="layui-carousel">
				<div carousel-item>
					<div class="layui-carousel-item" v-for="(item,index) in swiperList" :key="index">
						<img :src="item.img" />
					</div>
				</div>
			</div>
			<!-- 轮播图 -->
		
			<div class="data-add-container" :style='{"width":"90%","padding":"30px 0px 40px","margin":"10px auto","position":"relative","background":"rgba(255,255,255,.0)"}'>
				<form class="layui-form layui-form-pane add" lay-filter="myForm">
					<div :style='{"padding":"10px","margin":"0 0 10px 0","borderColor":"#c6ecc6","alignItems":"center","borderWidth":"0px","display":"flex","borderStyle":"solid"}' class="layui-form-item">
						<div :style='{"width":"120px","padding":"0 15px","lineHeight":"40px","color":"#3d74c0","textAlign":"right"}' class="label">高校名称：</div>
						<input :style='{"padding":"0 10px","margin":"0","borderColor":"#d2e5fd","color":"#333","outline":"none","borderRadius":"4px","borderWidth":"1px","background":"#fff","width":"360px","fontSize":"14px","lineHeight":"40px","borderStyle":"solid","height":"40px"}' v-model="detail.gaoxiaomingcheng" type="text" :readonly="ro.gaoxiaomingcheng" name="gaoxiaomingcheng" id="gaoxiaomingcheng" autocomplete="off" class="layui-input">
					</div>
					<div :style='{"padding":"10px","margin":"0 0 10px 0","borderColor":"#c6ecc6","alignItems":"center","borderWidth":"0px","display":"flex","borderStyle":"solid"}' class="layui-form-item">
						<div :style='{"width":"120px","padding":"0 15px","lineHeight":"40px","color":"#3d74c0","textAlign":"right"}' class="label">招生标题：</div>
						<input :style='{"padding":"0 10px","margin":"0","borderColor":"#d2e5fd","color":"#333","outline":"none","borderRadius":"4px","borderWidth":"1px","background":"#fff","width":"360px","fontSize":"14px","lineHeight":"40px","borderStyle":"solid","height":"40px"}' v-model="detail.zhaoshengbiaoti" type="text" :readonly="ro.zhaoshengbiaoti" name="zhaoshengbiaoti" id="zhaoshengbiaoti" autocomplete="off" class="layui-input">
					</div>
					<div :style='{"padding":"10px","margin":"0 0 10px 0","borderColor":"#c6ecc6","alignItems":"center","borderWidth":"0px","display":"flex","borderStyle":"solid"}' class="layui-form-item">
						<div :style='{"width":"120px","padding":"0 15px","lineHeight":"44px","color":"#3d74c0","textAlign":"right"}' class="label">招生封面：</div>
						<img :style='{"minHeight":"80px","width":"120px","margin":"0 10px 0 0","objectFit":"cover","height":"auto"}' v-if="detail.zhaoshengfengmian" id="zhaoshengfengmianImg" :src="baseurl+detail.zhaoshengfengmian">
						<input v-if="detail.zhaoshengfengmian" type="hidden" :value="detail.zhaoshengfengmian" id="zhaoshengfengmian" name="zhaoshengfengmian" />
						<button v-if="!ro.zhaoshengfengmian" :style='{"cursor":"pointer","border":"0","padding":"0px 20px","margin":"0","borderColor":"#86bae6","color":"#fff","minWidth":"80px","outline":"none","borderRadius":"0px","background":"#95c6ed","borderWidth":"1px","width":"auto","fontSize":"14px","lineHeight":"40px","borderStyle":"solid","height":"40px"}' type="button" class="layui-btn btn-theme" id="zhaoshengfengmianUpload">
							<i :style='{"margin":"0 10px 0 0","fontSize":"14px","color":"#fff","display":"inline-block"}' class="layui-icon">&#xe67c;</i>上传招生封面
						</button>
					</div>
					<div :style='{"padding":"10px","margin":"0 0 10px 0","borderColor":"#c6ecc6","alignItems":"center","borderWidth":"0px","display":"flex","borderStyle":"solid"}' class="layui-form-item">
						<div :style='{"width":"120px","padding":"0 15px","lineHeight":"40px","color":"#3d74c0","textAlign":"right"}' class="label">高校地址：</div>
						<input :style='{"padding":"0 10px","margin":"0","borderColor":"#d2e5fd","color":"#333","outline":"none","borderRadius":"4px","borderWidth":"1px","background":"#fff","width":"360px","fontSize":"14px","lineHeight":"40px","borderStyle":"solid","height":"40px"}' v-model="detail.gaoxiaodizhi" type="text" :readonly="ro.gaoxiaodizhi" name="gaoxiaodizhi" id="gaoxiaodizhi" autocomplete="off" class="layui-input">
					</div>
					<div :style='{"padding":"10px","margin":"0 0 10px 0","borderColor":"#c6ecc6","alignItems":"center","borderWidth":"0px","display":"flex","borderStyle":"solid"}' class="layui-form-item">
						<div :style='{"width":"120px","padding":"0 15px","lineHeight":"40px","color":"#3d74c0","textAlign":"right"}' class="label">总则：</div>
						<input :style='{"padding":"0 10px","margin":"0","borderColor":"#d2e5fd","color":"#333","outline":"none","borderRadius":"4px","borderWidth":"1px","background":"#fff","width":"360px","fontSize":"14px","lineHeight":"40px","borderStyle":"solid","height":"40px"}' v-model="detail.zongze" type="text" :readonly="ro.zongze" name="zongze" id="zongze" autocomplete="off" class="layui-input">
					</div>
					<div :style='{"padding":"10px","margin":"0 0 10px 0","borderColor":"#c6ecc6","alignItems":"center","borderWidth":"0px","display":"flex","borderStyle":"solid"}' class="layui-form-item">
						<div :style='{"width":"120px","padding":"0 15px","lineHeight":"40px","color":"#3d74c0","textAlign":"right"}' class="label">组织机构：</div>
						<input :style='{"padding":"0 10px","margin":"0","borderColor":"#d2e5fd","color":"#333","outline":"none","borderRadius":"4px","borderWidth":"1px","background":"#fff","width":"360px","fontSize":"14px","lineHeight":"40px","borderStyle":"solid","height":"40px"}' v-model="detail.zuzhijigou" type="text" :readonly="ro.zuzhijigou" name="zuzhijigou" id="zuzhijigou" autocomplete="off" class="layui-input">
					</div>
					<div :style='{"padding":"10px","margin":"0 0 10px 0","borderColor":"#c6ecc6","alignItems":"center","borderWidth":"0px","display":"flex","borderStyle":"solid"}' class="layui-form-item">
						<div :style='{"width":"120px","padding":"0 15px","lineHeight":"40px","color":"#3d74c0","textAlign":"right"}' class="label">学历学位证书：</div>
						<input :style='{"padding":"0 10px","margin":"0","borderColor":"#d2e5fd","color":"#333","outline":"none","borderRadius":"4px","borderWidth":"1px","background":"#fff","width":"360px","fontSize":"14px","lineHeight":"40px","borderStyle":"solid","height":"40px"}' v-model="detail.xuelixueweizhengshu" type="text" :readonly="ro.xuelixueweizhengshu" name="xuelixueweizhengshu" id="xuelixueweizhengshu" autocomplete="off" class="layui-input">
					</div>
					<div :style='{"padding":"10px","margin":"0 0 10px 0","borderColor":"#c6ecc6","alignItems":"center","borderWidth":"0px","display":"flex","borderStyle":"solid"}' class="layui-form-item">
						<div :style='{"width":"120px","padding":"0 15px","lineHeight":"40px","color":"#3d74c0","textAlign":"right"}' class="label">收费及其它：</div>
						<input :style='{"padding":"0 10px","margin":"0","borderColor":"#d2e5fd","color":"#333","outline":"none","borderRadius":"4px","borderWidth":"1px","background":"#fff","width":"360px","fontSize":"14px","lineHeight":"40px","borderStyle":"solid","height":"40px"}' v-model="detail.shoufeijiqita" type="text" :readonly="ro.shoufeijiqita" name="shoufeijiqita" id="shoufeijiqita" autocomplete="off" class="layui-input">
					</div>
					<div :style='{"padding":"10px","margin":"0 0 10px 0","borderColor":"#c6ecc6","alignItems":"center","borderWidth":"0px","display":"flex","borderStyle":"solid"}' class="layui-form-item">
						<div :style='{"width":"120px","padding":"0 15px","lineHeight":"40px","color":"#3d74c0","textAlign":"right"}' class="label">发布时间：</div>
						<input :style='{"padding":"0 10px","margin":"0","borderColor":"#d2e5fd","color":"#333","outline":"none","borderRadius":"4px","borderWidth":"1px","background":"#fff","width":"360px","fontSize":"14px","lineHeight":"40px","borderStyle":"solid","height":"40px"}' type="text" name="fabushijian" id="fabushijian" autocomplete="off" class="layui-input" >
					</div>

					<div :style='{"alignItems":"center","margin":"0 0 10px 0","display":"flex"}' class="layui-form-item">
						<div :style='{"width":"120px","padding":"0 15px","lineHeight":"44px","color":"#3d74c0","textAlign":"right"}' class="label">招生计划：</div>
						<textarea :style='{"padding":"0","boxShadow":"0 0 0px rgba(75,223,201,.5)","margin":"20px 0 20px","borderColor":"#ddd","backgroundColor":"rgba(255,255,255,.8)","borderRadius":"0","borderWidth":"1px","width":"88%","borderStyle":"solid","height":"auto"}' name="zhaoshengjihua" id="zhaoshengjihua">请输入招生计划</textarea>
					</div>

					<div :style='{"margin":"0 0 0 0px","alignItems":"center","justifyContent":"center","display":"flex"}' class="layui-form-item">
						<button :style='{"cursor":"pointer","padding":"0px 15px","margin":"0 10px","borderColor":"#6eb9ff","color":"#111","minWidth":"110px","outline":"none","borderRadius":"0","background":"#fff","borderWidth":"8px","width":"auto","fontSize":"14px","lineHeight":"34px","borderStyle":"outset","height":"48px"}'  class="layui-btn btn-submit" lay-submit lay-filter="*">提交</button>
						<button :style='{"cursor":"pointer","border":"0","padding":"0px 15px","margin":"0 10px","borderColor":"#ccc","color":"#333","minWidth":"110px","outline":"none","borderRadius":"0","background":"#fff","borderWidth":"8px","width":"auto","fontSize":"14px","lineHeight":"34px","borderStyle":"outset","height":"48px"}' type="reset" class="layui-btn layui-btn-primary">重置</button>
					</div>
				</form>
			</div>
		</div>

		<script src="../../layui/layui.js"></script>
		<script src="../../js/vue.js"></script>
		<!-- 组件配置信息 -->
		<script src="../../js/config.js"></script>
		<!-- 扩展插件配置信息 -->
		<script src="../../modules/config.js"></script>
		<!-- 工具方法 -->
		<script src="../../js/utils.js"></script>
		<!-- 校验格式工具类 -->
		<script src="../../js/validate.js"></script>
		<!-- 地图 -->
		<script type="text/javascript" src="../../js/jquery.js"></script>
		<script type="text/javascript" src="http://webapi.amap.com/maps?v=1.3&key=ca04cee7ac952691aa67a131e6f0cee0"></script>
		<script type="text/javascript" src="../../js/bootstrap.min.js"></script>
		<script type="text/javascript" src="../../js/bootstrap.AMapPositionPicker.js"></script>
		<script>
			var jquery = $;
			
			var vue = new Vue({
				el: '#app',
				data: {
					// 轮播图
					swiperList: [{
						img: '../../img/banner.jpg'
					}],
					baseurl: '',
					dataList: [],
					ro:{
                                        gaoxiaomingcheng : false,
                                        zhaoshengbiaoti : false,
                                        zhaoshengfengmian : false,
                                        gaoxiaodizhi : false,
                                        zongze : false,
                                        zuzhijigou : false,
                                        xuelixueweizhengshu : false,
                                        shoufeijiqita : false,
                                        zhaoshengjihua : false,
                                        luquyuanze : false,
                                        fabushijian : false,
					},
                    detail: {
                        gaoxiaomingcheng: '',
                        zhaoshengbiaoti: '',
                        zhaoshengfengmian: '',
                        gaoxiaodizhi: '',
                        zongze: '',
                        zuzhijigou: '',
                        xuelixueweizhengshu: '',
                        shoufeijiqita: '',
                        zhaoshengjihua: '',
                        luquyuanze: '',
                        fabushijian: '',
                    },
					centerMenu: centerMenu
				},
				updated: function() {
					layui.form.render('select', 'myForm');
				},
                computed: {



                },
				methods: {
					jump(url) {
						jump(url)
					}
				}
			})


			layui.use(['layer', 'element', 'carousel', 'http', 'jquery', 'form', 'upload', 'laydate','tinymce'], function() {
				var layer = layui.layer;
				var element = layui.element;
				var carousel = layui.carousel;
				var http = layui.http;
				var jquery = layui.jquery;
				var form = layui.form;
				var upload = layui.upload;
				var laydate = layui.laydate;
				var tinymce = layui.tinymce;
				vue.baseurl = http.baseurl;


                // 获取轮播图 数据
                http.request('config/list', 'get', {
                    page: 1,
                    limit: 3
                }, function(res) {
                    if (res.data.list.length > 0) {
                        let swiperList = [];
                        res.data.list.forEach(element => {
                          if (element.value != null) {
                            swiperList.push({
                              img: http.baseurl+element.value
                            });
                          }
                        });
                        vue.swiperList = swiperList;

                        vue.$nextTick(() => {
                            carousel.render({
                                elem: '#layui-carousel',
                                width: '100%',
                                height: '520px',
                                anim: 'fade',
                                autoplay: 'true',
                                interval: '6000',
                                arrow: 'none',
                                indicator: 'inside'
                            });
                        })
                    }
                });
				// 上传图片
				var zhaoshengfengmianUpload = upload.render({
					//绑定元素
					elem: '#zhaoshengfengmianUpload',
					//上传接口
					url: http.baseurl + 'file/upload',
					// 请求头
					headers: {
						Token: localStorage.getItem('Token')
					},
					// 允许上传时校验的文件类型
					accept: 'images',
					before: function() {
						//loading层
						var index = layer.load(1, {
							shade: [0.1, '#fff'] //0.1透明度的白色背景
						});
					},
					// 上传成功
					done: function(res) {
						console.log(res);
						layer.closeAll();
						if (res.code == 0) {
							layer.msg("上传成功", {
								time: 2000,
								icon: 6
							})
							var url = 'upload/' + res.file;
							jquery('#zhaoshengfengmian').val(url);
							jquery('#zhaoshengfengmianImg').attr('src', http.baseurl +url)
							vue.detail.zhaoshengfengmian = url;
						} else {
							layer.msg(res.msg, {
								time: 2000,
								icon: 5
							})
						}
					},
					//请求异常回调
					error: function() {
						layer.closeAll();
						layer.msg("请求接口异常", {
							time: 2000,
							icon: 5
						})
					}
				});
                var edit = tinymce.render({
                    elem: "#zhaoshengjihua",
                    height: 600,
                    images_upload_handler: function(blobInfo, succFun, failFun) {
                        var xhr, formData;
                        var file = blobInfo.blob(); //转化为易于理解的file对象
                        xhr = new XMLHttpRequest();
                        xhr.withCredentials = false;
                        xhr.open('POST', http.baseurl + 'file/upload');
                        xhr.setRequestHeader("Token", localStorage.getItem('Token')); //设置请求头
                        xhr.onload = function() {
                            var json;
                            if (xhr.status != 200) {
                                failFun('HTTP Error: ' + xhr.status);
                                return;
                            }
                            json = JSON.parse(xhr.responseText);
                            if (!json || typeof json.file != 'string') {
                                failFun('Invalid JSON: ' + xhr.responseText);
                                return;
                            }
                            succFun(http.baseurl + '/upload/' + json.file);
                        };
                        formData = new FormData();
                        formData.append('file', file, file.name); //此处与源文档不一样
                        xhr.send(formData);
                    }
                }, (opt) => {

                });
                                jquery('#fabushijian').val(getCurDateTime());
				laydate.render({
					elem: '#fabushijian',
					type: 'datetime'
				});
				
                // session独取
				let table = localStorage.getItem("userTable");
				http.request(`${table}/session`, 'get', {}, function(data) {
					// 表单赋值
					//form.val("myForm", data.data);
					data = data.data
					for(var key in data){
					}
				});

                // 跨表计算
                if(http.getParam('corss')){
					var obj = JSON.parse(localStorage.getItem('crossObj'));
					//form.val("myForm", obj);
					for(var o in obj){
                        if(o=='gaoxiaomingcheng'){
                                vue.detail[o] = obj[o];
                                vue.ro.gaoxiaomingcheng = true;
                                continue;
                        }
                        if(o=='zhaoshengbiaoti'){
                                vue.detail[o] = obj[o];
                                vue.ro.zhaoshengbiaoti = true;
                                continue;
                        }
                        if(o=='zhaoshengfengmian'){
                                vue.detail[o] = obj[o]?obj[o].split(",")[0]:'';
                                vue.ro.zhaoshengfengmian = true;
                                continue;
                        }
                        if(o=='gaoxiaodizhi'){
                                vue.detail[o] = obj[o];
                                vue.ro.gaoxiaodizhi = true;
                                continue;
                        }
                        if(o=='zongze'){
                                vue.detail[o] = obj[o];
                                vue.ro.zongze = true;
                                continue;
                        }
                        if(o=='zuzhijigou'){
                                vue.detail[o] = obj[o];
                                vue.ro.zuzhijigou = true;
                                continue;
                        }
                        if(o=='xuelixueweizhengshu'){
                                vue.detail[o] = obj[o];
                                vue.ro.xuelixueweizhengshu = true;
                                continue;
                        }
                        if(o=='shoufeijiqita'){
                                vue.detail[o] = obj[o];
                                vue.ro.shoufeijiqita = true;
                                continue;
                        }
                        if(o=='zhaoshengjihua'){
                                vue.detail[o] = obj[o];
                                vue.ro.zhaoshengjihua = true;
                                continue;
                        }
                        if(o=='luquyuanze'){
                                vue.detail[o] = obj[o];
                                vue.ro.luquyuanze = true;
                                continue;
                        }
                        if(o=='fabushijian'){
                                vue.detail[o] = obj[o];
                                vue.ro.fabushijian = true;
                                jquery('#fabushijian').val(obj[o]);
                                continue;
                        }
					}
				}
				

				// 提交
				form.on('submit(*)', function(data) {
					data = data.field;
					
                    // 数据校验
                    if(!data.zhaoshengbiaoti){
                        layer.msg('招生标题不能为空', {
							time: 2000,
							icon: 5
						});
                        return false
                    }
					var zhaoshengjihua = tinymce.get('#zhaoshengjihua').getContent()
					data.zhaoshengjihua = zhaoshengjihua;

					// 跨表计算判断
					
                    // 比较大小

                //更新跨表属性
               var crossuserid;
               var crossrefid;
               var crossoptnum;
                if(http.getParam('corss')){
                        var statusColumnName = localStorage.getItem('statusColumnName');
                        var statusColumnValue = localStorage.getItem('statusColumnValue');
                        if(statusColumnName!='') {
                                var obj = JSON.parse(localStorage.getItem('crossObj'));
				if(!statusColumnName.startsWith("[")) {
					for (var o in obj){
						if(o==statusColumnName){
							obj[o] = statusColumnValue;
						}
					}
					var table = localStorage.getItem('crossTable');
					http.requestJson(`${table}/update`,'post',obj,(res)=>{});
				} else {
                                       crossuserid=Number(localStorage.getItem('userid'));
                                       crossrefid=obj['id'];
                                       crossoptnum=localStorage.getItem('statusColumnName');
                                       crossoptnum=crossoptnum.replace(/\[/,"").replace(/\]/,"");
				}
                        }
                }
                        if(crossrefid && crossuserid) {
                                data.crossuserid=crossuserid;
                                data.crossrefid=crossrefid;
                                http.request('zhaoshengjianzhang/list', 'get', {
                                        page: 1,
                                        limit: 10,
                                        crossuserid:crossuserid,
                                        crossrefid:crossrefid,
                                }, function(res) {
                                        if(res.data.total>=crossoptnum) {
                                                layer.msg(localStorage.getItem('tips'), {
                                                        time: 2000,
                                                        icon: 6
                                                })
                                             return false;
                                        } else {
                                            // 跨表计算



                                            // 提交数据
                                            http.requestJson('zhaoshengjianzhang' + '/add', 'post', data, function(res) {
                                                    layer.msg('提交成功', {
                                                            time: 2000,
                                                            icon: 6
                                                    }, function() {
                                                            back();
                                                    });
                                             });
                                        }
                                });
                        } else {
                                // 跨表计算

                                // 提交数据
                                http.requestJson('zhaoshengjianzhang' + '/add', 'post', data, function(res) {
                                        layer.msg('提交成功', {
                                                time: 2000,
                                                icon: 6
                                        }, function() {
                                                back();
                                        });
                                 });
                        }
			return false
			});
		});
		</script>
	</body>
</html>
